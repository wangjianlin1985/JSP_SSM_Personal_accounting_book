// 
// 
// 

package com.taoxiuxia.service;

import java.util.Date;
import com.taoxiuxia.model.Expenditure;
import java.util.List;

public interface IExpenditureService
{
    List<Expenditure> loadExpenditures(int p0);
    
    void addExpenditure(int p0, String p1, int p2, float p3, String p4, String p5);
    
    void changeExpenditure(int p0, float p1, String p2, int p3, String p4, Date p5);
    
    void deleExpenditure(int p0);
}
