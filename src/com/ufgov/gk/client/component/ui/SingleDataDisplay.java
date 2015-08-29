package com.ufgov.gk.client.component.ui;

/**
 * <p>Title: GK53</p>
 * <p>Description: ������DataDisplay</p>
 * <p>Copyright: Copyright 2009 ufgov, Inc.</p>
 * <p>Company: ufgov</p>
 * <p>����ʱ��: 2009-4-23</p>
 * @author ����ΰ(manlge)
 * @version 1.0
 */
public abstract class SingleDataDisplay extends AbstractDataDisplay {

  /**
   * @param tableDisplay ��ʾ��TableDisplay
   * @param conditionArea ȫ������������
   * @param showConditionArea Ҫ��ʾ������������
   */
  public SingleDataDisplay(TableDisplay tableDisplay, AbstractSearchConditionArea conditionArea,
    boolean showConditionArea, String prefId) {
    super(new TableDisplay[] { tableDisplay }, new TableDisplay[] { tableDisplay }, conditionArea,
      showConditionArea, prefId);
    addTabDisplayPanel(tableDisplay);
  }
  
  public SingleDataDisplay(TableDisplay tableDisplay, AbstractSearchConditionArea conditionArea,
    boolean showConditionArea, boolean firstRefresh,String prefId) {
    super(new TableDisplay[] { tableDisplay }, new TableDisplay[] { tableDisplay }, conditionArea,
      showConditionArea, firstRefresh,prefId);
    addTabDisplayPanel(tableDisplay);
  }

}
