package com.ufgov.gk.common.system;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class RequestMeta implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -3561223757155463828L;

  private String token = "";

  private String clientIP = "";

  private String svUserID = "";

  private String svUserName = "";

  private String svCoCode = "";

  private String svCoName = "";

  private String svCoTypeCode = "";

  private String svOrgCode = "";

  private String svPoCode = "";

  private String svOrgPoCode = "";

  private String compoId = "";

  private String funcId = "";

  private String accountId = "";

  private String printCompoId = "";

  private String pageType = "";

  private java.util.Date transDate = new Date();

  private java.util.Date sysDate = new Date();

  private String expertCode = "";

  private String expertName = "";

  private String empCode = "";

  private String empName = "";

  private HashMap urlMap = new HashMap();

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getClientIP() {
    return clientIP;
  }

  public void setClientIP(String clientIP) {
    this.clientIP = clientIP;
  }

  public String getCompoId() {
    return compoId;
  }

  public void setCompoId(String compoId) {
    this.compoId = compoId;
    this.printCompoId = compoId;
  }

  public String getFuncId() {
    return funcId;
  }

  public void setFuncId(String funcId) {
    this.funcId = funcId;
  }

  public String getSvUserID() {
    return svUserID;
  }

  public void setSvUserID(String svUserID) {
    this.svUserID = svUserID;
  }

  public String getSvCoCode() {
    return svCoCode;
  }

  public void setSvCoCode(String svCoCode) {
    this.svCoCode = svCoCode;
  }

  public String getSvOrgCode() {
    return svOrgCode;
  }

  public void setSvOrgCode(String svOrgCode) {
    this.svOrgCode = svOrgCode;
  }

  public String getSvPoCode() {
    return svPoCode;
  }

  public void setSvPoCode(String svPoCode) {
    this.svPoCode = svPoCode;
  }

  public String getSvOrgPoCode() {
    return svOrgPoCode;
  }

  public void setSvOrgPoCode(String svOrgPoCode) {
    this.svOrgPoCode = svOrgPoCode;
  }

  public String getSvCoTypeCode() {
    return svCoTypeCode;
  }

  public void setSvCoTypeCode(String svCoTypeCode) {
    this.svCoTypeCode = svCoTypeCode;
  }

  public int getSvNd() {
    Calendar c = Calendar.getInstance();
    c.setTime(transDate);
    return c.get(Calendar.YEAR);
  }

  public int getSvMonth() {
    Calendar c = Calendar.getInstance();
    c.setTime(transDate);
    return c.get(Calendar.MONTH) + 1;
  }

  public java.util.Date getTransDate() {
    return transDate;
  }

  public void setTransDate(java.util.Date transDate) {
    this.transDate = transDate;
  }

  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public String getPageType() {
    return pageType;
  }

  public void setPageType(String pageType) {
    this.pageType = pageType;
  }

  public String getPrintCompoId() {
    return printCompoId;
  }

  public void setPrintCompoId(String printCompoId) {
    this.printCompoId = printCompoId;
  }

  public String getSvUserName() {
    return svUserName;
  }

  public void setSvUserName(String svUserName) {
    this.svUserName = svUserName;
  }

  public String getSvCoName() {
    return svCoName;
  }

  public String getEmpCode() {
    return empCode;
  }

  public void setEmpCode(String empCode) {
    this.empCode = empCode;
  }

  public String getEmpName() {
    return empName;
  }

  public void setEmpName(String empName) {
    this.empName = empName;
  }

  public void setSvCoName(String svCoName) {
    this.svCoName = svCoName;
  }

  public java.util.Date getSysDate() {
    return sysDate;
  }

  public void setSysDate(java.util.Date sysDate) {
    this.sysDate = sysDate;
  }

  public String getExpertCode() {
    return expertCode;
  }

  public void setExpertCode(String expertCode) {
    this.expertCode = expertCode;
  }

  public String getExpertName() {
    return expertName;
  }

  public void setExpertName(String expertName) {
    this.expertName = expertName;
  }

  public HashMap getUrlMap() {
    return urlMap;
  }

  public void setUrlMap(HashMap urlMap) {
    this.urlMap = urlMap;
  }

}