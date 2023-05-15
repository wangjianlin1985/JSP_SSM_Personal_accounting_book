// 
// 
// 

package com.taoxiuxia.controller;

import com.taoxiuxia.model.Balance;
import java.util.HashMap;
import com.taoxiuxia.util.MyDateFormat;
import com.taoxiuxia.model.PayMethod;
import com.taoxiuxia.model.Item;
import com.taoxiuxia.model.Expenditure;
import java.util.List;
import java.util.Map;
import com.taoxiuxia.model.SessionUser;
import com.taoxiuxia.util.NumberFormat;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import com.taoxiuxia.service.IPayMethodService;
import com.taoxiuxia.service.IMonthlyStatisticsService;
import com.taoxiuxia.service.IItemService;
import com.taoxiuxia.service.IExpenditureService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping({ "/expenditureController" })
public class ExpenditureController
{
    private IExpenditureService expenditureService;
    private IItemService itemService;
    private IMonthlyStatisticsService monthlyStatisticsService;
    private IPayMethodService payMethodService;
    
    public IExpenditureService getExpenditureService() {
        return this.expenditureService;
    }
    
    @Autowired
    public void setExpenditureService(final IExpenditureService expenditureService) {
        this.expenditureService = expenditureService;
    }
    
    public IItemService getItemService() {
        return this.itemService;
    }
    
    @Autowired
    public void setItemService(final IItemService itemService) {
        this.itemService = itemService;
    }
    
    public IMonthlyStatisticsService getMonthlyStatisticsService() {
        return this.monthlyStatisticsService;
    }
    
    @Autowired
    public void setMonthlyStatisticsService(final IMonthlyStatisticsService monthlyStatisticsService) {
        this.monthlyStatisticsService = monthlyStatisticsService;
    }
    
    public IPayMethodService getPayMethodService() {
        return this.payMethodService;
    }
    
    @Autowired
    public void setPayMethodService(final IPayMethodService payMethodService) {
        this.payMethodService = payMethodService;
    }
    
    @RequestMapping({ "/showExpenditure" })
    public String showExpenditures(final Model model, final HttpSession session) {
        final Map<String, Float> map = this.monthlyStatistics(session);
        model.addAttribute("totalIncome", (Object)NumberFormat.save2Decimals(map.get("monthlyIncome")));
        model.addAttribute("totalExpenditure", (Object)NumberFormat.save2Decimals(map.get("monthlyExpenditure")));
        model.addAttribute("notActualExpenditure", (Object)NumberFormat.save2Decimals(map.get("notActualExpenditure")));
        model.addAttribute("balanceInBeginOfMonth", (Object)NumberFormat.save2Decimals(map.get("balanceInBeginOfMonth")));
        model.addAttribute("balanceId_InBeginOfMonth", (Object)NumberFormat.save2Decimals(map.get("balanceId_InBeginOfMonth")));
        model.addAttribute("balanceShould", (Object)NumberFormat.save2Decimals(map.get("balanceShould")));
        model.addAttribute("actualBalance", (Object)NumberFormat.save2Decimals(map.get("actualBalance")));
        model.addAttribute("actualBalanceId", (Object)NumberFormat.save2Decimals(map.get("actualBalanceId")));
        model.addAttribute("actualExpenditure", (Object)NumberFormat.save2Decimals(map.get("actualExpenditure")));
        final SessionUser sessionUser = (SessionUser)session.getAttribute("session_user_key");
        model.addAttribute("sessionUser", (Object)sessionUser);
        final int userId = sessionUser.getUserId();
        final List<Expenditure> expenditures = this.expenditureService.loadExpenditures(userId);
        model.addAttribute("expenditures", (Object)expenditures);
        final List<Item> items = this.itemService.loadExpenditureItems(userId);
        model.addAttribute("items", (Object)items);
        final List<PayMethod> payMethods = this.payMethodService.loadPayMethods(userId, "ex");
        model.addAttribute("payMethods", (Object)payMethods);
        return "pages/expenditure";
    }
    
    @RequestMapping({ "/addExpenditure" })
    public void addExpenditures(final String date, final int item, final float money, final String moneyType, final String remark, final HttpSession session) {
        final int userId = (int)session.getAttribute("useId");
        this.expenditureService.addExpenditure(userId, date, item, money, moneyType, remark);
    }
    
    @RequestMapping({ "/changeExpenditure" })
    public void changeExpenditures(final int expenditureId, final float money, final String moneyType, final int itemId, final String remark, final String date, final HttpSession session) {
        this.expenditureService.changeExpenditure(expenditureId, money, moneyType, itemId, remark, MyDateFormat.dateFormat(date));
    }
    
    @RequestMapping({ "/deleExpenditure" })
    public void deleExpenditure(final int expenditureId) {
        this.expenditureService.deleExpenditure(expenditureId);
    }
    
    public Map<String, Float> monthlyStatistics(final HttpSession session) {
        final int userId = (int)session.getAttribute("useId");
        final Map<String, Float> map = new HashMap<String, Float>();
        final float monthlyIncome = this.monthlyStatisticsService.monthlyIncome(userId);
        map.put("monthlyIncome", monthlyIncome);
        final float monthlyExpenditure = this.monthlyStatisticsService.monthlyExpenditure(userId);
        map.put("monthlyExpenditure", monthlyExpenditure);
        final float notActualExpenditure = this.monthlyStatisticsService.notActualExpenditure(userId);
        map.put("notActualExpenditure", notActualExpenditure);
        final float actualExpenditure = monthlyExpenditure - notActualExpenditure;
        map.put("actualExpenditure", actualExpenditure);
        final Balance balance_InBeginOfMonth = this.monthlyStatisticsService.balanceInBeginOfMonth(userId);
        final float actualBalance_InBeginOfMonth = balance_InBeginOfMonth.getActualBalance();
        map.put("balanceInBeginOfMonth", actualBalance_InBeginOfMonth);
        map.put("balanceId_InBeginOfMonth", balance_InBeginOfMonth.getId() + 0.0f);
        final float balanceShould = actualBalance_InBeginOfMonth + monthlyIncome - (monthlyExpenditure - notActualExpenditure);
        map.put("balanceShould", balanceShould);
        final Balance balanceOfThisMonth = this.monthlyStatisticsService.balanceOfThisMonth(userId);
        float actualBalance;
        float actualBalanceId;
        if (balanceOfThisMonth == null) {
            actualBalance = -1.0f;
            actualBalanceId = -1.0f;
        }
        else {
            actualBalance = balanceOfThisMonth.getActualBalance();
            actualBalanceId = balanceOfThisMonth.getId();
        }
        map.put("actualBalance", actualBalance);
        map.put("actualBalanceId", actualBalanceId);
        return map;
    }
}
