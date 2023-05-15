// 
// 
// 

package com.taoxiuxia.model;

import java.util.Date;

public class Income
{
    private int id;
    private int itemId;
    private String itemName;
    private int userId;
    private Float money;
    private String type_of_money;
    private Date date;
    private String remark;
    private int dele;
    private String payMethodName;
    private int payMethodId;
    
    public int getPayMethodId() {
        return this.payMethodId;
    }
    
    public void setPayMethodId(final int payMethodId) {
        this.payMethodId = payMethodId;
    }
    
    public String getPayMethodName() {
        return this.payMethodName;
    }
    
    public void setPayMethodName(final String payMethodName) {
        this.payMethodName = payMethodName;
    }
    
    public int getItemId() {
        return this.itemId;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public void setItemId(final int itemId) {
        this.itemId = itemId;
    }
    
    public int getUserId() {
        return this.userId;
    }
    
    public void setUserId(final int userId) {
        this.userId = userId;
    }
    
    public int getDele() {
        return this.dele;
    }
    
    public void setDele(final int dele) {
        this.dele = dele;
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
        this.remark = remark;
    }
    
    public String getItemName() {
        return this.itemName;
    }
    
    public void setItemName(final String itemName) {
        this.itemName = itemName;
    }
}
