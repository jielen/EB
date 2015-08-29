package com.ufgov.gk.client.component.ui.conditionitem;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JTextField;

import com.ufgov.gk.common.system.dto.ElementConditionDto;
import com.ufgov.gk.common.system.util.BeanUtil;

public class TextConditionItem extends AbstractSearchConditionItem {

  private static final long serialVersionUID = -7395785099416302251L;

  public JTextField selectField;

  private String fieldName;

  public TextConditionItem(String displayName, String fieldName) {
    this.fieldName = fieldName;
    init(displayName);
  }

  public TextConditionItem(String displayName, Object defaultValue, String fieldName) {
    this.fieldName = fieldName;
    init(displayName);
    setValue(defaultValue);
  }

  @Override
  protected JComponent createEditorComponent() {
    selectField = new JTextField(20);

    selectField.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
          fireSearch();
          fireValueChanged();
        }
      }
    });
    return selectField;
  }

  @Override
  public Object getValue() {
    return null;
  }

  @Override
  public void setValue(Object value) {
  }

  @Override
  public void putToElementConditionDto(ElementConditionDto element) {
    BeanUtil.set(fieldName, selectField.getText().trim().equals("")?null:selectField.getText().trim(), element);
  }

}
