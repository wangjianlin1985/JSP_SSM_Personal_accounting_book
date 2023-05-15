// 
// 
// 

package com.taoxiuxia.model;

import java.util.Date;

public class Balance
{
    private Integer id;
    private Integer userId;
    private Date month;
    private Float actualBalance;
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(final Integer id) {
        this.id = id;
    }
    
    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(final Integer userId) {
        this.userId = userId;
    }
    
    public Date getMonth() {
        return this.month;
    }
    
    public void setMonth(final Date month) {
        this.month = month;
    }
    
    public Float getActualBalance() {
        return this.actualBalance;
    }
    
    public void setActualBalance(final Float actualBalance) {
        this.actualBalance = actualBalance;
    }
    
    @Override
    public String toString() {
        return "Balance [id=" + this.id + ", userId=" + this.userId + ", month=" + this.month + ", actualBalance=" + this.actualBalance + "]";
    }
}
