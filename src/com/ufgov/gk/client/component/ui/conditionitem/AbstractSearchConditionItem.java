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
 * <p>Description: ����������</p>
 * <p>Copyright: Copyright 2009 ufgov, Inc.</p>
 * <p>Company: ufgov</p>
 * <p>����ʱ��: 2009-4-20</p>
 * @author ����ΰ(manlge)
 * @version 1.0
 */
public abstract class AbstractSearchConditionItem extends JPanel {

  private String displayName;

  private JLabel displayLabel;

  private boolean display;

  /**
   * ���������Ӧ��searchCondition
   */
  private SearchCondition searchCondition;

  /**
   * �༭���
   */
  private JComponent editorComponent;

  /**
   * ���ڵ���������
   */
  private Searchable searchConditionArea;

  /**
   * @param displayName ��������������
   */
  public void init(String displayName) {
    this.displayName = displayName;
    addComponent();
  }

  private void addComponent() {
    setLayout(new FlowLayout(FlowLayout.LEFT, 2, 2));
    displayLabel = new JLabel(displayName + "��");
    displayLabel.setPreferredSize(new Dimension(100, 12));
    displayLabel.setHorizontalAlignment(JLabel.RIGHT);
    add(displayLabel);
    editorComponent = createEditorComponent();
    add(editorComponent);
  }

  /**
   * �����༭���
   * @return
   */
  protected abstract JComponent createEditorComponent();

  /**
   * ���ر༭���
   * @return
   */
  public JComponent getEditorComponent() {
    return editorComponent;
  }

  public void setPreferredSize(Dimension dimension) {
    this.editorComponent.setPreferredSize(dimension);
  }

  /**
   * ��ʾ����
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
   * �������������ڵ�SearchConditionArea
   * @param searchConditionArea
   */
  public void setSearchConditionArea(Searchable searchConditionArea) {
    this.searchConditionArea = searchConditionArea;
  }

  /**
   * ִ������������������������
   */
  protected void fireSearch() {
    if (searchConditionArea != null) {
      searchConditionArea.doSearch();
    }
  }

  public abstract void setValue(Object value);

  public abstract Object getValue();

  /**
   * ����ǰֵput��ElementConditionDto������
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
