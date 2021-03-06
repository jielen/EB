package com.ufgov.gk.common.commonbiz.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MaElementRelationRule implements Serializable {

  private static final long serialVersionUID = -8009098663096636575L;
  

  public final static String HANDLE_TYPE_MANUAL = "0";

  public final static String HANDLE_TYPE_AUTO = "1";
  
  private String compoId = "*";

  private String relationRuleId;

  private String relationRuleName;

  private String handleType = HANDLE_TYPE_AUTO;

  private String ruleType;

  private List  ruleEntryList= new ArrayList();
  
  public List getRuleEntryList() {
    return ruleEntryList;
  }

  public void setRuleEntryList(List ruleEntryList) {
    this.ruleEntryList = ruleEntryList;
  }

  public String getCompoId() {
    return compoId;
  }

  public void setCompoId(String compoId) {
    this.compoId = compoId;
  }

  public String getRelationRuleId() {
    return relationRuleId;
  }

  public void setRelationRuleId(String relationRuleId) {
    this.relationRuleId = relationRuleId;
  }

  public String getRelationRuleName() {
    return relationRuleName;
  }

  public void setRelationRuleName(String relationRuleName) {
    this.relationRuleName = relationRuleName;
  }

  public String getHandleType() {
    return handleType;
  }

  public void setHandleType(String handleType) {
    this.handleType = handleType;
  }

  public String getRuleType() {
    return ruleType;
  }

  public void setRuleType(String ruleType) {
    this.ruleType = ruleType;
  }
  
  public String toString() {
    return this.relationRuleName;
  }
  

}
