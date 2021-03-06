package com.ufgov.gk.client.component.ui.conditionitem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;

import com.ufgov.gk.client.component.AsValComboBox;
import com.ufgov.gk.common.system.model.AsVal;

public class BbAstatusCodeConditionItem extends AbstractSearchConditionItem {

  private static final long serialVersionUID = -6100840449408322085L;

  private AsValComboBox comboBox;

  public BbAstatusCodeConditionItem(String displayName) {
    init(displayName);
  }

  public BbAstatusCodeConditionItem(String displayName, Object defaultValue) {
    init(displayName);
    if (defaultValue != null) {
      setValue(defaultValue);
    }
  }

  @Override
  protected JComponent createEditorComponent() {
    comboBox = new AsValComboBox("VS_BB_STATUS", false);

    AsVal asval = new AsVal();
    asval.setValId("5");
    asval.setVal("ȫ��");
    comboBox.addItem(asval);
    comboBox.addItemDisplaLable(asval, asval.getVal());

    comboBox.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        fireSearch();
        fireValueChanged();
      }
    });
    return comboBox;
  }

  @Override
  public Object getValue() {
    AsVal asVal = (AsVal) comboBox.getSelectedItem();
    return asVal == null ? null : asVal.getValId();
  }

  @Override
  public void setValue(Object value) {
    String optId = (String) value;
    comboBox.setSelectedAsValByCode(optId == null ? null : optId);
  }
}
