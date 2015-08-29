package com.ufgov.gk.client.component.ui.conditionitem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JComponent;

import com.ufgov.gk.common.system.dto.ElementConditionDto;

/**
 * ȫ�����ǡ��� ����������
 * @author longrm
 */
public class YesNoAllComboBoxConditionItem extends AbstractSearchConditionItem {

  private static final long serialVersionUID = -3749506836206565655L;

  public JComboBox comboBox;

  public YesNoAllComboBoxConditionItem(String displayName) {
    init(displayName);
  }

  public YesNoAllComboBoxConditionItem(String displayName, Object defaultValue) {
    init(displayName);
    if (defaultValue != null)
      setValue(defaultValue);
  }

  @Override
  protected JComponent createEditorComponent() {
    if (comboBox == null) {
      comboBox = new JComboBox();
      comboBox.addItem("ȫ��");
      comboBox.addItem("��");
      comboBox.addItem("��");
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
    return comboBox.getSelectedIndex();
  }

  public Object getSelectValue() {
    return comboBox.getSelectedItem();
  }

  @Override
  public void setValue(Object value) {
    comboBox.setSelectedItem(value);
  }

  @Override
  public void putToElementConditionDto(ElementConditionDto element) {
    String isCreate = getValue().toString();
    if (isCreate.equals("0"))
      element.setIsCreateVou(null);
    else if (isCreate.equals("1"))
      element.setIsCreateVou("1");
    else if (isCreate.equals("2"))
      element.setIsCreateVou("0");
  }

}