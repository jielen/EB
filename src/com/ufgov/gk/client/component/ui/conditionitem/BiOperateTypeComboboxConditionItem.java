package com.ufgov.gk.client.component.ui.conditionitem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;

import com.ufgov.gk.client.component.AsValComboBox;
import com.ufgov.gk.common.system.dto.ElementConditionDto;
import com.ufgov.gk.common.system.model.AsVal;

public class BiOperateTypeComboboxConditionItem extends AbstractSearchConditionItem {

  private static final long serialVersionUID = -8335596582303595699L;

  private AsValComboBox comboBox;

  public BiOperateTypeComboboxConditionItem(String displayName) {
    init(displayName);
  }

  public BiOperateTypeComboboxConditionItem(String displayName, Object defaultValue) {
    init(displayName);
    if (defaultValue != null)
      setValue(defaultValue);
  }

  @Override
  protected JComponent createEditorComponent() {
    if (comboBox == null) {
      comboBox = new AsValComboBox("VS_BI_OPERATE_TYPE", true);
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

  public AsValComboBox getAsValComboBox(){
   return  this.comboBox;
  }

  @Override
  public void putToElementConditionDto(ElementConditionDto element) {
    AsVal asVal = (AsVal) getValue();
    element.setUseType(asVal == null ? null : asVal.getValId());
  }

}
