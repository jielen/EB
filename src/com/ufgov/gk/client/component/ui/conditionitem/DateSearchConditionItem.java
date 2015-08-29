package com.ufgov.gk.client.component.ui.conditionitem;

import java.awt.Dimension;
import java.util.Date;

import javax.swing.JComponent;

import com.ufgov.gk.client.component.DateField;
import com.ufgov.gk.client.component.event.ValueChangeEvent;
import com.ufgov.gk.client.component.event.ValueChangeListener;

/**
 * <p>Title: GK</p>
 * <p>Description:日期型式的搜索条件项</p>
 * <p>Copyright: Copyright 2009 ufgov, Inc.</p>
 * <p>Company: ufgov</p>
 * <p>创建时间: 2009-4-21</p>
 * @author 刘永伟(manlge)
 * @version 1.0
 */
public class DateSearchConditionItem extends AbstractSearchConditionItem {
  private DateField dateTextField;

  public DateSearchConditionItem(String displayName) {
    init(displayName);
  }

  public DateSearchConditionItem(String displayName, String dateString) {
    init(displayName);
    getDateTextField().setText(dateString);
  }

  @Override
  protected JComponent createEditorComponent() {
    return getDateTextField();
  }

  private DateField getDateTextField() {
    if (dateTextField == null) {
      dateTextField = new DateField();
      dateTextField.addValueChangeListener(new ValueChangeListener() {
        public void valueChanged(ValueChangeEvent e) {
          fireSearch();
          fireValueChanged();
        }
      });
      dateTextField.setPreferredSize(new Dimension(120, 20));
    }
    return dateTextField;
  }

  @Override
  public void setValue(Object value) {
    if (value == null || value instanceof String) {
      dateTextField.setText((String) value);
    }
  }

  public void setDate(Date date) {
    dateTextField.setDate(date);
  }

  @Override
  public Object getValue() {
    return dateTextField.getText();
  }

  public Date getDate() {
    return dateTextField.getDate();
  }

}
