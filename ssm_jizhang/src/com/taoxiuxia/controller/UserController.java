// 
// 
// 

package com.taoxiuxia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.io.IOException;
import java.io.OutputStream;
import checkcode.patchca.service.CaptchaService;
import checkcode.patchca.utils.encoder.EncoderHelper;
import checkcode.patchca.filter.FilterFactory;
import checkcode.patchca.filter.predefined.CurvesRippleFilterFactory;
import checkcode.patchca.color.ColorFactory;
import checkcode.patchca.color.SingleColorFactory;
import java.awt.Color;
import checkcode.patchca.service.ConfigurableCaptchaService;
import javax.servlet.http.HttpServletRequest;
import com.taoxiuxia.exception.BusinessException;
import javax.servlet.http.Cookie;
import java.net.URLEncoder;
import com.taoxiuxia.model.SessionUser;
import com.taoxiuxia.util.StringTools;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ResponseBody;
import com.taoxiuxia.util.DateTimeUtil;
import java.util.Date;
import com.taoxiuxia.util.PasswordUtil;
import com.taoxiuxia.util.Constants;
import com.taoxiuxia.model.User;
import com.taoxiuxia.util.EmailUtil;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.slf4j.LoggerFactory;
import com.taoxiuxia.service.IPayMethodService;
import com.taoxiuxia.service.IItemService;
import com.taoxiuxia.service.IUserService;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping({ "/userController" })
public class UserController
{
    private Logger logger;
    private IUserService userService;
    private IItemService itemService;
    private IPayMethodService payMethodService;
    
    public UserController() {
        this.logger = LoggerFactory.getLogger((Class)UserController.class);
    }
    
    @RequestMapping({ "/showUserRegister" })
    public String showUserRegister(final Model model) {
        return "pages/userRegister";
    }
    
    @RequestMapping({ "/showUserActive" })
    public String showUserActive(final Model model) {
        return "pages/userActive";
    }
    
    @RequestMapping({ "/showUserLogin" })
    public String showUserLogin(final Model model) {
        return "pages/userLogin";
    }
    
    @RequestMapping(value = { "/register.action" }, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public Map<String, Object> register(final HttpSession session, final String userName, final String email, final String password) {
        final Map<String, Object> map = new HashMap<String, Object>();
        final int emailState = this.userService.isEmailRegister(email);
        if (emailState == 0 || emailState == 1) {
            final User userChecked = this.userService.findUserByUserName(userName);
            if (userChecked != null && !userChecked.getEmail().equals(email)) {
                map.put("info", "\u7528\u6237\u540d\u88ab\u5360\u7528\uff0c\u8bf7\u4fee\u6539\u7528\u6237\u540d");
                return map;
            }
            final String activationCode = EmailUtil.sendEmail(email);
            final User user = new User();
            user.setName(userName);
            user.setEmail(email);
            user.setPassword(password);
            user.setIsActive(Constants.NOT_ACTIVE);
            user.setActivationCode(activationCode);
            user.setPassword(PasswordUtil.geneMD5WithSalt(user.getPassword()));
            user.setRegisterTime(new Date());
            user.setLastLoginTime(new Date());
            user.setActivationCodeTime(DateTimeUtil.nowTime());
            if (emailState == 0) {
                final int userId = this.userService.register(user);
                this.initItem(userId);
                this.initPayMethod(userId);
            }
            else if (emailState == 1) {
                final int userId = this.userService.findUserByEmail(email).getId();
                user.setId(userId);
                this.userService.update(user);
            }
            session.setAttribute("email", (Object)email);
            map.put("info", "\u4e0b\u4e00\u6b65");
            return map;
        }
        else {
            if (emailState == 2) {
                map.put("info", "\u90ae\u7bb1\u5df2\u7ecf\u6ce8\u518c\uff0c\u8bf7\u767b\u5f55");
                return map;
            }
            return map;
        }
    }
    
    @RequestMapping(value = { "/active.action" }, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public Map<String, Object> active(final User user) {
        final String result = this.userService.active(user.getEmail(), user.getActivationCode());
        final Map<String, Object> map = new HashMap<String, Object>();
        map.put("info", result);
        return map;
    }
    
    @RequestMapping(value = { "/login.action" }, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public Map<String, Object> login(final HttpSession session, final HttpServletResponse response, final String account, final String password, final String checkCode, final String rememberMe) {
        final String REMEMBERME = "true";
        final Map<String, Object> map = new HashMap<String, Object>();
        try {
            final String sessionCheckCode = String.valueOf(session.getAttribute("check_code"));
            if (StringTools.isEmpty(sessionCheckCode)) {
                map.put("info", "\u9a8c\u8bc1\u7801\u5df2\u8fc7\u671f\uff0c\u8bf7\u5237\u65b0\u9875\u9762\u91cd\u8bd5");
                this.logger.info("\u9a8c\u8bc1\u7801\u5df2\u8fc7\u671f\uff0c\u8bf7\u5237\u65b0\u9875\u9762\u91cd\u8bd5");
                return map;
            }
            if (!StringTools.isEmpty(sessionCheckCode) && !sessionCheckCode.equalsIgnoreCase(checkCode)) {
                map.put("info", "\u9a8c\u8bc1\u7801\u9519\u8bef");
                this.logger.info("\u9a8c\u8bc1\u7801\u9519\u8bef");
                return map;
            }
            final User user = this.userService.login(account, password, false);
            final SessionUser sessionUser = new SessionUser();
            sessionUser.setUserId(user.getId());
            sessionUser.setUserName(user.getName());
            session.setAttribute("session_user_key", (Object)sessionUser);
            session.setAttribute("useId", (Object)user.getId());
            if ("true".equals(rememberMe)) {
                final String infor = String.valueOf(URLEncoder.encode(account.toString(), "utf-8")) + "|" + user.getPassword();
                final Cookie cookie = new Cookie("cookie4UserInfo", (String)null);
                cookie.setPath("/");
                cookie.setMaxAge(0);
                final Cookie cookieInfo = new Cookie("cookie4UserInfo", infor);
                cookieInfo.setPath("/");
                cookieInfo.setMaxAge(31536000);
                response.addCookie(cookieInfo);
            }
            else {
                final Cookie cookie2 = new Cookie("cookie4UserInfo", (String)null);
                cookie2.setPath("/");
                cookie2.setMaxAge(0);
                response.addCookie(cookie2);
            }
        }
        catch (BusinessException e) {
            if (map.get("info") == null) {
                map.put("info", e.getMessage());
                this.logger.info("\u767b\u5f55\u5931\u8d25: " + e.getMessage());
                return map;
            }
        }
        catch (Exception e2) {
            if (map.get("info") == null) {
                map.put("info", "\u767b\u5f55\u5931\u8d25");
                this.logger.info("\u767b\u5f55\u5931\u8d25");
            }
            return map;
        }
        map.put("info", "\u767b\u5f55\u6210\u529f");
        return map;
    }
    
    @RequestMapping(value = { "/logout.action" }, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public Map<String, Object> logout(final HttpSession session, final HttpServletResponse response) {
        final Map<String, Object> map = new HashMap<String, Object>();
        session.setAttribute("session_user_key", (Object)null);
        final Cookie cookie = new Cookie("cookie4UserInfo", (String)null);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        map.put("info", "\u6ce8\u9500\u6210\u529f");
        return map;
    }
    
    @RequestMapping({ "checkCode.action" })
    public void checkCode(final HttpServletRequest request, final HttpServletResponse response, final HttpSession session) throws IOException {
        final ConfigurableCaptchaService cs = new ConfigurableCaptchaService();
        cs.setColorFactory(new SingleColorFactory(new Color(20, 60, 170)));
        cs.setFilterFactory(new CurvesRippleFilterFactory(cs.getColorFactory()));
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0L);
        response.setContentType("image/jpeg");
        final String code = EncoderHelper.getChallangeAndWriteImage(cs, "png", (OutputStream)response.getOutputStream());
        session.setAttribute("check_code", (Object)code);
    }
    
    private void initItem(final int userId) {
        this.itemService.addItem(userId, " ", "\u7a7a\u9879\u76ee", "in");
        this.itemService.addItem(userId, "\u5de5\u8d44", " ", "in");
        this.itemService.addItem(userId, "\u5176\u4ed6", " ", "in");
        this.itemService.addItem(userId, " ", "\u7a7a\u9879\u76ee", "ex");
        this.itemService.addItem(userId, "\u9910\u996e", " ", "ex");
        this.itemService.addItem(userId, "\u670d\u9970", " ", "ex");
        this.itemService.addItem(userId, "\u533b\u7597", " ", "ex");
        this.itemService.addItem(userId, "\u5176\u4ed6", " ", "ex");
    }
    
    private void initPayMethod(final int userId) {
        this.payMethodService.addPayMethod(userId, "\u4f59\u989d\u5b9d", -1, "in", "");
        this.payMethodService.addPayMethod(userId, "\u73b0\u91d1", -1, "in", "");
        this.payMethodService.addPayMethod(userId, "\u5fae\u4fe1", -1, "in", "");
        this.payMethodService.addPayMethod(userId, "\u94f6\u884c\u5361", -1, "in", "");
        this.payMethodService.addPayMethod(userId, "\u4f59\u989d\u5b9d", 1, "ex", "");
        this.payMethodService.addPayMethod(userId, "\u73b0\u91d1", 1, "ex", "");
        this.payMethodService.addPayMethod(userId, "\u5fae\u4fe1", 1, "ex", "");
        this.payMethodService.addPayMethod(userId, "\u94f6\u884c\u5361", 1, "ex", "");
        this.payMethodService.addPayMethod(userId, "\u82b1\u5457", 0, "ex", "");
        this.payMethodService.addPayMethod(userId, "\u4fe1\u7528\u5361", 0, "ex", "");
    }
    
    public IPayMethodService getPayMethodService() {
        return this.payMethodService;
    }
    
    @Autowired
    public void setPayMethodService(final IPayMethodService payMethodService) {
        this.payMethodService = payMethodService;
    }
    
    public IUserService getUserService() {
        return this.userService;
    }
    
    @Autowired
    public void setUserService(final IUserService userService) {
        this.userService = userService;
    }
    
    public IItemService getItemService() {
        return this.itemService;
    }
    
    @Autowired
    public void setItemService(final IItemService itemService) {
        this.itemService = itemService;
    }
}
