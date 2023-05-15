// 
// 
// 

package com.taoxiuxia.mapper;

import java.util.Map;
import com.taoxiuxia.model.Expenditure;
import java.util.List;
import java.util.HashMap;

public interface ExpenditureMapper
{
    List<Expenditure> selectAllExpenditures(HashMap p0);
    
    int updateByPrimaryKeySelective(Expenditure p0);
    
    int insert(Expenditure p0);
    
    List<Map> searchLast12Expenditure(Map p0);
    
    List<Map> selectExpenditureGroupByItemName(Map p0);
    
    List<Map> selectAllExpenditureGroupByItemName(Map p0);
    
    int deleteByPrimaryKey(Integer p0);
    
    int insertSelective(Expenditure p0);
    
    Expenditure selectByPrimaryKey(Integer p0);
}
