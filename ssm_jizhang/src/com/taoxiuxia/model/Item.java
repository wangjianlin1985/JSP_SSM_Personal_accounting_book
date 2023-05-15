// 
// 
// 

package com.taoxiuxia.model;

public class Item
{
    private Integer id;
    private int userId;
    private String name;
    private String inOrEx;
    private String remark;
    private int dele;
    private int sort;
    
    public int getSort() {
        return this.sort;
    }
    
    public void setSort(final int sort) {
        this.sort = sort;
    }
    
    public int getUserId() {
        return this.userId;
    }
    
    public void setUserId(final int userId) {
        this.userId = userId;
    }
    
    public String getInOrEx() {
        return this.inOrEx;
    }
    
    public void setInOrEx(final String inOrEx) {
        this.inOrEx = inOrEx;
    }
    
    public int getDele() {
        return this.dele;
    }
    
    public void setDele(final int dele) {
        this.dele = dele;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(final Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(final String name) {
        this.name = ((name == null) ? null : name.trim());
    }
    
    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(final String remark) {
        this.remark = ((remark == null) ? null : remark.trim());
    }
}
