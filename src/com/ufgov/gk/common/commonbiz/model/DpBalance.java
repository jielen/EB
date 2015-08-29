package com.ufgov.gk.common.commonbiz.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.ufgov.gk.common.commonbiz.aware.BalModeAware;
import com.ufgov.gk.common.commonbiz.aware.OperationTypeAware;
import com.ufgov.gk.common.system.Copyable;
import com.ufgov.gk.common.system.Digestable;
import com.ufgov.gk.common.system.util.DigestUtil;
import com.ufgov.gk.common.system.util.ObjectUtil;

public class DpBalance extends BaseBill implements OperationTypeAware,BalModeAware,Serializable, Digestable, Copyable {
  
  private String tempId;

  private static final long serialVersionUID = 1L;

  private String dpBalanceId;

  private BigDecimal balance;

  private String monthId;

  private BigDecimal dpmoney = new BigDecimal("0");

  private BigDecimal paySum = new BigDecimal("0");

  private String biBalanceId;

  private String isCarrydown = "0";

  private String isBiControl = "1";

  private String biTargetCode;

  private String bAccId;

  private String inceptdocCode;

  private String senddocTypeCode;

  private BigDecimal dpCdMoney = new BigDecimal("0");

  private BigDecimal dpCdUseMoney = new BigDecimal("0");

  private BigDecimal dpMoney1 = new BigDecimal("0");

  private BigDecimal dpMoney2 = new BigDecimal("0");

  private BigDecimal dpMoney3 = new BigDecimal("0");

  private BigDecimal dpMoney4 = new BigDecimal("0");

  private BigDecimal dpMoney5 = new BigDecimal("0");

  private BigDecimal dpMoney6 = new BigDecimal("0");

  private BigDecimal dpMoney7 = new BigDecimal("0");

  private BigDecimal dpMoney8 = new BigDecimal("0");

  private BigDecimal dpMoney9 = new BigDecimal("0");

  private BigDecimal dpMoney10 = new BigDecimal("0");

  private BigDecimal dpMoney11 = new BigDecimal("0");

  private BigDecimal dpMoney12 = new BigDecimal("0");

  private BigDecimal amMoney = new BigDecimal("0");

  private BigDecimal cpMoney = new BigDecimal("0");

  private BigDecimal freezeMoney = new BigDecimal("0");

  private BigDecimal afreezeMoney = new BigDecimal("0");

  private BigDecimal cdMoney = new BigDecimal("0");

  private BigDecimal stamp = new BigDecimal("0");

  private BigDecimal camMoney = new BigDecimal("0");

  private BigDecimal acamMoney = new BigDecimal("0");

  private String fileName;

  private String filenameBlobid;
  
  private String jjPlanDetailOid;
  
  
  private String operationTypeCode;

  private String operationTypeName;
  
  private String balModeCode;

  private String balModeName;

  public String getOperationTypeCode() {
    return operationTypeCode;
  }

  public void setOperationTypeCode(String operationTypeCode) {
    this.operationTypeCode = operationTypeCode;
  }

  public String getOperationTypeName() {
    return operationTypeName;
  }

  public void setOperationTypeName(String operationTypeName) {
    this.operationTypeName = operationTypeName;
  }

  public String getJjPlanDetailOid() {
    return jjPlanDetailOid;
  }

  public void setJjPlanDetailOid(String jjPlanDetailOid) {
    this.jjPlanDetailOid = jjPlanDetailOid;
  }

  public BigDecimal getAcamMoney() {
    return acamMoney;
  }

  public void setAcamMoney(BigDecimal acamMoney) {
    this.acamMoney = acamMoney;
  }

  public BigDecimal getAfreezeMoney() {
    return afreezeMoney;
  }

  public void setAfreezeMoney(BigDecimal afreezeMoney) {
    this.afreezeMoney = afreezeMoney;
  }

  public BigDecimal getAmMoney() {
    return amMoney;
  }

  public void setAmMoney(BigDecimal amMoney) {
    this.amMoney = amMoney;
  }

  public String getBAccId() {
    return bAccId;
  }

  public void setBAccId(String accId) {
    bAccId = accId;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

  public String getBiBalanceId() {
    return biBalanceId;
  }

  public void setBiBalanceId(String biBalanceId) {
    this.biBalanceId = biBalanceId;
  }

  public String getBiTargetCode() {
    return biTargetCode;
  }

  public void setBiTargetCode(String biTargetCode) {
    this.biTargetCode = biTargetCode;
  }

  public BigDecimal getCamMoney() {
    return camMoney;
  }

  public void setCamMoney(BigDecimal camMoney) {
    this.camMoney = camMoney;
  }

  public BigDecimal getCdMoney() {
    return cdMoney;
  }

  public void setCdMoney(BigDecimal cdMoney) {
    this.cdMoney = cdMoney;
  }

  public BigDecimal getCpMoney() {
    return cpMoney;
  }

  public void setCpMoney(BigDecimal cpMoney) {
    this.cpMoney = cpMoney;
  }

  public String getDpBalanceId() {
    return dpBalanceId;
  }

  public void setDpBalanceId(String dpBalanceId) {
    this.dpBalanceId = dpBalanceId;
  }

  public BigDecimal getDpCdMoney() {
    return dpCdMoney;
  }

  public void setDpCdMoney(BigDecimal dpCdMoney) {
    this.dpCdMoney = dpCdMoney;
  }

  public BigDecimal getDpCdUseMoney() {
    return dpCdUseMoney;
  }

  public void setDpCdUseMoney(BigDecimal dpCdUseMoney) {
    this.dpCdUseMoney = dpCdUseMoney;
  }

  public BigDecimal getDpmoney() {
    return dpmoney;
  }

  public void setDpmoney(BigDecimal dpmoney) {
    this.dpmoney = dpmoney;
  }

  public BigDecimal getDpMoney1() {
    return dpMoney1;
  }

  public void setDpMoney1(BigDecimal dpMoney1) {
    this.dpMoney1 = dpMoney1;
  }

  public BigDecimal getDpMoney10() {
    return dpMoney10;
  }

  public void setDpMoney10(BigDecimal dpMoney10) {
    this.dpMoney10 = dpMoney10;
  }

  public BigDecimal getDpMoney11() {
    return dpMoney11;
  }

  public void setDpMoney11(BigDecimal dpMoney11) {
    this.dpMoney11 = dpMoney11;
  }

  public BigDecimal getDpMoney12() {
    return dpMoney12;
  }

  public void setDpMoney12(BigDecimal dpMoney12) {
    this.dpMoney12 = dpMoney12;
  }

  public BigDecimal getDpMoney2() {
    return dpMoney2;
  }

  public void setDpMoney2(BigDecimal dpMoney2) {
    this.dpMoney2 = dpMoney2;
  }

  public BigDecimal getDpMoney3() {
    return dpMoney3;
  }

  public void setDpMoney3(BigDecimal dpMoney3) {
    this.dpMoney3 = dpMoney3;
  }

  public BigDecimal getDpMoney4() {
    return dpMoney4;
  }

  public void setDpMoney4(BigDecimal dpMoney4) {
    this.dpMoney4 = dpMoney4;
  }

  public BigDecimal getDpMoney5() {
    return dpMoney5;
  }

  public void setDpMoney5(BigDecimal dpMoney5) {
    this.dpMoney5 = dpMoney5;
  }

  public BigDecimal getDpMoney6() {
    return dpMoney6;
  }

  public void setDpMoney6(BigDecimal dpMoney6) {
    this.dpMoney6 = dpMoney6;
  }

  public BigDecimal getDpMoney7() {
    return dpMoney7;
  }

  public void setDpMoney7(BigDecimal dpMoney7) {
    this.dpMoney7 = dpMoney7;
  }

  public BigDecimal getDpMoney8() {
    return dpMoney8;
  }

  public void setDpMoney8(BigDecimal dpMoney8) {
    this.dpMoney8 = dpMoney8;
  }

  public BigDecimal getDpMoney9() {
    return dpMoney9;
  }

  public void setDpMoney9(BigDecimal dpMoney9) {
    this.dpMoney9 = dpMoney9;
  }

  public BigDecimal getFreezeMoney() {
    return freezeMoney;
  }

  public void setFreezeMoney(BigDecimal freezeMoney) {
    this.freezeMoney = freezeMoney;
  }

  public String getInceptdocCode() {
    return inceptdocCode;
  }

  public void setInceptdocCode(String inceptdocCode) {
    this.inceptdocCode = inceptdocCode;
  }

  public String getIsBiControl() {
    return isBiControl;
  }

  public void setIsBiControl(String isBiControl) {
    this.isBiControl = isBiControl;
  }

  public String getIsCarrydown() {
    return isCarrydown;
  }

  public void setIsCarrydown(String isCarrydown) {
    this.isCarrydown = isCarrydown;
  }

  public String getMonthId() {
    return monthId;
  }

  public void setMonthId(String monthId) {
    this.monthId = monthId;
  }

  public BigDecimal getPaySum() {
    return paySum;
  }

  public void setPaySum(BigDecimal paySum) {
    this.paySum = paySum;
  }

  public String getSenddocTypeCode() {
    return senddocTypeCode;
  }

  public void setSenddocTypeCode(String senddocTypeCode) {
    this.senddocTypeCode = senddocTypeCode;
  }

  public BigDecimal getStamp() {
    return stamp;
  }

  public void setStamp(BigDecimal stamp) {
    this.stamp = stamp;
  }

  public String digest() {
    return DigestUtil.digest(this);
  }

  public Copyable copy() {
    return (Copyable) ObjectUtil.deepCopy(this);
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

  public String getTempId() {
    return tempId;
  }

  public void setTempId(String tempId) {
    this.tempId = tempId;
  }

  public String getBalModeCode() {
    return balModeCode;
  }

  public void setBalModeCode(String balModeCode) {
    this.balModeCode = balModeCode;
  }

  public String getBalModeName() {
    return balModeName;
  }

  public void setBalModeName(String balModeName) {
    this.balModeName = balModeName;
  }

}
