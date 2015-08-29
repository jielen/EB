package com.ufgov.gk.common.commonbiz.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.ufgov.gk.common.system.util.BeanUtil;

public class Project extends BaseElement implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 5102398761702385473L;

  private String pdProjectTypeCode;

  private String pdIsLowest;

  private String pdCreaCoCode;

  private String pdCreaCoName;

  private String pdCreateUserId;

  private String pdProjectLevel;

  private String pdVersionId="1.0";

  private Date pdCreateDate;

  private BigDecimal pdMoney = new BigDecimal("0");//项目金额

  private BigDecimal pdUseMoney = new BigDecimal("0");//项目已用金额

  private BigDecimal pdBalance = new BigDecimal("0");//项目余额

  private String oid;


  public String getOid() {
    return oid;
  }

  public void setOid(String oid) {
    this.oid = oid;
  }

  public String getPdProjectTypeCode() {
    return pdProjectTypeCode;
  }

  public void setPdProjectTypeCode(String pdProjectTypeCode) {
    this.pdProjectTypeCode = pdProjectTypeCode;
  }

  public String getPdIsLowest() {
    return pdIsLowest;
  }

  public void setPdIsLowest(String pdIsLowest) {
    this.pdIsLowest = pdIsLowest;
  }

  public String getPdCreaCoCode() {
    return pdCreaCoCode;
  }

  public void setPdCreaCoCode(String pdCreaCoCode) {
    this.pdCreaCoCode = pdCreaCoCode;
  }

  public String getPdCreaCoName() {
    return pdCreaCoName;
  }

  public void setPdCreaCoName(String pdCreaCoName) {
    this.pdCreaCoName = pdCreaCoName;
  }

  public String getPdCreateUserId() {
    return pdCreateUserId;
  }

  public void setPdCreateUserId(String pdCreateUserId) {
    this.pdCreateUserId = pdCreateUserId;
  }

  public String getPdProjectLevel() {
    return pdProjectLevel;
  }

  public void setPdProjectLevel(String pdProjectLevel) {
    this.pdProjectLevel = pdProjectLevel;
  }

  public String getPdVersionId() {
    return pdVersionId;
  }

  public void setPdVersionId(String pdVersionId) {
    this.pdVersionId = pdVersionId;
  }

  public Date getPdCreateDate() {
    return pdCreateDate;
  }

  public void setPdCreateDate(Date pdCreateDate) {
    this.pdCreateDate = pdCreateDate;
  }

  public BigDecimal getPdBalance() {
    return pdBalance;
  }

  public void setPdBalance(BigDecimal pdBalance) {
    this.pdBalance = pdBalance;
  }

  public BigDecimal getPdMoney() {
    return pdMoney;
  }

  public void setPdMoney(BigDecimal pdMoney) {
    this.pdMoney = pdMoney;
  }

  public BigDecimal getPdUseMoney() {
    return pdUseMoney;
  }

  public void setPdUseMoney(BigDecimal pdUseMoney) {
    this.pdUseMoney = pdUseMoney;
  }

  public Object get(String name) {
    return BeanUtil.get(name, this);
  }

  public boolean equals(Object ob) {
    if (ob == null) return false;
    Project p = (Project)ob;
    if (this.getCode().equals(p.getCode())) {
      return true;
    } else {
      return false;
    }
  }

}
