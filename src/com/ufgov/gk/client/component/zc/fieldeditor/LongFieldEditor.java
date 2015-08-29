package com.ufgov.gk.client.component.zc.fieldeditor;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JTextField;

import com.ufgov.gk.client.component.RegexDocument;
import com.ufgov.gk.client.component.ui.fieldeditor.AbstractFieldEditor;
import com.ufgov.gk.common.commonbiz.model.BaseBill;
import com.ufgov.gk.common.system.util.BeanUtil;

public class LongFieldEditor extends AbstractFieldEditor {
  /**
   * 
   */
  private static final long serialVersionUID = -9126316741144675929L;

  private JTextField field;

  private boolean minusAllow = false;

  public LongFieldEditor(String name, String fieldName) {
    this.fieldName = fieldName;
    init(name);
  }

  public LongFieldEditor(String name, boolean minusAllow, String fieldName) {
    this.fieldName = fieldName;
    this.minusAllow = minusAllow;
    init(name);
  }

  public LongFieldEditor(String name, String fieldName, boolean isEditable) {
    this.fieldName = fieldName;
    init(name);
    this.field.setEditable(isEditable);
  }

  public Object getValue() {
    Long obj = Long.valueOf(field.getText());
    return obj;
  }

  public void setValue(Object value) { //在选择的上面的行发生改变的时候所触发的事件
    if (value == null) {
      field.setText(null);
      field.setToolTipText(null);
    } else if (value instanceof BaseBill) {
      Long v = (Long) BeanUtil.get(fieldName, value);
      String vs = "";
      if (v != null) {
        vs = v.toString();
      }
      field.setText(vs);

    }
  }

  protected JComponent createEditorComponent() { //生成下面的控件，并将改变的内容同步到对象中
    field = new JTextField(45);
    RegexDocument rd = new RegexDocument();
    String regex = "[0-9]*";
    if (minusAllow) {
      regex = "-?" + regex;
    }
    rd.setRegex(regex);
    field.setDocument(rd);
    field.addKeyListener(new KeyAdapter() {
      public void keyReleased(KeyEvent e) {
        syncEditObject();
      }
    });
    field.setHorizontalAlignment(JTextField.RIGHT);
    return field;
  }

  protected void syncEditObject() {
    if (getEditObject() != null) {
      String text = field.getText();
      Long v = null;
      if (!"".equals(text.trim())) {
        v = new Long(text.trim());
      }
      BeanUtil.set(fieldName, v, getEditObject());
    }
    this.fireEditSynced();
  }

  public void setEnabled(boolean enabled) {
    field.setEditable(enabled);
    field.setEnabled(enabled);
  }

}
