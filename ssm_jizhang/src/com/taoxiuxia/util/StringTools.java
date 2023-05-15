// 
// 
// 

package com.taoxiuxia.util;

public class StringTools
{
    public static boolean isEmpty(final String str) {
        return str == null || "".equals(str) || "null".equals(str) || "".equals(str.trim());
    }
    
    public static boolean isNumber(final String str) {
        final String checkPassword = "^[0-9]+$";
        return str != null && str.matches(checkPassword);
    }
    
    public static boolean checkEmail(final String email) {
        final String checkEamil = "^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$";
        return !isEmpty(email) && email.matches(checkEamil);
    }
    
    public static boolean checkUsername(final String userName) {
        final String checkUsername = "^[\\w\\u4e00-\\u9fa5]+$";
        return !isEmpty(userName) && userName.matches(checkUsername);
    }
    
    public static boolean checkPassword(final String password) {
        final String checkPassword = "^[0-9a-zA-Z]+$";
        return !isEmpty(password) && password.matches(checkPassword);
    }
}
