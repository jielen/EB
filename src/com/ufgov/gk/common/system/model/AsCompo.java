package com.ufgov.gk.common.system.model;

import java.io.Serializable;

public class AsCompo implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -2655297328875426511L;

  private String compoId;

  private String compoName;

  private String masterTabId;

  private String noField;

  private String orderColumns;

  private String orderField;

  private String order;
  
  private String funcControl;

  public String getCompoId() {
    return compoId;
  }

  public void setCompoId(String compoId) {
    this.compoId = compoId;
  }

  public String getCompoName() {
    return compoName;
  }

  public void setCompoName(String compoName) {
    this.compoName = compoName;
  }

  public String getMasterTabId() {
    return masterTabId;
  }

  public void setMasterTabId(String masterTabId) {
    this.masterTabId = masterTabId;
  }

  public String getNoField() {
    return noField;
  }

  public void setNoField(String noField) {
    this.noField = noField;
  }

  public String getOrderColumns() {
    return orderColumns;
  }

  public void setOrderColumns(String orderColumns) {
    this.orderColumns = orderColumns;
  }

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public String getOrderField() {
    return orderField;
  }

  public String getFuncControl() {
    return funcControl;
  }

  public void setFuncControl(String funcControl) {
    this.funcControl = funcControl;
  }

  public void setOrderField(String orderField) {
    this.orderField = orderField;
  }

  public String getOrder() {
    return order;
  }

  public void setOrder(String order) {
    this.order = order;
  }

}
