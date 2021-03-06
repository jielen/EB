package com.ufgov.gk.common.commonbiz.model;

import java.io.Serializable;
import java.util.Date;

public class WfTaskGranter implements Serializable {
  /**
   *
   */
  private static final long serialVersionUID = 6166613698088689062L;

  private String userId;

  private String grantedId;

  private String grantedName;

  private Date grantDate;

  private String userCoCode;

  private String userOrgCode;

  private String userPosiCode;

  private String userPosiId;

  private String isGrant;

  private int level;

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }


  public Date getGrantDate() {
    return grantDate;
  }

  public void setGrantDate(Date grantDate) {
    this.grantDate = grantDate;
  }

  public String getUserCoCode() {
    return userCoCode;
  }

  public void setUserCoCode(String userCoCode) {
    this.userCoCode = userCoCode;
  }

  public String getUserOrgCode() {
    return userOrgCode;
  }

  public void setUserOrgCode(String userOrgCode) {
    this.userOrgCode = userOrgCode;
  }

  public String getUserPosiCode() {
    return userPosiCode;
  }

  public void setUserPosiCode(String userPosiCode) {
    this.userPosiCode = userPosiCode;
  }

  public String getIsGrant() {
    return isGrant;
  }

  public void setIsGrant(String isGrant) {
    this.isGrant = isGrant;
  }

  public String getGrantedName() {
    return grantedName;
  }

  public void setGrantedName(String grantedName) {
    this.grantedName = grantedName;
  }

  public String getUserPosiId() {
    return userPosiId;
  }

  public void setUserPosiId(String userPosiId) {
    this.userPosiId = userPosiId;
  }

  public String getGrantedId() {
    return grantedId;
  }

  public void setGrantedId(String grantedId) {
    this.grantedId = grantedId;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }


}
