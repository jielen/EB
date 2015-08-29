package com.ufgov.gk.client.component.ui.conditionitem;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.ufgov.gk.client.component.event.ValueChangeEvent;
import com.ufgov.gk.client.component.event.ValueChangeListener;
import com.ufgov.gk.common.commonbiz.model.SearchCondition;
import com.ufgov.gk.common.system.dto.ElementConditionDto;

/**
 * <p>Title: GK</p>
 * <p>Description: 搜索条件项</p>
 * <p>Copyright: Copyright 2009 ufgov, Inc.</p>
 * <p>Company: ufgov</p>
 * <p>创建时间: 2009-4-20</p>
 * @author 刘永伟(manlge)
 * @version 1.0
 */
public abstract class AbstractSearchConditionItem extends JPanel {

  private String displayName;

  private JLabel displayLabel;

  private boolean display;

  /**
   * 与条件项对应的searchCondition
   */
  private SearchCondition searchCondition;

  /**
   * 编辑组件
   */
  private JComponent editorComponent;

  /**
   * 所在的条件区域
   */
  private Searchable searchConditionArea;

  /**
   * @param displayName 搜索条件项名称
   */
  public void init(String displayName) {
    this.displayName = displayName;
    addComponent();
  }

  private void addComponent() {
    setLayout(new FlowLayout(FlowLayout.LEFT, 2, 2));
    displayLabel = new JLabel(displayName + "：");
    displayLabel.setPreferredSize(new Dimension(100, 12));
    displayLabel.setHorizontalAlignment(JLabel.RIGHT);
    add(displayLabel);
    editorComponent = createEditorComponent();
    add(editorComponent);
  }

  /**
   * 创建编辑组件
   * @return
   */
  protected abstract JComponent createEditorComponent();

  /**
   * 返回编辑组件
   * @return
   */
  public JComponent getEditorComponent() {
    return editorComponent;
  }

  public void setPreferredSize(Dimension dimension) {
    this.editorComponent.setPreferredSize(dimension);
  }

  /**
   * 显示名称
   * @return
   */
  public String getDisplayName() {
    return displayName;
  }

  @Override
  public String toString() {
    return getDisplayName();
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((displayName == null) ? 0 : displayName.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    AbstractSearchConditionItem other = (AbstractSearchConditionItem) obj;
    if (displayName == null) {
      if (other.displayName != null)
        return false;
    } else if (!displayName.equals(other.displayName))
      return false;
    return true;
  }

  public Searchable getSearchConditionArea() {
    return searchConditionArea;
  }

  /**
   * 设置条件项所在的SearchConditionArea
   * @param searchConditionArea
   */
  public void setSearchConditionArea(Searchable searchConditionArea) {
    this.searchConditionArea = searchConditionArea;
  }

  /**
   * 执行搜索（整个搜索条件区）
   */
  protected void fireSearch() {
    if (searchConditionArea != null) {
      searchConditionArea.doSearch();
    }
  }

  public abstract void setValue(Object value);

  public abstract Object getValue();

  /**
   * 将当前值put到ElementConditionDto对象中
   * @param element
   */
  public void putToElementConditionDto(ElementConditionDto element) {
  }

  public SearchCondition getSearchCondition() {
    return searchCondition;
  }

  public void setSearchCondition(SearchCondition searchCondition) {
    this.searchCondition = searchCondition;
  }

  public JLabel getDisplayLabel() {
    return displayLabel;
  }

  public void setDisplayLabel(JLabel displayLabel) {
    this.displayLabel = displayLabel;
  }

  public void addValueChangeListener(ValueChangeListener l) {
    this.listenerList.add(ValueChangeListener.class, l);
  }

  public void removeValueChangeListener(ValueChangeListener l) {
    this.listenerList.remove(ValueChangeListener.class, l);
  }

  protected void fireValueChanged() {
    ValueChangeEvent e = null;
    ValueChangeListener[] listeners = listenerList.getListeners(ValueChangeListener.class);
    for (ValueChangeListener l : listeners) {
      if (e == null) {
        e = new ValueChangeEvent(this);
      }
      l.valueChanged(e);
    }
  }

  /**
   * @return the display
   */
  public boolean isDisplay() {
    return display;
  }

  /**
   * @param display the display to set
   */
  public void setDisplay(boolean display) {
    this.display = display;
  }
}
