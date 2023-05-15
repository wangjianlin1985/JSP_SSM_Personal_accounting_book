// 
// 
// 

package com.taoxiuxia.model;

import java.util.Iterator;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class BalanceExample
{
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;
    
    public BalanceExample() {
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
        
        protected void addCriterionForJDBCDate(final String condition, final Date value, final String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            this.addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }
        
        protected void addCriterionForJDBCDate(final String condition, final List<Date> values, final String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            final List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            final Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            this.addCriterion(condition, dateList, property);
        }
        
        protected void addCriterionForJDBCDate(final String condition, final Date value1, final Date value2, final String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            this.addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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
        
        public Criteria andUserIdIsNull() {
            this.addCriterion("user_id is null");
            return (Criteria)this;
        }
        
        public Criteria andUserIdIsNotNull() {
            this.addCriterion("user_id is not null");
            return (Criteria)this;
        }
        
        public Criteria andUserIdEqualTo(final Integer value) {
            this.addCriterion("user_id =", value, "userId");
            return (Criteria)this;
        }
        
        public Criteria andUserIdNotEqualTo(final Integer value) {
            this.addCriterion("user_id <>", value, "userId");
            return (Criteria)this;
        }
        
        public Criteria andUserIdGreaterThan(final Integer value) {
            this.addCriterion("user_id >", value, "userId");
            return (Criteria)this;
        }
        
        public Criteria andUserIdGreaterThanOrEqualTo(final Integer value) {
            this.addCriterion("user_id >=", value, "userId");
            return (Criteria)this;
        }
        
        public Criteria andUserIdLessThan(final Integer value) {
            this.addCriterion("user_id <", value, "userId");
            return (Criteria)this;
        }
        
        public Criteria andUserIdLessThanOrEqualTo(final Integer value) {
            this.addCriterion("user_id <=", value, "userId");
            return (Criteria)this;
        }
        
        public Criteria andUserIdIn(final List<Integer> values) {
            this.addCriterion("user_id in", values, "userId");
            return (Criteria)this;
        }
        
        public Criteria andUserIdNotIn(final List<Integer> values) {
            this.addCriterion("user_id not in", values, "userId");
            return (Criteria)this;
        }
        
        public Criteria andUserIdBetween(final Integer value1, final Integer value2) {
            this.addCriterion("user_id between", value1, value2, "userId");
            return (Criteria)this;
        }
        
        public Criteria andUserIdNotBetween(final Integer value1, final Integer value2) {
            this.addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria)this;
        }
        
        public Criteria andMonthIsNull() {
            this.addCriterion("month is null");
            return (Criteria)this;
        }
        
        public Criteria andMonthIsNotNull() {
            this.addCriterion("month is not null");
            return (Criteria)this;
        }
        
        public Criteria andMonthEqualTo(final Date value) {
            this.addCriterionForJDBCDate("month =", value, "month");
            return (Criteria)this;
        }
        
        public Criteria andMonthNotEqualTo(final Date value) {
            this.addCriterionForJDBCDate("month <>", value, "month");
            return (Criteria)this;
        }
        
        public Criteria andMonthGreaterThan(final Date value) {
            this.addCriterionForJDBCDate("month >", value, "month");
            return (Criteria)this;
        }
        
        public Criteria andMonthGreaterThanOrEqualTo(final Date value) {
            this.addCriterionForJDBCDate("month >=", value, "month");
            return (Criteria)this;
        }
        
        public Criteria andMonthLessThan(final Date value) {
            this.addCriterionForJDBCDate("month <", value, "month");
            return (Criteria)this;
        }
        
        public Criteria andMonthLessThanOrEqualTo(final Date value) {
            this.addCriterionForJDBCDate("month <=", value, "month");
            return (Criteria)this;
        }
        
        public Criteria andMonthIn(final List<Date> values) {
            this.addCriterionForJDBCDate("month in", values, "month");
            return (Criteria)this;
        }
        
        public Criteria andMonthNotIn(final List<Date> values) {
            this.addCriterionForJDBCDate("month not in", values, "month");
            return (Criteria)this;
        }
        
        public Criteria andMonthBetween(final Date value1, final Date value2) {
            this.addCriterionForJDBCDate("month between", value1, value2, "month");
            return (Criteria)this;
        }
        
        public Criteria andMonthNotBetween(final Date value1, final Date value2) {
            this.addCriterionForJDBCDate("month not between", value1, value2, "month");
            return (Criteria)this;
        }
        
        public Criteria andActualBalanceIsNull() {
            this.addCriterion("actual_balance is null");
            return (Criteria)this;
        }
        
        public Criteria andActualBalanceIsNotNull() {
            this.addCriterion("actual_balance is not null");
            return (Criteria)this;
        }
        
        public Criteria andActualBalanceEqualTo(final Float value) {
            this.addCriterion("actual_balance =", value, "actualBalance");
            return (Criteria)this;
        }
        
        public Criteria andActualBalanceNotEqualTo(final Float value) {
            this.addCriterion("actual_balance <>", value, "actualBalance");
            return (Criteria)this;
        }
        
        public Criteria andActualBalanceGreaterThan(final Float value) {
            this.addCriterion("actual_balance >", value, "actualBalance");
            return (Criteria)this;
        }
        
        public Criteria andActualBalanceGreaterThanOrEqualTo(final Float value) {
            this.addCriterion("actual_balance >=", value, "actualBalance");
            return (Criteria)this;
        }
        
        public Criteria andActualBalanceLessThan(final Float value) {
            this.addCriterion("actual_balance <", value, "actualBalance");
            return (Criteria)this;
        }
        
        public Criteria andActualBalanceLessThanOrEqualTo(final Float value) {
            this.addCriterion("actual_balance <=", value, "actualBalance");
            return (Criteria)this;
        }
        
        public Criteria andActualBalanceIn(final List<Float> values) {
            this.addCriterion("actual_balance in", values, "actualBalance");
            return (Criteria)this;
        }
        
        public Criteria andActualBalanceNotIn(final List<Float> values) {
            this.addCriterion("actual_balance not in", values, "actualBalance");
            return (Criteria)this;
        }
        
        public Criteria andActualBalanceBetween(final Float value1, final Float value2) {
            this.addCriterion("actual_balance between", value1, value2, "actualBalance");
            return (Criteria)this;
        }
        
        public Criteria andActualBalanceNotBetween(final Float value1, final Float value2) {
            this.addCriterion("actual_balance not between", value1, value2, "actualBalance");
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
