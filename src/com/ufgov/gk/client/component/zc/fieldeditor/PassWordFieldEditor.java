package com.ufgov.gk.client.component.zc.fieldeditor;

import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.Serializable;

import javax.swing.JComponent;
import javax.swing.JPasswordField;

import com.ufgov.gk.client.component.RegexDocument;
import com.ufgov.gk.client.component.ui.fieldeditor.AbstractFieldEditor;
import com.ufgov.gk.common.commonbiz.model.BaseBill;
import com.ufgov.gk.common.system.util.BeanUtil;

public class PassWordFieldEditor extends AbstractFieldEditor {

  private JPasswordField field;

  //  private int maxLength = 60;

  public PassWordFieldEditor(String name, String fieldName) {
    this.fieldName = fieldName;
    this.maxContentSize = 60;
    init(name);
  }

  public PassWordFieldEditor(String name, String fieldName, int maxLength) {
    this.fieldName = fieldName;
    this.maxContentSize = maxLength;
    init(name);
  }

  public PassWordFieldEditor(String name, String fieldName, boolean isEditable) {
    this.fieldName = fieldName;
    this.maxContentSize = 60;
    init(name);
    this.field.setEditable(isEditable);
  }

  public PassWordFieldEditor(String name, String fieldName, int occCol, boolean isEditable) {
    this.fieldName = fieldName;
    this.occCol = occCol;
    this.maxContentSize = 60;
    init(name);
    this.field.setEditable(isEditable);
  }

  public Object getValue() {
    return field.getPassword();
  }

  public void setValue(Object value) { //在选择的上面的行发生改变的时候所触发的事件
    if (value == null) {
      field.setText(null);
      field.setToolTipText(null);
    } else if (value instanceof BaseBill) {
      String v = (String) BeanUtil.get(fieldName, value);
      field.setText(v);
      if (v == null || v.trim().equals("")) {
        field.setToolTipText(null);
      } else {
        field.setToolTipText(v);
      }
    } else if (value instanceof Serializable) {
      String v = (String) BeanUtil.get(fieldName, value);
      field.setText(v);
      if (v == null || v.trim().equals("")) {
        field.setToolTipText(null);
      } else {
        field.setToolTipText(v);
      }
    }
  }

  protected JComponent createEditorComponent() { //生成下面的控件，并将改变的内容同步到对象中
    field = new JPasswordField(45);
    RegexDocument rd = new RegexDocument();
    rd.setMaxLength(this.maxContentSize);
    field.setDocument(rd);
    field.addKeyListener(new KeyAdapter() {
      public void keyReleased(KeyEvent e) {
        syncEditObject();
      }
    });
    if (this.occCol > 1) {
      field.setPreferredSize(new Dimension(120 * this.occCol, 24));
    }
    return field;
  }

  protected void syncEditObject() {
    if (getEditObject() != null) {
      if ("".equals(field.getPassword())) {
        BeanUtil.set(fieldName, null, getEditObject());
      } else {
        BeanUtil.set(fieldName, field.getPassword(), getEditObject());
      }
    }
    this.fireEditSynced();
  }

  public void setEnabled(boolean enabled) {
    field.setEditable(enabled);
    //field.setEnabled(enabled);
  }

}
