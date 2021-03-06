package com.ufgov.gk.client.component.ui;

/**
 * <p>Title: GK53</p>
 * <p>Description: 单表格的DataDisplay</p>
 * <p>Copyright: Copyright 2009 ufgov, Inc.</p>
 * <p>Company: ufgov</p>
 * <p>创建时间: 2009-4-23</p>
 * @author 刘永伟(manlge)
 * @version 1.0
 */
public abstract class SingleDataDisplay extends AbstractDataDisplay {

  /**
   * @param tableDisplay 显示的TableDisplay
   * @param conditionArea 全部搜索条件区
   * @param showConditionArea 要显示的搜索条件区
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
