package com.ufgov.gk.common.system.model;

import java.io.Serializable;

public class UserPreferences implements Serializable{

  private static final long serialVersionUID = 1L;
  private String userId;
  private String preferId;
  private String preferValue;
  
  public String getUserId() {
    return userId;
  }
  public void setUserId(String userId) {
    this.userId = userId;
  }
  public String getPreferId() {
    return preferId;
  }
  public void setPreferId(String preferId) {
    this.preferId = preferId;
  }
  public String getPreferValue() {
    return preferValue;
  }
  public void setPreferValue(String preferValue) {
    this.preferValue = preferValue;
  }
}
