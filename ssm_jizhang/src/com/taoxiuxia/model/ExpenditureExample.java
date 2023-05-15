// 
// 
// 

package com.taoxiuxia.model;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class ExpenditureExample
{
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;
    
    public ExpenditureExample() {
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
        
        public Criteria andItemIdIsNull() {
            this.addCriterion("item_id is null");
            return (Criteria)this;
        }
        
        public Criteria andItemIdIsNotNull() {
            this.addCriterion("item_id is not null");
            return (Criteria)this;
        }
        
        public Criteria andItemIdEqualTo(final Integer value) {
            this.addCriterion("item_id =", value, "itemId");
            return (Criteria)this;
        }
        
        public Criteria andItemIdNotEqualTo(final Integer value) {
            this.addCriterion("item_id <>", value, "itemId");
            return (Criteria)this;
        }
        
        public Criteria andItemIdGreaterThan(final Integer value) {
            this.addCriterion("item_id >", value, "itemId");
            return (Criteria)this;
        }
        
        public Criteria andItemIdGreaterThanOrEqualTo(final Integer value) {
            this.addCriterion("item_id >=", value, "itemId");
            return (Criteria)this;
        }
        
        public Criteria andItemIdLessThan(final Integer value) {
            this.addCriterion("item_id <", value, "itemId");
            return (Criteria)this;
        }
        
        public Criteria andItemIdLessThanOrEqualTo(final Integer value) {
            this.addCriterion("item_id <=", value, "itemId");
            return (Criteria)this;
        }
        
        public Criteria andItemIdIn(final List<Integer> values) {
            this.addCriterion("item_id in", values, "itemId");
            return (Criteria)this;
        }
        
        public Criteria andItemIdNotIn(final List<Integer> values) {
            this.addCriterion("item_id not in", values, "itemId");
            return (Criteria)this;
        }
        
        public Criteria andItemIdBetween(final Integer value1, final Integer value2) {
            this.addCriterion("item_id between", value1, value2, "itemId");
            return (Criteria)this;
        }
        
        public Criteria andItemIdNotBetween(final Integer value1, final Integer value2) {
            this.addCriterion("item_id not between", value1, value2, "itemId");
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
        
        public Criteria andMoneyIsNull() {
            this.addCriterion("money is null");
            return (Criteria)this;
        }
        
        public Criteria andMoneyIsNotNull() {
            this.addCriterion("money is not null");
            return (Criteria)this;
        }
        
        public Criteria andMoneyEqualTo(final Float value) {
            this.addCriterion("money =", value, "money");
            return (Criteria)this;
        }
        
        public Criteria andMoneyNotEqualTo(final Float value) {
            this.addCriterion("money <>", value, "money");
            return (Criteria)this;
        }
        
        public Criteria andMoneyGreaterThan(final Float value) {
            this.addCriterion("money >", value, "money");
            return (Criteria)this;
        }
        
        public Criteria andMoneyGreaterThanOrEqualTo(final Float value) {
            this.addCriterion("money >=", value, "money");
            return (Criteria)this;
        }
        
        public Criteria andMoneyLessThan(final Float value) {
            this.addCriterion("money <", value, "money");
            return (Criteria)this;
        }
        
        public Criteria andMoneyLessThanOrEqualTo(final Float value) {
            this.addCriterion("money <=", value, "money");
            return (Criteria)this;
        }
        
        public Criteria andMoneyIn(final List<Float> values) {
            this.addCriterion("money in", values, "money");
            return (Criteria)this;
        }
        
        public Criteria andMoneyNotIn(final List<Float> values) {
            this.addCriterion("money not in", values, "money");
            return (Criteria)this;
        }
        
        public Criteria andMoneyBetween(final Float value1, final Float value2) {
            this.addCriterion("money between", value1, value2, "money");
            return (Criteria)this;
        }
        
        public Criteria andMoneyNotBetween(final Float value1, final Float value2) {
            this.addCriterion("money not between", value1, value2, "money");
            return (Criteria)this;
        }
        
        public Criteria andDateIsNull() {
            this.addCriterion("date is null");
            return (Criteria)this;
        }
        
        public Criteria andDateIsNotNull() {
            this.addCriterion("date is not null");
            return (Criteria)this;
        }
        
        public Criteria andDateEqualTo(final Date value) {
            this.addCriterion("date =", value, "date");
            return (Criteria)this;
        }
        
        public Criteria andDateNotEqualTo(final Date value) {
            this.addCriterion("date <>", value, "date");
            return (Criteria)this;
        }
        
        public Criteria andDateGreaterThan(final Date value) {
            this.addCriterion("date >", value, "date");
            return (Criteria)this;
        }
        
        public Criteria andDateGreaterThanOrEqualTo(final Date value) {
            this.addCriterion("date >=", value, "date");
            return (Criteria)this;
        }
        
        public Criteria andDateLessThan(final Date value) {
            this.addCriterion("date <", value, "date");
            return (Criteria)this;
        }
        
        public Criteria andDateLessThanOrEqualTo(final Date value) {
            this.addCriterion("date <=", value, "date");
            return (Criteria)this;
        }
        
        public Criteria andDateIn(final List<Date> values) {
            this.addCriterion("date in", values, "date");
            return (Criteria)this;
        }
        
        public Criteria andDateNotIn(final List<Date> values) {
            this.addCriterion("date not in", values, "date");
            return (Criteria)this;
        }
        
        public Criteria andDateBetween(final Date value1, final Date value2) {
            this.addCriterion("date between", value1, value2, "date");
            return (Criteria)this;
        }
        
        public Criteria andDateNotBetween(final Date value1, final Date value2) {
            this.addCriterion("date not between", value1, value2, "date");
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
        
        public Criteria andDeleIsNull() {
            this.addCriterion("dele is null");
            return (Criteria)this;
        }
        
        public Criteria andDeleIsNotNull() {
            this.addCriterion("dele is not null");
            return (Criteria)this;
        }
        
        public Criteria andDeleEqualTo(final Integer value) {
            this.addCriterion("dele =", value, "dele");
            return (Criteria)this;
        }
        
        public Criteria andDeleNotEqualTo(final Integer value) {
            this.addCriterion("dele <>", value, "dele");
            return (Criteria)this;
        }
        
        public Criteria andDeleGreaterThan(final Integer value) {
            this.addCriterion("dele >", value, "dele");
            return (Criteria)this;
        }
        
        public Criteria andDeleGreaterThanOrEqualTo(final Integer value) {
            this.addCriterion("dele >=", value, "dele");
            return (Criteria)this;
        }
        
        public Criteria andDeleLessThan(final Integer value) {
            this.addCriterion("dele <", value, "dele");
            return (Criteria)this;
        }
        
        public Criteria andDeleLessThanOrEqualTo(final Integer value) {
            this.addCriterion("dele <=", value, "dele");
            return (Criteria)this;
        }
        
        public Criteria andDeleIn(final List<Integer> values) {
            this.addCriterion("dele in", values, "dele");
            return (Criteria)this;
        }
        
        public Criteria andDeleNotIn(final List<Integer> values) {
            this.addCriterion("dele not in", values, "dele");
            return (Criteria)this;
        }
        
        public Criteria andDeleBetween(final Integer value1, final Integer value2) {
            this.addCriterion("dele between", value1, value2, "dele");
            return (Criteria)this;
        }
        
        public Criteria andDeleNotBetween(final Integer value1, final Integer value2) {
            this.addCriterion("dele not between", value1, value2, "dele");
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
