package com.ufgov.gk.common.system.model;

import java.io.Serializable;

public class AsLog implements Serializable {
    /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
    private String guid;
    private String operTime;
    private String userId;
    private String userName;
    private String userIP;
    private String compoId;
    private String compoName;
    private String funcId;
    private String operDesc;
    private String  ifSuc;
    private String  pkDesc;
    
    public String getGuid() {
      return guid;
    }
    public void setGuid(String guid) {
      this.guid = guid;
    }
    public String getOperTime() {
      return operTime;
    }
    public void setOperTime(String operTime) {
      this.operTime = operTime;
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
    public String getUserIP() {
      return userIP;
    }
    public void setUserIP(String userIP) {
      this.userIP = userIP;
    }
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
    public String getFuncId() {
      return funcId;
    }
    public void setFuncId(String funcId) {
      this.funcId = funcId;
    }
    public String getOperDesc() {
      return operDesc;
    }
    public void setOperDesc(String operDesc) {
      this.operDesc = operDesc;
    }
    public String getIfSuc() {
      return ifSuc;
    }
    public void setIfSuc(String ifSuc) {
      this.ifSuc = ifSuc;
    }
    public String getPkDesc() {
      return pkDesc;
    }
    public void setPkDesc(String pkDesc) {
      this.pkDesc = pkDesc;
    }
    

}
