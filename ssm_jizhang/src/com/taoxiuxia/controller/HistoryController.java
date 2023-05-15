// 
// 
// 

package com.taoxiuxia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.taoxiuxia.util.MyDateFormat;
import java.util.Iterator;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import com.taoxiuxia.util.DateTimeUtil;
import com.taoxiuxia.model.PayMethod;
import com.taoxiuxia.model.Item;
import java.util.Map;
import java.util.List;
import com.taoxiuxia.model.SessionUser;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import com.taoxiuxia.service.IPayMethodService;
import com.taoxiuxia.service.IHistoryService;
import com.taoxiuxia.service.IItemService;
import com.taoxiuxia.service.IExpenditureService;
import com.taoxiuxia.service.IIncomeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping({ "/historyController" })
public class HistoryController
{
    private IIncomeService incomeService;
    private IExpenditureService expenditureService;
    private IItemService itemService;
    private IHistoryService historyService;
    private IPayMethodService payMethodService;
    
    @RequestMapping({ "/showhistory" })
    public String showHistory(final Model model, final HttpSession session) {
        final SessionUser sessionUser = (SessionUser)session.getAttribute("session_user_key");
        final int userId = sessionUser.getUserId();
        final int limit = 20;
        final int totalRecords = this.historyService.countIncomesAndExpenditure(userId, null, -1, -1, null);
        final int totalPages = (int)Math.ceil(totalRecords * 1.0 / limit);
        final List<Map> historys = this.historyService.loadIncomesAndExpenditure(userId, null, -1, -1, null, "date DESC", 1, totalPages);
        final List<Item> incomesItems = this.itemService.loadIncomeItems(userId);
        final List<Item> expenditureItems = this.itemService.loadExpenditureItems(userId);
        final List<PayMethod> incomePayMethods = this.payMethodService.loadPayMethods(userId, "in");
        final List<PayMethod> expendturePayMethods = this.payMethodService.loadPayMethods(userId, "ex");
        model.addAttribute("incomesItems", (Object)incomesItems);
        model.addAttribute("expenditureItems", (Object)expenditureItems);
        model.addAttribute("incomePayMethods", (Object)incomePayMethods);
        model.addAttribute("expendturePayMethods", (Object)expendturePayMethods);
        model.addAttribute("historys", (Object)historys);
        model.addAttribute("totalPages", (Object)totalPages);
        model.addAttribute("totalRecords", (Object)totalRecords);
        model.addAttribute("curPage", (Object)1);
        model.addAttribute("sessionUser", (Object)sessionUser);
        return "pages/history";
    }
    
    @RequestMapping({ "/showChartStatistics" })
    public String showChartStatistics(final Model model, final HttpSession session) {
        final String startdate = DateTimeUtil.firstDayOfThisMonth();
        final String enddate = DateTimeUtil.lastDayOfThisMonth();
        final SessionUser sessionUser = (SessionUser)session.getAttribute("session_user_key");
        final int userId = sessionUser.getUserId();
        final List<Map> incomeList = this.historyService.last12Income(userId);
        final List<Map> expenditureList = this.historyService.last12Expenditure(userId);
        model.addAttribute("last12Income", (Object)incomeList);
        model.addAttribute("last12Expenditure", (Object)expenditureList);
        final List<Map> incomeGroupByItemName = this.historyService.selectIncomeGroupByItemName(userId, startdate, enddate);
        final List<Map> expenditureGroupByItemName = this.historyService.selectExpenditureGroupByItemName(userId, startdate, enddate);
        final List<Map> allExpenditureGroupByItemName = this.historyService.selectAllExpenditureGroupByItemName(userId, startdate, enddate);
        model.addAttribute("inGroupByItemName", (Object)incomeGroupByItemName);
        model.addAttribute("exGroupByItemName", (Object)expenditureGroupByItemName);
        model.addAttribute("allExGroupByItemName", (Object)allExpenditureGroupByItemName);
        return "pages/chartStatistics";
    }
    
    @RequestMapping(value = { "/searchChartStatistics" }, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public Map<String, Object> searchChartStatistics(final Model model, final HttpSession session, final String startdate, final String enddate) {
        final Map<String, Object> map = new HashMap<String, Object>();
        final SessionUser sessionUser = (SessionUser)session.getAttribute("session_user_key");
        final int userId = sessionUser.getUserId();
        final List<Map> incomeGroupByItemName = this.historyService.selectIncomeGroupByItemName(userId, startdate, enddate);
        final List<Map> expenditureGroupByItemName = this.historyService.selectExpenditureGroupByItemName(userId, startdate, enddate);
        map.put("inGroupByItemName", incomeGroupByItemName);
        map.put("exGroupByItemName", expenditureGroupByItemName);
        return map;
    }
    
    @RequestMapping(value = { "/searchHistory" }, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public Map<String, Object> searchHistory(final HttpSession session, final Model model, final String type, final int year, final int month, final String keyword, final String sortBy, final int curPage) {
        final Map<String, Object> map = new HashMap<String, Object>();
        final SessionUser sessionUser = (SessionUser)session.getAttribute("session_user_key");
        final int userId = sessionUser.getUserId();
        final int limit = 20;
        final int totalRecords = this.historyService.countIncomesAndExpenditure(userId, type.equals("all") ? null : type, year, month, keyword);
        final int totalPages = (int)Math.ceil(totalRecords * 1.0 / limit);
        if (totalRecords == 0) {
            map.put("list", null);
            map.put("dateList", null);
            map.put("typeList", null);
            map.put("totalPages", 0);
            map.put("totalRecords", 0);
            map.put("curPage", 0);
            return map;
        }
        final List<Map> historys = this.historyService.loadIncomesAndExpenditure(userId, type.equals("all") ? null : type, year, month, keyword, sortBy, curPage, totalPages);
        final List<String> dateList = new ArrayList<String>();
        for (final Map history : historys) {
            final Date date = history.get("date");
            final Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            final int year2 = cal.get(1);
            final int month2 = cal.get(2) + 1;
            final int day1 = cal.get(5);
            dateList.add(String.valueOf(year2) + "-" + ((month2 < 10) ? ("0" + month2) : month2) + "-" + ((day1 < 10) ? ("0" + day1) : day1));
        }
        final List<String> typeList = new ArrayList<String>();
        for (final Map history2 : historys) {
            final String type2 = history2.get("itemType");
            typeList.add(type2.equals("ex") ? "\u652f\u51fa" : "\u6536\u5165");
        }
        map.put("list", historys);
        map.put("dateList", dateList);
        map.put("typeList", typeList);
        map.put("totalPages", totalPages);
        map.put("totalRecords", totalRecords);
        map.put("curPage", curPage);
        return map;
    }
    
    @RequestMapping({ "/changeHistory" })
    public void changeHistory(final String itemType, final String changedType, final int detailsId, final String changedDate, final float changedMoney, final String changedMoneyType, final int changedItem, final String changedRemark, final HttpSession session) {
        final int userId = (int)session.getAttribute("useId");
        if (itemType.equals(changedType)) {
            if (itemType.equals("in")) {
                this.incomeService.changeIncome(detailsId, changedMoney, changedMoneyType, changedItem, changedRemark, MyDateFormat.dateFormat(changedDate));
            }
            else {
                this.expenditureService.changeExpenditure(detailsId, changedMoney, changedMoneyType, changedItem, changedRemark, MyDateFormat.dateFormat(changedDate));
            }
        }
        else if (changedType.equals("in")) {
            this.incomeService.addIncome(userId, changedDate, changedItem, changedMoney, changedMoneyType, changedRemark);
            this.expenditureService.deleExpenditure(detailsId);
        }
        else {
            this.expenditureService.addExpenditure(userId, changedDate, changedItem, changedMoney, changedMoneyType, changedRemark);
            this.incomeService.deleIncome(detailsId);
        }
    }
    
    @RequestMapping({ "/deleHistory" })
    public void deleteHistory(final String itemType, final int historyId) {
        if (itemType.equals("in")) {
            this.incomeService.deleIncome(historyId);
        }
        else {
            this.expenditureService.deleExpenditure(historyId);
        }
    }
    
    public IHistoryService getHistoryService() {
        return this.historyService;
    }
    
    @Autowired
    public void setHistoryService(final IHistoryService historyService) {
        this.historyService = historyService;
    }
    
    public IExpenditureService getExpenditureService() {
        return this.expenditureService;
    }
    
    @Autowired
    public void setExpenditureService(final IExpenditureService expenditureService) {
        this.expenditureService = expenditureService;
    }
    
    public IIncomeService getIncomeService() {
        return this.incomeService;
    }
    
    @Autowired
    public void setIncomeService(final IIncomeService incomeService) {
        this.incomeService = incomeService;
    }
    
    public IItemService getItemService() {
        return this.itemService;
    }
    
    @Autowired
    public void setItemService(final IItemService itemService) {
        this.itemService = itemService;
    }
    
    public IPayMethodService getPayMethodService() {
        return this.payMethodService;
    }
    
    @Autowired
    public void setPayMethodService(final IPayMethodService payMethodService) {
        this.payMethodService = payMethodService;
    }
}
