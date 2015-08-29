package com.ufgov.gk.client.component.ui.conditionitem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;

import com.ufgov.gk.client.component.YesOrNoPrintComboBox;
import com.ufgov.gk.common.system.dto.ElementConditionDto;

public class YesOrNoPrintComboBoxConditionItem extends AbstractSearchConditionItem {
  public YesOrNoPrintComboBoxConditionItem(String displayName) {
    init(displayName);
  }

  public YesOrNoPrintComboBoxConditionItem(String displayName, Object defaultValue) {
    if (defaultValue != null) {
      defaultSelect = Integer.valueOf(defaultValue.toString().trim());
    }
    init(displayName);
  }

  public YesOrNoPrintComboBox printComboBox;

  private int defaultSelect = 2;

  @Override
  protected JComponent createEditorComponent() {
    if (printComboBox == null) {
      printComboBox = new YesOrNoPrintComboBox();
      printComboBox.setSelectedIndex(defaultSelect);
      printComboBox.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
          fireSearch();
          fireValueChanged();
        }
      });
    }
    return printComboBox;
  }

  @Override
  public void setValue(Object value) {
    printComboBox.setSelectedItem(value);
  }

  @Override
  public Object getValue() {
    return printComboBox.getSelectedItem();
  }

  public YesOrNoPrintComboBox getYesOrNoPrintComboBox() {
    return this.printComboBox;
  }

  public void putToElementConditionDto(ElementConditionDto element) {
    String value = (String) printComboBox.getSelectedItem();
    if (value.equals("Y")) {
      element.setPrintTimes(1);
    } else if (value.equals("N")) {
      element.setPrintTimes(0);
    } else {
      element.setPrintTimes(null);
    }

  }

}
