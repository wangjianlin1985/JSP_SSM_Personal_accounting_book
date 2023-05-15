// 
// 
// 

package com.taoxiuxia.model;

public class PayMethod
{
    private Integer id;
    private Integer userId;
    private String name;
    private Integer isCountInThisMonthEx;
    private String inOrEx;
    private String remark;
    private Integer dele;
    private Integer sort;
    
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
    
    public String getName() {
        return this.name;
    }
    
    public void setName(final String name) {
        this.name = ((name == null) ? null : name.trim());
    }
    
    public Integer getIsCountInThisMonthEx() {
        return this.isCountInThisMonthEx;
    }
    
    public void setIsCountInThisMonthEx(final Integer isCountInThisMonthEx) {
        this.isCountInThisMonthEx = isCountInThisMonthEx;
    }
    
    public String getInOrEx() {
        return this.inOrEx;
    }
    
    public void setInOrEx(final String inOrEx) {
        this.inOrEx = ((inOrEx == null) ? null : inOrEx.trim());
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
    
    public Integer getSort() {
        return this.sort;
    }
    
    public void setSort(final Integer sort) {
        this.sort = sort;
    }
}
