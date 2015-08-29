package com.ufgov.gk.client.component.ui;

import java.util.ArrayList;
import java.util.List;

import com.ufgov.gk.client.common.AsOptionMeta;
import com.ufgov.gk.client.common.ServiceFactory;
import com.ufgov.gk.client.common.WorkEnv;
import com.ufgov.gk.common.commonbiz.model.SearchCondition;
import com.ufgov.gk.common.commonbiz.publish.IBaseDataServiceDelegate;
import com.ufgov.gk.common.system.constants.SystemOptionConstants;

/**
 * <p>Title: GK53</p>
 * <p>Description: ��ҳǩ��DataDisplay������tab���湦��</p>
 * <p>Copyright: Copyright 2009 ufgov, Inc.</p>
 * <p>Company: ufgov</p>
 * <p>����ʱ��: 2009-4-23</p>
 * @author ����ΰ(manlge)
 * @version 1.0
 */
public abstract class MultiDataDisplay extends AbstractDataDisplay {
  public String tabId;

  /**
   * @param displays ���е�TableDisplay
   * @param showingDisplays ��Ҫ��ʾ��TableDisplay
   * @param conditionArea ��������
   * @param showConditionArea ����ʾ������
   * @param tabId ҳǩ���ݿ��е�id
   */
  public MultiDataDisplay(List<TableDisplay> displays, List<TableDisplay> showingDisplays,
    AbstractSearchConditionArea conditionArea, boolean showConditionArea, String tabId) {
    super(displays, showingDisplays, conditionArea, showConditionArea,true, tabId);
    this.tabId = tabId;
  }

  @Override
  protected void saveSelectedTableDisplays(TableDisplay[] displays) {
    List<SearchCondition> list = new ArrayList<SearchCondition>();
    for (TableDisplay d : displays) {
      list.add(d.getSearchCondition());
    }
    
    String userId=WorkEnv.getInstance().getCurrUserId();
    String value = AsOptionMeta.getOptVal(SystemOptionConstants.OPT_PREFER_SET_DEFAULT);
    if ("1".equals(value)) {
      userId="*";
    }
    
    getSearchConditionServiceDelegate().updateUserSearchCondition(userId, tabId, list,
      WorkEnv.getInstance().getRequestMeta());
  }

  public IBaseDataServiceDelegate getSearchConditionServiceDelegate() {
    IBaseDataServiceDelegate searchConditionServiceDelegate = (IBaseDataServiceDelegate) ServiceFactory
      .create(IBaseDataServiceDelegate.class, "baseDataServiceDelegate");
    return searchConditionServiceDelegate;
  }

}
