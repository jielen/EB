package com.ufgov.gk.common.commonbiz.model;

import java.io.Serializable;

public class MaTzdSumElement implements Comparable, Serializable {
  private String elementId;

  private int nd;

  private String billTypeCode;

  private String elementCode;

  private String elementName;

  private String isSum;

  private String sumLevel;

  private String isDisplay;

  private String displayOrder;

  private String userId;

  public String getElementId() {
    return elementId;
  }

  public void setElementId(String elementId) {
    this.elementId = elementId;
  }

  public int getNd() {
    return nd;
  }

  public void setNd(int nd) {
    this.nd = nd;
  }

  public String getBillTypeCode() {
    return billTypeCode;
  }

  public void setBillTypeCode(String billTypeCode) {
    this.billTypeCode = billTypeCode;
  }

  public String getElementCode() {
    return elementCode;
  }

  public void setElementCode(String elementCode) {
    this.elementCode = elementCode;
  }

  public String getElementName() {
    return elementName;
  }

  public void setElementName(String elementName) {
    this.elementName = elementName;
  }

  public String getIsSum() {
    return isSum;
  }

  public void setIsSum(String isSum) {
    this.isSum = isSum;
  }

  public String getSumLevel() {
    return sumLevel;
  }

  public void setSumLevel(String sumLevel) {
    this.sumLevel = sumLevel;
  }

  public String getIsDisplay() {
    return isDisplay;
  }

  public void setIsDisplay(String isDisplay) {
    this.isDisplay = isDisplay;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getDisplayOrder() {
    return displayOrder;
  }

  public void setDisplayOrder(String displayOrder) {
    this.displayOrder = displayOrder;
  }

  public int compareTo(Object object) {
    MaTzdSumElement other = (MaTzdSumElement) object;
    return this.displayOrder.compareTo(other.getDisplayOrder());
  }

}
