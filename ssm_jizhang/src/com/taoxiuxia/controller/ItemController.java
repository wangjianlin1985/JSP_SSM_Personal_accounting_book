// 
// 
// 

package com.taoxiuxia.controller;

import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.Map;
import com.taoxiuxia.model.Item;
import java.util.List;
import com.taoxiuxia.model.SessionUser;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.LoggerFactory;
import com.taoxiuxia.service.IItemService;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping({ "/itemController" })
public class ItemController
{
    private Logger logger;
    private IItemService itemService;
    
    public ItemController() {
        this.logger = LoggerFactory.getLogger((Class)ItemController.class);
    }
    
    public IItemService getItemService() {
        return this.itemService;
    }
    
    @Autowired
    public void setItemService(final IItemService itemService) {
        this.itemService = itemService;
    }
    
    @RequestMapping({ "/showManageItems" })
    public String showManageItems(final Model model, final HttpSession session) {
        final SessionUser sessionUser = (SessionUser)session.getAttribute("session_user_key");
        final int userId = sessionUser.getUserId();
        final List<Item> expenditureItems = this.itemService.loadExpenditureItems(userId);
        final List<Item> incomeItems = this.itemService.loadIncomeItems(userId);
        model.addAttribute("expenditureItems", (Object)expenditureItems);
        model.addAttribute("incomeItems", (Object)incomeItems);
        model.addAttribute("sessionUser", (Object)sessionUser);
        return "pages/manageItems";
    }
    
    @RequestMapping({ "/addItem" })
    public void addItem(final HttpSession session, final String itemName, final String remark, final String inOrEx) {
        final SessionUser sessionUser = (SessionUser)session.getAttribute("session_user_key");
        final int userId = sessionUser.getUserId();
        this.itemService.addItem(userId, itemName, remark, inOrEx);
    }
    
    @RequestMapping({ "/changeItem" })
    public void changeItem(final int itemId, final String itemName, final String remark, final String inOrEx) {
        this.itemService.changeItem(itemId, itemName, remark);
    }
    
    @RequestMapping({ "/deleItem" })
    public void deleItem(final int itemId) {
        this.itemService.deleItem(itemId);
    }
    
    @RequestMapping(value = { "/upAndDownItem" }, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public Map<String, Object> upAndDownItem(final HttpSession session, final int itemId, final String inOrEx, final String upAndDown) {
        final Map<String, Object> map = new HashMap<String, Object>();
        final SessionUser sessionUser = (SessionUser)session.getAttribute("session_user_key");
        final int userId = sessionUser.getUserId();
        final String msg = this.itemService.upAndDownItem(userId, itemId, inOrEx, upAndDown);
        map.put("info", msg);
        return map;
    }
}
