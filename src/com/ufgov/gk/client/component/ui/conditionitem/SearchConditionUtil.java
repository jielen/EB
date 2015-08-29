package com.ufgov.gk.client.component.ui.conditionitem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ufgov.gk.client.common.BillElementMeta;
import com.ufgov.gk.client.common.ServiceFactory;
import com.ufgov.gk.client.common.WorkEnv;
import com.ufgov.gk.client.component.ui.TableDisplay;
import com.ufgov.gk.common.commonbiz.model.SearchCondition;
import com.ufgov.gk.common.commonbiz.publish.IBaseDataServiceDelegate;
import com.ufgov.gk.common.system.RequestMeta;

public class SearchConditionUtil {
  private static RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();

  private static IBaseDataServiceDelegate baseDataServiceDelegate = (IBaseDataServiceDelegate) ServiceFactory.create(IBaseDataServiceDelegate.class,
    "baseDataServiceDelegate");

  /*
   * �õ���Ҫ��ʾ��searchCondition��
   * �Ȱ���userId���ң��ٰ���*���ң����Ĭ������
   */
  public static List<SearchCondition> getNeedDisplaySearchConditonList(String userId, String conditionId) {
    List<SearchCondition> searchConditonListByUserJoinRoleId = getSearchConditionListJoinRole(false, userId, conditionId);
    if (searchConditonListByUserJoinRoleId != null & searchConditonListByUserJoinRoleId.size() > 0) {
      return searchConditonListByUserJoinRoleId;

    }
    List<SearchCondition> searchConditonListByUserId = getSearchConditionList(userId, conditionId);
    if (searchConditonListByUserId != null & searchConditonListByUserId.size() > 0)
      return searchConditonListByUserId;

    List<SearchCondition> searchConditionListByDefautUser = getSearchConditionList("*", conditionId);
    if (searchConditionListByDefautUser != null & searchConditionListByDefautUser.size() > 0)
      return searchConditionListByDefautUser;

    return getSearchConditionList(null, conditionId);

  }

  /* edit by fanpl
   * �õ����û�����Ҫ��ʾ��searchCondition��,
   * ��role����
   */
  public static List<SearchCondition> getNeedDisplaySearchConditonListJoinRole(String userId, String conditionId) {
    List<SearchCondition> searchConditonListByUserJoinRoleId = getSearchConditionListJoinRole(false, userId, conditionId);
    if (searchConditonListByUserJoinRoleId != null & searchConditonListByUserJoinRoleId.size() > 0)
      return searchConditonListByUserJoinRoleId;
    return getNeedDisplaySearchConditonList(userId, conditionId);
  }

  private static List<SearchCondition> getSearchConditionList(String userId, String conditionId) {
    if (conditionId == null) {
      throw new IllegalArgumentException("conditionId ����Ϊ��");
    }
    if (userId == null) {
      return baseDataServiceDelegate.getSearchCondition(conditionId, WorkEnv.getInstance().getRequestMeta());
    }
    return baseDataServiceDelegate.getUserSearchCondition(conditionId, userId, WorkEnv.getInstance().getRequestMeta());
  }

  /***
   * edit by fanpl
  * @Description: isRole Ϊtrue ��ȡ�ý�ɫ�µ�ҳǩ��Ϊfalse��ȡ���û��µ�ҳǩ
  * @return List<SearchCondition> ��������
  * @since 1.0
   */
  public static List<SearchCondition> getSearchConditionListJoinRole(boolean isRole, String userId, String conditionId) {
    if (conditionId == null) {
      throw new IllegalArgumentException("conditionId ����Ϊ��");
    }
    /**
     * ȡȫ��ҳǩ���ȹ�����ɫȡ��,������ɫȡ������ȡ����
     */
    if (isRole) {
      List<SearchCondition> list = baseDataServiceDelegate.getRoleSearchCondition(conditionId, userId, WorkEnv.getInstance().getRequestMeta());
      if (list != null & list.size() > 0) {
        return list;
      }
      return getSearchConditionList(null, conditionId);
    } else {
      /**
       * ȡ�û�ѡ�е�ҳǩ ��������ɫ���û�����,������ɫ�����û�ȡ�������ݣ�������ɫȥȡ��������ɫȡ�����������û�ȥȡ�������ȡ���С�
       */
      List<SearchCondition> list1 = baseDataServiceDelegate.getUserSearchConditionJoinRole(conditionId, userId, WorkEnv.getInstance()
        .getRequestMeta());
      if (list1 != null && list1.size() > 0) {
        return list1;
      } else {
        List<SearchCondition> list2 = baseDataServiceDelegate.getRoleSearchCondition(conditionId, userId, WorkEnv.getInstance().getRequestMeta());
        if (list2 != null & list2.size() > 0) {
          return list2;
        }
        return getSearchConditionList(userId, conditionId);
      }
    }

  }

  //  public static List<AbstractSearchConditionItem> getAllSearchConditionItems(String conditionId,
  //    String billTypeCode, Map defautValueMap) {
  //    BillElementMeta bem = BillElementMeta.getBillElementMeta(billTypeCode);
  //    return getAllSearchConditionItems(conditionId, bem, defautValueMap);
  //  }

  /**
   * �������е�������
   * @param conditionId �������id billTypeCode ���ݵ����ʹ���
   * @return
   */
  //  public static List<AbstractSearchConditionItem> getAllSearchConditionItems(String conditionId,
  //    BillElementMeta bem, Map defautValueMap) {
  //    List<AbstractSearchConditionItem> selectedSearchConditionItems = new ArrayList<AbstractSearchConditionItem>();
  //
  //    for (Object obj : getSearchConditionList(null, conditionId)) {
  //      SearchCondition searchCondition = (SearchCondition) obj;
  //      String fieldCode = searchCondition.getConditionFieldCode();
  //      String fieldName = searchCondition.getConditionFieldName();
  //      AbstractSearchConditionItem newSearchConditionItem = SearchConditionItemFactory
  //        .createSearchConditionItem(fieldCode, fieldName, bem.getElementRenderType(fieldCode), defautValueMap
  //          .get(fieldCode));
  //      newSearchConditionItem.setSearchCondition(searchCondition);
  //      selectedSearchConditionItems.add(newSearchConditionItem);
  //    }
  //    return selectedSearchConditionItems;
  //  }

  //  public static List<AbstractSearchConditionItem> getDisplaySearchConditionItems(String conditionId,
  //    String billTypeCode, Map defaultValueMap) {
  //    BillElementMeta bem = BillElementMeta.getBillElementMeta(billTypeCode);
  //    return getDisplaySearchConditionItems(conditionId, bem, defaultValueMap);
  //  }

  //  public static List<AbstractSearchConditionItem> getDisplaySearchConditionItems(String conditionId,
  //    BillElementMeta bem, Map defaultValueMap) {
  //    List<AbstractSearchConditionItem> selectedSearchConditionItems = new ArrayList<AbstractSearchConditionItem>();
  //    for (Object obj : getNeedDisplaySearchConditonList(WorkEnv.getInstance().getCurrUserId(), conditionId)) {
  //      SearchCondition searchCondition = (SearchCondition) obj;
  //      String fieldCode = searchCondition.getConditionFieldCode();
  //      String fieldName = searchCondition.getConditionFieldName();
  //      AbstractSearchConditionItem newSearchConditionItem = SearchConditionItemFactory
  //        .createSearchConditionItem(fieldCode, fieldName, bem.getElementRenderType(fieldCode), defaultValueMap
  //          .get(fieldCode));
  //      newSearchConditionItem.setSearchCondition(searchCondition);
  //      selectedSearchConditionItems.add(newSearchConditionItem);
  //    }
  //    return selectedSearchConditionItems;
  //  }

  public static List<AbstractSearchConditionItem> toCompoment(List searchConditionList, BillElementMeta bem, Map defaultValueMap, String numLimCompoId) {
    List<AbstractSearchConditionItem> conditionItems = new ArrayList<AbstractSearchConditionItem>();
    for (Object obj : searchConditionList) {
      SearchCondition searchCondition = (SearchCondition) obj;
      String fieldCode = searchCondition.getConditionFieldCode();
      String fieldName = searchCondition.getConditionFieldName();
      AbstractSearchConditionItem newSearchConditionItem = SearchConditionItemFactory
        .createSearchConditionItem(fieldCode, fieldName, bem == null ? "" : bem.getElementRenderType(ConditionFieldConstants
          .getElementCode(fieldCode)), defaultValueMap.get(fieldCode), numLimCompoId);
      newSearchConditionItem.setSearchCondition(searchCondition);
      conditionItems.add(newSearchConditionItem);
    }
    return conditionItems;
  }

  /**
   * ����DataDisplay
   * @param �õ���Ҫ��ʾ�����е�ҳǩ
   * @return
   */
  public static List<TableDisplay> getAllTableDisplay(String tabConditionId) {
    List<TableDisplay> list = new ArrayList<TableDisplay>();
    for (Object obj : getSearchConditionListJoinRole(true, requestMeta.getSvUserID(), tabConditionId)) {
      SearchCondition searchCondition = (SearchCondition) obj;
      TableDisplay tableDisplay = new TableDisplay(searchCondition.getConditionFieldName());
      tableDisplay.setStatus(searchCondition.getConditionFieldCode());
      tableDisplay.setSearchCondition(searchCondition);
      list.add(tableDisplay);
    }
    return list;

    //    List<TableDisplay> list = new ArrayList<TableDisplay>();
    //    for (Object obj : getSearchConditionList(null, tabConditionId)) {
    //      SearchCondition searchCondition = (SearchCondition) obj;
    //      TableDisplay tableDisplay = new TableDisplay(searchCondition.getConditionFieldName());
    //      tableDisplay.setStatus(searchCondition.getConditionFieldCode());
    //      tableDisplay.setSearchCondition(searchCondition);
    //      list.add(tableDisplay);
    //    }
    //    return list;
  }

  /**
   * ����DataDisplay
   * @param ������ɫ�õ���Ҫ��ʾ�����е�ҳǩ
   * @return
   */
  public static List<TableDisplay> getAllTableDisplayJoinRole(String userId, String tabConditionId) {
    List<TableDisplay> list = new ArrayList<TableDisplay>();
    for (Object obj : getSearchConditionListJoinRole(true, userId, tabConditionId)) {
      SearchCondition searchCondition = (SearchCondition) obj;
      TableDisplay tableDisplay = new TableDisplay(searchCondition.getConditionFieldName());
      tableDisplay.setStatus(searchCondition.getConditionFieldCode());
      tableDisplay.setSearchCondition(searchCondition);
      list.add(tableDisplay);
    }
    return list;
  }

  /*
   * �õ���Ҫ��ʾ��ҳǩ
   */
  public static List<TableDisplay> getNeedDisplayTableDisplay(String tabConditionId) {
    List<TableDisplay> list = new ArrayList<TableDisplay>();
    for (Object obj : getNeedDisplaySearchConditonList(WorkEnv.getInstance().getCurrUserId(), tabConditionId)) {
      SearchCondition searchCondition = (SearchCondition) obj;
      TableDisplay tableDisplay = new TableDisplay(searchCondition.getConditionFieldName());
      tableDisplay.setStatus(searchCondition.getConditionFieldCode());
      tableDisplay.setSearchCondition(searchCondition);
      list.add(tableDisplay);
    }
    return list;
  }

  /*
   * �õ���Ҫ��ʾ��ҳǩ
   */
  public static List<TableDisplay> getNeedDisplayTableDisplay(List<SearchCondition> conditions) {
    List<TableDisplay> list = new ArrayList<TableDisplay>();
    for (Object obj : conditions) {
      SearchCondition searchCondition = (SearchCondition) obj;
      TableDisplay tableDisplay = new TableDisplay(searchCondition.getConditionFieldName());
      tableDisplay.setStatus(searchCondition.getConditionFieldCode());
      tableDisplay.setSearchCondition(searchCondition);
      list.add(tableDisplay);
    }
    return list;
  }

}
