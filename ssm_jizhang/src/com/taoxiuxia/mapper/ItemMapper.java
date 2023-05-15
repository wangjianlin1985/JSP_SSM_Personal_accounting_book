// 
// 
// 

package com.taoxiuxia.mapper;

import org.apache.ibatis.annotations.Param;
import com.taoxiuxia.model.ItemExample;
import java.util.Map;
import com.taoxiuxia.model.Item;
import java.util.List;

public interface ItemMapper
{
    List<Item> selectIncomeItemByUserId(int p0);
    
    List<Item> selectExpenditureItemByUserId(int p0);
    
    Map<String, Object> insert(Map<String, Object> p0);
    
    int updateByPrimaryKeySelective(Item p0);
    
    List<Item> selectByExample(ItemExample p0);
    
    int updateByExampleSelective(@Param("record") Item p0, @Param("example") ItemExample p1);
    
    int updateByExample(@Param("record") Item p0, @Param("example") ItemExample p1);
    
    int updateByPrimaryKey(Item p0);
}
