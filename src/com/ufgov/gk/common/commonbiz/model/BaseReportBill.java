package com.ufgov.gk.common.commonbiz.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.ufgov.gk.common.system.util.BeanUtil;

public class BaseReportBill implements Serializable {

  private String coCode;

  private String coName;

  private String originCode;

  private String originName;

  private String fundCode;

  private String fundName;

  private String baccCode;

  private String baccName;

  private String projectCode;

  private String projectName;

  private String outlayCode;

  private String outlayName;

  private String orgCode;

  private String orgName;

  private String payoutCode;

  private String payoutName;

  private String sendDocCode;

  private String sendDocName;

  protected String dattr1;

  protected String dattr2;

  protected String dattr3;

  protected String dattr4;

  protected String dattr5;

  protected String dattr1Name;

  protected String dattr2Name;

  protected String dattr3Name;

  protected String dattr4Name;

  protected String dattr5Name;

  protected String balModeCode;

  protected String balModeName;

  protected String inceptdocCode;

  protected String inceptdocName;

  protected String manageCode;

  protected String manageName;

  protected String operationTypeCode;

  protected String operationTypeName;

  protected String paytypeCode;

  protected String paytypeName;

  protected String numLimStr;

  protected BigDecimal money1 = new BigDecimal("0");

  protected BigDecimal money2 = new BigDecimal("0");

  protected BigDecimal money3 = new BigDecimal("0");

  protected BigDecimal money4 = new BigDecimal("0");

  protected BigDecimal money5 = new BigDecimal("0");

  protected BigDecimal money6 = new BigDecimal("0");

  protected BigDecimal money7 = new BigDecimal("0");

  protected BigDecimal money8 = new BigDecimal("0");

  protected BigDecimal money9 = new BigDecimal("0");

  protected BigDecimal money10 = new BigDecimal("0");

  protected BigDecimal money11 = new BigDecimal("0");

  protected BigDecimal money12 = new BigDecimal("0");

  public void set(String name, Object value) {
    BeanUtil.set(name, value, this);
  }

  public BigDecimal getMoney1() {
    return money1;
  }

  public void setMoney1(BigDecimal money1) {
    this.money1 = money1;
  }

  public BigDecimal getMoney10() {
    return money10;
  }

  public void setMoney10(BigDecimal money10) {
    this.money10 = money10;
  }

  public BigDecimal getMoney11() {
    return money11;
  }

  public void setMoney11(BigDecimal money11) {
    this.money11 = money11;
  }

  public BigDecimal getMoney12() {
    return money12;
  }

  public void setMoney12(BigDecimal money12) {
    this.money12 = money12;
  }

  public BigDecimal getMoney2() {
    return money2;
  }

  public void setMoney2(BigDecimal money2) {
    this.money2 = money2;
  }

  public BigDecimal getMoney3() {
    return money3;
  }

  public void setMoney3(BigDecimal money3) {
    this.money3 = money3;
  }

  public BigDecimal getMoney4() {
    return money4;
  }

  public void setMoney4(BigDecimal money4) {
    this.money4 = money4;
  }

  public BigDecimal getMoney5() {
    return money5;
  }

  public void setMoney5(BigDecimal money5) {
    this.money5 = money5;
  }

  public BigDecimal getMoney6() {
    return money6;
  }

  public void setMoney6(BigDecimal money6) {
    this.money6 = money6;
  }

  public BigDecimal getMoney7() {
    return money7;
  }

  public void setMoney7(BigDecimal money7) {
    this.money7 = money7;
  }

  public BigDecimal getMoney8() {
    return money8;
  }

  public void setMoney8(BigDecimal money8) {
    this.money8 = money8;
  }

  public BigDecimal getMoney9() {
    return money9;
  }

  public void setMoney9(BigDecimal money9) {
    this.money9 = money9;
  }

  public String getSendDocCode() {
    return sendDocCode;
  }

  public void setSendDocCode(String sendDocCode) {
    this.sendDocCode = sendDocCode;
  }

  public String getSendDocName() {
    return sendDocName;
  }

  public void setSendDocName(String sendDocName) {
    this.sendDocName = sendDocName;
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

  public String getOriginCode() {
    return originCode;
  }

  public void setOriginCode(String originCode) {
    this.originCode = originCode;
  }

  public String getOriginName() {
    return originName;
  }

  public void setOriginName(String originName) {
    this.originName = originName;
  }

  public String getFundCode() {
    return fundCode;
  }

  public void setFundCode(String fundCode) {
    this.fundCode = fundCode;
  }

  public String getFundName() {
    return fundName;
  }

  public void setFundName(String fundName) {
    this.fundName = fundName;
  }

  public String getBaccCode() {
    return baccCode;
  }

  public void setBaccCode(String baccCode) {
    this.baccCode = baccCode;
  }

  public String getBaccName() {
    return baccName;
  }

  public void setBaccName(String baccName) {
    this.baccName = baccName;
  }

  public String getProjectCode() {
    return projectCode;
  }

  public void setProjectCode(String projectCode) {
    this.projectCode = projectCode;
  }

  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  public String getOutlayCode() {
    return outlayCode;
  }

  public void setOutlayCode(String outlayCode) {
    this.outlayCode = outlayCode;
  }

  public String getOutlayName() {
    return outlayName;
  }

  public void setOutlayName(String outlayName) {
    this.outlayName = outlayName;
  }

  public String getOrgCode() {
    return orgCode;
  }

  public void setOrgCode(String orgCode) {
    this.orgCode = orgCode;
  }

  public String getOrgName() {
    return orgName;
  }

  public void setOrgName(String orgName) {
    this.orgName = orgName;
  }

  public String getPayoutCode() {
    return payoutCode;
  }

  public void setPayoutCode(String payoutCode) {
    this.payoutCode = payoutCode;
  }

  public String getPayoutName() {
    return payoutName;
  }

  public void setPayoutName(String payoutName) {
    this.payoutName = payoutName;
  }

  public String getDattr2() {
    return dattr2;
  }

  public void setDattr2(String dattr2) {
    this.dattr2 = dattr2;
  }

  public String getDattr4() {
    return dattr4;
  }

  public void setDattr4(String dattr4) {
    this.dattr4 = dattr4;
  }

  public String getDattr5() {
    return dattr5;
  }

  public void setDattr5(String dattr5) {
    this.dattr5 = dattr5;
  }

  public String getDattr1() {
    return dattr1;
  }

  public void setDattr1(String dattr1) {
    this.dattr1 = dattr1;
  }

  public String getDattr3() {
    return dattr3;
  }

  public void setDattr3(String dattr3) {
    this.dattr3 = dattr3;
  }

  public String getDattr1Name() {
    return dattr1Name;
  }

  public void setDattr1Name(String dattr1Name) {
    this.dattr1Name = dattr1Name;
  }

  public String getDattr2Name() {
    return dattr2Name;
  }

  public void setDattr2Name(String dattr2Name) {
    this.dattr2Name = dattr2Name;
  }

  public String getDattr3Name() {
    return dattr3Name;
  }

  public void setDattr3Name(String dattr3Name) {
    this.dattr3Name = dattr3Name;
  }

  public String getDattr4Name() {
    return dattr4Name;
  }

  public void setDattr4Name(String dattr4Name) {
    this.dattr4Name = dattr4Name;
  }

  public String getDattr5Name() {
    return dattr5Name;
  }

  public void setDattr5Name(String dattr5Name) {
    this.dattr5Name = dattr5Name;
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

  public String getInceptdocCode() {
    return inceptdocCode;
  }

  public void setInceptdocCode(String inceptdocCode) {
    this.inceptdocCode = inceptdocCode;
  }

  public String getInceptdocName() {
    return inceptdocName;
  }

  public void setInceptdocName(String inceptdocName) {
    this.inceptdocName = inceptdocName;
  }

  public String getManageCode() {
    return manageCode;
  }

  public void setManageCode(String manageCode) {
    this.manageCode = manageCode;
  }

  public String getManageName() {
    return manageName;
  }

  public void setManageName(String manageName) {
    this.manageName = manageName;
  }

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

  public String getPaytypeCode() {
    return paytypeCode;
  }

  public void setPaytypeCode(String paytypeCode) {
    this.paytypeCode = paytypeCode;
  }

  public String getPaytypeName() {
    return paytypeName;
  }

  public void setPaytypeName(String paytypeName) {
    this.paytypeName = paytypeName;
  }

  public String getNumLimStr() {
    return numLimStr;
  }

  public void setNumLimStr(String numLimStr) {
    this.numLimStr = numLimStr;
  }
  
}
