package com.ufgov.gk.client.component.zc.fieldeditor;

import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.Serializable;

import javax.swing.JComponent;
import javax.swing.JTextField;

import com.ufgov.gk.client.component.RegexDocument;
import com.ufgov.gk.client.component.ui.fieldeditor.AbstractFieldEditor;
import com.ufgov.gk.common.commonbiz.model.BaseBill;
import com.ufgov.gk.common.system.util.BeanUtil;

public class TextFieldEditor extends AbstractFieldEditor {
  /**
   * 
   */
  private static final long serialVersionUID = -9126316741144675929L;

  private JTextField field;

  //  private int maxLength = 60;

  public TextFieldEditor(String name, String fieldName) {
    this.fieldName = fieldName;
    this.maxContentSize = 60;
    init(name);
  }

  public TextFieldEditor(String name, String fieldName, int maxLength) {
    this.fieldName = fieldName;
    this.maxContentSize = maxLength;
    init(name);
  }

  public TextFieldEditor(String name, String fieldName, boolean isEditable) {
    this.fieldName = fieldName;
    this.maxContentSize = 60;
    init(name);
    this.field.setEditable(isEditable);
  }

  public TextFieldEditor(String name, String fieldName, int occCol, boolean isEditable) {
    this.fieldName = fieldName;
    this.occCol = occCol;
    this.maxContentSize = 60;
    init(name);
    this.field.setEditable(isEditable);
  }

  public Object getValue() {
    return field.getText();
  }

  public void setValue(Object value) { //��ѡ���������з����ı��ʱ�����������¼�
  //    System.out.println(fieldName);
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

  protected JComponent createEditorComponent() { //��������Ŀؼ��������ı������ͬ����������
    field = new JTextField(45);
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
      if ("".equals(field.getText())) {
        BeanUtil.set(fieldName, null, getEditObject());
      } else {
        BeanUtil.set(fieldName, field.getText(), getEditObject());
      }
    }
    this.fireEditSynced();
  }

  public void setEnabled(boolean enabled) {
    field.setEditable(enabled);
    //field.setEnabled(enabled);
  }

}
