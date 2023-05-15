// 
// 
// 

package com.taoxiuxia.service.impl;

import java.time.Instant;
import java.time.ZoneId;
import java.time.LocalDate;
import java.util.Date;
import com.taoxiuxia.model.Balance;
import org.springframework.beans.factory.annotation.Autowired;
import com.taoxiuxia.mapper.BalanceMapper;
import org.springframework.stereotype.Service;
import com.taoxiuxia.service.IMonthlyStatisticsService;

@Service("monthlyStatisticsService")
public class MonthlyStatisticsServiceImpl implements IMonthlyStatisticsService
{
    private BalanceMapper balanceMapper;
    
    public BalanceMapper getBalanceMapper() {
        return this.balanceMapper;
    }
    
    @Autowired
    public void setBalanceMapper(final BalanceMapper balanceMapper) {
        this.balanceMapper = balanceMapper;
    }
    
    @Override
    public float monthlyIncome(final int userId) {
        return this.balanceMapper.selectMonthlyIncome(userId);
    }
    
    @Override
    public float monthlyExpenditure(final int userId) {
        return this.balanceMapper.selectMonthlyExpenditure(userId);
    }
    
    @Override
    public float notActualExpenditure(final int userId) {
        return this.balanceMapper.selectNotActualExpenditure(userId);
    }
    
    @Override
    public Balance balanceInBeginOfMonth(final int userId) {
        if (this.balanceMapper.selectBalanceInBeginOfMonth(userId) == null) {
            final Balance balance = new Balance();
            balance.setUserId(userId);
            balance.setMonth(this.getLastMonth());
            balance.setActualBalance(0.0f);
            this.balanceMapper.insertBalance(balance);
            return balance;
        }
        return this.balanceMapper.selectBalanceInBeginOfMonth(userId);
    }
    
    @Override
    public Balance balanceOfThisMonth(final int userId) {
        return this.balanceMapper.selectBalanceOfThisMonth(userId);
    }
    
    @Override
    public void addBalance(final float balanceMoney, final int userId) {
        final Balance balance = new Balance();
        balance.setUserId(userId);
        balance.setActualBalance(balanceMoney);
        balance.setMonth(new Date());
        this.balanceMapper.insertBalance(balance);
    }
    
    @Override
    public void changeBalance(final int balanceId, final float changed_balance) {
        final Balance balance = new Balance();
        balance.setId(balanceId);
        balance.setActualBalance(changed_balance);
        this.balanceMapper.updateByPrimaryKeySelective(balance);
    }
    
    public Date getLastMonth() {
        LocalDate localDate = LocalDate.now();
        localDate = localDate.minusMonths(1L);
        final ZoneId zone = ZoneId.systemDefault();
        final Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        final Date date = Date.from(instant);
        return date;
    }
}
