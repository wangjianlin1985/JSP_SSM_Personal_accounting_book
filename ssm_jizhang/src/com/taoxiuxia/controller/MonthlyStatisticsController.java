// 
// 
// 

package com.taoxiuxia.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import com.taoxiuxia.service.IMonthlyStatisticsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping({ "/monthlyStatisticsController" })
public class MonthlyStatisticsController
{
    private IMonthlyStatisticsService monthlyStatisticsService;
    
    public IMonthlyStatisticsService getMonthlyStatisticsService() {
        return this.monthlyStatisticsService;
    }
    
    @Autowired
    public void setMonthlyStatisticsService(final IMonthlyStatisticsService monthlyStatisticsService) {
        this.monthlyStatisticsService = monthlyStatisticsService;
    }
    
    @RequestMapping({ "/addBalance" })
    public void addBalance(final float actualBalance, final HttpSession session) {
        final int userId = (int)session.getAttribute("useId");
        this.monthlyStatisticsService.addBalance(actualBalance, userId);
    }
    
    @RequestMapping({ "/changeBalance" })
    public void changeBalance(final int balanceId, final float changed_balance) {
        this.monthlyStatisticsService.changeBalance(balanceId, changed_balance);
    }
}
