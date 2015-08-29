package com.ufgov.gk.common.system.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ufgov.gk.common.system.util.DateUtil;

public class ElementConditionDto implements Serializable {

  private static final long serialVersionUID = -3681316792427010040L;

  private int nd;

  private String numLimitStr;// 数值权限字符串；

  private String dpBalanceViewName;

  private int month;

  private int startMonth;

  private int endMonth;

  private String coCode;

  private Date tradeDate;

  private BigDecimal tradeMoney = new BigDecimal(0);

  private String coCodeFilter;

  private String tableName;

  private String coTypeCode;

  private String orderCompoId;

  private String baccCode;

  private String fundCode;

  private String fundCode2;

  private String fundName;

  private String inceptDocCode;

  private String manageCode;

  private String orgCode;

  private BigDecimal orgMoney;

  private String orgMoneyOperator;

  private String orgTradeMoneyOperator;

  private String originCode;

  private String outlayCode;

  private String payoutCode;

  private String paytypeCode;

  private String projectTypeCode;

  private String projectCode;

  private String sendDocTypeCode;

  private String sendDocCode;

  private String pmAdjustCode;

  private List pmAdjustCodeList = new ArrayList();

  private String operationTypeCode;

  private String transDate;

  private String status;

  private String executor;

  private String wfcompoId;

  private String numLimCompoId;

  private String bankCode;

  private String banknodeCode;

  private String bankAccCode;

  private Date bankDate;

  private String billType;

  private String isCreateVou;

  private String isGenBalance;

  private String isSum;

  private Integer printTimes;

  private String pmType;

  private int season;

  private String dataRuleId; // 取数规则

  private String dataRuleCondiStr; // 取数规则对应的条件语句

  private String dpBalanceMonthView;

  private String controlType;

  private String biBalanceId;

  private String dpBalanceId;

  private String orderColumns;

  private String dealState;

  private String dattrType;

  private String compoId;

  private String adjustCode;// 调整类型

  private String astatusCode;//单据状态

  private String flowCode;

  private String biIncomeType;

  private String isCarryDown;

  private String cdType;

  private String createTzdType;

  private int planMonth;

  private String isNeedWorkFlow;//是否走工作流

  private String isBiControl;

  private String cpApplyId;

  private String biLevel;

  private String fundAttribute;//新疆：资金属性

  private String kind;//新疆：类别

  private String cpVouNo;

  protected BigDecimal curMoney = new BigDecimal("0");

  private String dattr1;

  private String dattr2;

  private String dattr3;

  private String dattr4;

  private String dattr5;

  private String balModeCode;

  private String content;

  private Integer exportTimes;

  private String useType;

  private String cpBalDayVouState = "1";//支出日报时间标志

  private String clearBankCode;

  private String payBankCode;

  private String sumCpVoucherId;

  private String balanceStatus;

  private String cpAdjustCode;

  private String todoAddDateFilter;

  private Date payDate;

  private String groupFieldStr;//分组条件对应的sql

  private String groupConditionStr;

  private String procedureName;//oracle的存储过程名称

  private String extField1;

  private String extField2;

  private String extField3;

  private String extField4;

  private String extField5;

  private String extField6;

  private String extField7;

  private String extField8;

  private String extField9;

  private String extField10;

  private String inputGroupId;

  private String receBankCode;

  private String bankStatus;

  private String yesNoAll;

  private String biAdjustCode;

  private Date clearDate;

  private String empCoCode;

  private String anStatus;

  private Integer exportTipsTimes;

  private String grantedExecutor;

  private String posiId;

  private String posiCode;

  private String zcMakeStatus;

  private String zcMakeCode;

  private String billStatus;

  private Date startDate;

  private Date bankStartDate;

  private Date bankEndDate;

  private Date payStartDate;

  private Date payEndDate;

  private String zcText0;

  private String zcText1;

  private String zcText2;

  private String zcText3;

  private String zcText4;

  private String packCode;

  private String projCode;

  private String bulletinMoldType;

  private String projectType;

  private String transType;

  /**
   * 计划编号
   */
  private String planNo;

  /**
   * 品目代码
   */
  private String catalogueCode;

  /**
   * 品牌代码
   */
  private String brandCode;

  private String pnTime;

  private String type;

  public String getBulletinMoldType() {
    return bulletinMoldType;
  }

  public void setBulletinMoldType(String bulletinMoldType) {
    this.bulletinMoldType = bulletinMoldType;
  }

  /**
   * @return the zcMakeStatus
   */
  public String getZcMakeStatus() {
    return zcMakeStatus;
  }

  /**
   * @param zcMakeStatus the zcMakeStatus to set
   */
  public void setZcMakeStatus(String zcMakeStatus) {
    this.zcMakeStatus = zcMakeStatus;
  }

  public String getPosiId() {
    return posiId;
  }

  public void setPosiId(String posiId) {
    this.posiId = posiId;
  }

  public String getPosiCode() {
    return posiCode;
  }

  public void setPosiCode(String posiCode) {
    this.posiCode = posiCode;
  }

  public String getGrantedExecutor() {
    return grantedExecutor;
  }

  public void setGrantedExecutor(String grantedExecutor) {
    this.grantedExecutor = grantedExecutor;
  }

  public String getYesNoAll() {
    return yesNoAll;
  }

  public void setYesNoAll(String yesNoAll) {
    this.yesNoAll = yesNoAll;
  }

  public String getEmpCoCode() {
    return empCoCode;
  }

  public void setEmpCoCode(String empCoCode) {
    this.empCoCode = empCoCode;
  }

  public String getProcedureName() {
    return procedureName;
  }

  public void setProcedureName(String procedureName) {
    this.procedureName = procedureName;
  }

  public String getExtField3() {
    return extField3;
  }

  public void setExtField3(String extField3) {
    this.extField3 = extField3;
  }

  public String getExtField10() {
    return extField10;
  }

  public void setExtField10(String extField10) {
    this.extField10 = extField10;
  }

  public String getExtField7() {
    return extField7;
  }

  public void setExtField7(String extField7) {
    this.extField7 = extField7;
  }

  public String getExtField8() {
    return extField8;
  }

  public void setExtField8(String extField8) {
    this.extField8 = extField8;
  }

  public String getExtField9() {
    return extField9;
  }

  public void setExtField9(String extField9) {
    this.extField9 = extField9;
  }

  public String getInputGroupId() {
    return inputGroupId;
  }

  public void setInputGroupId(String inputGroupId) {
    this.inputGroupId = inputGroupId;
  }

  public String getExtField1() {
    return extField1;
  }

  public void setExtField1(String extField1) {
    this.extField1 = extField1;
  }

  public String getExtField6() {
    return extField6;
  }

  public void setExtField6(String extField6) {
    this.extField6 = extField6;
  }

  public String getExtField2() {
    return extField2;
  }

  public void setExtField2(String extField2) {
    this.extField2 = extField2;
  }

  public String getCpAdjustCode() {
    return cpAdjustCode;
  }

  public void setCpAdjustCode(String cpAdjustCode) {
    this.cpAdjustCode = cpAdjustCode;
  }

  public String getBalanceStatus() {
    return balanceStatus;
  }

  public void setBalanceStatus(String balanceStatus) {
    this.balanceStatus = balanceStatus;
  }

  public String getSumCpVoucherId() {
    return sumCpVoucherId;
  }

  public void setSumCpVoucherId(String sumCpVoucherId) {
    this.sumCpVoucherId = sumCpVoucherId;
  }

  public String getPayBankCode() {
    return payBankCode;
  }

  public void setPayBankCode(String payBankCode) {
    this.payBankCode = payBankCode;
  }

  public String getCpBalDayVouState() {
    return cpBalDayVouState;
  }

  public void setCpBalDayVouState(String cpBalDayVouState) {
    this.cpBalDayVouState = cpBalDayVouState;
  }

  //银行类别,取银行网点代码前三位
  //如102 工行，105 建行
  private String bankType;

  /**
   * @return the biLevel
   */
  public String getBiLevel() {
    return biLevel;
  }

  /**
   * @param biLevel the biLevel to set
   */
  public void setBiLevel(String biLevel) {
    this.biLevel = biLevel;
  }

  public String getIsBiControl() {
    return isBiControl;
  }

  public void setIsBiControl(String isBiControl) {
    this.isBiControl = isBiControl;
  }

  public String getIsNeedWorkFlow() {
    return isNeedWorkFlow;
  }

  public void setIsNeedWorkFlow(String isNeedWorkFlow) {
    this.isNeedWorkFlow = isNeedWorkFlow;
  }

  public String getCreateTzdType() {
    return createTzdType;
  }

  public void setCreateTzdType(String createTzdType) {
    this.createTzdType = createTzdType;
  }

  public String getCdType() {
    return cdType;
  }

  public void setCdType(String cdType) {
    this.cdType = cdType;
  }

  /**
   * @return the astatusCode
   */
  public String getAstatusCode() {
    return astatusCode;
  }

  /**
   * @param astatusCode the astatusCode to set
   */
  public void setAstatusCode(String astatusCode) {
    this.astatusCode = astatusCode;
  }

  public String getCompoId() {
    return compoId;
  }

  public void setCompoId(String compoId) {
    this.compoId = compoId;
  }

  public String getDattrType() {
    return dattrType;
  }

  public void setDattrType(String dattrType) {
    this.dattrType = dattrType;
  }

  public String getDealState() {
    return dealState;
  }

  public void setDealState(String dealState) {
    this.dealState = dealState;
  }

  public String getOrderColumns() {
    return orderColumns;
  }

  public void setOrderColumns(String orderColumns) {
    this.orderColumns = orderColumns;
  }

  public String getBiBalanceId() {
    return biBalanceId;
  }

  public void setBiBalanceId(String biBalanceId) {
    this.biBalanceId = biBalanceId;
  }

  public String getDpBalanceId() {
    return dpBalanceId;
  }

  public void setDpBalanceId(String dpBalanceId) {
    this.dpBalanceId = dpBalanceId;
  }

  public String getDpBalanceMonthView() {
    return dpBalanceMonthView;
  }

  public void setDpBalanceMonthView(String dpBalanceMonthView) {
    this.dpBalanceMonthView = dpBalanceMonthView;
  }

  public int getSeason() {
    return season;
  }

  public void setSeason(int season) {
    this.season = season;
  }

  public String getBalModeCode() {
    return balModeCode;
  }

  public void setBalModeCode(String balModeCode) {
    this.balModeCode = balModeCode;
  }

  public String getPmType() {
    return pmType;
  }

  public void setPmType(String pmType) {
    this.pmType = pmType;
  }

  public Integer getPrintTimes() {
    return printTimes;
  }

  public void setPrintTimes(Integer printTimes) {
    this.printTimes = printTimes;
  }

  public String getBillType() {
    return billType;
  }

  public void setBillType(String billType) {
    this.billType = billType;
  }

  public String getBankCode() {
    return bankCode;
  }

  public void setBankCode(String bankCode) {
    this.bankCode = bankCode;
  }

  public String getBanknodeCode() {
    return banknodeCode;
  }

  public void setBanknodeCode(String banknodeCode) {
    this.banknodeCode = banknodeCode;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getExecutor() {
    return executor;
  }

  public void setExecutor(String executor) {
    this.executor = executor;
  }

  public String getWfcompoId() {
    return wfcompoId;
  }

  public void setWfcompoId(String wfcompoId) {
    this.wfcompoId = wfcompoId;
  }

  public String getPackCode() {
    return packCode;
  }

  public void setPackCode(String packCode) {
    this.packCode = packCode;
  }

  public String getZcText0() {
    return zcText0;
  }

  public void setZcText0(String zcText0) {
    this.zcText0 = zcText0;
  }

  public String getZcText1() {
    return zcText1;
  }

  public void setZcText1(String zcText1) {
    this.zcText1 = zcText1;
  }

  public String getZcText2() {
    return zcText2;
  }

  public void setZcText2(String zcText2) {
    this.zcText2 = zcText2;
  }

  public String getZcText3() {
    return zcText3;
  }

  public void setZcText3(String zcText3) {
    this.zcText3 = zcText3;
  }

  public String getZcText4() {
    return zcText4;
  }

  public void setZcText4(String zcText4) {
    this.zcText4 = zcText4;
  }

  public Date getStartDate() {
    //    try {
    //      String dateStr = DateUtil.dateToDdString(startDate);
    //      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    //      return format.parse(dateStr);
    //    } catch (Exception ex) {
    //      return startDate;
    //    }
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    //    try {
    //      String dateStr = DateUtil.dateToDdString(endDate);
    //      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    //      return format.parse(dateStr);
    //    } catch (Exception ex) {
    //      return endDate;
    //    }
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  private Date endDate;

  public int getNd() {
    return nd;
  }

  public void setNd(int nd) {
    this.nd = nd;
  }

  public int getMonth() {
    return month;
  }

  public void setMonth(int month) {
    this.month = month;
  }

  public String getCoCode() {
    return coCode;
  }

  public void setCoCode(String coCode) {
    this.coCode = coCode;
  }

  public String getBaccCode() {
    return baccCode;
  }

  public void setBaccCode(String baccCode) {
    this.baccCode = baccCode;
  }

  public String getFundCode() {
    return fundCode;
  }

  public void setFundCode(String fundCode) {
    this.fundCode = fundCode;
  }

  public String getInceptDocCode() {
    return inceptDocCode;

  }

  public void setInceptDocCode(String inceptDocCode) {
    this.inceptDocCode = inceptDocCode;
  }

  public String getManageCode() {
    return manageCode;
  }

  public void setManageCode(String manageCode) {
    this.manageCode = manageCode;
  }

  public String getOrgCode() {
    return orgCode;
  }

  public void setOrgCode(String orgCode) {
    this.orgCode = orgCode;
  }

  public String getOriginCode() {
    return originCode;
  }

  public void setOriginCode(String originCode) {
    this.originCode = originCode;
  }

  public String getOutlayCode() {
    return outlayCode;
  }

  public void setOutlayCode(String outlayCode) {
    this.outlayCode = outlayCode;
  }

  public String getPayoutCode() {
    return payoutCode;
  }

  public void setPayoutCode(String payoutCode) {
    this.payoutCode = payoutCode;
  }

  public String getPaytypeCode() {
    return paytypeCode;
  }

  public void setPaytypeCode(String paytypeCode) {
    this.paytypeCode = paytypeCode;
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

  public String getPmAdjustCode() {
    return pmAdjustCode;
  }

  public void setPmAdjustCode(String pmAdjustCode) {
    this.pmAdjustCode = pmAdjustCode;
  }

  public String getTransDate() {
    return transDate;
  }

  public void setTransDate(String transDate) {
    this.transDate = transDate;
  }

  public String getOperationTypeCode() {
    return operationTypeCode;
  }

  public void setOperationTypeCode(String operationTypeCode) {
    this.operationTypeCode = operationTypeCode;
  }

  public String getDpBalanceViewName() {
    return dpBalanceViewName;
  }

  public void setDpBalanceViewName(String dpBalanceViewName) {
    this.dpBalanceViewName = dpBalanceViewName;
  }

  public List getPmAdjustCodeList() {
    return pmAdjustCodeList;
  }

  public void setPmAdjustCodeList(List pmAdjustCodeList) {
    this.pmAdjustCodeList = pmAdjustCodeList;
  }

  public String getCoTypeCode() {
    return coTypeCode;
  }

  public void setCoTypeCode(String coTypeCode) {
    this.coTypeCode = coTypeCode;
  }

  public String getNumLimCompoId() {
    return numLimCompoId;
  }

  public void setNumLimCompoId(String numLimCompoId) {
    this.numLimCompoId = numLimCompoId;
  }

  public String getIsCreateVou() {
    return isCreateVou;
  }

  public void setIsCreateVou(String isCreateVou) {
    this.isCreateVou = isCreateVou;
  }

  public String getBankAccCode() {
    return bankAccCode;
  }

  public void setBankAccCode(String bankAccCode) {
    this.bankAccCode = bankAccCode;
  }

  public String getCoCodeFilter() {
    return coCodeFilter;
  }

  public void setCoCodeFilter(String coCodeFilter) {
    this.coCodeFilter = coCodeFilter;
  }

  public String getNumLimitStr() {
    return numLimitStr;
  }

  public void setNumLimitStr(String numLimitStr) {
    this.numLimitStr = numLimitStr;
  }

  public int getStartMonth() {
    return startMonth;
  }

  public void setStartMonth(int startMonth) {
    this.startMonth = startMonth;
  }

  public int getEndMonth() {
    return endMonth;
  }

  public void setEndMonth(int endMonth) {
    this.endMonth = endMonth;
  }

  public String getDataRuleId() {
    return dataRuleId;
  }

  public void setDataRuleId(String dataRuleId) {
    this.dataRuleId = dataRuleId;
  }

  public String getDataRuleCondiStr() {
    return dataRuleCondiStr;
  }

  public void setDataRuleCondiStr(String dataRuleCondiStr) {
    this.dataRuleCondiStr = dataRuleCondiStr;
  }

  public String getIsSum() {
    return isSum;
  }

  public void setIsSum(String isSum) {
    this.isSum = isSum;
  }

  public String getControlType() {
    return controlType;
  }

  public void setControlType(String controlType) {
    this.controlType = controlType;
  }

  public String getTableName() {
    return tableName;
  }

  public void setTableName(String tableName) {
    this.tableName = tableName;
  }

  /**
   * @return the adjustCode
   */
  public String getAdjustCode() {
    return adjustCode;
  }

  public String getSingleAdjustCode() {
    String temp = adjustCode.split(",")[0];
    temp = temp.substring(1, temp.length() - 1);
    if (Integer.parseInt(temp) < 200) {
      temp = "100";
    } else {
      temp = "200";
    }
    return temp;
  }

  /**
   * @param adjustCode
   *            the adjustCode to set
   */
  public void setAdjustCode(String adjustCode) {
    this.adjustCode = adjustCode;
  }

  public String getFlowCode() {
    return flowCode;
  }

  public void setFlowCode(String flowCode) {
    this.flowCode = flowCode;
  }

  public String getBiIncomeType() {
    return biIncomeType;
  }

  public void setBiIncomeType(String biIncomeType) {
    this.biIncomeType = biIncomeType;
  }

  public String getIsCarryDown() {
    return isCarryDown;
  }

  public void setIsCarryDown(String isCarryDown) {
    this.isCarryDown = isCarryDown;
  }

  public int getPlanMonth() {
    return planMonth;
  }

  public void setPlanMonth(int planMonth) {
    this.planMonth = planMonth;
  }

  public String getFundName() {
    return fundName;
  }

  public void setFundName(String fundName) {
    this.fundName = fundName;
  }

  public String getCpApplyId() {
    return cpApplyId;
  }

  public void setCpApplyId(String cpApplyId) {
    this.cpApplyId = cpApplyId;
  }

  public String getOrderCompoId() {
    return orderCompoId;
  }

  public void setOrderCompoId(String orderCompoId) {
    this.orderCompoId = orderCompoId;
  }

  public String getFundAttribute() {
    return fundAttribute;
  }

  public void setFundAttribute(String fundAttribute) {
    this.fundAttribute = fundAttribute;
  }

  public String getKind() {
    return kind;
  }

  public void setKind(String kind) {
    this.kind = kind;
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

  public String getCpVouNo() {
    return cpVouNo;
  }

  public void setCpVouNo(String cpVouNo) {
    this.cpVouNo = cpVouNo;
  }

  public BigDecimal getCurMoney() {
    return curMoney;
  }

  public void setCurMoney(BigDecimal curMoney) {
    this.curMoney = curMoney;
  }

  public String getBankType() {
    return bankType;
  }

  public void setBankType(String bankType) {
    this.bankType = bankType;
  }

  public Integer getExportTimes() {
    return exportTimes;
  }

  public void setExportTimes(Integer exportTimes) {
    this.exportTimes = exportTimes;
  }

  public String getUseType() {
    return useType;
  }

  public void setUseType(String useType) {
    this.useType = useType;
  }

  public String getFundCode2() {
    return fundCode2;
  }

  public void setFundCode2(String fundCode2) {
    this.fundCode2 = fundCode2;
  }

  public String getClearBankCode() {
    return clearBankCode;
  }

  public void setClearBankCode(String clearBankCode) {
    this.clearBankCode = clearBankCode;
  }

  public String getIsGenBalance() {
    return isGenBalance;
  }

  public void setIsGenBalance(String isGenBalance) {
    this.isGenBalance = isGenBalance;
  }

  public BigDecimal getOrgMoney() {
    return orgMoney;
  }

  public void setOrgMoney(BigDecimal orgMoney) {
    this.orgMoney = orgMoney;
  }

  public String getOrgMoneyOperator() {
    return orgMoneyOperator;
  }

  public void setOrgMoneyOperator(String orgMoneyOperator) {
    this.orgMoneyOperator = orgMoneyOperator;
  }

  public String getGroupFieldStr() {
    return groupFieldStr;
  }

  public void setGroupFieldStr(String groupFieldStr) {
    this.groupFieldStr = groupFieldStr;
  }

  public String getGroupConditionStr() {
    return groupConditionStr;
  }

  public void setGroupConditionStr(String groupConditionStr) {
    this.groupConditionStr = groupConditionStr;
  }

  public String getTodoAddDateFilter() {
    return todoAddDateFilter;
  }

  public void setTodoAddDateFilter(String todoAddDateFilter) {
    this.todoAddDateFilter = todoAddDateFilter;
  }

  public Date getPayDate() {
    return payDate;
  }

  public void setPayDate(Date payDate) {
    this.payDate = payDate;
  }

  public Date getBankDate() {
    return bankDate;
  }

  public void setBankDate(Date bankDate) {
    this.bankDate = bankDate;
  }

  public String getExtField4() {
    return extField4;
  }

  public void setExtField4(String extField4) {
    this.extField4 = extField4;
  }

  public String getExtField5() {
    return extField5;
  }

  public void setExtField5(String extField5) {
    this.extField5 = extField5;
  }

  public String getBiAdjustCode() {
    return biAdjustCode;
  }

  public void setBiAdjustCode(String biAdjustCode) {
    this.biAdjustCode = biAdjustCode;
  }

  public String getReceBankCode() {
    return receBankCode;
  }

  public void setReceBankCode(String receBankCode) {
    this.receBankCode = receBankCode;
  }

  public Date getTradeDate() {
    return tradeDate;
  }

  public void setTradeDate(Date tradeDate) {
    this.tradeDate = tradeDate;
  }

  public BigDecimal getTradeMoney() {
    return tradeMoney;
  }

  public void setTradeMoney(BigDecimal tradeMoney) {
    this.tradeMoney = tradeMoney;
  }

  public String getBankStatus() {
    return bankStatus;
  }

  public void setBankStatus(String bankStatus) {
    this.bankStatus = bankStatus;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Date getBankStartDate() {
    return bankStartDate;
  }

  public void setBankStartDate(Date bankStartDate) {
    this.bankStartDate = bankStartDate;
  }

  public Date getBankEndDate() {
    return bankEndDate;
  }

  public void setBankEndDate(Date bankEndDate) {
    this.bankEndDate = bankEndDate;
  }

  public Date getPayStartDate() {
    return payStartDate;
  }

  public void setPayStartDate(Date payStartDate) {
    this.payStartDate = payStartDate;
  }

  public Date getPayEndDate() {
    return payEndDate;
  }

  public void setPayEndDate(Date payEndDate) {
    this.payEndDate = payEndDate;
  }

  public String getOrgTradeMoneyOperator() {
    return orgTradeMoneyOperator;
  }

  public void setOrgTradeMoneyOperator(String orgTradeMoneyOperator) {
    this.orgTradeMoneyOperator = orgTradeMoneyOperator;
  }

  public Date getClearDate() {
    return clearDate;
  }

  public void setClearDate(Date clearDate) {
    this.clearDate = clearDate;
  }

  public String getAnStatus() {
    return anStatus;
  }

  public void setAnStatus(String anStatus) {
    this.anStatus = anStatus;
  }

  public Integer getExportTipsTimes() {
    return exportTipsTimes;
  }

  public void setExportTipsTimes(Integer exportTipsTimes) {
    this.exportTipsTimes = exportTipsTimes;
  }

  public static void main(String[] args) throws ParseException {
    Date d = new Date();
    String dateStr = DateUtil.dateToDdString(d);
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    d = format.parse(dateStr);
    System.out.println(d);
  }

  /**
  * @Description: TODO(这里用一句话描述这个方法的作用)
  * @return void 返回类型
  * @since 1.0
  */
  public void setBillStatus(String billStatus) {
    this.billStatus = billStatus;
  }

  /**
   * @return the billStatus
   */
  public String getBillStatus() {
    return billStatus;
  }

  public void setProjCode(String projCode) {
    this.projCode = projCode;
  }

  public String getProjCode() {
    return projCode;
  }

  public String getCatalogueCode() {
    return catalogueCode;
  }

  public void setCatalogueCode(String catalogueCode) {
    this.catalogueCode = catalogueCode;
  }

  public String getBrandCode() {
    return brandCode;
  }

  public void setBrandCode(String brandCode) {
    this.brandCode = brandCode;
  }

  public String getPlanNo() {
    return planNo;
  }

  public void setPlanNo(String planNo) {
    this.planNo = planNo;
  }

  public void setZcMakeCode(String zcMakeCode) {
    this.zcMakeCode = zcMakeCode;
  }

  public String getZcMakeCode() {
    return zcMakeCode;
  }

  public String getProjectType() {
    return projectType;
  }

  public void setProjectType(String projectType) {
    this.projectType = projectType;
  }

  public String getTransType() {
    return transType;
  }

  public void setTransType(String transType) {
    this.transType = transType;
  }

  public String getPnTime() {
    return pnTime;
  }

  public void setPnTime(String pnTime) {
    this.pnTime = pnTime;
  }

  /**
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * @param type the type to set
   */
  public void setType(String type) {
    this.type = type;
  }

public void setZcFukuanType(String zcFukuanType) {
	// TODO Auto-generated method stub
	
}
}
