package com.ufgov.gk.common.commonbiz.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.ufgov.gk.common.system.util.BeanUtil;

public class Provider implements Serializable  {
  /**
   * 
   */
  private static final long serialVersionUID = 4174481215485751013L;

  private String bankInfoId;
  
  private int nd;
  
  private String coCode;
  
  private String coName;
  
  private String receAccName;
  
  private String receBankNodeName;
  
  private String receBankAccCode;
  
  private BigDecimal orgMoney= new BigDecimal("0.00");
  
  public Object get(String name) {
    return BeanUtil.get(name, this);
  }

  public void set(String name, Object value) {
    BeanUtil.set(name, value, this);
  }

  public String getBankInfoId() {
    return bankInfoId;
  }

  public void setBankInfoId(String bankInfoId) {
    this.bankInfoId = bankInfoId;
  }

  public int getNd() {
    return nd;
  }

  public void setNd(int nd) {
    this.nd = nd;
  }

  public String getCoCode() {
    return coCode;
  }

  public void setCoCode(String coCode) {
    this.coCode = coCode;
  }

  public String getCoName() {
    return coName;
  }

  public void setCoName(String coName) {
    this.coName = coName;
  }

  public String getReceAccName() {
    return receAccName;
  }

  public void setReceAccName(String receAccName) {
    this.receAccName = receAccName;
  }

  public String getReceBankNodeName() {
    return receBankNodeName;
  }

  public void setReceBankNodeName(String receBankNodeName) {
    this.receBankNodeName = receBankNodeName;
  }

  public String getReceBankAccCode() {
    return receBankAccCode;
  }

  public void setReceBankAccCode(String receBankAccCode) {
    this.receBankAccCode = receBankAccCode;
  }

  public BigDecimal getOrgMoney() {
    return orgMoney;
  }

  public void setOrgMoney(BigDecimal orgMoney) {
    this.orgMoney = orgMoney;
  }


  

}
