package com.ufgov.gk.common.system.model;

import java.io.Serializable;

public class User implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 6756693422578097035L;

  private String userId;

  private String userName;

  private String password;

  private String tempId;

  public String getTempId() {
    return tempId;
  }

  public void setTempId(String tempId) {
    this.tempId = tempId;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
