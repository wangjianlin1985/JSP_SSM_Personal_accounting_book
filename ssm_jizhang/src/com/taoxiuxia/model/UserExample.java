// 
// 
// 

package com.taoxiuxia.model;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class UserExample
{
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;
    
    public UserExample() {
        this.oredCriteria = new ArrayList<Criteria>();
    }
    
    public void setOrderByClause(final String orderByClause) {
        this.orderByClause = orderByClause;
    }
    
    public String getOrderByClause() {
        return this.orderByClause;
    }
    
    public void setDistinct(final boolean distinct) {
        this.distinct = distinct;
    }
    
    public boolean isDistinct() {
        return this.distinct;
    }
    
    public List<Criteria> getOredCriteria() {
        return this.oredCriteria;
    }
    
    public void or(final Criteria criteria) {
        this.oredCriteria.add(criteria);
    }
    
    public Criteria or() {
        final Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }
    
    public Criteria createCriteria() {
        final Criteria criteria = this.createCriteriaInternal();
        if (this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }
        return criteria;
    }
    
    protected Criteria createCriteriaInternal() {
        final Criteria criteria = new Criteria();
        return criteria;
    }
    
    public void clear() {
        this.oredCriteria.clear();
        this.orderByClause = null;
        this.distinct = false;
    }
    
    public static class Criteria extends GeneratedCriteria
    {
    }
    
    protected abstract static class GeneratedCriteria
    {
        protected List<Criterion> criteria;
        
        protected GeneratedCriteria() {
            this.criteria = new ArrayList<Criterion>();
        }
        
        public boolean isValid() {
            return this.criteria.size() > 0;
        }
        
        public List<Criterion> getAllCriteria() {
            return this.criteria;
        }
        
        public List<Criterion> getCriteria() {
            return this.criteria;
        }
        
        protected void addCriterion(final String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            this.criteria.add(new Criterion(condition));
        }
        
        protected void addCriterion(final String condition, final Object value, final String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            this.criteria.add(new Criterion(condition, value));
        }
        
        protected void addCriterion(final String condition, final Object value1, final Object value2, final String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            this.criteria.add(new Criterion(condition, value1, value2));
        }
        
        public Criteria andIdIsNull() {
            this.addCriterion("id is null");
            return (Criteria)this;
        }
        
        public Criteria andIdIsNotNull() {
            this.addCriterion("id is not null");
            return (Criteria)this;
        }
        
        public Criteria andIdEqualTo(final Integer value) {
            this.addCriterion("id =", value, "id");
            return (Criteria)this;
        }
        
        public Criteria andIdNotEqualTo(final Integer value) {
            this.addCriterion("id <>", value, "id");
            return (Criteria)this;
        }
        
        public Criteria andIdGreaterThan(final Integer value) {
            this.addCriterion("id >", value, "id");
            return (Criteria)this;
        }
        
        public Criteria andIdGreaterThanOrEqualTo(final Integer value) {
            this.addCriterion("id >=", value, "id");
            return (Criteria)this;
        }
        
        public Criteria andIdLessThan(final Integer value) {
            this.addCriterion("id <", value, "id");
            return (Criteria)this;
        }
        
        public Criteria andIdLessThanOrEqualTo(final Integer value) {
            this.addCriterion("id <=", value, "id");
            return (Criteria)this;
        }
        
        public Criteria andIdIn(final List<Integer> values) {
            this.addCriterion("id in", values, "id");
            return (Criteria)this;
        }
        
        public Criteria andIdNotIn(final List<Integer> values) {
            this.addCriterion("id not in", values, "id");
            return (Criteria)this;
        }
        
        public Criteria andIdBetween(final Integer value1, final Integer value2) {
            this.addCriterion("id between", value1, value2, "id");
            return (Criteria)this;
        }
        
        public Criteria andIdNotBetween(final Integer value1, final Integer value2) {
            this.addCriterion("id not between", value1, value2, "id");
            return (Criteria)this;
        }
        
        public Criteria andNameIsNull() {
            this.addCriterion("name is null");
            return (Criteria)this;
        }
        
        public Criteria andNameIsNotNull() {
            this.addCriterion("name is not null");
            return (Criteria)this;
        }
        
        public Criteria andNameEqualTo(final String value) {
            this.addCriterion("name =", value, "name");
            return (Criteria)this;
        }
        
        public Criteria andNameNotEqualTo(final String value) {
            this.addCriterion("name <>", value, "name");
            return (Criteria)this;
        }
        
        public Criteria andNameGreaterThan(final String value) {
            this.addCriterion("name >", value, "name");
            return (Criteria)this;
        }
        
        public Criteria andNameGreaterThanOrEqualTo(final String value) {
            this.addCriterion("name >=", value, "name");
            return (Criteria)this;
        }
        
        public Criteria andNameLessThan(final String value) {
            this.addCriterion("name <", value, "name");
            return (Criteria)this;
        }
        
        public Criteria andNameLessThanOrEqualTo(final String value) {
            this.addCriterion("name <=", value, "name");
            return (Criteria)this;
        }
        
        public Criteria andNameLike(final String value) {
            this.addCriterion("name like", value, "name");
            return (Criteria)this;
        }
        
        public Criteria andNameNotLike(final String value) {
            this.addCriterion("name not like", value, "name");
            return (Criteria)this;
        }
        
        public Criteria andNameIn(final List<String> values) {
            this.addCriterion("name in", values, "name");
            return (Criteria)this;
        }
        
        public Criteria andNameNotIn(final List<String> values) {
            this.addCriterion("name not in", values, "name");
            return (Criteria)this;
        }
        
        public Criteria andNameBetween(final String value1, final String value2) {
            this.addCriterion("name between", value1, value2, "name");
            return (Criteria)this;
        }
        
        public Criteria andNameNotBetween(final String value1, final String value2) {
            this.addCriterion("name not between", value1, value2, "name");
            return (Criteria)this;
        }
        
        public Criteria andEmailIsNull() {
            this.addCriterion("email is null");
            return (Criteria)this;
        }
        
        public Criteria andEmailIsNotNull() {
            this.addCriterion("email is not null");
            return (Criteria)this;
        }
        
        public Criteria andEmailEqualTo(final String value) {
            this.addCriterion("email =", value, "email");
            return (Criteria)this;
        }
        
        public Criteria andEmailNotEqualTo(final String value) {
            this.addCriterion("email <>", value, "email");
            return (Criteria)this;
        }
        
        public Criteria andEmailGreaterThan(final String value) {
            this.addCriterion("email >", value, "email");
            return (Criteria)this;
        }
        
        public Criteria andEmailGreaterThanOrEqualTo(final String value) {
            this.addCriterion("email >=", value, "email");
            return (Criteria)this;
        }
        
        public Criteria andEmailLessThan(final String value) {
            this.addCriterion("email <", value, "email");
            return (Criteria)this;
        }
        
        public Criteria andEmailLessThanOrEqualTo(final String value) {
            this.addCriterion("email <=", value, "email");
            return (Criteria)this;
        }
        
        public Criteria andEmailLike(final String value) {
            this.addCriterion("email like", value, "email");
            return (Criteria)this;
        }
        
        public Criteria andEmailNotLike(final String value) {
            this.addCriterion("email not like", value, "email");
            return (Criteria)this;
        }
        
        public Criteria andEmailIn(final List<String> values) {
            this.addCriterion("email in", values, "email");
            return (Criteria)this;
        }
        
        public Criteria andEmailNotIn(final List<String> values) {
            this.addCriterion("email not in", values, "email");
            return (Criteria)this;
        }
        
        public Criteria andEmailBetween(final String value1, final String value2) {
            this.addCriterion("email between", value1, value2, "email");
            return (Criteria)this;
        }
        
        public Criteria andEmailNotBetween(final String value1, final String value2) {
            this.addCriterion("email not between", value1, value2, "email");
            return (Criteria)this;
        }
        
        public Criteria andPasswordIsNull() {
            this.addCriterion("password is null");
            return (Criteria)this;
        }
        
        public Criteria andPasswordIsNotNull() {
            this.addCriterion("password is not null");
            return (Criteria)this;
        }
        
        public Criteria andPasswordEqualTo(final String value) {
            this.addCriterion("password =", value, "password");
            return (Criteria)this;
        }
        
        public Criteria andPasswordNotEqualTo(final String value) {
            this.addCriterion("password <>", value, "password");
            return (Criteria)this;
        }
        
        public Criteria andPasswordGreaterThan(final String value) {
            this.addCriterion("password >", value, "password");
            return (Criteria)this;
        }
        
        public Criteria andPasswordGreaterThanOrEqualTo(final String value) {
            this.addCriterion("password >=", value, "password");
            return (Criteria)this;
        }
        
        public Criteria andPasswordLessThan(final String value) {
            this.addCriterion("password <", value, "password");
            return (Criteria)this;
        }
        
        public Criteria andPasswordLessThanOrEqualTo(final String value) {
            this.addCriterion("password <=", value, "password");
            return (Criteria)this;
        }
        
        public Criteria andPasswordLike(final String value) {
            this.addCriterion("password like", value, "password");
            return (Criteria)this;
        }
        
        public Criteria andPasswordNotLike(final String value) {
            this.addCriterion("password not like", value, "password");
            return (Criteria)this;
        }
        
        public Criteria andPasswordIn(final List<String> values) {
            this.addCriterion("password in", values, "password");
            return (Criteria)this;
        }
        
        public Criteria andPasswordNotIn(final List<String> values) {
            this.addCriterion("password not in", values, "password");
            return (Criteria)this;
        }
        
        public Criteria andPasswordBetween(final String value1, final String value2) {
            this.addCriterion("password between", value1, value2, "password");
            return (Criteria)this;
        }
        
        public Criteria andPasswordNotBetween(final String value1, final String value2) {
            this.addCriterion("password not between", value1, value2, "password");
            return (Criteria)this;
        }
        
        public Criteria andAgeIsNull() {
            this.addCriterion("age is null");
            return (Criteria)this;
        }
        
        public Criteria andAgeIsNotNull() {
            this.addCriterion("age is not null");
            return (Criteria)this;
        }
        
        public Criteria andAgeEqualTo(final Integer value) {
            this.addCriterion("age =", value, "age");
            return (Criteria)this;
        }
        
        public Criteria andAgeNotEqualTo(final Integer value) {
            this.addCriterion("age <>", value, "age");
            return (Criteria)this;
        }
        
        public Criteria andAgeGreaterThan(final Integer value) {
            this.addCriterion("age >", value, "age");
            return (Criteria)this;
        }
        
        public Criteria andAgeGreaterThanOrEqualTo(final Integer value) {
            this.addCriterion("age >=", value, "age");
            return (Criteria)this;
        }
        
        public Criteria andAgeLessThan(final Integer value) {
            this.addCriterion("age <", value, "age");
            return (Criteria)this;
        }
        
        public Criteria andAgeLessThanOrEqualTo(final Integer value) {
            this.addCriterion("age <=", value, "age");
            return (Criteria)this;
        }
        
        public Criteria andAgeIn(final List<Integer> values) {
            this.addCriterion("age in", values, "age");
            return (Criteria)this;
        }
        
        public Criteria andAgeNotIn(final List<Integer> values) {
            this.addCriterion("age not in", values, "age");
            return (Criteria)this;
        }
        
        public Criteria andAgeBetween(final Integer value1, final Integer value2) {
            this.addCriterion("age between", value1, value2, "age");
            return (Criteria)this;
        }
        
        public Criteria andAgeNotBetween(final Integer value1, final Integer value2) {
            this.addCriterion("age not between", value1, value2, "age");
            return (Criteria)this;
        }
        
        public Criteria andSexIsNull() {
            this.addCriterion("sex is null");
            return (Criteria)this;
        }
        
        public Criteria andSexIsNotNull() {
            this.addCriterion("sex is not null");
            return (Criteria)this;
        }
        
        public Criteria andSexEqualTo(final String value) {
            this.addCriterion("sex =", value, "sex");
            return (Criteria)this;
        }
        
        public Criteria andSexNotEqualTo(final String value) {
            this.addCriterion("sex <>", value, "sex");
            return (Criteria)this;
        }
        
        public Criteria andSexGreaterThan(final String value) {
            this.addCriterion("sex >", value, "sex");
            return (Criteria)this;
        }
        
        public Criteria andSexGreaterThanOrEqualTo(final String value) {
            this.addCriterion("sex >=", value, "sex");
            return (Criteria)this;
        }
        
        public Criteria andSexLessThan(final String value) {
            this.addCriterion("sex <", value, "sex");
            return (Criteria)this;
        }
        
        public Criteria andSexLessThanOrEqualTo(final String value) {
            this.addCriterion("sex <=", value, "sex");
            return (Criteria)this;
        }
        
        public Criteria andSexLike(final String value) {
            this.addCriterion("sex like", value, "sex");
            return (Criteria)this;
        }
        
        public Criteria andSexNotLike(final String value) {
            this.addCriterion("sex not like", value, "sex");
            return (Criteria)this;
        }
        
        public Criteria andSexIn(final List<String> values) {
            this.addCriterion("sex in", values, "sex");
            return (Criteria)this;
        }
        
        public Criteria andSexNotIn(final List<String> values) {
            this.addCriterion("sex not in", values, "sex");
            return (Criteria)this;
        }
        
        public Criteria andSexBetween(final String value1, final String value2) {
            this.addCriterion("sex between", value1, value2, "sex");
            return (Criteria)this;
        }
        
        public Criteria andSexNotBetween(final String value1, final String value2) {
            this.addCriterion("sex not between", value1, value2, "sex");
            return (Criteria)this;
        }
        
        public Criteria andRemarkIsNull() {
            this.addCriterion("remark is null");
            return (Criteria)this;
        }
        
        public Criteria andRemarkIsNotNull() {
            this.addCriterion("remark is not null");
            return (Criteria)this;
        }
        
        public Criteria andRemarkEqualTo(final String value) {
            this.addCriterion("remark =", value, "remark");
            return (Criteria)this;
        }
        
        public Criteria andRemarkNotEqualTo(final String value) {
            this.addCriterion("remark <>", value, "remark");
            return (Criteria)this;
        }
        
        public Criteria andRemarkGreaterThan(final String value) {
            this.addCriterion("remark >", value, "remark");
            return (Criteria)this;
        }
        
        public Criteria andRemarkGreaterThanOrEqualTo(final String value) {
            this.addCriterion("remark >=", value, "remark");
            return (Criteria)this;
        }
        
        public Criteria andRemarkLessThan(final String value) {
            this.addCriterion("remark <", value, "remark");
            return (Criteria)this;
        }
        
        public Criteria andRemarkLessThanOrEqualTo(final String value) {
            this.addCriterion("remark <=", value, "remark");
            return (Criteria)this;
        }
        
        public Criteria andRemarkLike(final String value) {
            this.addCriterion("remark like", value, "remark");
            return (Criteria)this;
        }
        
        public Criteria andRemarkNotLike(final String value) {
            this.addCriterion("remark not like", value, "remark");
            return (Criteria)this;
        }
        
        public Criteria andRemarkIn(final List<String> values) {
            this.addCriterion("remark in", values, "remark");
            return (Criteria)this;
        }
        
        public Criteria andRemarkNotIn(final List<String> values) {
            this.addCriterion("remark not in", values, "remark");
            return (Criteria)this;
        }
        
        public Criteria andRemarkBetween(final String value1, final String value2) {
            this.addCriterion("remark between", value1, value2, "remark");
            return (Criteria)this;
        }
        
        public Criteria andRemarkNotBetween(final String value1, final String value2) {
            this.addCriterion("remark not between", value1, value2, "remark");
            return (Criteria)this;
        }
        
        public Criteria andRegisterTimeIsNull() {
            this.addCriterion("register_time is null");
            return (Criteria)this;
        }
        
        public Criteria andRegisterTimeIsNotNull() {
            this.addCriterion("register_time is not null");
            return (Criteria)this;
        }
        
        public Criteria andRegisterTimeEqualTo(final Date value) {
            this.addCriterion("register_time =", value, "registerTime");
            return (Criteria)this;
        }
        
        public Criteria andRegisterTimeNotEqualTo(final Date value) {
            this.addCriterion("register_time <>", value, "registerTime");
            return (Criteria)this;
        }
        
        public Criteria andRegisterTimeGreaterThan(final Date value) {
            this.addCriterion("register_time >", value, "registerTime");
            return (Criteria)this;
        }
        
        public Criteria andRegisterTimeGreaterThanOrEqualTo(final Date value) {
            this.addCriterion("register_time >=", value, "registerTime");
            return (Criteria)this;
        }
        
        public Criteria andRegisterTimeLessThan(final Date value) {
            this.addCriterion("register_time <", value, "registerTime");
            return (Criteria)this;
        }
        
        public Criteria andRegisterTimeLessThanOrEqualTo(final Date value) {
            this.addCriterion("register_time <=", value, "registerTime");
            return (Criteria)this;
        }
        
        public Criteria andRegisterTimeIn(final List<Date> values) {
            this.addCriterion("register_time in", values, "registerTime");
            return (Criteria)this;
        }
        
        public Criteria andRegisterTimeNotIn(final List<Date> values) {
            this.addCriterion("register_time not in", values, "registerTime");
            return (Criteria)this;
        }
        
        public Criteria andRegisterTimeBetween(final Date value1, final Date value2) {
            this.addCriterion("register_time between", value1, value2, "registerTime");
            return (Criteria)this;
        }
        
        public Criteria andRegisterTimeNotBetween(final Date value1, final Date value2) {
            this.addCriterion("register_time not between", value1, value2, "registerTime");
            return (Criteria)this;
        }
        
        public Criteria andLastLoginTimeIsNull() {
            this.addCriterion("last_login_time is null");
            return (Criteria)this;
        }
        
        public Criteria andLastLoginTimeIsNotNull() {
            this.addCriterion("last_login_time is not null");
            return (Criteria)this;
        }
        
        public Criteria andLastLoginTimeEqualTo(final Date value) {
            this.addCriterion("last_login_time =", value, "lastLoginTime");
            return (Criteria)this;
        }
        
        public Criteria andLastLoginTimeNotEqualTo(final Date value) {
            this.addCriterion("last_login_time <>", value, "lastLoginTime");
            return (Criteria)this;
        }
        
        public Criteria andLastLoginTimeGreaterThan(final Date value) {
            this.addCriterion("last_login_time >", value, "lastLoginTime");
            return (Criteria)this;
        }
        
        public Criteria andLastLoginTimeGreaterThanOrEqualTo(final Date value) {
            this.addCriterion("last_login_time >=", value, "lastLoginTime");
            return (Criteria)this;
        }
        
        public Criteria andLastLoginTimeLessThan(final Date value) {
            this.addCriterion("last_login_time <", value, "lastLoginTime");
            return (Criteria)this;
        }
        
        public Criteria andLastLoginTimeLessThanOrEqualTo(final Date value) {
            this.addCriterion("last_login_time <=", value, "lastLoginTime");
            return (Criteria)this;
        }
        
        public Criteria andLastLoginTimeIn(final List<Date> values) {
            this.addCriterion("last_login_time in", values, "lastLoginTime");
            return (Criteria)this;
        }
        
        public Criteria andLastLoginTimeNotIn(final List<Date> values) {
            this.addCriterion("last_login_time not in", values, "lastLoginTime");
            return (Criteria)this;
        }
        
        public Criteria andLastLoginTimeBetween(final Date value1, final Date value2) {
            this.addCriterion("last_login_time between", value1, value2, "lastLoginTime");
            return (Criteria)this;
        }
        
        public Criteria andLastLoginTimeNotBetween(final Date value1, final Date value2) {
            this.addCriterion("last_login_time not between", value1, value2, "lastLoginTime");
            return (Criteria)this;
        }
        
        public Criteria andActivationCodeIsNull() {
            this.addCriterion("activation_code is null");
            return (Criteria)this;
        }
        
        public Criteria andActivationCodeIsNotNull() {
            this.addCriterion("activation_code is not null");
            return (Criteria)this;
        }
        
        public Criteria andActivationCodeEqualTo(final String value) {
            this.addCriterion("activation_code =", value, "activationCode");
            return (Criteria)this;
        }
        
        public Criteria andActivationCodeNotEqualTo(final String value) {
            this.addCriterion("activation_code <>", value, "activationCode");
            return (Criteria)this;
        }
        
        public Criteria andActivationCodeGreaterThan(final String value) {
            this.addCriterion("activation_code >", value, "activationCode");
            return (Criteria)this;
        }
        
        public Criteria andActivationCodeGreaterThanOrEqualTo(final String value) {
            this.addCriterion("activation_code >=", value, "activationCode");
            return (Criteria)this;
        }
        
        public Criteria andActivationCodeLessThan(final String value) {
            this.addCriterion("activation_code <", value, "activationCode");
            return (Criteria)this;
        }
        
        public Criteria andActivationCodeLessThanOrEqualTo(final String value) {
            this.addCriterion("activation_code <=", value, "activationCode");
            return (Criteria)this;
        }
        
        public Criteria andActivationCodeLike(final String value) {
            this.addCriterion("activation_code like", value, "activationCode");
            return (Criteria)this;
        }
        
        public Criteria andActivationCodeNotLike(final String value) {
            this.addCriterion("activation_code not like", value, "activationCode");
            return (Criteria)this;
        }
        
        public Criteria andActivationCodeIn(final List<String> values) {
            this.addCriterion("activation_code in", values, "activationCode");
            return (Criteria)this;
        }
        
        public Criteria andActivationCodeNotIn(final List<String> values) {
            this.addCriterion("activation_code not in", values, "activationCode");
            return (Criteria)this;
        }
        
        public Criteria andActivationCodeBetween(final String value1, final String value2) {
            this.addCriterion("activation_code between", value1, value2, "activationCode");
            return (Criteria)this;
        }
        
        public Criteria andActivationCodeNotBetween(final String value1, final String value2) {
            this.addCriterion("activation_code not between", value1, value2, "activationCode");
            return (Criteria)this;
        }
    }
    
    public static class Criterion
    {
        private String condition;
        private Object value;
        private Object secondValue;
        private boolean noValue;
        private boolean singleValue;
        private boolean betweenValue;
        private boolean listValue;
        private String typeHandler;
        
        public String getCondition() {
            return this.condition;
        }
        
        public Object getValue() {
            return this.value;
        }
        
        public Object getSecondValue() {
            return this.secondValue;
        }
        
        public boolean isNoValue() {
            return this.noValue;
        }
        
        public boolean isSingleValue() {
            return this.singleValue;
        }
        
        public boolean isBetweenValue() {
            return this.betweenValue;
        }
        
        public boolean isListValue() {
            return this.listValue;
        }
        
        public String getTypeHandler() {
            return this.typeHandler;
        }
        
        protected Criterion(final String condition) {
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }
        
        protected Criterion(final String condition, final Object value, final String typeHandler) {
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List) {
                this.listValue = true;
            }
            else {
                this.singleValue = true;
            }
        }
        
        protected Criterion(final String condition, final Object value) {
            this(condition, value, null);
        }
        
        protected Criterion(final String condition, final Object value, final Object secondValue, final String typeHandler) {
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }
        
        protected Criterion(final String condition, final Object value, final Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
