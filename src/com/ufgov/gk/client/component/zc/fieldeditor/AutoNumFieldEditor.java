package com.ufgov.gk.client.component.zc.fieldeditor;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JTextField;

import com.ufgov.gk.client.component.RegexDocument;
import com.ufgov.gk.client.component.ui.fieldeditor.AbstractFieldEditor;
import com.ufgov.gk.common.commonbiz.model.BaseBill;
import com.ufgov.gk.common.system.util.BeanUtil;

public class AutoNumFieldEditor extends AbstractFieldEditor {
  /**
   * 
   */
  private static final long serialVersionUID = -9126316741134675929L;

  private JTextField field;

  private int maxLength = 60;

  public AutoNumFieldEditor(String name, String fieldName) {
    this.fieldName = fieldName;
    init(name);
  }

  public AutoNumFieldEditor(String name, String fieldName, int maxLength) {
    this.fieldName = fieldName;
    this.maxLength = maxLength;
    init(name);
  }

  public AutoNumFieldEditor(String name, String fieldName, boolean isEditable) {
    this.fieldName = fieldName;
    init(name);
    this.field.setEditable(isEditable);
  }

  public Object getValue() {
    return field.getText();
  }

  public void setValue(Object value) { //��ѡ���������з����ı��ʱ�����������¼�
    if (value == null) {
      field.setText(null);
      field.setToolTipText(null);
    } else if (value instanceof BaseBill) {
      String v = (String) BeanUtil.get(fieldName, value);
      if (v == null || v.trim().equals("")) {
        field.setText("�Զ����");
        field.setToolTipText("�Զ����");
      } else {
        field.setText(v);
        field.setToolTipText(v);
      }
    }
  }

  protected JComponent createEditorComponent() { //��������Ŀؼ��������ı������ͬ����������
    field = new JTextField(45);
    RegexDocument rd = new RegexDocument();
    rd.setMaxLength(this.maxLength);
    field.setDocument(rd);
    field.setEditable(false);
    //field.setEnabled(false);
    field.addKeyListener(new KeyAdapter() {
      public void keyReleased(KeyEvent e) {
        syncEditObject();
      }
    });
    return field;
  }

  protected void syncEditObject() {
    if (getEditObject() != null && field.getText() != null && !"�Զ����".equals(field.getText())) {
      BeanUtil.set(fieldName, field.getText(), getEditObject());
    }
    this.fireEditSynced();
  }

  public void setEnabled(boolean enabled) {
  }

}
