package com.ufgov.gk.client.component.ui;

public class MyEntry {
  private String label;

  private Object value;

  public MyEntry(String label, Object value) {
    this.label = label;
    this.value = value;
  }

  public String getLabel() {
    return label;
  }

  public Object getValue() {
    return value;
  }

  public String toString() {
    return this.label;
  }
}
