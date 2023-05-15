// 
// 
// 

package com.taoxiuxia.controller;

import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.Map;
import com.taoxiuxia.model.PayMethod;
import java.util.List;
import com.taoxiuxia.model.SessionUser;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.LoggerFactory;
import com.taoxiuxia.service.IPayMethodService;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping({ "/payMethodController" })
public class PayMethodController
{
    private Logger logger;
    private IPayMethodService payMethodService;
    
    public PayMethodController() {
        this.logger = LoggerFactory.getLogger((Class)PayMethodController.class);
    }
    
    public IPayMethodService getPayMethodService() {
        return this.payMethodService;
    }
    
    @Autowired
    public void setPayMethodService(final IPayMethodService payMethodService) {
        this.payMethodService = payMethodService;
    }
    
    @RequestMapping({ "/showManagePayMethods" })
    public String showManagePayMethods(final Model model, final HttpSession session) {
        final SessionUser sessionUser = (SessionUser)session.getAttribute("session_user_key");
        final int userId = sessionUser.getUserId();
        final List<PayMethod> incomePayMethods = this.payMethodService.loadPayMethods(userId, "in");
        final List<PayMethod> expenditurePayMethods = this.payMethodService.loadPayMethods(userId, "ex");
        model.addAttribute("incomePayMethods", (Object)incomePayMethods);
        model.addAttribute("expenditurePayMethods", (Object)expenditurePayMethods);
        model.addAttribute("sessionUser", (Object)sessionUser);
        return "pages/managePayMethods";
    }
    
    @RequestMapping({ "/changePayMethod" })
    public void changeItem(final int payMethodId, final String payMethodName, final int isCountInThisMonthEx, final String remark) {
        this.payMethodService.changePayMethod(payMethodId, payMethodName, isCountInThisMonthEx, remark);
    }
    
    @RequestMapping({ "/delePayMethod" })
    public void delePayMethod(final int payMethodId) {
        this.payMethodService.delePayMethod(payMethodId);
    }
    
    @RequestMapping({ "/addPayMethod" })
    public void addItem(final HttpSession session, final String payMethodName, final int isCountInThisMonthEx, final String remark, final String inOrEx) {
        final SessionUser sessionUser = (SessionUser)session.getAttribute("session_user_key");
        final int userId = sessionUser.getUserId();
        this.payMethodService.addPayMethod(userId, payMethodName, isCountInThisMonthEx, inOrEx, remark);
    }
    
    @RequestMapping(value = { "/upAndDownPayMethod" }, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public Map<String, Object> upAndDownPayMethod(final HttpSession session, final int payMethodId, final String inOrEx, final String upAndDown) {
        final Map<String, Object> map = new HashMap<String, Object>();
        final SessionUser sessionUser = (SessionUser)session.getAttribute("session_user_key");
        final int userId = sessionUser.getUserId();
        final String msg = this.payMethodService.upAndDownPayMethod(userId, payMethodId, inOrEx, upAndDown);
        map.put("info", msg);
        return map;
    }
}
