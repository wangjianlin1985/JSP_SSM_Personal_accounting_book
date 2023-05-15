// 
// 
// 

package com.taoxiuxia.service;

import com.taoxiuxia.model.PayMethod;
import java.util.List;

public interface IPayMethodService
{
    List<PayMethod> loadPayMethods(int p0, String p1);
    
    void addPayMethod(int p0, String p1, int p2, String p3, String p4);
    
    void changePayMethod(int p0, String p1, int p2, String p3);
    
    void delePayMethod(int p0);
    
    String upAndDownPayMethod(int p0, int p1, String p2, String p3);
}
