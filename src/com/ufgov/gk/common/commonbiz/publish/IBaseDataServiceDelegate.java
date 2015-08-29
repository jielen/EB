package com.ufgov.gk.common.commonbiz.publish;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.kingdrive.workflow.model.runtime.TraceInfoModel;
import com.ufgov.gk.common.ebay.model.AppMenuItem;
import com.ufgov.gk.common.system.Publishable;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.dto.ElementConditionDto;
import com.ufgov.gk.common.system.dto.UserFuncDto;
import com.ufgov.gk.common.system.model.AsCompo;
import com.ufgov.gk.common.system.model.AsFile;
import com.ufgov.gk.common.system.model.AsOption;
import com.ufgov.gk.common.system.model.UserPreferences;
import com.ufgov.gk.common.system.model.UserSearchStore;

public interface IBaseDataServiceDelegate extends Publishable {

  UserPreferences getUserPreferences(String userId, String key, RequestMeta requestMeta);

  void putUserPreferences(UserPreferences userPreferences, RequestMeta requestMeta);

  void removeUserPreferences(UserPreferences userPreferences, RequestMeta requestMeta);

  String getNo(String compoId, String noField, Object bill, RequestMeta requestMeta);

  String getNumLimCondByCoType(String numLimCompoId, String funcId, String ctrlField, RequestMeta requestMeta);

  boolean isFinalAudit(long processInstId, RequestMeta requestMeta);

  List getZcOrg(int nd, RequestMeta requestMeta);

  List getCompany(ElementConditionDto dto, RequestMeta requestMeta);

  List getAsVal(String valSetId, RequestMeta requestMeta);

  List getForeignEntitySelectedData(String sqlMapSelectedId, ElementConditionDto elementConditionDto, RequestMeta requestMeta);

  List getSearchCondition(String conditionId, RequestMeta requestMeta);

  List getUserSearchCondition(String conditionId, String userId, RequestMeta requestMeta);

  List getRoleSearchCondition(String conditionId, String userId, RequestMeta requestMeta);

  List getUserSearchConditionJoinRole(String conditionId, String userId, RequestMeta requestMeta);

  void insertuserSearchStore(UserSearchStore store, RequestMeta requestMeta);

  void updateUserSearchStore(UserSearchStore store, RequestMeta meta);

  List getUserSearchStore(String svUserID, String conditionId, int svNd, RequestMeta meta);

  void updateUserSearchCondition(String userId, String conditionId, List list, RequestMeta requestMeta);

  AsFile getAsFileById(String fileId, RequestMeta requestMeta);

  AsFile downloadFile(String fileId, RequestMeta requestMeta);

  void deleteFile(String fileId, RequestMeta requestMeta);

  String uploadFile(AsFile asFile, RequestMeta requestMeta);

  TraceInfoModel getTraceInfo(Long instanceId, RequestMeta requestMeta);

  List getCompoSearchCondition(String searchConditonType, RequestMeta requestMeta);

  AsCompo getAsCompoById(String compoId, RequestMeta requestMeta);

  List getAllAsOptionById(String optId, RequestMeta requestMeta);

  AsOption getAsOption(String optId, RequestMeta requestMeta);

  void updateOptionVal(AsOption asOption, RequestMeta requestMeta);

  List getUsedCompoFunc(String compoId, RequestMeta requestMeta);

  Map getLangTrans(String resId, RequestMeta requestMeta);

  Collection getUserGrantFunc(UserFuncDto userFuncDto, RequestMeta requestMeta);

  Map<String, String> getWfCanEditField(Long processInstId, RequestMeta requestMeta);

  List getDownDisplayBillElementList(int nd, String billTypeCode, String string, RequestMeta requestMeta);

  Map getBillElement(int nd, String billTypeCode, RequestMeta requestMeta);

  List queryDataForList(String string, Map parameter, RequestMeta requestMeta);

  List<AppMenuItem> getMenus(RequestMeta requestMeta);

}
