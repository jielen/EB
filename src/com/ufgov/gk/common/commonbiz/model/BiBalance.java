package com.ufgov.gk.common.commonbiz.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class BiBalance extends BaseBill implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  private String biBalanceId;

  private BigDecimal biMoney = new BigDecimal("0");

  private BigDecimal dpMoney = new BigDecimal("0");

  private BigDecimal amMoney = new BigDecimal("0");

  private BigDecimal lpMoney = new BigDecimal("0");

  private BigDecimal cpMoney = new BigDecimal("0");

  private BigDecimal balance = new BigDecimal("0");

  private BigDecimal paySum = new BigDecimal("0");

  private BigDecimal cdMoney = new BigDecimal("0");

  private BigDecimal freezeMoney = new BigDecimal("0");

  private BigDecimal afreezeMoney = new BigDecimal("0");

  private BigDecimal biCanUseMoney = new BigDecimal("0");

  private BigDecimal dpCanUseMoney = new BigDecimal("0");

  private String biTargetCode;

  private String isCarryup = "N";

  private String fileName;

  private String filenameBlobid;

  private String biLevel;

  private int currMonthPlanTimes;

  private BigDecimal biAssignMoney = new BigDecimal("0");

  private BigDecimal biUpperMoney = new BigDecimal("0");

  private BigDecimal extMoney1 = new BigDecimal("0");

  private BigDecimal extMoney2 = new BigDecimal("0");

  private String operateType;

  private String isControl;

  public String getOperateType() {
    return operateType;
  }

  public void setOperateType(String operateType) {
    this.operateType = operateType;
  }

  public int getCurrMonthPlanTimes() {
    return currMonthPlanTimes;
  }

  public void setCurrMonthPlanTimes(int currMonthPlanTimes) {
    this.currMonthPlanTimes = currMonthPlanTimes;
  }

  public String getBiTargetCode() {
    return biTargetCode;
  }

  public void setBiTargetCode(String biTargetCode) {
    this.biTargetCode = biTargetCode;
  }

  public String getBiBalanceId() {
    return biBalanceId;
  }

  public void setBiBalanceId(String biBalanceId) {
    this.biBalanceId = biBalanceId;
  }

  public BigDecimal getBiMoney() {
    return biMoney;
  }

  public double getBiMoneyDoubleValue() {
    return biMoney.doubleValue();
  }

  public void setBiMoney(BigDecimal biMoney) {
    this.biMoney = biMoney;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

  public BigDecimal getPaySum() {
    return paySum;
  }

  public void setPaySum(BigDecimal paySum) {
    this.paySum = paySum;
  }

  public String getIsCarryup() {
    return isCarryup;
  }

  public void setIsCarryup(String isCarryup) {
    this.isCarryup = isCarryup;
  }

  public BigDecimal getDpMoney() {
    return dpMoney;
  }

  public void setDpMoney(BigDecimal dpMoney) {
    this.dpMoney = dpMoney;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public String getFilenameBlobid() {
    return filenameBlobid;
  }

  public void setFilenameBlobid(String filenameBlobid) {
    this.filenameBlobid = filenameBlobid;
  }

  public String getBiLevel() {
    return biLevel;
  }

  public void setBiLevel(String biLevel) {
    this.biLevel = biLevel;
  }

  public BigDecimal getAmMoney() {
    return amMoney;
  }

  public void setAmMoney(BigDecimal amMoney) {
    this.amMoney = amMoney;
  }

  public BigDecimal getLpMoney() {
    return lpMoney;
  }

  public void setLpMoney(BigDecimal lpMoney) {
    this.lpMoney = lpMoney;
  }

  public BigDecimal getCpMoney() {
    return cpMoney;
  }

  public void setCpMoney(BigDecimal cpMoney) {
    this.cpMoney = cpMoney;
  }

  /**
   * @return the assignMoney
   */
  public BigDecimal getBiAssignMoney() {
    return biAssignMoney;
  }

  public double getBiAssignMoneyDoubleValue() {
    return biAssignMoney.doubleValue();
  }

  public BigDecimal getBiUpperMoney() {
    return biUpperMoney;
  }

  public void setBiUpperMoney(BigDecimal biUpperMoney) {
    this.biUpperMoney = biUpperMoney;
  }

  public void setBiAssignMoney(BigDecimal assignMoney) {
    this.biAssignMoney = assignMoney;
  }

  public BigDecimal getExtMoney1() {
    return extMoney1;
  }

  public void setExtMoney1(BigDecimal extMoney1) {
    this.extMoney1 = extMoney1;
  }

  public BigDecimal getExtMoney2() {
    return extMoney2;
  }

  public void setExtMoney2(BigDecimal extMoney2) {
    this.extMoney2 = extMoney2;
  }

  public BigDecimal getAfreezeMoney() {
    return afreezeMoney;
  }

  public void setAfreezeMoney(BigDecimal afreezeMoney) {
    this.afreezeMoney = afreezeMoney;
  }

  public BigDecimal getCdMoney() {
    return cdMoney;
  }

  public void setCdMoney(BigDecimal cdMoney) {
    this.cdMoney = cdMoney;
  }

  public BigDecimal getFreezeMoney() {
    return freezeMoney;
  }

  public void setFreezeMoney(BigDecimal freezeMoney) {
    this.freezeMoney = freezeMoney;
  }

  public void setIsControl(String isControl) {
    this.isControl = isControl;
  }

  public String getIsControl() {
    return this.isControl;
  }

  public BigDecimal getBiCanUseMoney() {
    return biCanUseMoney;
  }

  public void setBiCanUseMoney(BigDecimal biCanUseMoney) {
    this.biCanUseMoney = biCanUseMoney;
  }

  public BigDecimal getDpCanUseMoney() {
    return dpCanUseMoney;
  }

  public void setDpCanUseMoney(BigDecimal dpCanUseMoney) {
    this.dpCanUseMoney = dpCanUseMoney;
  }

}
