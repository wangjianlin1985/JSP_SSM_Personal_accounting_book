// 
// 
// 

package com.taoxiuxia.service;

import java.util.Map;
import java.util.List;

public interface IHistoryService
{
    List<Map> loadIncomesAndExpenditure(int p0, String p1, int p2, int p3, String p4, String p5, int p6, int p7);
    
    int countIncomesAndExpenditure(int p0, String p1, int p2, int p3, String p4);
    
    List<Map> last12Income(int p0);
    
    List<Map> last12Expenditure(int p0);
    
    List<Map> selectIncomeGroupByItemName(int p0, String p1, String p2);
    
    List<Map> selectExpenditureGroupByItemName(int p0, String p1, String p2);
    
    List<Map> selectAllExpenditureGroupByItemName(int p0, String p1, String p2);
}
