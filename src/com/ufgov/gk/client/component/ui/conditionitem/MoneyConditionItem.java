package com.ufgov.gk.client.component.ui.conditionitem;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;

import javax.swing.JComponent;
import javax.swing.JPanel;

import com.ufgov.gk.client.component.MoneyField;
import com.ufgov.gk.common.system.dto.ElementConditionDto;
import com.ufgov.smartclient.component.JComboBoxEx;


public class MoneyConditionItem extends AbstractSearchConditionItem {

  private static final long serialVersionUID = -7395785099416302251L;

  public MoneyField selectField;
  public JComboBoxEx operatorBox;
  public MoneyConditionItem(String displayName) {
    init(displayName);
  }

  public MoneyConditionItem(String displayName, Object defaultValue) {
    init(displayName);
    setValue(defaultValue);
  }

  @Override
  protected JComponent createEditorComponent() {
      selectField = new MoneyField(20){
        public BigDecimal getMoney() {
          String s = this.getText();
          if (s == null || "".equals(s.trim())) {
            return null;
          } else {
            return new BigDecimal(s);
          }
        }
      };

      selectField.addKeyListener(new KeyAdapter() {

        @Override
        public void keyPressed(KeyEvent e) {
          if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            fireSearch();
            fireValueChanged();
          }
        }
      });

      JPanel panel = new JPanel(new GridLayout(1, 2, 0, 0));
      operatorBox= new JComboBoxEx();
      operatorBox.setFocusable(false);
      operatorBox.setPrototypeDisplayValue("AAAA");

      operatorBox.addItem(">");
      operatorBox.addItemDisplaLable(">", "大于");
      operatorBox.addItem("=");
      operatorBox.addItemDisplaLable("=", "等于");

      operatorBox.addItem("<");
      operatorBox.addItemDisplaLable("<", "小于");
      panel.setMinimumSize(new Dimension(75, 20));
      panel.add(operatorBox);
      panel.add(selectField);

      operatorBox.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        fireSearch();
        fireValueChanged();
      }
    });

    return panel;
  }

  @Override
  public Object getValue() {
    return selectField.getMoney();
  }

  @Override
  public void setValue(Object value) {
    selectField.setMoney((BigDecimal)value);
  }

  @Override
  public void putToElementConditionDto(ElementConditionDto element) {
    element.setOrgMoney(selectField.getMoney());
    element.setOrgMoneyOperator((String)operatorBox.getSelectedItem());
  }

}
