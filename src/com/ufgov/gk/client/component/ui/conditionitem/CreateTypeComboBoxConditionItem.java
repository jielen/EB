package com.ufgov.gk.client.component.ui.conditionitem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JComponent;

import com.ufgov.gk.common.system.dto.ElementConditionDto;

public class CreateTypeComboBoxConditionItem extends AbstractSearchConditionItem {

  private static final long serialVersionUID = -2555370855456075787L;

  private JComboBox comboBox;

  public CreateTypeComboBoxConditionItem(String displayName) {
    init(displayName);
  }

  public CreateTypeComboBoxConditionItem(String displayName, Object defaultValue) {
    init(displayName);
    if(defaultValue!=null)
      setValue(defaultValue);
  }

  @Override
  protected JComponent createEditorComponent() {
    if(comboBox==null) {
      comboBox = new JComboBox();
      comboBox.addItem("����");
      comboBox.addItem("����");
      comboBox.addItem("Ԥ��");
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
    return comboBox.getSelectedItem();
  }

  @Override
  public void setValue(Object value) {
    comboBox.setSelectedItem(value);
  }

  // ������
  public void putToElementConditionDto(ElementConditionDto element) {
    String type = getValue().toString();
//    if(type.equals("����"))
//      element.setIsCreateVou(null);
//    else if(type.equals("����"))
//      element.setIsCreateVou("1");
//    else if(type.equals("Ԥ��"))
//      element.setIsCreateVou("0");
  }

}
