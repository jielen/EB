package com.ufgov.gk.client.component.ui.conditionitem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;

import com.ufgov.gk.client.component.MonthComboBox;

public class MonthComboboxConditionItem extends AbstractSearchConditionItem {
  public MonthComboboxConditionItem(String displayName) {
    init(displayName);
  }

  private MonthComboBox monthComboBox;

  protected JComponent createEditorComponent() {
    if (monthComboBox == null) {
      monthComboBox = new MonthComboBox();
      monthComboBox.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          fireSearch();
          fireValueChanged();
        }
      });
    }
    return monthComboBox;
  }

  public void setValue(Object value) {
    monthComboBox.setSelectedItem(value);
  }
  public Object getValue() {
    return monthComboBox.getSelectedItem();
  }
  public void setValueByCode(String code ){
    monthComboBox.setSelectedAsValByCode(code);
  }

}
