// 
// 
// 

package com.taoxiuxia.model;

import java.util.Date;

public class User
{
    private Integer id;
    private String name;
    private String email;
    private String password;
    private Integer age;
    private String sex;
    private String remark;
    private Date registerTime;
    private Date lastLoginTime;
    private Integer isActive;
    private String activationCode;
    private String activationCodeTime;
    
    public Integer getIsActive() {
        return this.isActive;
    }
    
    public void setIsActive(final Integer isActive) {
        this.isActive = isActive;
    }
    
    public String getActivationCodeTime() {
        return this.activationCodeTime;
    }
    
    public void setActivationCodeTime(final String activationCodeTime) {
        this.activationCodeTime = activationCodeTime;
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
    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(final String email) {
        this.email = ((email == null) ? null : email.trim());
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(final String password) {
        this.password = ((password == null) ? null : password.trim());
    }
    
    public Integer getAge() {
        return this.age;
    }
    
    public void setAge(final Integer age) {
        this.age = age;
    }
    
    public String getSex() {
        return this.sex;
    }
    
    public void setSex(final String sex) {
        this.sex = ((sex == null) ? null : sex.trim());
    }
    
    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(final String remark) {
        this.remark = ((remark == null) ? null : remark.trim());
    }
    
    public Date getRegisterTime() {
        return this.registerTime;
    }
    
    public void setRegisterTime(final Date registerTime) {
        this.registerTime = registerTime;
    }
    
    public Date getLastLoginTime() {
        return this.lastLoginTime;
    }
    
    public void setLastLoginTime(final Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
    
    public String getActivationCode() {
        return this.activationCode;
    }
    
    public void setActivationCode(final String activationCode) {
        this.activationCode = ((activationCode == null) ? null : activationCode.trim());
    }
}
