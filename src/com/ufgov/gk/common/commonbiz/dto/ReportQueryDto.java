package com.ufgov.gk.common.commonbiz.dto;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class ReportQueryDto implements Serializable {
  /**
   *
   */
  private static final long serialVersionUID = 5956838272909492444L;

  private Integer nd;

  private String coCode;

  private String originCode;

  private String fundCode;

  private String kmlb;

  private String baccCode;

  private String projectCode;

  private String outlayCode;

  private String orgCode;

  private String selectStr;

  private String selectStrOut;

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

  protected String projectDetailCode;

  private Date startDate;
  private Date endDate;

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public String getSelectStrOut() {
    return selectStrOut;
  }

  public void setSelectStrOut(String selectStrOut) {
    this.selectStrOut = selectStrOut;
  }

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public ReportQueryDto() {
    Calendar c = Calendar.getInstance();
    c.setTime(new Date());
    nd = new Integer(c.get(Calendar.YEAR));
  }

  public Integer getNd() {
    return nd;
  }

  public void setNd(Integer nd) {
    this.nd = nd;
  }

  public String getCoCode() {
    return coCode;
  }

  public void setCoCode(String coCode) {
    this.coCode = coCode;
  }

  public String getOriginCode() {
    return originCode;
  }

  public void setOriginCode(String originCode) {
    this.originCode = originCode;
  }

  public String getFundCode() {
    return fundCode;
  }

  public void setFundCode(String fundCode) {
    this.fundCode = fundCode;
  }

  public String getKmlb() {
    return kmlb;
  }

  public void setKmlb(String kmlb) {
    this.kmlb = kmlb;
  }

  public String getBaccCode() {
    return baccCode;
  }

  public void setBaccCode(String baccCode) {
    this.baccCode = baccCode;
  }

  public String getProjectCode() {
    return projectCode;
  }

  public void setProjectCode(String projectCode) {
    this.projectCode = projectCode;
  }

  public String getOutlayCode() {
    return outlayCode;
  }

  public void setOutlayCode(String outlayCode) {
    this.outlayCode = outlayCode;
  }

  public String getOrgCode() {
    return orgCode;
  }

  public void setOrgCode(String orgCode) {
    this.orgCode = orgCode;
  }

  public String getSelectStr() {
    return selectStr;
  }

  public void setSelectStr(String selectStr) {
    this.selectStr = selectStr;
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

  public String getDattr1() {
    return dattr1;
  }

  public void setDattr1(String dattr1) {
    this.dattr1 = dattr1;
  }

  public String getDattr2() {
    return dattr2;
  }

  public void setDattr2(String dattr2) {
    this.dattr2 = dattr2;
  }

  public String getDattr3() {
    return dattr3;
  }

  public void setDattr3(String dattr3) {
    this.dattr3 = dattr3;
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

  public String getProjectDetailCode() {
    return projectDetailCode;
  }

  public void setProjectDetailCode(String projectDetailCode) {
    this.projectDetailCode = projectDetailCode;
  }
}
