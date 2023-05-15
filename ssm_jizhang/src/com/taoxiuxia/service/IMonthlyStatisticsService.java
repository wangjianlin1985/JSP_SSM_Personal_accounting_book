// 
// 
// 

package com.taoxiuxia.service;

import com.taoxiuxia.model.Balance;

public interface IMonthlyStatisticsService
{
    float monthlyIncome(int p0);
    
    float monthlyExpenditure(int p0);
    
    float notActualExpenditure(int p0);
    
    Balance balanceInBeginOfMonth(int p0);
    
    Balance balanceOfThisMonth(int p0);
    
    void addBalance(float p0, int p1);
    
    void changeBalance(int p0, float p1);
}
