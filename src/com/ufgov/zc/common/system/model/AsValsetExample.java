package com.ufgov.zc.common.system.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AsValsetExample {
    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database table AS_VALSET
     *
     * @abatorgenerated Tue Jun 26 18:19:50 CST 2012
     */
    protected String orderByClause;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database table AS_VALSET
     *
     * @abatorgenerated Tue Jun 26 18:19:50 CST 2012
     */
    protected List oredCriteria;

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table AS_VALSET
     *
     * @abatorgenerated Tue Jun 26 18:19:50 CST 2012
     */
    public AsValsetExample() {
        oredCriteria = new ArrayList();
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table AS_VALSET
     *
     * @abatorgenerated Tue Jun 26 18:19:50 CST 2012
     */
    protected AsValsetExample(AsValsetExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table AS_VALSET
     *
     * @abatorgenerated Tue Jun 26 18:19:50 CST 2012
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table AS_VALSET
     *
     * @abatorgenerated Tue Jun 26 18:19:50 CST 2012
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table AS_VALSET
     *
     * @abatorgenerated Tue Jun 26 18:19:50 CST 2012
     */
    public List getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table AS_VALSET
     *
     * @abatorgenerated Tue Jun 26 18:19:50 CST 2012
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table AS_VALSET
     *
     * @abatorgenerated Tue Jun 26 18:19:50 CST 2012
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table AS_VALSET
     *
     * @abatorgenerated Tue Jun 26 18:19:50 CST 2012
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table AS_VALSET
     *
     * @abatorgenerated Tue Jun 26 18:19:50 CST 2012
     */
    public void clear() {
        oredCriteria.clear();
    }

    /**
     * This class was generated by Abator for iBATIS.
     * This class corresponds to the database table AS_VALSET
     *
     * @abatorgenerated Tue Jun 26 18:19:50 CST 2012
     */
    public static class Criteria {
        protected List criteriaWithoutValue;

        protected List criteriaWithSingleValue;

        protected List criteriaWithListValue;

        protected List criteriaWithBetweenValue;

        protected Criteria() {
            super();
            criteriaWithoutValue = new ArrayList();
            criteriaWithSingleValue = new ArrayList();
            criteriaWithListValue = new ArrayList();
            criteriaWithBetweenValue = new ArrayList();
        }

        public boolean isValid() {
            return criteriaWithoutValue.size() > 0
                || criteriaWithSingleValue.size() > 0
                || criteriaWithListValue.size() > 0
                || criteriaWithBetweenValue.size() > 0;
        }

        public List getCriteriaWithoutValue() {
            return criteriaWithoutValue;
        }

        public List getCriteriaWithSingleValue() {
            return criteriaWithSingleValue;
        }

        public List getCriteriaWithListValue() {
            return criteriaWithListValue;
        }

        public List getCriteriaWithBetweenValue() {
            return criteriaWithBetweenValue;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteriaWithoutValue.add(condition);
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("value", value);
            criteriaWithSingleValue.add(map);
        }

        protected void addCriterion(String condition, List values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("values", values);
            criteriaWithListValue.add(map);
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            List list = new ArrayList();
            list.add(value1);
            list.add(value2);
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("values", list);
            criteriaWithBetweenValue.add(map);
        }

        public Criteria andValsetIdIsNull() {
            addCriterion("VALSET_ID is null");
            return this;
        }

        public Criteria andValsetIdIsNotNull() {
            addCriterion("VALSET_ID is not null");
            return this;
        }

        public Criteria andValsetIdEqualTo(String value) {
            addCriterion("VALSET_ID =", value, "valsetId");
            return this;
        }

        public Criteria andValsetIdNotEqualTo(String value) {
            addCriterion("VALSET_ID <>", value, "valsetId");
            return this;
        }

        public Criteria andValsetIdGreaterThan(String value) {
            addCriterion("VALSET_ID >", value, "valsetId");
            return this;
        }

        public Criteria andValsetIdGreaterThanOrEqualTo(String value) {
            addCriterion("VALSET_ID >=", value, "valsetId");
            return this;
        }

        public Criteria andValsetIdLessThan(String value) {
            addCriterion("VALSET_ID <", value, "valsetId");
            return this;
        }

        public Criteria andValsetIdLessThanOrEqualTo(String value) {
            addCriterion("VALSET_ID <=", value, "valsetId");
            return this;
        }

        public Criteria andValsetIdLike(String value) {
            addCriterion("VALSET_ID like", value, "valsetId");
            return this;
        }

        public Criteria andValsetIdNotLike(String value) {
            addCriterion("VALSET_ID not like", value, "valsetId");
            return this;
        }

        public Criteria andValsetIdIn(List values) {
            addCriterion("VALSET_ID in", values, "valsetId");
            return this;
        }

        public Criteria andValsetIdNotIn(List values) {
            addCriterion("VALSET_ID not in", values, "valsetId");
            return this;
        }

        public Criteria andValsetIdBetween(String value1, String value2) {
            addCriterion("VALSET_ID between", value1, value2, "valsetId");
            return this;
        }

        public Criteria andValsetIdNotBetween(String value1, String value2) {
            addCriterion("VALSET_ID not between", value1, value2, "valsetId");
            return this;
        }

        public Criteria andValsetNameIsNull() {
            addCriterion("VALSET_NAME is null");
            return this;
        }

        public Criteria andValsetNameIsNotNull() {
            addCriterion("VALSET_NAME is not null");
            return this;
        }

        public Criteria andValsetNameEqualTo(String value) {
            addCriterion("VALSET_NAME =", value, "valsetName");
            return this;
        }

        public Criteria andValsetNameNotEqualTo(String value) {
            addCriterion("VALSET_NAME <>", value, "valsetName");
            return this;
        }

        public Criteria andValsetNameGreaterThan(String value) {
            addCriterion("VALSET_NAME >", value, "valsetName");
            return this;
        }

        public Criteria andValsetNameGreaterThanOrEqualTo(String value) {
            addCriterion("VALSET_NAME >=", value, "valsetName");
            return this;
        }

        public Criteria andValsetNameLessThan(String value) {
            addCriterion("VALSET_NAME <", value, "valsetName");
            return this;
        }

        public Criteria andValsetNameLessThanOrEqualTo(String value) {
            addCriterion("VALSET_NAME <=", value, "valsetName");
            return this;
        }

        public Criteria andValsetNameLike(String value) {
            addCriterion("VALSET_NAME like", value, "valsetName");
            return this;
        }

        public Criteria andValsetNameNotLike(String value) {
            addCriterion("VALSET_NAME not like", value, "valsetName");
            return this;
        }

        public Criteria andValsetNameIn(List values) {
            addCriterion("VALSET_NAME in", values, "valsetName");
            return this;
        }

        public Criteria andValsetNameNotIn(List values) {
            addCriterion("VALSET_NAME not in", values, "valsetName");
            return this;
        }

        public Criteria andValsetNameBetween(String value1, String value2) {
            addCriterion("VALSET_NAME between", value1, value2, "valsetName");
            return this;
        }

        public Criteria andValsetNameNotBetween(String value1, String value2) {
            addCriterion("VALSET_NAME not between", value1, value2, "valsetName");
            return this;
        }

        public Criteria andValSqlIsNull() {
            addCriterion("VAL_SQL is null");
            return this;
        }

        public Criteria andValSqlIsNotNull() {
            addCriterion("VAL_SQL is not null");
            return this;
        }

        public Criteria andValSqlEqualTo(String value) {
            addCriterion("VAL_SQL =", value, "valSql");
            return this;
        }

        public Criteria andValSqlNotEqualTo(String value) {
            addCriterion("VAL_SQL <>", value, "valSql");
            return this;
        }

        public Criteria andValSqlGreaterThan(String value) {
            addCriterion("VAL_SQL >", value, "valSql");
            return this;
        }

        public Criteria andValSqlGreaterThanOrEqualTo(String value) {
            addCriterion("VAL_SQL >=", value, "valSql");
            return this;
        }

        public Criteria andValSqlLessThan(String value) {
            addCriterion("VAL_SQL <", value, "valSql");
            return this;
        }

        public Criteria andValSqlLessThanOrEqualTo(String value) {
            addCriterion("VAL_SQL <=", value, "valSql");
            return this;
        }

        public Criteria andValSqlLike(String value) {
            addCriterion("VAL_SQL like", value, "valSql");
            return this;
        }

        public Criteria andValSqlNotLike(String value) {
            addCriterion("VAL_SQL not like", value, "valSql");
            return this;
        }

        public Criteria andValSqlIn(List values) {
            addCriterion("VAL_SQL in", values, "valSql");
            return this;
        }

        public Criteria andValSqlNotIn(List values) {
            addCriterion("VAL_SQL not in", values, "valSql");
            return this;
        }

        public Criteria andValSqlBetween(String value1, String value2) {
            addCriterion("VAL_SQL between", value1, value2, "valSql");
            return this;
        }

        public Criteria andValSqlNotBetween(String value1, String value2) {
            addCriterion("VAL_SQL not between", value1, value2, "valSql");
            return this;
        }

        public Criteria andLstdateIsNull() {
            addCriterion("LSTDATE is null");
            return this;
        }

        public Criteria andLstdateIsNotNull() {
            addCriterion("LSTDATE is not null");
            return this;
        }

        public Criteria andLstdateEqualTo(Date value) {
            addCriterion("LSTDATE =", value, "lstdate");
            return this;
        }

        public Criteria andLstdateNotEqualTo(Date value) {
            addCriterion("LSTDATE <>", value, "lstdate");
            return this;
        }

        public Criteria andLstdateGreaterThan(Date value) {
            addCriterion("LSTDATE >", value, "lstdate");
            return this;
        }

        public Criteria andLstdateGreaterThanOrEqualTo(Date value) {
            addCriterion("LSTDATE >=", value, "lstdate");
            return this;
        }

        public Criteria andLstdateLessThan(Date value) {
            addCriterion("LSTDATE <", value, "lstdate");
            return this;
        }

        public Criteria andLstdateLessThanOrEqualTo(Date value) {
            addCriterion("LSTDATE <=", value, "lstdate");
            return this;
        }

        public Criteria andLstdateIn(List values) {
            addCriterion("LSTDATE in", values, "lstdate");
            return this;
        }

        public Criteria andLstdateNotIn(List values) {
            addCriterion("LSTDATE not in", values, "lstdate");
            return this;
        }

        public Criteria andLstdateBetween(Date value1, Date value2) {
            addCriterion("LSTDATE between", value1, value2, "lstdate");
            return this;
        }

        public Criteria andLstdateNotBetween(Date value1, Date value2) {
            addCriterion("LSTDATE not between", value1, value2, "lstdate");
            return this;
        }

        public Criteria andIsSystemIsNull() {
            addCriterion("IS_SYSTEM is null");
            return this;
        }

        public Criteria andIsSystemIsNotNull() {
            addCriterion("IS_SYSTEM is not null");
            return this;
        }

        public Criteria andIsSystemEqualTo(String value) {
            addCriterion("IS_SYSTEM =", value, "isSystem");
            return this;
        }

        public Criteria andIsSystemNotEqualTo(String value) {
            addCriterion("IS_SYSTEM <>", value, "isSystem");
            return this;
        }

        public Criteria andIsSystemGreaterThan(String value) {
            addCriterion("IS_SYSTEM >", value, "isSystem");
            return this;
        }

        public Criteria andIsSystemGreaterThanOrEqualTo(String value) {
            addCriterion("IS_SYSTEM >=", value, "isSystem");
            return this;
        }

        public Criteria andIsSystemLessThan(String value) {
            addCriterion("IS_SYSTEM <", value, "isSystem");
            return this;
        }

        public Criteria andIsSystemLessThanOrEqualTo(String value) {
            addCriterion("IS_SYSTEM <=", value, "isSystem");
            return this;
        }

        public Criteria andIsSystemLike(String value) {
            addCriterion("IS_SYSTEM like", value, "isSystem");
            return this;
        }

        public Criteria andIsSystemNotLike(String value) {
            addCriterion("IS_SYSTEM not like", value, "isSystem");
            return this;
        }

        public Criteria andIsSystemIn(List values) {
            addCriterion("IS_SYSTEM in", values, "isSystem");
            return this;
        }

        public Criteria andIsSystemNotIn(List values) {
            addCriterion("IS_SYSTEM not in", values, "isSystem");
            return this;
        }

        public Criteria andIsSystemBetween(String value1, String value2) {
            addCriterion("IS_SYSTEM between", value1, value2, "isSystem");
            return this;
        }

        public Criteria andIsSystemNotBetween(String value1, String value2) {
            addCriterion("IS_SYSTEM not between", value1, value2, "isSystem");
            return this;
        }
    }
}