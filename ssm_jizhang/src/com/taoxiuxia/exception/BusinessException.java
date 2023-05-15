// 
// 
// 

package com.taoxiuxia.exception;

public class BusinessException extends Exception
{
    private static final long serialVersionUID = -5587054685087764286L;
    
    public BusinessException(final String message, final Throwable e) {
        super(message, e);
    }
    
    public BusinessException(final String message) {
        super(message);
    }
    
    public BusinessException(final Throwable e) {
        super(e);
    }
    
    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
