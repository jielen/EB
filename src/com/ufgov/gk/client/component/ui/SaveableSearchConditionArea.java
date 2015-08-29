package com.ufgov.gk.client.component.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ufgov.gk.client.common.AsOptionMeta;
import com.ufgov.gk.client.common.BillElementMeta;
import com.ufgov.gk.client.common.ServiceFactory;
import com.ufgov.gk.client.common.WorkEnv;
import com.ufgov.gk.client.component.ui.conditionitem.SearchConditionUtil;
import com.ufgov.gk.common.commonbiz.model.SearchCondition;
import com.ufgov.gk.common.commonbiz.publish.IBaseDataServiceDelegate;
import com.ufgov.gk.common.system.constants.SystemOptionConstants;

/**
 * <p>Title: GK53</p>
 * <p>Description: ��������������湦�ܵ�SearchConditionArea</p>
 * <p>Copyright: Copyright 2009 ufgov, Inc.</p>
 * <p>Company: ufgov</p>
 * <p>����ʱ��: 2009-4-23</p>
 * @author ����ΰ(manlge)
 * @version 1.0
 */
public class SaveableSearchConditionArea extends AbstractSearchConditionArea {

  public SaveableSearchConditionArea(List<SearchCondition> searchConditionItems, List<SearchCondition> selectedSearchConditionItems,
    String conditionId, BillElementMeta bem, Map defaultValueMap) {
    super(conditionId, searchConditionItems, selectedSearchConditionItems, bem, defaultValueMap);
  }

  public SaveableSearchConditionArea(String conditionId, BillElementMeta bem, boolean showFlag, Map defaultValueMap, String numLimCompoId) {
    super.init(conditionId, this.getAllSearchConditions(conditionId), this.getSelectedSearchConditions(conditionId), bem, defaultValueMap, showFlag,
      numLimCompoId);
  }

  public SaveableSearchConditionArea(boolean isJoinRole, String conditionId, BillElementMeta bem, boolean showFlag, Map defaultValueMap,
    String numLimCompoId) {
    super.init(conditionId, this.getRoleSearchConditions(conditionId), this.getSelectedSearchConditions(conditionId), bem, defaultValueMap, showFlag,
      numLimCompoId);
  }

  public SaveableSearchConditionArea(final String conditionId, final BillElementMeta bem, final boolean showFlag, final Map defaultValueMap,
    final String numLimCompoId, final boolean isRefresh) {
    List<SearchCondition> allSearchConditions;
    List<SearchCondition> selectedSearchConditions;
    allSearchConditions = getAllSearchConditions(conditionId);
    selectedSearchConditions = getSelectedSearchConditions(conditionId);
    init(conditionId, allSearchConditions, selectedSearchConditions, bem, defaultValueMap, showFlag, numLimCompoId, isRefresh);
  }

  public SaveableSearchConditionArea(SearchCondition[] conditionItems, SearchCondition[] showConditionItems, String conditionId) {
    super.init(conditionId, this.getAllSearchConditions(conditionId), this.getSelectedSearchConditions(conditionId));
  }

  @Override
  protected void saveSelectedConditionItems(SearchCondition[] showingConditionItems) {
    List list = new ArrayList();
    for (SearchCondition item : showingConditionItems) {
      list.add(item);
    }
    String userId = WorkEnv.getInstance().getCurrUserId();
    String value = AsOptionMeta.getOptVal(SystemOptionConstants.OPT_PREFER_SET_DEFAULT);
    if ("1".equals(value)) {
      userId = "*";
    }

    IBaseDataServiceDelegate searchConditionServiceDelegate = getSearchConditionServiceDelegate();
    searchConditionServiceDelegate.updateUserSearchCondition(userId, conditionId, list, WorkEnv.getInstance().getRequestMeta());
  }

  public IBaseDataServiceDelegate getSearchConditionServiceDelegate() {
    IBaseDataServiceDelegate searchConditionServiceDelegate = (IBaseDataServiceDelegate) ServiceFactory.create(IBaseDataServiceDelegate.class,
      "baseDataServiceDelegate");
    return searchConditionServiceDelegate;
  }

  private List<SearchCondition> getAllSearchConditions(String conditionId) {
    return SearchConditionUtil.getNeedDisplaySearchConditonList(null, conditionId);
  }

  private List<SearchCondition> getRoleSearchConditions(String conditionId) {
    return SearchConditionUtil.getSearchConditionListJoinRole(true, WorkEnv.getInstance().getCurrUserId(), conditionId);
  }

  private List<SearchCondition> getSelectedSearchConditions(String conditionId) {
    return SearchConditionUtil.getNeedDisplaySearchConditonList(WorkEnv.getInstance().getCurrUserId(), conditionId);
  }

  private List<SearchCondition> getSelectedSearchConditionsJoinRole(String conditionId) {
    return SearchConditionUtil.getNeedDisplaySearchConditonListJoinRole(WorkEnv.getInstance().getCurrUserId(), conditionId);
  }
}
