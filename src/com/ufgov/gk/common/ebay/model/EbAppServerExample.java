package com.ufgov.gk.common.ebay.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ufgov.gk.common.commonbiz.model.BaseBill;

public class EbAppServerExample extends BaseBill {
  /**
   * This field was generated by Abator for iBATIS.
   * This field corresponds to the database table EB_APP_SERVER
   *
   * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
   */
  protected String orderByClause;

  /**
   * This field was generated by Abator for iBATIS.
   * This field corresponds to the database table EB_APP_SERVER
   *
   * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
   */
  protected List oredCriteria;

  /**
   * This method was generated by Abator for iBATIS.
   * This method corresponds to the database table EB_APP_SERVER
   *
   * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
   */
  public EbAppServerExample() {
    oredCriteria = new ArrayList();
  }

  /**
   * This method was generated by Abator for iBATIS.
   * This method corresponds to the database table EB_APP_SERVER
   *
   * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
   */
  protected EbAppServerExample(EbAppServerExample example) {
    this.orderByClause = example.orderByClause;
    this.oredCriteria = example.oredCriteria;
  }

  /**
   * This method was generated by Abator for iBATIS.
   * This method corresponds to the database table EB_APP_SERVER
   *
   * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
   */
  public void setOrderByClause(String orderByClause) {
    this.orderByClause = orderByClause;
  }

  /**
   * This method was generated by Abator for iBATIS.
   * This method corresponds to the database table EB_APP_SERVER
   *
   * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
   */
  public String getOrderByClause() {
    return orderByClause;
  }

  /**
   * This method was generated by Abator for iBATIS.
   * This method corresponds to the database table EB_APP_SERVER
   *
   * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
   */
  public List getOredCriteria() {
    return oredCriteria;
  }

  /**
   * This method was generated by Abator for iBATIS.
   * This method corresponds to the database table EB_APP_SERVER
   *
   * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
   */
  public void or(Criteria criteria) {
    oredCriteria.add(criteria);
  }

  /**
   * This method was generated by Abator for iBATIS.
   * This method corresponds to the database table EB_APP_SERVER
   *
   * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
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
   * This method corresponds to the database table EB_APP_SERVER
   *
   * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
   */
  protected Criteria createCriteriaInternal() {
    Criteria criteria = new Criteria();
    return criteria;
  }

  /**
   * This method was generated by Abator for iBATIS.
   * This method corresponds to the database table EB_APP_SERVER
   *
   * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
   */
  public void clear() {
    oredCriteria.clear();
  }

  /**
   * This class was generated by Abator for iBATIS.
   * This class corresponds to the database table EB_APP_SERVER
   *
   * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
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
      return criteriaWithoutValue.size() > 0 || criteriaWithSingleValue.size() > 0 || criteriaWithListValue.size() > 0
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

    public Criteria andSiteIdIsNull() {
      addCriterion("SITE_ID is null");
      return this;
    }

    public Criteria andSiteIdIsNotNull() {
      addCriterion("SITE_ID is not null");
      return this;
    }

    public Criteria andSiteIdEqualTo(String value) {
      addCriterion("SITE_ID =", value, "siteId");
      return this;
    }

    public Criteria andSiteIdNotEqualTo(String value) {
      addCriterion("SITE_ID <>", value, "siteId");
      return this;
    }

    public Criteria andSiteIdGreaterThan(String value) {
      addCriterion("SITE_ID >", value, "siteId");
      return this;
    }

    public Criteria andSiteIdGreaterThanOrEqualTo(String value) {
      addCriterion("SITE_ID >=", value, "siteId");
      return this;
    }

    public Criteria andSiteIdLessThan(String value) {
      addCriterion("SITE_ID <", value, "siteId");
      return this;
    }

    public Criteria andSiteIdLessThanOrEqualTo(String value) {
      addCriterion("SITE_ID <=", value, "siteId");
      return this;
    }

    public Criteria andSiteIdLike(String value) {
      addCriterion("SITE_ID like", value, "siteId");
      return this;
    }

    public Criteria andSiteIdNotLike(String value) {
      addCriterion("SITE_ID not like", value, "siteId");
      return this;
    }

    public Criteria andSiteIdIn(List values) {
      addCriterion("SITE_ID in", values, "siteId");
      return this;
    }

    public Criteria andSiteIdNotIn(List values) {
      addCriterion("SITE_ID not in", values, "siteId");
      return this;
    }

    public Criteria andSiteIdBetween(String value1, String value2) {
      addCriterion("SITE_ID between", value1, value2, "siteId");
      return this;
    }

    public Criteria andSiteIdNotBetween(String value1, String value2) {
      addCriterion("SITE_ID not between", value1, value2, "siteId");
      return this;
    }

    public Criteria andServerUrlIsNull() {
      addCriterion("SERVER_URL is null");
      return this;
    }

    public Criteria andServerUrlIsNotNull() {
      addCriterion("SERVER_URL is not null");
      return this;
    }

    public Criteria andServerUrlEqualTo(String value) {
      addCriterion("SERVER_URL =", value, "serverUrl");
      return this;
    }

    public Criteria andServerUrlNotEqualTo(String value) {
      addCriterion("SERVER_URL <>", value, "serverUrl");
      return this;
    }

    public Criteria andServerUrlGreaterThan(String value) {
      addCriterion("SERVER_URL >", value, "serverUrl");
      return this;
    }

    public Criteria andServerUrlGreaterThanOrEqualTo(String value) {
      addCriterion("SERVER_URL >=", value, "serverUrl");
      return this;
    }

    public Criteria andServerUrlLessThan(String value) {
      addCriterion("SERVER_URL <", value, "serverUrl");
      return this;
    }

    public Criteria andServerUrlLessThanOrEqualTo(String value) {
      addCriterion("SERVER_URL <=", value, "serverUrl");
      return this;
    }

    public Criteria andServerUrlLike(String value) {
      addCriterion("SERVER_URL like", value, "serverUrl");
      return this;
    }

    public Criteria andServerUrlNotLike(String value) {
      addCriterion("SERVER_URL not like", value, "serverUrl");
      return this;
    }

    public Criteria andServerUrlIn(List values) {
      addCriterion("SERVER_URL in", values, "serverUrl");
      return this;
    }

    public Criteria andServerUrlNotIn(List values) {
      addCriterion("SERVER_URL not in", values, "serverUrl");
      return this;
    }

    public Criteria andServerUrlBetween(String value1, String value2) {
      addCriterion("SERVER_URL between", value1, value2, "serverUrl");
      return this;
    }

    public Criteria andServerUrlNotBetween(String value1, String value2) {
      addCriterion("SERVER_URL not between", value1, value2, "serverUrl");
      return this;
    }

    public Criteria andEpsServerUrlIsNull() {
      addCriterion("EPS_SERVER_URL is null");
      return this;
    }

    public Criteria andEpsServerUrlIsNotNull() {
      addCriterion("EPS_SERVER_URL is not null");
      return this;
    }

    public Criteria andEpsServerUrlEqualTo(String value) {
      addCriterion("EPS_SERVER_URL =", value, "epsServerUrl");
      return this;
    }

    public Criteria andEpsServerUrlNotEqualTo(String value) {
      addCriterion("EPS_SERVER_URL <>", value, "epsServerUrl");
      return this;
    }

    public Criteria andEpsServerUrlGreaterThan(String value) {
      addCriterion("EPS_SERVER_URL >", value, "epsServerUrl");
      return this;
    }

    public Criteria andEpsServerUrlGreaterThanOrEqualTo(String value) {
      addCriterion("EPS_SERVER_URL >=", value, "epsServerUrl");
      return this;
    }

    public Criteria andEpsServerUrlLessThan(String value) {
      addCriterion("EPS_SERVER_URL <", value, "epsServerUrl");
      return this;
    }

    public Criteria andEpsServerUrlLessThanOrEqualTo(String value) {
      addCriterion("EPS_SERVER_URL <=", value, "epsServerUrl");
      return this;
    }

    public Criteria andEpsServerUrlLike(String value) {
      addCriterion("EPS_SERVER_URL like", value, "epsServerUrl");
      return this;
    }

    public Criteria andEpsServerUrlNotLike(String value) {
      addCriterion("EPS_SERVER_URL not like", value, "epsServerUrl");
      return this;
    }

    public Criteria andEpsServerUrlIn(List values) {
      addCriterion("EPS_SERVER_URL in", values, "epsServerUrl");
      return this;
    }

    public Criteria andEpsServerUrlNotIn(List values) {
      addCriterion("EPS_SERVER_URL not in", values, "epsServerUrl");
      return this;
    }

    public Criteria andEpsServerUrlBetween(String value1, String value2) {
      addCriterion("EPS_SERVER_URL between", value1, value2, "epsServerUrl");
      return this;
    }

    public Criteria andEpsServerUrlNotBetween(String value1, String value2) {
      addCriterion("EPS_SERVER_URL not between", value1, value2, "epsServerUrl");
      return this;
    }

    public Criteria andSignInUrlIsNull() {
      addCriterion("SIGN_IN_URL is null");
      return this;
    }

    public Criteria andSignInUrlIsNotNull() {
      addCriterion("SIGN_IN_URL is not null");
      return this;
    }

    public Criteria andSignInUrlEqualTo(String value) {
      addCriterion("SIGN_IN_URL =", value, "signInUrl");
      return this;
    }

    public Criteria andSignInUrlNotEqualTo(String value) {
      addCriterion("SIGN_IN_URL <>", value, "signInUrl");
      return this;
    }

    public Criteria andSignInUrlGreaterThan(String value) {
      addCriterion("SIGN_IN_URL >", value, "signInUrl");
      return this;
    }

    public Criteria andSignInUrlGreaterThanOrEqualTo(String value) {
      addCriterion("SIGN_IN_URL >=", value, "signInUrl");
      return this;
    }

    public Criteria andSignInUrlLessThan(String value) {
      addCriterion("SIGN_IN_URL <", value, "signInUrl");
      return this;
    }

    public Criteria andSignInUrlLessThanOrEqualTo(String value) {
      addCriterion("SIGN_IN_URL <=", value, "signInUrl");
      return this;
    }

    public Criteria andSignInUrlLike(String value) {
      addCriterion("SIGN_IN_URL like", value, "signInUrl");
      return this;
    }

    public Criteria andSignInUrlNotLike(String value) {
      addCriterion("SIGN_IN_URL not like", value, "signInUrl");
      return this;
    }

    public Criteria andSignInUrlIn(List values) {
      addCriterion("SIGN_IN_URL in", values, "signInUrl");
      return this;
    }

    public Criteria andSignInUrlNotIn(List values) {
      addCriterion("SIGN_IN_URL not in", values, "signInUrl");
      return this;
    }

    public Criteria andSignInUrlBetween(String value1, String value2) {
      addCriterion("SIGN_IN_URL between", value1, value2, "signInUrl");
      return this;
    }

    public Criteria andSignInUrlNotBetween(String value1, String value2) {
      addCriterion("SIGN_IN_URL not between", value1, value2, "signInUrl");
      return this;
    }
  }
}