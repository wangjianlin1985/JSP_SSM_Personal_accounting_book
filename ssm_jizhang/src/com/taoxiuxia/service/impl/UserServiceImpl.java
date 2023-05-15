// 
// 
// 

package com.taoxiuxia.service.impl;

import com.taoxiuxia.util.Constants;
import com.taoxiuxia.util.DateTimeUtil;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;
import com.taoxiuxia.util.PasswordUtil;
import com.taoxiuxia.exception.BusinessException;
import com.taoxiuxia.util.StringTools;
import com.taoxiuxia.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.taoxiuxia.mapper.ItemMapper;
import javax.annotation.Resource;
import com.taoxiuxia.mapper.UserMapper;
import org.springframework.stereotype.Service;
import com.taoxiuxia.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService
{
    @Resource
    private UserMapper userMapper;
    @Resource
    private ItemMapper itemMapper;
    
    public UserMapper getUserMapper() {
        return this.userMapper;
    }
    
    @Autowired
    public void setUserMapper(final UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    
    public ItemMapper getItemMapper() {
        return this.itemMapper;
    }
    
    @Autowired
    public void setItemMapper(final ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }
    
    @Override
    public int register(final User user) {
        final int recordNum = this.userMapper.insert(user);
        int userId = 0;
        if (recordNum == 1) {
            userId = user.getId();
        }
        return userId;
    }
    
    @Override
    public User login(final String account, final String password, final boolean hasMD5) throws Exception {
        if (StringTools.isEmpty(account) || StringTools.isEmpty(password)) {
            throw new BusinessException("\u8f93\u5165\u53c2\u6570\u4e0d\u5408\u6cd5,account\u6216password\u4e0d\u80fd\u4e3a\u7a7a");
        }
        User user = null;
        if (account.contains("@")) {
            user = this.findUserByEmail(account);
        }
        else {
            user = this.findUserByUserName(account);
        }
        if (user == null) {
            throw new BusinessException("\u7528\u6237\u4e0d\u5b58\u5728\uff0c\u8bf7\u524d\u5f80\u6ce8\u518c");
        }
        if (hasMD5) {
            if (!password.equals(user.getPassword())) {
                throw new BusinessException("\u5bc6\u7801\u9519\u8bef");
            }
        }
        else if (!PasswordUtil.verifyPassword(password, user.getPassword())) {
            throw new BusinessException("\u5bc6\u7801\u9519\u8bef");
        }
        if (user.getIsActive() == 0) {
            throw new BusinessException("\u8be5\u90ae\u7bb1\u5c1a\u672a\u6fc0\u6d3b\uff0c\u8bf7\u91cd\u65b0\u6ce8\u518c\u5e76\u6fc0\u6d3b");
        }
        user.setLastLoginTime(new Date());
        this.userMapper.updateByPrimaryKeySelective(user);
        return user;
    }
    
    @Override
    public void update(final User user) {
        this.userMapper.updateByPrimaryKeySelective(user);
    }
    
    @Override
    public int isEmailRegister(final String email) {
        final Map<String, String> map = new HashMap<String, String>();
        map.put("email", email);
        final List<User> userlist = this.userMapper.findUserByEmail(map);
        if (userlist.size() == 0) {
            return 0;
        }
        final User user = userlist.get(0);
        if (user.getIsActive() == 1) {
            return 2;
        }
        return 1;
    }
    
    @Override
    public String active(final String email, final String activationCode) {
        final User user = this.findUserByEmail(email);
        if (StringTools.isEmpty(activationCode)) {
            return "\u6fc0\u6d3b\u7801\u4e3a\u7a7a";
        }
        if (DateTimeUtil.compareTimeByMin(user.getActivationCodeTime(), DateTimeUtil.nowTime()) > 180) {
            return "\u6fc0\u6d3b\u7801\u5931\u6548\uff0c\u8bf7\u91cd\u65b0\u6ce8\u518c";
        }
        if (activationCode.equals(user.getActivationCode())) {
            user.setIsActive(Constants.ACTIVE);
            final int row = this.userMapper.updateByPrimaryKeySelective(user);
            if (row == 1) {
                return "\u6fc0\u6d3b\u6210\u529f";
            }
        }
        return "\u6fc0\u6d3b\u5931\u8d25";
    }
    
    @Override
    public User findUserByEmail(final String email) {
        final Map<String, String> map = new HashMap<String, String>();
        map.put("email", email);
        final List<User> list = this.userMapper.findUserByEmail(map);
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }
    
    @Override
    public User findUserByUserName(final String userName) {
        final Map<String, String> map = new HashMap<String, String>();
        map.put("name", userName);
        if (this.userMapper == null) {
            this.userMapper = this.getUserMapper();
        }
        final List<User> list = this.userMapper.findUserByUserName(map);
        if (list.size() >= 1) {
            return list.get(0);
        }
        return null;
    }
}
