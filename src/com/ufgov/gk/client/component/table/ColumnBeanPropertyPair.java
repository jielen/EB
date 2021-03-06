package com.ufgov.gk.client.component.table;

import java.io.Serializable;

public class ColumnBeanPropertyPair implements Serializable {

  private static final long serialVersionUID = 1L;

  private String columnIdentifier;

  private String beanPropertyName;

  private String headerValue;

  public ColumnBeanPropertyPair() {
  }

  public ColumnBeanPropertyPair(String columnIdentifier, String beanPropertyName, String headerValue) {
    this.columnIdentifier = columnIdentifier;
    this.beanPropertyName = beanPropertyName;
    this.headerValue = headerValue;
  }

  public String getHeaderValue() {
    return headerValue;
  }

  public void setHeaderValue(String headerValue) {
    this.headerValue = headerValue;
  }

  public String getColumnIdentifier() {
    return columnIdentifier;
  }

  public void setColumnIdentifier(String columnIdentifier) {
    this.columnIdentifier = columnIdentifier;
  }

  public String getBeanPropertyName() {
    return beanPropertyName;
  }

  public void setBeanPropertyName(String beanPropertyName) {
    this.beanPropertyName = beanPropertyName;
  }

}
