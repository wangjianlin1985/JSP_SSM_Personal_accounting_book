// 
// 
// 

package com.taoxiuxia.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

public class SpringContextUtil
{
    private static ApplicationContext context;
    
    static {
        SpringContextUtil.context = null;
    }
    
    public static void setContext(final ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.context = applicationContext;
    }
    
    public static Object getBean(final String name) {
        return SpringContextUtil.context.getBean(name);
    }
}
