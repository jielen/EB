package com.ufgov.gk.client.component.ui.conditionitem;

import java.awt.Dimension;
import java.util.Date;

import javax.swing.JComponent;

import com.ufgov.gk.client.component.DateField;
import com.ufgov.gk.client.component.event.ValueChangeEvent;
import com.ufgov.gk.client.component.event.ValueChangeListener;
import com.ufgov.gk.common.system.dto.ElementConditionDto;

public class DateConditionItem extends AbstractSearchConditionItem {
  public DateField dateTextField;

  public DateConditionItem(String displayName) {
    init(displayName);
  }

  public DateConditionItem(String displayName, String dateString) {
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

  @Override
  public Object getValue() {
    return dateTextField.getText();
  }

  public void setDate(Date date) {
    dateTextField.setDate(date);
  }

  public Date getDate() {
    return dateTextField.getDate();
  }

  @Override
  public void putToElementConditionDto(ElementConditionDto element) {
    element.setPayDate(dateTextField.getDate());
  }
}
