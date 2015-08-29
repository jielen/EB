package com.ufgov.gk.client.component.zc.fieldeditor;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;

import javax.swing.JComponent;

import com.ufgov.gk.client.component.FractionDigitsField;
import com.ufgov.gk.client.component.ui.fieldeditor.AbstractFieldEditor;
import com.ufgov.gk.common.commonbiz.model.BaseBill;
import com.ufgov.gk.common.system.util.BeanUtil;

public class FractionDigitsFieldEditor extends AbstractFieldEditor {
  private static final long serialVersionUID = -8816384590773625042L;

  private FractionDigitsField field;

  private int length;

  private boolean allowMinus = true;

  public FractionDigitsFieldEditor(String name, String fieldName) {
    this.fieldName = fieldName;
    init(name);
  }

  /**
   * @param allowMinus �Ƿ��Ϊ����
   * @param name
   */
  public FractionDigitsFieldEditor(boolean allowMinus, String name, String fieldName) {
    this.fieldName = fieldName;
    this.allowMinus = allowMinus;
    init(name);
  }

  /**
   * @param allowMinus �Ƿ��Ϊ����
   * @param length С��λ����
   */
  public FractionDigitsFieldEditor(boolean allowMinus, String name, String fieldName, int length) {
    this.fieldName = fieldName;
    this.allowMinus = allowMinus;
    this.length = length;
    init(name);
  }

  /**
   * ���캯��
   * @param name
   * @param isEditable �Ƿ�ֻ��
   */
  public FractionDigitsFieldEditor(String name, boolean isEditable, String fieldName) {
    this.fieldName = fieldName;
    init(name);
    this.field.setEditable(isEditable);
  }

  /**
   * ���캯��
   * @param name
   * @param isEditable �Ƿ�ֻ��
   */
  public FractionDigitsFieldEditor(String name, boolean isEditable, boolean allowMinus, String fieldName) {
    this.fieldName = fieldName;
    this.allowMinus = allowMinus;
    init(name);
    this.field.setEditable(isEditable);
  }

  public void setEnabled(boolean enabled) {
    field.setEditable(enabled);
  }

  public Object getValue() {
    return field.getValue();
  }

  public void setValue(Object value) { //��ѡ���������з����ı��ʱ�����������¼�
    if (value == null) {
      field.setValue(null);
    } else if (value instanceof BaseBill) {
      BigDecimal v = (BigDecimal) BeanUtil.get(fieldName, value);
      field.setValue(v);
    }
  }

  protected JComponent createEditorComponent() { //��������Ŀؼ��������ı������ͬ����������
    field = new FractionDigitsField(this.allowMinus, length);
    field.addKeyListener(new KeyAdapter() {
      public void keyReleased(KeyEvent e) {
        syncEditObject();
      }
    });
    return field;
  }

  protected void syncEditObject() {
    BaseBill bill = (BaseBill) getEditObject();
    if (bill != null) {
      BeanUtil.set(fieldName, field.getValue(), bill);
    }
    this.fireEditSynced();
  }

}
