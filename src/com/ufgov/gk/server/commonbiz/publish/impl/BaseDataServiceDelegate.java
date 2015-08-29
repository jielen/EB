package com.ufgov.gk.server.commonbiz.publish.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.kingdrive.workflow.model.runtime.TraceInfoModel;
import com.ufgov.gk.common.commonbiz.model.BaseBill;
import com.ufgov.gk.common.commonbiz.model.BillElement;
import com.ufgov.gk.common.commonbiz.model.Company;
import com.ufgov.gk.common.commonbiz.model.MaElementRelationRule;
import com.ufgov.gk.common.commonbiz.model.MaElementRelationRuleEntry;
import com.ufgov.gk.common.commonbiz.model.MaExpSerial;
import com.ufgov.gk.common.commonbiz.model.MaTzdSumElement;
import com.ufgov.gk.common.commonbiz.model.NumLimCompo;
import com.ufgov.gk.common.commonbiz.model.SendDoc;
import com.ufgov.gk.common.commonbiz.model.WfTaskGranter;
import com.ufgov.gk.common.commonbiz.publish.IBaseDataServiceDelegate;
import com.ufgov.gk.common.console.model.AsEmp;
import com.ufgov.gk.common.console.model.GkGetdataRule;
import com.ufgov.gk.common.ebay.model.AppMenuItem;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.dto.ElementConditionDto;
import com.ufgov.gk.common.system.dto.PrintObject;
import com.ufgov.gk.common.system.dto.UserFuncDto;
import com.ufgov.gk.common.system.model.AsCompo;
import com.ufgov.gk.common.system.model.AsFile;
import com.ufgov.gk.common.system.model.AsOption;
import com.ufgov.gk.common.system.model.GkBusinessLog;
import com.ufgov.gk.common.system.model.PrintSetting;
import com.ufgov.gk.common.system.model.ResultInfo;
import com.ufgov.gk.common.system.model.User;
import com.ufgov.gk.common.system.model.UserPreferences;
import com.ufgov.gk.common.system.model.UserSearchStore;
import com.ufgov.gk.server.commonbiz.service.IBillElementService;
import com.ufgov.gk.server.commonbiz.service.ICompanyService;
import com.ufgov.gk.server.commonbiz.service.IContractService;
import com.ufgov.gk.server.commonbiz.service.IGkWorkflowService;
import com.ufgov.gk.server.commonbiz.service.IInceptDocService;
import com.ufgov.gk.server.commonbiz.service.IMaCpElementMappingService;
import com.ufgov.gk.server.commonbiz.service.IMaElementRelationRuleService;
import com.ufgov.gk.server.commonbiz.service.IMaSearchStoreService;
import com.ufgov.gk.server.commonbiz.service.IMaTzdSumElementService;
import com.ufgov.gk.server.commonbiz.service.IMacpRuleDetailService;
import com.ufgov.gk.server.commonbiz.service.IManageService;
import com.ufgov.gk.server.commonbiz.service.INumLimCompoService;
import com.ufgov.gk.server.commonbiz.service.IOperationTypeService;
import com.ufgov.gk.server.commonbiz.service.IOrgService;
import com.ufgov.gk.server.commonbiz.service.IOriginService;
import com.ufgov.gk.server.commonbiz.service.IOutlayService;
import com.ufgov.gk.server.commonbiz.service.IPrintService;
import com.ufgov.gk.server.commonbiz.service.ISearchConditionService;
import com.ufgov.gk.server.commonbiz.service.ISendDocService;
import com.ufgov.gk.server.commonbiz.service.ISendDocTypeService;
import com.ufgov.gk.server.commonbiz.service.IWfTaskGranterService;
import com.ufgov.gk.server.console.service.IAsEmpService;
import com.ufgov.gk.server.console.service.IAsRoleNumLimService;
import com.ufgov.gk.server.console.service.IAsUserNumLimService;
import com.ufgov.gk.server.console.service.IGkGetdataRuleService;
import com.ufgov.gk.server.console.service.IMenuService;
import com.ufgov.gk.server.system.service.IAsCompoFuncService;
import com.ufgov.gk.server.system.service.IAsCompoService;
import com.ufgov.gk.server.system.service.IAsFileService;
import com.ufgov.gk.server.system.service.IAsOptionService;
import com.ufgov.gk.server.system.service.IAsValService;
import com.ufgov.gk.server.system.service.IBankTradeLogService;
import com.ufgov.gk.server.system.service.IForeignEntityServic;
import com.ufgov.gk.server.system.service.IGkBusinessLogService;
import com.ufgov.gk.server.system.service.ILangTransService;
import com.ufgov.gk.server.system.service.IMaExpSerialService;
import com.ufgov.gk.server.system.service.INumService;
import com.ufgov.gk.server.system.service.IUserFuncService;
import com.ufgov.gk.server.system.service.IUserPreferencesService;
import com.ufgov.gk.server.system.service.IUserService;
import com.ufgov.gk.server.system.service.IWorkflowTraceService;

public class BaseDataServiceDelegate implements IBaseDataServiceDelegate {

  IAsOptionService asOptionService;

  public IAsOptionService getAsOptionService() {
    return asOptionService;
  }

  public void setAsOptionService(IAsOptionService asOptionService) {
    this.asOptionService = asOptionService;
  }

  public AsOption getAsOption(String optId, RequestMeta requestMeta) {
    return this.asOptionService.getAsOption(optId);
  }

  public void updateOptionVal(AsOption asOption, RequestMeta requestMeta) {
    this.asOptionService.updateOptionVal(asOption);
  }

  public List getAllAsOptionById(String optId, RequestMeta requestMeta) {
    return this.asOptionService.getAllAsOptionById(optId);
  }

  private IAsValService asValService;

  public IAsValService getAsValService() {
    return asValService;
  }

  public void setAsValService(IAsValService asValService) {
    this.asValService = asValService;
  }

  public List getAsVal(String valSetId, RequestMeta requestMeta) {
    return this.asValService.getAsVal(valSetId);
  }

  public Map getAsValMap(String valSetId, RequestMeta requestMeta) {
    return this.asValService.getAsValMap(valSetId);
  }

  private IBillElementService billElementService;

  public IBillElementService getBillElementService() {
    return billElementService;
  }

  public void setBillElementService(IBillElementService billElementService) {
    this.billElementService = billElementService;
  }

  public Map getBillElement(int nd, String billTypeCode, RequestMeta requestMeta) {
    return billElementService.getBillElement(nd, billTypeCode);
  }

  public Map getWfCanEditField(Long proInstId, RequestMeta requestMeta) {
    return billElementService.getWfCanEditField(proInstId);
  }

  public List getDownDisplayBillElementList(int nd, String billTypeCode, String displayType, RequestMeta requestMeta) {
    return billElementService.getDownDisplayBillElementList(nd, billTypeCode, displayType);
  }

  public void updateBillElementForBbFN(List list, RequestMeta requestMeta) {
    billElementService.updateBillElementForBb(list);
  }

  public void updateIncludeForBillElement(BillElement billElement, RequestMeta requestMeta) {
    billElementService.updateIncludeForBillElement(billElement);
  }

  public void updateBillElementGroupInfo(BillElement billElement, RequestMeta requestMeta) {
    billElementService.updateBillElementGroupInfo(billElement);
  }

  private ICompanyService companyService;

  public ICompanyService getCompanyService() {
    return companyService;
  }

  public void setCompanyService(ICompanyService companyService) {
    this.companyService = companyService;
  }

  public List getCompanyTree(int nd, RequestMeta requestMeta) {
    return companyService.getCompanyTree(nd);
  }

  public List getCompany(ElementConditionDto dto, RequestMeta requestMeta) {
    return companyService.getCompany(dto);
  }

  public List getCompanyByUserId(String userId, int nd, RequestMeta requestMeta) {
    return companyService.getCompanyByUserId(userId, nd);
  }

  public List getCompanyNumLimTree(ElementConditionDto dto, RequestMeta requestMeta) {
    return companyService.getCompanyNumLimTree(dto);
  }

  public Company getCompanyByCoCode(int nd, String coCode, RequestMeta requestMeta) {
    return companyService.getCompanyByCoCode(nd, coCode);
  }

  public List getCompanyChildren(int nd, String coCode, RequestMeta requestMeta) {
    return companyService.getCompanyChildren(nd, coCode);
  }

  private IContractService contractService;

  public IContractService getContractService() {
    return contractService;
  }

  public void setContractService(IContractService contractService) {
    this.contractService = contractService;
  }

  public List getContract(int nd, RequestMeta requestMeta) {
    return contractService.getContract(nd);

  }

  IInceptDocService inceptDocService;

  public IInceptDocService getInceptDocService() {
    return inceptDocService;
  }

  public void setInceptDocService(IInceptDocService inceptDocService) {
    this.inceptDocService = inceptDocService;
  }

  public List getInceptDoc(int nd, RequestMeta requestMeta) {
    return this.inceptDocService.getInceptDoc(nd);
  }

  ILangTransService langTransService;

  public ILangTransService getLangTransService() {
    return langTransService;
  }

  public void setLangTransService(ILangTransService langTransService) {
    this.langTransService = langTransService;
  }

  public Map getLangTrans(String resId, RequestMeta requestMeta) {
    return langTransService.getLangTrans(resId);
  }

  public List getAsLangTrans(String resId, RequestMeta requestMeta) {
    return langTransService.getAsLangTrans(resId);
  }

  public void updateAslangTrans(List langTranList, RequestMeta requestMeta) {
    langTransService.updateAslangTrans(langTranList);
  }

  private IManageService manageService;

  public List getManage(ElementConditionDto dto, RequestMeta requestMeta) {
    return manageService.getManage(dto);
  }

  public List getManageForBiXJ(ElementConditionDto dto, RequestMeta requestMeta) {
    return manageService.getManageForBiXJ(dto);
  }

  public IManageService getManageService() {
    return manageService;
  }

  public void setManageService(IManageService manageService) {
    this.manageService = manageService;
  }

  private INumLimCompoService numLimCompoService;

  public INumLimCompoService getNumLimCompoService() {
    return numLimCompoService;
  }

  public void setNumLimCompoService(INumLimCompoService numLimCompoService) {
    this.numLimCompoService = numLimCompoService;
  }

  public List getNumLimCompo(RequestMeta requestMeta) {
    return numLimCompoService.getNumLimCompo();
  }

  public NumLimCompo getNumLimCompoByCompoId(String compoId, RequestMeta requestMeta) {
    return numLimCompoService.getNumLimCompoByCompoId(compoId);
  }

  public List getNumLimCompoByParentCompoId(String parentCompoId, RequestMeta requestMeta) {
    return numLimCompoService.getNumLimCompoByParentCompoId(parentCompoId);
  }

  private IOperationTypeService operationTypeService;

  public List getOperationType(ElementConditionDto dto, RequestMeta requestMeta) {
    return operationTypeService.getOperationType(dto);
  }

  public IOperationTypeService getOperationTypeService() {
    return operationTypeService;
  }

  public void setOperationTypeService(IOperationTypeService operationTypeService) {
    this.operationTypeService = operationTypeService;
  }

  private IOrgService orgService;

  public List getCzOrg(int nd, RequestMeta requestMeta) {
    return orgService.getCzOrg(nd);
  }

  public List getZcOrg(int nd, RequestMeta requestMeta) {
    return orgService.getZcOrg(nd);
  }

  public IOrgService getOrgService() {
    return orgService;
  }

  public List getOrg(int nd, RequestMeta requestMeta) {
    return orgService.getOrg(nd);
  }

  public List getOrg(ElementConditionDto dto, RequestMeta requestMeta) {
    return orgService.getOrg(dto);
  }

  public List getPosition(int nd, RequestMeta requestMeta) {
    return orgService.getPosition(nd);
  }

  public List getEmp(int nd, RequestMeta requestMeta) {
    return orgService.getEmp(nd);
  }

  public void setOrgService(IOrgService orgService) {
    this.orgService = orgService;
  }

  private IOriginService originService;

  public List getOrigin(ElementConditionDto dto, RequestMeta requestMeta) {
    return originService.getOrigin(dto);
  }

  public IOriginService getOriginService() {
    return originService;
  }

  public void setOriginService(IOriginService originService) {
    this.originService = originService;
  }

  private IOutlayService outlayService;

  public List getOutlay(ElementConditionDto dto, RequestMeta requestMeta) {
    return outlayService.getOutlay(dto);
  }

  public List getOutlayTree(int nd, RequestMeta requestMeta) {
    return outlayService.getOutlayTree(nd);
  }

  public IOutlayService getOutlayService() {
    return outlayService;
  }

  public void setOutlayService(IOutlayService outlayService) {
    this.outlayService = outlayService;
  }

  private ISearchConditionService searchConditionService;

  public void deleteUserSearchCondition(String conditionId, String userId, RequestMeta requestMeta) {
    searchConditionService.deleteUserSearchCondition(conditionId, userId);
  }

  public List getSearchTypeCondition(String conditionId, String conditionType, RequestMeta requestMeta) {
    return searchConditionService.getSearchTypeCondition(conditionId, conditionType);
  }

  public List getSearchCondition(String conditionId, RequestMeta requestMeta) {
    return searchConditionService.getSearchCondition(conditionId);
  }

  public List getRoleSearchCondition(String conditionId, String userId, RequestMeta requestMeta) {
    return searchConditionService.getRoleSearchCondition(conditionId, userId, requestMeta);
  }

  public List getUserSearchCondition(String conditionId, String userId, RequestMeta requestMeta) {
    return searchConditionService.getUserSearchCondition(conditionId, userId);
  }

  public List getUserSearchConditionJoinRole(String conditionId, String userId, RequestMeta requestMeta) {
    return searchConditionService.getUserSearchConditionJoinRole(conditionId, userId, requestMeta);
  }

  public void insertUserSearchCondition(List userSearchConditionList, RequestMeta requestMeta) {
    searchConditionService.insertUserSearchCondition(userSearchConditionList);
  }

  public void updateUserSearchCondition(String userId, String conditionId, List searchConditionList, RequestMeta requestMeta) {
    searchConditionService.updateUserSearchCondition(userId, conditionId, searchConditionList);
  }

  public void updateSearchCondition(List searchConditionList, RequestMeta requestMeta) {
    searchConditionService.updateSearchCondition(searchConditionList);
  }

  public ISearchConditionService getSearchConditionService() {
    return searchConditionService;
  }

  public void setSearchConditionService(ISearchConditionService searchConditionService) {
    this.searchConditionService = searchConditionService;
  }

  public List getCompoSearchCondition(String conditionType, RequestMeta requestMeta) {
    return searchConditionService.getCompoSearchCondition(conditionType);
  }

  private ISendDocService sendDocService;

  public List getSendDoc(int nd, RequestMeta requestMeta) {
    return sendDocService.getSendDoc(nd);
  }

  public void insertSendDoc(SendDoc sendDoc, RequestMeta requestMeta) {
    sendDocService.insertSendDoc(sendDoc);
  }

  public void updateSendDoc(SendDoc sendDoc, RequestMeta requestMeta) {
    sendDocService.updateSendDoc(sendDoc);
  }

  public void deleteSendDoc(SendDoc sendDoc, RequestMeta requestMeta) {
    sendDocService.deleteSendDoc(sendDoc);
  }

  public boolean sendDocCodeExist(SendDoc sendDoc, RequestMeta requestMeta) {
    return sendDocService.codeExist(sendDoc);
  }

  public boolean sendDocNameExist(SendDoc sendDoc, RequestMeta requestMeta) {
    return sendDocService.nameExist(sendDoc);
  }

  /**
   * 除当前code对应name外的 是否重复
   * @param nd
   * @param currentCode
   * @return
   */
  public boolean sendDocNameExistSelfExcluded(SendDoc sendDoc, RequestMeta requestMeta) {
    return sendDocService.nameExistSelfExcluded(sendDoc);
  }

  public boolean sendDocUsed(SendDoc sendDoc, RequestMeta requestMeta) {
    return sendDocService.sendDocUsed(sendDoc);
  }

  public ISendDocService getSendDocService() {
    return sendDocService;
  }

  public void setSendDocService(ISendDocService sendDocService) {
    this.sendDocService = sendDocService;
  }

  private ISendDocTypeService sendDocTypeService;

  public List getSendDocType(int nd, RequestMeta requestMeta) {
    return sendDocTypeService.getSendDocType(nd);
  }

  public ISendDocTypeService getSendDocTypeService() {
    return sendDocTypeService;
  }

  public void setSendDocTypeService(ISendDocTypeService sendDocTypeService) {
    this.sendDocTypeService = sendDocTypeService;
  }

  private IUserPreferencesService userPreferencesService;

  public UserPreferences getUserPreferences(String userId, String preferId, RequestMeta requestMeta) {
    return userPreferencesService.getUserPreferences(userId, preferId);
  }

  public void deleteUserPreferences(String userId, String preferId, RequestMeta requestMeta) {
    userPreferencesService.deleteUserPreferences(userId, preferId);

  }

  public void putUserPreferences(UserPreferences userPreferences, RequestMeta requestMeta) {
    userPreferencesService.putUserPreferences(userPreferences);
  }

  public void removeUserPreferences(UserPreferences userPreferences, RequestMeta requestMeta) {
    userPreferencesService.removeUserPreferences(userPreferences);
  }

  public IUserPreferencesService getUserPreferencesService() {
    return userPreferencesService;
  }

  public void setUserPreferencesService(IUserPreferencesService userPreferencesService) {
    this.userPreferencesService = userPreferencesService;
  }

  private IMaTzdSumElementService maTzdSumElementService;

  public List getMaTzdSumElement(int nd, String billTypeCode, RequestMeta requestMeta) {
    return maTzdSumElementService.getMaTzdSumElement(nd, billTypeCode);
  }

  public List getMaUserTzdSumElement(int nd, String billTypeCode, String userId, RequestMeta requestMeta) {
    return maTzdSumElementService.getMaUserTzdSumElement(nd, billTypeCode, userId);
  }

  public Map getMaTzdSumElementMap(int nd, String billTypeCode, RequestMeta requestMeta, String userId) {
    return maTzdSumElementService.getMaTzdSumElementMap(nd, billTypeCode, userId);
  }

  public MaTzdSumElement getMaTzdSumElement(int nd, String billTypeCode, String elementCode, RequestMeta requestMeta) {
    return maTzdSumElementService.getMaTzdSumElement(nd, billTypeCode, elementCode);
  }

  public void updateMaTzdSumElement(MaTzdSumElement maTzdSumElement, RequestMeta requestMeta) {
    maTzdSumElementService.updateMaTzdSumElement(maTzdSumElement);
  }

  public void updateMaTzdSumElements(List maTzdSumElementList, RequestMeta requestMeta) {
    maTzdSumElementService.updateMaTzdSumElements(maTzdSumElementList);
  }

  public void updateMaUserTzdSumElements(List maTzdSumElementList, RequestMeta requestMeta) {
    maTzdSumElementService.updateMaUserTzdSumElements(maTzdSumElementList);
  }

  public void updateMaTzdSum(MaTzdSumElement maTzdSumElement, RequestMeta requestMeta) {
    maTzdSumElementService.updateMaTzdSum(maTzdSumElement);
  }

  public IMaTzdSumElementService getMaTzdSumElementService() {
    return maTzdSumElementService;
  }

  public void setMaTzdSumElementService(IMaTzdSumElementService maTzdSumElementService) {
    this.maTzdSumElementService = maTzdSumElementService;
  }

  public List getDecBillElementList(int nd, String billTypeCode, RequestMeta requestMeta) {
    return billElementService.getDecBillElementList(nd, billTypeCode);
  }

  public List getAllDecBillElementList(int nd, String billTypeCode, RequestMeta requestMeta) {
    return billElementService.getAllDecBillElementList(nd, billTypeCode);
  }

  private IUserService userService;

  public User getUserById(String userId, RequestMeta requestMeta) {
    return userService.getUserById(userId);
  }

  public IUserService getUserService() {
    return userService;
  }

  public void setUserService(IUserService userService) {
    this.userService = userService;
  }

  private IUserFuncService userFuncService;

  public IUserFuncService getUserFuncService() {
    return userFuncService;
  }

  public void setUserFuncService(IUserFuncService userFuncService) {
    this.userFuncService = userFuncService;
  }

  public List getUserGrantFunc(UserFuncDto dto, RequestMeta requestMeta) {
    return userFuncService.getUserGrantFunc(dto);
  }

  public List getUsedCompoFunc(String compoId, RequestMeta requestMeta) {
    return userFuncService.getUsedCompoFunc(compoId);
  }

  private IWorkflowTraceService workflowTraceService;

  public TraceInfoModel getTraceInfo(Long instanceId, RequestMeta requestMeta) {
    return workflowTraceService.getTraceInfo(instanceId);
  }

  public IWorkflowTraceService getWorkflowTraceService() {
    return workflowTraceService;
  }

  public void setWorkflowTraceService(IWorkflowTraceService workflowTraceService) {
    this.workflowTraceService = workflowTraceService;
  }

  public List getMaGkFuncCompo(RequestMeta requestMeta) {
    return this.asCompoService.getMaGkFuncCompo();
  }

  private IAsCompoFuncService asCompoFuncService;

  public List getAsCompoFunc(String compoId, RequestMeta requestMeta) {
    return asCompoFuncService.getAsCompoFunc(compoId);
  }

  public void updateAsCompoFunc(List asCompoFuncList, RequestMeta requestMeta) {
    asCompoFuncService.updateAsCompoFunc(asCompoFuncList);
  }

  public IAsCompoFuncService getAsCompoFuncService() {
    return asCompoFuncService;
  }

  public void setAsCompoFuncService(IAsCompoFuncService asCompoFuncService) {
    this.asCompoFuncService = asCompoFuncService;
  }

  private IPrintService printService;

  public IPrintService getPrintService() {
    return printService;
  }

  public void setPrintService(IPrintService printService) {
    this.printService = printService;
  }

  public PrintSetting getCurrentPrintSetting(RequestMeta requestMeta) {
    return printService.getCurrentPrintSetting();
  }

  public List getCurrentPrintTemplate(RequestMeta requestMeta) {
    return printService.getCurrentPrintTemplate();
  }

  public void savePrintSettingFN(PrintSetting printSetting, RequestMeta requestMeta) {
    printService.savePrintSetting(printSetting);
  }

  public PrintObject genMainBillPrintObjectFN(BaseBill bill, RequestMeta requestMeta) {
    return printService.genMainBillPrintObject(bill);
  }

  public PrintObject genMainBillPrintObjectFN(List billList, RequestMeta requestMeta) {
    return printService.genMainBillPrintObject(billList);
  }

  //  public PrintObject genMainSubPrintObject(List billList, RequestMeta requestMeta) {
  //    return printService.genMainSubPrintObject(billList);
  //  }

  public PrintObject genMainBillPrintObjectFN(BaseBill bill, String templateCode, RequestMeta requestMeta) {
    return printService.genMainBillPrintObject(bill, templateCode);
  }

  public PrintObject genMainBillPrintObjectFN(List billList, String templateCode, RequestMeta requestMeta) {
    return printService.genMainBillPrintObject(billList, templateCode);
  }

  private IGkWorkflowService gkWorkflowService;

  public IGkWorkflowService getGkWorkflowService() {
    return gkWorkflowService;
  }

  public void setGkWorkflowService(IGkWorkflowService gkWorkflowService) {
    this.gkWorkflowService = gkWorkflowService;
  }

  public boolean isFinalAudit(Long processInstId, RequestMeta requestMeta) {
    return this.gkWorkflowService.isFinalAudit(processInstId);
  }

  public String getOrgPosiId(String coCode, String orgCode, String posiCode, int nd, RequestMeta requestMeta) {
    return this.gkWorkflowService.getOrgPosiId(coCode, orgCode, posiCode, nd);
  }

  private IAsFileService asFileService;

  public IAsFileService getAsFileService() {
    return asFileService;
  }

  public void setAsFileService(IAsFileService asFileService) {
    this.asFileService = asFileService;
  }

  public String uploadFile(AsFile asFile, RequestMeta requestMeta) {
    return asFileService.uploadFile(asFile);
  }

  public boolean uploadFile(AsFile asFile, String savePath, String fileName, RequestMeta requestMeta) {
    return asFileService.uploadFile(asFile, savePath, fileName);
  }

  public void updateAsFileById(AsFile asFile, RequestMeta requestMeta) {
    asFileService.updateAsFileById(asFile);
  }

  public AsFile getAsFileById(String fileId, RequestMeta requestMeta) {
    return asFileService.getAsFileById(fileId);
  }

  public AsFile getLargeAsFileById(String fileId, RequestMeta requestMeta) {
    return asFileService.getLargeAsFileById(fileId);

  }

  public AsFile downloadFile(String fileId, RequestMeta requestMeta) {
    return asFileService.downloadFile(fileId);
  }

  public void deleteFile(String fileId, RequestMeta requestMeta) {
    asFileService.deleteFile(fileId);
  }

  private IAsUserNumLimService asUserNumLimService;

  public IAsUserNumLimService getAsUserNumLimService() {
    return asUserNumLimService;
  }

  public void setAsUserNumLimService(IAsUserNumLimService asUserNumLimService) {
    this.asUserNumLimService = asUserNumLimService;
  }

  public List getAsUserNumLim(String userId, String compoId, String funcId, String ctrlField, RequestMeta requestMeta) {
    return this.asUserNumLimService.getAsUserNumLim(userId, compoId, funcId, ctrlField);
  }

  private IAsRoleNumLimService asRoleNumLimService;

  public IAsRoleNumLimService getAsRoleNumLimService() {
    return asRoleNumLimService;
  }

  public void setAsRoleNumLimService(IAsRoleNumLimService asRoleNumLimService) {
    this.asRoleNumLimService = asRoleNumLimService;
  }

  public List getAsRoleNumLimByUserId(String userId, String compoId, String funcId, String ctrlField, RequestMeta requestMeta) {
    return this.asRoleNumLimService.getAsRoleNumLimByUserId(userId, compoId, funcId, ctrlField);
  }

  private IAsCompoService asCompoService;

  public List getAllAsCompo(RequestMeta requestMeta) {
    return asCompoService.getAllAsCompo();
  }

  public AsCompo getAsCompoById(String compoId, RequestMeta requestMeta) {
    return asCompoService.getAsCompoById(compoId);
  }

  public void updateAsCompo(AsCompo asCompo, RequestMeta requestMeta) {
    asCompoService.updateAsCompo(asCompo);
  }

  public IAsCompoService getAsCompoService() {
    return asCompoService;
  }

  public void setAsCompoService(IAsCompoService asCompoService) {
    this.asCompoService = asCompoService;
  }

  public List getAsTabColForOrder(String tabName, RequestMeta requestMeta) {
    return asCompoService.getAsTabColForOrder(tabName);
  }

  private IGkGetdataRuleService gkGetdataRuleService;

  public IGkGetdataRuleService getGkGetdataRuleService() {
    return gkGetdataRuleService;
  }

  public void setGkGetdataRuleService(IGkGetdataRuleService gkGetdataRuleService) {
    this.gkGetdataRuleService = gkGetdataRuleService;
  }

  public GkGetdataRule getGkGetDataRuleById(String ruleId, RequestMeta requestMeta) {
    return gkGetdataRuleService.getGkGetDataRuleById(ruleId);
  }

  public GkGetdataRule getGkGetDataRule(String ruleId, RequestMeta requestMeta) {
    return gkGetdataRuleService.getGkGetDataRule(ruleId);
  }

  IWfTaskGranterService WfTaskGranterService;

  public List getWfTaskGranter(String userId, RequestMeta requestMeta) {
    return WfTaskGranterService.getWfTaskGranter(userId);
  }

  public void insertWfTaskGranterFN(WfTaskGranter wfTaskGranter, RequestMeta requestMeta) {
    this.WfTaskGranterService.insertWfTaskGranter(wfTaskGranter);
  }

  public void deleteWfTaskGranterFN(String userId, RequestMeta requestMeta) {
    this.WfTaskGranterService.deleteWfTaskGranter(userId);
  }

  public void updateWfTaskGranterFN(List grantList, RequestMeta requestMeta) {
    this.WfTaskGranterService.updateWfTaskGranter(grantList);
  }

  public void updateToRelieveWarrant(List grantList, RequestMeta requestMeta) {
    this.WfTaskGranterService.updateToRelieveWarrant(grantList);
  }

  public void cancelGrantedTaskFN(String userId, RequestMeta requestMeta) {
    this.WfTaskGranterService.cancelGrantedTask(userId);
  }

  private IMaCpElementMappingService maCpElementMappingService;

  public List getMaCpElementMapping(ElementConditionDto dto, RequestMeta requestMeta) {
    return maCpElementMappingService.getMaCpElementMapping(dto);
  }

  public IMaCpElementMappingService getMaCpElementMappingService() {
    return maCpElementMappingService;
  }

  public void setMaCpElementMappingService(IMaCpElementMappingService maCpElementMappingService) {
    this.maCpElementMappingService = maCpElementMappingService;
  }

  public void saveMaCpElementMapping(List maCpElementMappingList, String type, String useType, RequestMeta requestMeta) {
    maCpElementMappingService.save(maCpElementMappingList, type, useType);
  }

  public IWfTaskGranterService getWfTaskGranterService() {
    return WfTaskGranterService;
  }

  public void setWfTaskGranterService(IWfTaskGranterService wfTaskGranterService) {
    WfTaskGranterService = wfTaskGranterService;
  }

  public Map getFieldLevelOptions(RequestMeta requestMeta) {
    return asOptionService.getFieldLevelOptions();
  }

  private INumService numService;

  public INumService getNumService() {
    return numService;
  }

  public void setNumService(INumService numService) {
    this.numService = numService;
  }

  public String getNo(String compoId, String noField, Object bill, RequestMeta requestMeta) {
    return numService.getNo(compoId, noField, bill);
  }

  private IMaElementRelationRuleService maCpElementRelationService;

  public IMaElementRelationRuleService getMaCpElementRelationService() {
    return maCpElementRelationService;
  }

  public void setMaCpElementRelationService(IMaElementRelationRuleService maCpElementRelationService) {
    this.maCpElementRelationService = maCpElementRelationService;
  }

  public String getElementRelationId(RequestMeta requestMeta) {
    return maCpElementRelationService.getElementRelationId();
  }

  public List getElementRelationRules(String compoId, String handleType, String ruleType, RequestMeta requestMeta) {
    return maCpElementRelationService.getElementRelationRules(compoId, handleType, ruleType);
  }

  public String getNumLimCondByCoType(String numLimCompoId, String funcId, RequestMeta requestMeta) {
    return this.asUserNumLimService.getNumLimCondByCoType(numLimCompoId, funcId);
  }

  public String getNumLimCondByCoType(String numLimCompoId, String funcId, String ctrlField, RequestMeta requestMeta) {
    return this.asUserNumLimService.getNumLimCondByCoType(numLimCompoId, funcId, ctrlField);
  }

  public String getNumLimCondByCoType(String numLimCompoId, String funcId, String ctrlField, boolean isTableContainCoCode, RequestMeta requestMeta) {
    return this.asUserNumLimService.getNumLimCondByCoType(numLimCompoId, funcId, ctrlField, isTableContainCoCode);
  }

  public String getNumLimCondByCoType(String numLimCompoId, String funcId, boolean isTableContainCoCode, RequestMeta requestMeta) {
    return this.asUserNumLimService.getNumLimCondByCoType(numLimCompoId, funcId, isTableContainCoCode);
  }

  public void deleteElementRelationRuleById(String ruleId, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    maCpElementRelationService.deleteElementRelationRuleById(ruleId);
  }

  public void deleteRelationEntryByEntryId(String entityId, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    maCpElementRelationService.deleteRelationEntityByEntryId(entityId);
  }

  public void insertElementRelationRule(MaElementRelationRule relationRule, RequestMeta requestMeta) {
    maCpElementRelationService.insertElementRelationRule(relationRule);
  }

  public void updateElementRelationRule(MaElementRelationRule relationRule, RequestMeta requestMeta) {
    maCpElementRelationService.updateElementRelationRule(relationRule);
  }

  public String getElementEntryId(RequestMeta requestMeta) {
    return maCpElementRelationService.getElementEntryId();
  }

  public void insertElementRelationEntry(MaElementRelationRuleEntry ruleEntry, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    maCpElementRelationService.insertElementRelationEntry(ruleEntry);
  }

  public void updateElementRelationEntry(MaElementRelationRuleEntry ruleEntry, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    maCpElementRelationService.updateElementRelationEntry(ruleEntry);
  }

  public Date getSysDate(RequestMeta requestMeta) {
    return new Date();
  }

  private IMaExpSerialService expSerialService;

  public IMaExpSerialService getExpSerialService() {
    return expSerialService;
  }

  public void setExpSerialService(IMaExpSerialService expSerialService) {
    this.expSerialService = expSerialService;
  }

  public MaExpSerial getMaExpSerial(Map params, RequestMeta requestMeta) {
    return this.expSerialService.getMaExpSerial(params);
  }

  public void insertMaExpSerial(MaExpSerial serial, RequestMeta requestMeta) {
    this.expSerialService.insertMaExpSerial(serial);
  }

  public void updateMaExpSerial(MaExpSerial serial, RequestMeta requestMeta) {
    this.expSerialService.updateMaExpSerial(serial);
  }

  public Company getDirectorCompany(ElementConditionDto dto, RequestMeta requestMeta) {
    return this.companyService.getDirectorCompany(dto);
  }

  private IBankTradeLogService bankTradeLogService;

  public IBankTradeLogService getBankTradeLogService() {
    return bankTradeLogService;
  }

  public void setBankTradeLogService(IBankTradeLogService bankTradeLogService) {
    this.bankTradeLogService = bankTradeLogService;
  }

  public void saveLog(ResultInfo result, RequestMeta requestMeta) {
    bankTradeLogService.saveLog(result);
  }

  private IGkBusinessLogService gkBusinessLogService;

  public IGkBusinessLogService getGkBusinessLogService() {
    return gkBusinessLogService;
  }

  public void setGkBusinessLogService(IGkBusinessLogService gkBusinessLogService) {
    this.gkBusinessLogService = gkBusinessLogService;
  }

  public List getGkBusinessLog(BaseBill bill, RequestMeta requestMeta) {
    List list = gkBusinessLogService.getGkBusinessLog(bill);
    List resultList = new ArrayList();

    for (int i = 0; i < list.size(); i++) {
      GkBusinessLog log = (GkBusinessLog) list.get(i);
      //      log.setCertDNCN(DSignSUtil.getCertDNCN(log.getDsignedData()));
      log.setDsignedData(null);
      resultList.add(log);
    }
    return resultList;
  }

  public List getGkBusinessLog(String billId, String tableName, RequestMeta requestMeta) {
    List list = gkBusinessLogService.getGkBusinessLog(billId, tableName);
    List resultList = new ArrayList();

    for (int i = 0; i < list.size(); i++) {
      GkBusinessLog log = (GkBusinessLog) list.get(i);
      //      log.setCertDNCN(DSignSUtil.getCertDNCN(log.getDsignedData()));
      log.setDsignedData(null);
      resultList.add(log);
    }
    return resultList;
  }

  private IMacpRuleDetailService macpRuleDetailService;

  public IMacpRuleDetailService getMacpRuleDetailService() {
    return macpRuleDetailService;
  }

  public void setMacpRuleDetailService(IMacpRuleDetailService macpRuleDetailService) {
    this.macpRuleDetailService = macpRuleDetailService;
  }

  public Map getMacpRuleDetail(Map params, RequestMeta requestMeta) {
    return this.macpRuleDetailService.getMacpRuleDetail(params);
  }

  private IMaSearchStoreService searchStoreService;

  public IMaSearchStoreService getSearchStoreService() {
    return searchStoreService;
  }

  public void setSearchStoreService(IMaSearchStoreService searchStoreService) {
    this.searchStoreService = searchStoreService;
  }

  public void deleteSearchStore(UserSearchStore store, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    this.searchStoreService.deleteSearchStore(store);
  }

  public List getUserSearchStore(String userId, String conditionId, int nd, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.searchStoreService.getUserSearchStore(userId, conditionId, nd);
  }

  public void insertuserSearchStore(UserSearchStore store, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    this.searchStoreService.insertuserSearchStore(store);
  }

  public void updateUserSearchStore(UserSearchStore store, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    this.searchStoreService.updateUserSearchStore(store);
  }

  public void addUser(User user, String coCode, String orgCode, String posiCode, String groupId, String nd) {
    this.userService.addUser(user, coCode, orgCode, posiCode, groupId, nd);
  }

  public void uploadLargeFile(AsFile asFile, RequestMeta meta) {
    this.asFileService.uploadLargeFile(asFile);
  }

  public byte[] getTbylbFromFileMenuById(String fileId, String packCode, RequestMeta requestMeta) {
    return this.asFileService.getTbylbFromFileMenuById(fileId, packCode);
  }

  public void uploadFileSavePath(AsFile asFile, RequestMeta meta) {
    asFileService.uploadFileSavePath(asFile);
  }

  IAsEmpService asEmpService;

  public IAsEmpService getAsEmpService() {
    return asEmpService;
  }

  public void setAsEmpService(IAsEmpService asEmpService) {
    this.asEmpService = asEmpService;
  }

  public List getAsEmpByUserID(AsEmp emp, RequestMeta meta) {
    return this.asEmpService.getAsEmp(emp);
  }

  @Override
  public boolean isFinalAudit(long processInstId, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return false;
  }

  private IForeignEntityServic foreignEntityService;

  @Override
  public List getForeignEntitySelectedData(String sqlMapSelectedId, ElementConditionDto elementConditionDto, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.foreignEntityService.getForeignEntitySelectedData(sqlMapSelectedId, elementConditionDto, requestMeta);
  }

  @Override
  public List queryDataForList(String string, Map parameter, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return null;
  }

  private IMenuService menuService;

  @Override
  public List<AppMenuItem> getMenus(RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return menuService.getMenus(requestMeta);
  }

  public IMenuService getMenuService() {
    return menuService;
  }

  public void setMenuService(IMenuService menuService) {
    this.menuService = menuService;
  }

  public IForeignEntityServic getForeignEntityService() {
    return foreignEntityService;
  }

  public void setForeignEntityService(IForeignEntityServic foreignEntityService) {
    this.foreignEntityService = foreignEntityService;
  }
}
