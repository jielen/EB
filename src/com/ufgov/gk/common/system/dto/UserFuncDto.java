package com.ufgov.gk.common.system.dto;

import java.io.Serializable;

public class UserFuncDto implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -7179316587131919757L;

  private String userId;

  private String compoId;
  
  private String funcId;

  private String coCode;

  private String orgCode;

  private String posiCode;

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getCompoId() {
    return compoId;
  }

  public void setCompoId(String compoId) {
    this.compoId = compoId;
  }

  public String getFuncId() {
    return funcId;
  }

  public void setFuncId(String funcId) {
    this.funcId = funcId;
  }

  public String getCoCode() {
    return coCode;
  }

  public void setCoCode(String coCode) {
    this.coCode = coCode;
  }

  public String getOrgCode() {
    return orgCode;
  }

  public void setOrgCode(String orgCode) {
    this.orgCode = orgCode;
  }

  public String getPosiCode() {
    return posiCode;
  }

  public void setPosiCode(String posiCode) {
    this.posiCode = posiCode;
  }

}
