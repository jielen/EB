package com.ufgov.gk.client.component;

public class EbFilterKey {

  private String fieldName;

  private int fieldType;

  public static final int TYPE_NUMBER = 0;

  public static final int TYPE_STRING = 1;

  public static final int TYPE_DATE = 2;

  public String getFieldName() {
    return fieldName;
  }

  public void setFieldName(String fieldName) {
    this.fieldName = fieldName;
  }

  public int getFieldType() {
    return fieldType;
  }

  public void setFieldType(int fieldType) {
    this.fieldType = fieldType;
  }

}
