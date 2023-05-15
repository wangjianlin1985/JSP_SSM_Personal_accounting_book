// 
// 
// 

package com.taoxiuxia.mapper;

import java.util.Map;
import com.taoxiuxia.model.Income;
import java.util.List;
import java.util.HashMap;

public interface IncomeMapper
{
    List<Income> selectAllIncomes(HashMap p0);
    
    List<Map> selectIncomesAndExpenditure(HashMap p0);
    
    int countIncomesAndExpenditure(HashMap p0);
    
    int updateByPrimaryKeySelective(Income p0);
    
    int insert(Income p0);
    
    List<Map> searchLast12Income(Map p0);
    
    List<Map> selectIncomeGroupByItemName(Map p0);
    
    int deleteByPrimaryKey(Integer p0);
    
    int insertSelective(Income p0);
    
    Income selectByPrimaryKey(Integer p0);
    
    int updateByPrimaryKey(Income p0);
}
