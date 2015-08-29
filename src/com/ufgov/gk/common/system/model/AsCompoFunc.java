package com.ufgov.gk.common.system.model;

import java.io.Serializable;

public class AsCompoFunc implements Serializable {
  private String compoId;

  private String compoName;

  private String funcId;

  private String funcName;

  private String isWrLog;

  private String isNeverUse;

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

  public String getIsWrLog() {
    return isWrLog;
  }

  public void setIsWrLog(String isWrLog) {
    this.isWrLog = isWrLog;
  }

  public String getIsNeverUse() {
    return isNeverUse;
  }

  public void setIsNeverUse(String isNeverUse) {
    this.isNeverUse = isNeverUse;
  }

  public String getCompoName() {
    return compoName;
  }

  public void setCompoName(String compoName) {
    this.compoName = compoName;
  }

  public String getFuncName() {
    return funcName;
  }

  public void setFuncName(String funcName) {
    this.funcName = funcName;
  }

}
