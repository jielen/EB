package com.ufgov.gk.client.component.ui.conditionitem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;

import com.ufgov.gk.common.system.dto.ElementConditionDto;
import com.ufgov.smartclient.component.JComboBoxEx;

public class BalanceStatusConditionItem extends AbstractSearchConditionItem {

  private static final long serialVersionUID = -7395785099416302251L;

  private JComboBoxEx balanceStatusBox;

  public BalanceStatusConditionItem(String displayName, Object defaultValue) {
    init(displayName);
    setValue(defaultValue);
  }

  protected JComponent createEditorComponent() {

    balanceStatusBox = new JComboBoxEx();
    balanceStatusBox.setFocusable(false);
    balanceStatusBox.setPrototypeDisplayValue("AA");
    balanceStatusBox.addItem(null);
    balanceStatusBox.addItem("0");
    balanceStatusBox.addItemDisplaLable("0", "�����");
    balanceStatusBox.addItem("1");
    balanceStatusBox.addItemDisplaLable("1", "�����");

    balanceStatusBox.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        fireSearch();
        fireValueChanged();
      }
    });

    return balanceStatusBox;
  }

  public Object getValue() {
    return balanceStatusBox.getSelectedItem();
  }

  public void setValue(Object value) {
    balanceStatusBox.setSelectedItem(value);
  }

  public void putToElementConditionDto(ElementConditionDto element) {

    element.setBalanceStatus((String) balanceStatusBox.getSelectedItem());

  }

}
