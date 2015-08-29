package com.ufgov.gk.common.commonbiz.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.ufgov.gk.common.system.Copyable;
import com.ufgov.gk.common.system.Digestable;
import com.ufgov.gk.common.system.util.BeanUtil;
import com.ufgov.gk.common.system.util.DigestUtil;
import com.ufgov.gk.common.system.util.ObjectUtil;

public class BaseBill implements Serializable, Digestable, WfAware, Copyable {

  private static final long serialVersionUID = 3253855330970534159L;

  protected int nd;

  protected String id = "";

  protected String titleField;

  protected BigDecimal orgMoney;

  protected BigDecimal curMoney;

  protected String coCode;

  protected String coName;

  protected String baccCode;

  protected String baccName;

  protected String fundCode;

  protected String fundName;

  protected String inceptDocCode;

  protected String inceptDocName;

  protected String manageCode;

  protected String manageName;

  protected String orgCode;

  protected String orgName;

  protected String originCode;

  protected String originName;

  protected String outlayCode;

  protected String outlayName;

  protected String payoutCode;

  protected String payoutName;

  protected String paytypeCode;

  protected String paytypeName;

  protected String projectTypeCode;

  protected String projectTypeName;

  protected String projectCode;

  protected String projectName;

  protected String projectDetailCode;

  protected String projectDetailName;

  protected String sendDocTypeCode;

  protected String sendDocTypeName;

  protected String sendDocCode;

  protected String sendDocName;

  protected String remark;

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

  protected Long processInstId;

  protected String comment = "";//填写的意见

  protected Date printDate; //打印日期

  protected String payAccNo;

  protected String payAccCode;

  protected String payAccName;

  protected String payBankAccCode;

  protected String payBankNo;

  protected String payBankNodeCode;

  protected String payBankNodeName;

  protected String payBankCode;

  protected String payBankName;

  protected String payCode;

  protected String payName;

  protected String clearAccCode;

  protected String clearAccName;

  protected String clearAccNo;

  protected String clearBankCode;

  protected String clearBankName;

  protected String clearBankNo;

  protected String receBankNodeCode;

  protected String receBankNodeName;

  protected String receBankAccCode;

  protected String receCode;

  protected String receAccCode;

  protected String receAccName;

  protected String receName;

  protected String receBankCode;

  protected String receBankName;

  protected String receBankNo;

  protected String receAccNo;

  protected String receBankRemark;//收款人帐户备注信息

  protected String inputorId;

  protected String inputorName;

  protected String auditorId;

  protected String auditorName;

  protected BigDecimal sumMoney = new BigDecimal("0");

  protected BigDecimal sumMoney1 = new BigDecimal("0");

  protected BigDecimal sumMoney2 = new BigDecimal("0");

  protected BigDecimal sumMoney3 = new BigDecimal("0");

  /**
   * dbDigest 从数据库中拿出来数据的摘要信息，加这个field是为了判断在数据拿出数据库以后，数据库中的数据是不是被修改过
   * 是为了检查数据一致性用的，另外 加这个字段是为了处理Object经过Hessian序列化后对象实例本身有所变化的问题
   */
  protected String dbDigest;

  public int getNd() {
    return nd;
  }

  public void setNd(int nd) {
    this.nd = nd;
  }

  public Long getProcessInstId() {
    return processInstId;
  }

  public void setProcessInstId(Long processInstId) {
    this.processInstId = processInstId;
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

  public String getInceptDocCode() {
    return inceptDocCode;
  }

  public void setInceptDocCode(String inceptDocCode) {
    this.inceptDocCode = inceptDocCode;
  }

  public String getInceptDocName() {
    return inceptDocName;
  }

  public void setInceptDocName(String inceptDocName) {
    this.inceptDocName = inceptDocName;
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

  public String getProjectTypeCode() {
    return projectTypeCode;
  }

  public void setProjectTypeCode(String projectTypeCode) {
    this.projectTypeCode = projectTypeCode;
  }

  public String getProjectCode() {
    return projectCode;
  }

  public void setProjectCode(String projectCode) {
    this.projectCode = projectCode;
  }

  public String getProjectDetailCode() {
    return projectDetailCode;
  }

  public void setProjectDetailCode(String projectDetailCode) {
    this.projectDetailCode = projectDetailCode;
  }

  public String getProjectDetailName() {
    return projectDetailName;
  }

  public void setProjectDetailName(String projectDetailName) {
    this.projectDetailName = projectDetailName;
  }

  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  public String getSendDocTypeCode() {
    return sendDocTypeCode;
  }

  public void setSendDocTypeCode(String sendDocTypeCode) {
    this.sendDocTypeCode = sendDocTypeCode;
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

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
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

  public BigDecimal getOrgMoney() {
    return orgMoney;
  }

  public void setOrgMoney(BigDecimal orgMoney) {
    this.orgMoney = orgMoney;
  }

  public BigDecimal getCurMoney() {
    return curMoney;
  }

  public void setCurMoney(BigDecimal curMoney) {
    this.curMoney = curMoney;
  }

  public String getTitleField() {
    return titleField;
  }

  public void setTitleField(String titleField) {
    this.titleField = titleField;
  }

  private String contractCode;

  private String contractName;

  public String getContractCode() {
    return contractCode;
  }

  public void setContractCode(String contractCode) {
    this.contractCode = contractCode;
  }

  public String getContractName() {
    return contractName;
  }

  public void setContractName(String contractName) {
    this.contractName = contractName;
  }

  public Object get(String name) {
    return BeanUtil.get(name, this);
  }

  public void set(String name, Object value) {
    BeanUtil.set(name, value, this);
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String digest() {
    return DigestUtil.digest(this);
  }

  public Copyable copy() {
    return (Copyable) ObjectUtil.deepCopy(this);
  }

  public Date getPrintDate() {
    return printDate;
  }

  public void setPrintDate(Date printDate) {
    this.printDate = printDate;
  }

  public String getProjectTypeName() {
    return projectTypeName;
  }

  public void setProjectTypeName(String projectTypeName) {
    this.projectTypeName = projectTypeName;
  }

  public String getSendDocTypeName() {
    return sendDocTypeName;
  }

  public void setSendDocTypeName(String sendDocTypeName) {
    this.sendDocTypeName = sendDocTypeName;
  }

  public String getClearAccCode() {
    return clearAccCode;
  }

  public void setClearAccCode(String clearAccCode) {
    this.clearAccCode = clearAccCode;
  }

  public String getClearAccName() {
    return clearAccName;
  }

  public void setClearAccName(String clearAccName) {
    this.clearAccName = clearAccName;
  }

  public String getClearAccNo() {
    return clearAccNo;
  }

  public void setClearAccNo(String clearAccNo) {
    this.clearAccNo = clearAccNo;
  }

  public String getClearBankCode() {
    return clearBankCode;
  }

  public void setClearBankCode(String clearBankCode) {
    this.clearBankCode = clearBankCode;
  }

  public String getClearBankName() {
    return clearBankName;
  }

  public void setClearBankName(String clearBankName) {
    this.clearBankName = clearBankName;
  }

  public String getClearBankNo() {
    return clearBankNo;
  }

  public void setClearBankNo(String clearBankNo) {
    this.clearBankNo = clearBankNo;
  }

  public String getPayAccCode() {
    return payAccCode;
  }

  public void setPayAccCode(String payAccCode) {
    this.payAccCode = payAccCode;
  }

  public String getPayAccName() {
    return payAccName;
  }

  public void setPayAccName(String payAccName) {
    this.payAccName = payAccName;
  }

  public String getPayBankAccCode() {
    return payBankAccCode;
  }

  public void setPayBankAccCode(String payBankAccCode) {
    this.payBankAccCode = payBankAccCode;
  }

  public String getPayBankCode() {
    return payBankCode;
  }

  public void setPayBankCode(String payBankCode) {
    this.payBankCode = payBankCode;
  }

  public String getPayBankName() {
    return payBankName;
  }

  public void setPayBankName(String payBankName) {
    this.payBankName = payBankName;
  }

  public String getPayBankNo() {
    return payBankNo;
  }

  public void setPayBankNo(String payBankNo) {
    this.payBankNo = payBankNo;
  }

  public String getPayBankNodeCode() {
    return payBankNodeCode;
  }

  public void setPayBankNodeCode(String payBankNodeCode) {
    this.payBankNodeCode = payBankNodeCode;
  }

  public String getPayBankNodeName() {
    return payBankNodeName;
  }

  public void setPayBankNodeName(String payBankNodeName) {
    this.payBankNodeName = payBankNodeName;
  }

  public String getPayCode() {
    return payCode;
  }

  public void setPayCode(String payCode) {
    this.payCode = payCode;
  }

  public String getPayName() {
    return payName;
  }

  public void setPayName(String payName) {
    this.payName = payName;
  }

  public String getPayAccNo() {
    return payAccNo;
  }

  public void setPayAccNo(String payAccNo) {
    this.payAccNo = payAccNo;
  }

  public String getReceAccCode() {
    return receAccCode;
  }

  public void setReceAccCode(String receAccCode) {
    this.receAccCode = receAccCode;
  }

  public String getReceAccName() {
    return receAccName;
  }

  public void setReceAccName(String receAccName) {
    this.receAccName = receAccName;
  }

  public String getReceAccNo() {
    return receAccNo;
  }

  public void setReceAccNo(String receAccNo) {
    this.receAccNo = receAccNo;
  }

  public String getReceBankAccCode() {
    return receBankAccCode;
  }

  public void setReceBankAccCode(String receBankAccCode) {
    this.receBankAccCode = receBankAccCode;
  }

  public String getReceBankCode() {
    return receBankCode;
  }

  public void setReceBankCode(String receBankCode) {
    this.receBankCode = receBankCode;
  }

  public String getReceBankName() {
    return receBankName;
  }

  public void setReceBankName(String receBankName) {
    this.receBankName = receBankName;
  }

  public String getReceBankNo() {
    return receBankNo;
  }

  public void setReceBankNo(String receBankNo) {
    this.receBankNo = receBankNo;
  }

  public String getReceBankNodeCode() {
    return receBankNodeCode;
  }

  public void setReceBankNodeCode(String receBankNodeCode) {
    this.receBankNodeCode = receBankNodeCode;
  }

  public String getReceBankNodeName() {
    return receBankNodeName;
  }

  public void setReceBankNodeName(String receBankNodeName) {
    this.receBankNodeName = receBankNodeName;
  }

  public String getReceCode() {
    return receCode;
  }

  public void setReceCode(String receCode) {
    this.receCode = receCode;
  }

  public String getReceName() {
    return receName;
  }

  public void setReceName(String receName) {
    this.receName = receName;
  }

  public String getReceBankRemark() {
    return receBankRemark;
  }

  public void setReceBankRemark(String receBankRemark) {
    this.receBankRemark = receBankRemark;
  }

  public String getAuditorId() {
    return auditorId;
  }

  public void setAuditorId(String auditorId) {
    this.auditorId = auditorId;
  }

  public String getAuditorName() {
    return auditorName;
  }

  public void setAuditorName(String auditorName) {
    this.auditorName = auditorName;
  }

  public String getInputorId() {
    return inputorId;
  }

  public void setInputorId(String inputorId) {
    this.inputorId = inputorId;
  }

  public String getInputorName() {
    return inputorName;
  }

  public void setInputorName(String inputorName) {
    this.inputorName = inputorName;
  }

  public String getDbDigest() {
    return dbDigest;
  }

  public void setDbDigest(String dbDigest) {
    this.dbDigest = dbDigest;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String toXml() {
    StringBuffer sb = new StringBuffer();
    sb.append(" <FIELD ");
    sb.append("BILL_ID=\"").append(this.id == null ? "" : this.id).append("\" ");
    sb.append("B_ACC_CODE=\"").append(this.baccCode == null ? "" : this.baccCode).append("\" ");
    sb.append("CUR_MONEY=\"").append(curMoney == null ? new BigDecimal("0") : curMoney).append("\" ");
    sb.append("FUND_CODE=\"").append(this.fundCode == null ? "" : this.fundCode).append("\" ");
    sb.append("MANAGE_CODE=\"").append(this.manageCode == null ? "" : this.manageCode).append("\" ");
    sb.append("ORG_CODE=\"").append(this.orgCode == null ? "" : this.orgCode).append("\" ");
    sb.append("ORIGIN_CODE=\"").append(this.originCode == null ? "" : this.originCode).append("\" ");
    sb.append("OUTLAY_CODE=\"").append(this.outlayCode == null ? "" : this.outlayCode).append("\" ");
    sb.append("PAYOUT_CODE=\"").append(this.payoutCode == null ? "" : this.payoutCode).append("\" ");
    sb.append("PAYTYPE_CODE=\"").append(this.paytypeCode == null ? "" : this.paytypeCode).append("\" ");
    sb.append("PROJECT_CODE=\"").append(this.projectCode == null ? "" : this.projectCode).append("\" ");
    sb.append("PROCESS_INST_ID=\"").append(processInstId == null ? Long.valueOf("0") : processInstId).append("\" ");
    sb.append("CONTRACT_CODE=\"").append(this.contractCode == null ? "" : this.contractCode).append("\" ");
    sb.append("D_ATTR1=\"").append(this.dattr1 == null ? "" : this.dattr1).append("\" ");
    sb.append("D_ATTR2=\"").append(this.dattr2 == null ? "" : this.dattr2).append("\" ");
    sb.append("D_ATTR3=\"").append(this.dattr3 == null ? "" : this.dattr3).append("\" ");
    sb.append("D_ATTR4=\"").append(this.dattr4 == null ? "" : this.dattr4).append("\" ");
    sb.append("D_ATTR5=\"").append(this.dattr5 == null ? "" : this.dattr5).append("\" ");
    sb.append("/>\n");
    return sb.toString();
  }

  public BigDecimal getSumMoney() {
    return sumMoney;
  }

  public void setSumMoney(BigDecimal sumMoney) {
    this.sumMoney = sumMoney;
  }

  public BigDecimal getSumMoney1() {
    return sumMoney1;
  }

  public void setSumMoney1(BigDecimal sumMoney1) {
    this.sumMoney1 = sumMoney1;
  }

  public BigDecimal getSumMoney2() {
    return sumMoney2;
  }

  public void setSumMoney2(BigDecimal sumMoney2) {
    this.sumMoney2 = sumMoney2;
  }

  public BigDecimal getSumMoney3() {
    return sumMoney3;
  }

  public void setSumMoney3(BigDecimal sumMoney3) {
    this.sumMoney3 = sumMoney3;
  }
}
