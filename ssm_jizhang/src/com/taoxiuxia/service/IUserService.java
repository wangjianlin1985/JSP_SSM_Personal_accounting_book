// 
// 
// 

package com.taoxiuxia.service;

import com.taoxiuxia.model.User;

public interface IUserService
{
    int register(User p0);
    
    User login(String p0, String p1, boolean p2) throws Exception;
    
    void update(User p0);
    
    int isEmailRegister(String p0);
    
    String active(String p0, String p1);
    
    User findUserByEmail(String p0);
    
    User findUserByUserName(String p0);
}
