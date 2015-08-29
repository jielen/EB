package com.ufgov.gk.common.console.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AsEmp implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = -9121550675920533265L;

  private String empCode;

  private String empName;

  private String userId;

  private String isLogin = "N";

  private String caSerial;

  private List grantRoles = new ArrayList();

  private boolean queryed;

  private String sex;

  private String email;

  private String phone;

  private String fax;

  private String identityCard;

  private String titleTech;

  private String rtXuin;

  private String coName;

  private Date transDate;

  private Date userBirthDate;

  private String empIndex;

  public boolean isQueryed() {
    return queryed;
  }

  public void setQueryed(boolean queryed) {
    this.queryed = queryed;
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

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public List getGrantRoles() {
    return grantRoles;
  }

  public void setGrantRoles(List grantRoles) {
    this.grantRoles = grantRoles;
  }

  public void setIsLogin(String isLogin) {
    this.isLogin = isLogin;
  }

  public String getIsLogin() {
    return isLogin;
  }

  public String getCaSerial() {
    return caSerial;
  }

  public void setCaSerial(String caSerial) {
    this.caSerial = caSerial;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getFax() {
    return fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
  }

  public String getIdentityCard() {
    return identityCard;
  }

  public void setIdentityCard(String identityCard) {
    this.identityCard = identityCard;
  }

  public String getTitleTech() {
    return titleTech;
  }

  public void setTitleTech(String titleTech) {
    this.titleTech = titleTech;
  }

  public String getRtXuin() {
    return rtXuin;
  }

  public void setRtXuin(String rtXuin) {
    this.rtXuin = rtXuin;
  }

  public String getCoName() {
    return coName;
  }

  public void setCoName(String coName) {
    this.coName = coName;
  }

  public Date getTransDate() {
    return transDate;
  }

  public void setTransDate(Date transDate) {
    this.transDate = transDate;
  }

  public Date getUserBirthDate() {
    return userBirthDate;
  }

  public void setUserBirthDate(Date userBirthDate) {
    this.userBirthDate = userBirthDate;
  }

  public String getEmpIndex() {
    return empIndex;
  }

  public void setEmpIndex(String empIndex) {
    this.empIndex = empIndex;
  }

  public AsEmp() {
  }
}
