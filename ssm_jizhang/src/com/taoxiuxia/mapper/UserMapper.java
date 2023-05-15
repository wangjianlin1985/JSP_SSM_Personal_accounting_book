// 
// 
// 

package com.taoxiuxia.mapper;

import org.apache.ibatis.annotations.Param;
import com.taoxiuxia.model.UserExample;
import java.util.List;
import java.util.Map;
import com.taoxiuxia.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper
{
    int insert(User p0);
    
    List<User> findUserByUserName(Map p0);
    
    List<User> findUserByEmail(Map p0);
    
    int updateByPrimaryKeySelective(User p0);
    
    int countByExample(UserExample p0);
    
    int deleteByExample(UserExample p0);
    
    int deleteByPrimaryKey(Integer p0);
    
    int insertSelective(User p0);
    
    List<User> selectByExample(UserExample p0);
    
    User selectByPrimaryKey(Integer p0);
    
    int updateByExampleSelective(@Param("record") User p0, @Param("example") UserExample p1);
    
    int updateByExample(@Param("record") User p0, @Param("example") UserExample p1);
    
    int updateByPrimaryKey(User p0);
}
