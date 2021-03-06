package com.ufgov.gk.common.commonbiz.model;

import java.io.Serializable;

public class MaBank implements Serializable {
  /**
   *
   */
  private static final long serialVersionUID = -7072839492781364138L;

  private int nd;

  private String code;

  private String name;

  private String bankNo;

  private String baSendTarget;
  
  private String bankAbbName;//���м��

  public int getNd() {
    return nd;
  }

  public void setNd(int nd) {
    this.nd = nd;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBankNo() {
    return bankNo;
  }

  public void setBankNo(String bankNo) {
    this.bankNo = bankNo;
  }

  public String getBaSendTarget() {
    return baSendTarget;
  }

  public void setBaSendTarget(String baSendTarget) {
    this.baSendTarget = baSendTarget;
  }

  public String getBankAbbName() {
    return bankAbbName;
  }

  public void setBankAbbName(String bankAbbName) {
    this.bankAbbName = bankAbbName;
  }

  public String toString() {
    return "[" + code + "]" + name;
  }
}
