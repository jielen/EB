package com.ufgov.gk.common.commonbiz.model;

import java.io.Serializable;

public class MaElementRelationRuleDetail implements Serializable {

  private static final long serialVersionUID = -8009098663096636575L;

  public final static String DIRECTION_SRC = "src";

  public final static String DIRECTION_DEST = "dest";
  
  /*
   * 目前支持三种操作符 =，like，in 对于自动处理（handleType为1）并且direction 为dest的要素 ，
   * 要素的值应该是唯一的 此时的操作符也没有什么意义
   */
  public final static String OPERATOR_LIKE = "like";

  public final static String OPERATOR_EQUAL = "=";

  public final static String OPERATOR_IN = "in";

  public final static String HANDLE_TYPE_MANUAL = "0";

  public final static String HANDLE_TYPE_AUTO = "1";
  
  private String relationRuleId;

  private String element;

  private String elementValue;

  private String direction;

  private String operator;
  
  private String entryId;

  public String getEntryId() {
    return entryId;
  }

  public void setEntryId(String entryId) {
    this.entryId = entryId;
  }

  public String getElement() {
    return element;
  }

  public void setElement(String element) {
    this.element = element;
  }

  public String getElementValue() {
    return elementValue;
  }

  public void setElementValue(String elementValue) {
    this.elementValue = elementValue;
  }

  public String getDirection() {
    return direction;
  }

  public void setDirection(String direction) {
    this.direction = direction;
  }

  public String getOperator() {
    return operator;
  }

  public void setOperator(String operator) {
    this.operator = operator;
  }

  public String getRelationRuleId() {
    return relationRuleId;
  }

  public void setRelationRuleId(String relationRuleId) {
    this.relationRuleId = relationRuleId;
  }

}
