// 
// 
// 

package com.taoxiuxia.model;

import java.util.ArrayList;
import java.util.List;

public class ItemExample
{
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;
    
    public ItemExample() {
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
        
        public Criteria andInOrExIsNull() {
            this.addCriterion("in_or_ex is null");
            return (Criteria)this;
        }
        
        public Criteria andInOrExIsNotNull() {
            this.addCriterion("in_or_ex is not null");
            return (Criteria)this;
        }
        
        public Criteria andInOrExEqualTo(final String value) {
            this.addCriterion("in_or_ex =", value, "inOrEx");
            return (Criteria)this;
        }
        
        public Criteria andInOrExNotEqualTo(final String value) {
            this.addCriterion("in_or_ex <>", value, "inOrEx");
            return (Criteria)this;
        }
        
        public Criteria andInOrExGreaterThan(final String value) {
            this.addCriterion("in_or_ex >", value, "inOrEx");
            return (Criteria)this;
        }
        
        public Criteria andInOrExGreaterThanOrEqualTo(final String value) {
            this.addCriterion("in_or_ex >=", value, "inOrEx");
            return (Criteria)this;
        }
        
        public Criteria andInOrExLessThan(final String value) {
            this.addCriterion("in_or_ex <", value, "inOrEx");
            return (Criteria)this;
        }
        
        public Criteria andInOrExLessThanOrEqualTo(final String value) {
            this.addCriterion("in_or_ex <=", value, "inOrEx");
            return (Criteria)this;
        }
        
        public Criteria andInOrExLike(final String value) {
            this.addCriterion("in_or_ex like", value, "inOrEx");
            return (Criteria)this;
        }
        
        public Criteria andInOrExNotLike(final String value) {
            this.addCriterion("in_or_ex not like", value, "inOrEx");
            return (Criteria)this;
        }
        
        public Criteria andInOrExIn(final List<String> values) {
            this.addCriterion("in_or_ex in", values, "inOrEx");
            return (Criteria)this;
        }
        
        public Criteria andInOrExNotIn(final List<String> values) {
            this.addCriterion("in_or_ex not in", values, "inOrEx");
            return (Criteria)this;
        }
        
        public Criteria andInOrExBetween(final String value1, final String value2) {
            this.addCriterion("in_or_ex between", value1, value2, "inOrEx");
            return (Criteria)this;
        }
        
        public Criteria andInOrExNotBetween(final String value1, final String value2) {
            this.addCriterion("in_or_ex not between", value1, value2, "inOrEx");
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
