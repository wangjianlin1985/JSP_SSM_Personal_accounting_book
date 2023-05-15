// 
// 
// 

package com.taoxiuxia.model;

import java.util.Date;

public class Expenditure
{
    private Integer id;
    private Integer itemId;
    private String itemName;
    private Integer userId;
    private Float money;
    private String type_of_money;
    private Date date;
    private String remark;
    private Integer dele;
    private String payMethodName;
    
    public String getPayMethodName() {
        return this.payMethodName;
    }
    
    public void setPayMethodName(final String payMethodName) {
        this.payMethodName = payMethodName;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(final Integer id) {
        this.id = id;
    }
    
    public Integer getItemId() {
        return this.itemId;
    }
    
    public String getItemName() {
        return this.itemName;
    }
    
    public void setItemName(final String itemName) {
        this.itemName = itemName;
    }
    
    public void setItemId(final Integer itemId) {
        this.itemId = itemId;
    }
    
    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(final Integer userId) {
        this.userId = userId;
    }
    
    public Float getMoney() {
        return this.money;
    }
    
    public void setMoney(final Float money) {
        this.money = money;
    }
    
    public String getType_of_money() {
        return this.type_of_money;
    }
    
    public void setType_of_money(final String type_of_money) {
        this.type_of_money = type_of_money;
    }
    
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(final Date date) {
        this.date = date;
    }
    
    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(final String remark) {
        this.remark = ((remark == null) ? null : remark.trim());
    }
    
    public Integer getDele() {
        return this.dele;
    }
    
    public void setDele(final Integer dele) {
        this.dele = dele;
    }
}
