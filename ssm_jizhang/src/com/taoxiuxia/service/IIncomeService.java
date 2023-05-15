// 
// 
// 

package com.taoxiuxia.service;

import java.util.Date;
import com.taoxiuxia.model.Income;
import java.util.List;

public interface IIncomeService
{
    List<Income> loadIncomes(int p0);
    
    void addIncome(int p0, String p1, int p2, float p3, String p4, String p5);
    
    void changeIncome(int p0, float p1, String p2, int p3, String p4, Date p5);
    
    void deleIncome(int p0);
}
