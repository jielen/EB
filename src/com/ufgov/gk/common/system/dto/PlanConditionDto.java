package com.ufgov.gk.common.system.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class PlanConditionDto implements Serializable {

  private static final long serialVersionUID = -3681316792427010040L;

  private long pnUid;

  private List list = new ArrayList();
  /**
   * 计划季度
   */
  private String pnTime;//format:20090表示2009年第一季度

  private String no;

  /**
   * 采购计划编号
   */
  private String pcPlanNo;
  //用于in(,,,)删除
  private String pcPlanNos;

  private String cPlanNoPrefix;

  /**
   * 品目
   */
  private String cCodePd;

  /**
   * 品目计量单位
   */
  private String cCodePdUnit;

  /**
   * 采购数量
   */
  private BigDecimal nPlanAmount;

  /**
   * 项目编码
   */
  private String cProjectNo;

  private BigDecimal mBgSum;

  /**
   * 计划资金小计
   */
  private BigDecimal mPlanSum;

  /**
   * 计划财政性资金
   */
  private BigDecimal mPlanFinance;

  /**
   * 计划其他资金
   */
  private BigDecimal mPlanOther;

  private Date dPlanUser;

  /**
   * 采购方式
   */
  private String cModeSk;

  /**
   * 组织方式
   */
  private String cModeOg;

  private String cModeOgOther;

  /**
   * 集中采购机构代码
   */
  private String cAgentUnit;

  private String cPlanUseUnit;

  /**
   * 录入人
   */
  private String cOpCreate;

  private Date startDCreate;
  
  private Date endDCreate;

  private String cOpModify;

  private Date dModify;

  /**
   * 备注信息
   */
  private String cRemark;

  /**
   * 预算代码
   */
  private String budgetID;

  /**
   * 预算名称
   */
  private String budgetName;

  /**
   * 预算金额总金额
   */
  private BigDecimal budgetSum;

  /**
   * 预算采购金额
   */
  private BigDecimal budgetZC;

  private String status;

  private String coCode;

  private String coName;
  
  private String projectType;

  public String getProjectType() {
    return projectType;
  }

  public void setProjectType(String projectType) {
    this.projectType = projectType;
  }

  public long getPnUid() {
    return pnUid;
  }

  public void setPnUid(long pnUid) {
    this.pnUid = pnUid;
  }

  public String getNo() {
    return no;
  }

  public void setNo(String no) {
    this.no = no;
  }

  public String getPnTime() {
    return pnTime;
  }

  public void setPnTime(String pnTime) {
    this.pnTime = pnTime;
  }

  public String getPcPlanNo() {
    return pcPlanNo;
  }

  public void setPcPlanNo(String pcPlanNo) {
    this.pcPlanNo = pcPlanNo;
  }

  public String getcPlanNoPrefix() {
    return cPlanNoPrefix;
  }

  public void setcPlanNoPrefix(String cPlanNoPrefix) {
    this.cPlanNoPrefix = cPlanNoPrefix;
  }

  public String getcCodePd() {
    return cCodePd;
  }

  public void setcCodePd(String cCodePd) {
    this.cCodePd = cCodePd;
  }

  public String getcCodePdUnit() {
    return cCodePdUnit;
  }

  public void setcCodePdUnit(String cCodePdUnit) {
    this.cCodePdUnit = cCodePdUnit;
  }

  public BigDecimal getnPlanAmount() {
    return nPlanAmount;
  }

  public void setnPlanAmount(BigDecimal nPlanAmount) {
    this.nPlanAmount = nPlanAmount;
  }

  public String getcProjectNo() {
    return cProjectNo;
  }

  public void setcProjectNo(String cProjectNo) {
    this.cProjectNo = cProjectNo;
  }

  public BigDecimal getmBgSum() {
    return mBgSum;
  }

  public void setmBgSum(BigDecimal mBgSum) {
    this.mBgSum = mBgSum;
  }

  public BigDecimal getmPlanSum() {
    return mPlanSum;
  }

  public void setmPlanSum(BigDecimal mPlanSum) {
    this.mPlanSum = mPlanSum;
  }

  public BigDecimal getmPlanFinance() {
    return mPlanFinance;
  }

  public void setmPlanFinance(BigDecimal mPlanFinance) {
    this.mPlanFinance = mPlanFinance;
  }

  public BigDecimal getmPlanOther() {
    return mPlanOther;
  }

  public void setmPlanOther(BigDecimal mPlanOther) {
    this.mPlanOther = mPlanOther;
  }

  public Date getdPlanUser() {
    return dPlanUser;
  }

  public void setdPlanUser(Date dPlanUser) {
    this.dPlanUser = dPlanUser;
  }

  public String getcModeSk() {
    return cModeSk;
  }

  public void setcModeSk(String cModeSk) {
    this.cModeSk = cModeSk;
  }

  public String getcModeOg() {
    return cModeOg;
  }

  public void setcModeOg(String cModeOg) {
    this.cModeOg = cModeOg;
  }

  public String getcModeOgOther() {
    return cModeOgOther;
  }

  public void setcModeOgOther(String cModeOgOther) {
    this.cModeOgOther = cModeOgOther;
  }

  public String getcAgentUnit() {
    return cAgentUnit;
  }

  public void setcAgentUnit(String cAgentUnit) {
    this.cAgentUnit = cAgentUnit;
  }

  public String getcPlanUseUnit() {
    return cPlanUseUnit;
  }

  public void setcPlanUseUnit(String cPlanUseUnit) {
    this.cPlanUseUnit = cPlanUseUnit;
  }

  public String getcOpCreate() {
    return cOpCreate;
  }

  public void setcOpCreate(String cOpCreate) {
    this.cOpCreate = cOpCreate;
  }

  public Date getStartDCreate() {
    return startDCreate;
  }

  public void setStartDCreate(Date startDCreate) {
    this.startDCreate = startDCreate;
  }

  public Date getEndDCreate() {
    return endDCreate;
  }

  public void setEndDCreate(Date endDCreate) {
    this.endDCreate = endDCreate;
  }

  public String getcOpModify() {
    return cOpModify;
  }

  public void setcOpModify(String cOpModify) {
    this.cOpModify = cOpModify;
  }

  public Date getdModify() {
    return dModify;
  }

  public void setdModify(Date dModify) {
    this.dModify = dModify;
  }

  public String getcRemark() {
    return cRemark;
  }

  public void setcRemark(String cRemark) {
    this.cRemark = cRemark;
  }

  public String getBudgetID() {
    return budgetID;
  }

  public void setBudgetID(String budgetID) {
    this.budgetID = budgetID;
  }

  public String getBudgetName() {
    return budgetName;
  }

  public void setBudgetName(String budgetName) {
    this.budgetName = budgetName;
  }

  public BigDecimal getBudgetSum() {
    return budgetSum;
  }

  public void setBudgetSum(BigDecimal budgetSum) {
    this.budgetSum = budgetSum;
  }

  public BigDecimal getBudgetZC() {
    return budgetZC;
  }

  public void setBudgetZC(BigDecimal budgetZC) {
    this.budgetZC = budgetZC;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
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

  public String getPcPlanNos() {
    return pcPlanNos;
  }

  public void setPcPlanNos(String pcPlanNos) {
    this.pcPlanNos = pcPlanNos;
  }

  public List getList() {
    return list;
  }

  public void setList(List list) {
    this.list = list;
  }
}
