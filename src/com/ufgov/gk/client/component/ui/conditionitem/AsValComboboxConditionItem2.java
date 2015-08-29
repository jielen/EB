package com.ufgov.gk.client.component.ui.conditionitem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;

import com.ufgov.gk.client.component.AsValComboBox;

public class AsValComboboxConditionItem2 extends AbstractSearchConditionItem {
  public AsValComboboxConditionItem2(String displayName,String valSetId) {
    this.valSetId=valSetId;
    init(displayName);
  }

  private String valSetId;

  public AsValComboBox comboBox;

  protected JComponent createEditorComponent() {
    if (comboBox == null) {
      comboBox = new AsValComboBox(true,valSetId);
      comboBox.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
          fireSearch();
          fireValueChanged();
        }
      });
    }
    return comboBox;
  }

  public void setValue(Object value) {
    comboBox.setSelectedItem(value);
  }
  public void setValueByCode(String code){
    comboBox.setSelectedAsValByCode(code);
  }

  @Override
  public Object getValue() {
    return comboBox.getSelectedItem();
  }

}
