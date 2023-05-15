// 
// 
// 

package com.taoxiuxia.mapper;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.taoxiuxia.model.BalanceExample;
import com.taoxiuxia.model.Balance;

public interface BalanceMapper
{
    float selectMonthlyIncome(int p0);
    
    float selectMonthlyExpenditure(int p0);
    
    float selectNotActualExpenditure(int p0);
    
    Balance selectBalanceInBeginOfMonth(int p0);
    
    Balance selectBalanceOfThisMonth(int p0);
    
    void insertBalance(Balance p0);
    
    void updateByPrimaryKeySelective(Balance p0);
    
    int countByExample(BalanceExample p0);
    
    int deleteByExample(BalanceExample p0);
    
    int deleteByPrimaryKey(Integer p0);
    
    int insert(Balance p0);
    
    int insertSelective(Balance p0);
    
    List<Balance> selectByExample(BalanceExample p0);
    
    Balance selectByPrimaryKey(Integer p0);
    
    int updateByExampleSelective(@Param("record") Balance p0, @Param("example") BalanceExample p1);
    
    int updateByExample(@Param("record") Balance p0, @Param("example") BalanceExample p1);
    
    int updateByPrimaryKey(Balance p0);
}
