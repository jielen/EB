package com.ufgov.gk.client.component.ui.conditionitem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;

import com.ufgov.gk.client.component.AsValComboBox;
import com.ufgov.gk.common.system.dto.ElementConditionDto;
import com.ufgov.gk.common.system.model.AsVal;

public class TzdBillTypeComboboxConditionItem extends AbstractSearchConditionItem {

  private static final long serialVersionUID = -3749506836206565655L;

  private AsValComboBox comboBox;

  public TzdBillTypeComboboxConditionItem(String displayName) {
    init(displayName);
  }

  public TzdBillTypeComboboxConditionItem(String displayName, Object defaultValue) {
    init(displayName);
    if (defaultValue != null)
      setValue(defaultValue);
  }

  @Override
  protected JComponent createEditorComponent() {
    if (comboBox == null) {
      comboBox = new AsValComboBox("VS_TZD_BILL_TYPE", false);
    }
    comboBox.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        fireSearch();
        fireValueChanged();
      }
    });
    return comboBox;
  }

  @Override
  public Object getValue() {
    return (AsVal) comboBox.getSelectedItem();
  }

  @Override
  public void setValue(Object value) {
    comboBox.setSelectedItem(value);
  }

  @Override
  public void putToElementConditionDto(ElementConditionDto element) {
    AsVal asVal = (AsVal) getValue();
    if (asVal.getValId().equals("0")) {
      element.setBillType(null);//全部
    } else if (asVal.getValId().equals("1")) {
      element.setBillType("1");//调整
    } else if (asVal.getValId().equals("2")) {
      element.setBillType("2");//往来
    } else if (asVal.getValId().equals("3")) {
      element.setBillType("3");//预拨
    }
  }

}
