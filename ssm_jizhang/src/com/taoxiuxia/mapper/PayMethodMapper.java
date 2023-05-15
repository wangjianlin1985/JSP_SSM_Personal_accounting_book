// 
// 
// 

package com.taoxiuxia.mapper;

import org.apache.ibatis.annotations.Param;
import com.taoxiuxia.model.PayMethodExample;
import com.taoxiuxia.model.PayMethod;
import java.util.List;
import java.util.Map;

public interface PayMethodMapper
{
    List<PayMethod> selectPayMethodsByUserId(Map<String, Object> p0);
    
    int updateByPrimaryKeySelective(PayMethod p0);
    
    Map<String, Object> insert(Map<String, Object> p0);
    
    int countByExample(PayMethodExample p0);
    
    int deleteByExample(PayMethodExample p0);
    
    int deleteByPrimaryKey(Integer p0);
    
    int insertSelective(PayMethod p0);
    
    List<PayMethod> selectByExample(PayMethodExample p0);
    
    PayMethod selectByPrimaryKey(Integer p0);
    
    int updateByExampleSelective(@Param("record") PayMethod p0, @Param("example") PayMethodExample p1);
    
    int updateByExample(@Param("record") PayMethod p0, @Param("example") PayMethodExample p1);
    
    int updateByPrimaryKey(PayMethod p0);
}
