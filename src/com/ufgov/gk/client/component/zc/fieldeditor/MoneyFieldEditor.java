package com.ufgov.gk.client.component.zc.fieldeditor;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;

import javax.swing.JComponent;

import com.ufgov.gk.client.component.MoneyField;
import com.ufgov.gk.client.component.ui.fieldeditor.AbstractFieldEditor;
import com.ufgov.gk.common.commonbiz.model.BaseBill;
import com.ufgov.gk.common.system.util.BeanUtil;

public class MoneyFieldEditor extends AbstractFieldEditor {
  private MoneyField field;

  private boolean allowMinus = true;

  private int zeroLength = 2;

  public MoneyFieldEditor(String name, String fieldName) {
    this.fieldName = fieldName;
    init(name);
  }

  public MoneyFieldEditor(String name, String fieldName, int zeroLength) {
    this.fieldName = fieldName;
    this.zeroLength = zeroLength;
    init(name);
  }

  /**
   * @param allowMinus ����Ƿ��Ϊ����
   * @param name
   */
  public MoneyFieldEditor(boolean allowMinus, String name, String fieldName) {
    this.fieldName = fieldName;
    this.allowMinus = allowMinus;
    init(name);
  }

  public MoneyFieldEditor(boolean allowMinus, String name, String fieldName, int zeroLength) {
    this.fieldName = fieldName;
    this.allowMinus = allowMinus;
    this.zeroLength = zeroLength;
    init(name);
  }

  /**
   * ���캯��
   * @param name
   * @param isEditable �Ƿ�ֻ��
   */
  public MoneyFieldEditor(String name, boolean isEditable, String fieldName) {
    this.fieldName = fieldName;
    init(name);
    this.field.setEditable(isEditable);
  }

  public MoneyFieldEditor(String name, boolean isEditable, String fieldName, int zeroLength) {
    this.fieldName = fieldName;
    this.zeroLength = zeroLength;
    init(name);
    this.field.setEditable(isEditable);
  }

  /**
   * ���캯��
   * @param name
   * @param isEditable �Ƿ�ֻ��
   */
  public MoneyFieldEditor(String name, boolean isEditable, boolean allowMinus, String fieldName) {
    this.fieldName = fieldName;
    this.allowMinus = allowMinus;
    init(name);
    this.field.setEditable(isEditable);
  }

  public MoneyFieldEditor(String name, boolean isEditable, boolean allowMinus, String fieldName, int zeroLength) {
    this.fieldName = fieldName;
    this.allowMinus = allowMinus;
    this.zeroLength = zeroLength;
    init(name);
    this.field.setEditable(isEditable);
  }

  public void setEnabled(boolean enabled) {
    field.setEditable(enabled);
    field.setEnabled(enabled);
  }

  public Object getValue() {
    return field.getMoney();
  }

  public void setValue(Object value) { //��ѡ���������з����ı��ʱ�����������¼�
    if (value == null) {
      field.setMoney(null);
    } else if (value instanceof BaseBill) {
      BigDecimal v = (BigDecimal) BeanUtil.get(fieldName, value);
      field.setMoney(v);
    }
  }

  protected JComponent createEditorComponent() { //��������Ŀؼ��������ı������ͬ����������
    field = new MoneyField(this.allowMinus, zeroLength);
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
      BeanUtil.set(fieldName, field.getMoney(), bill);
    }
    this.fireEditSynced();
  }

  public MoneyField getMoneyField() {
    return this.field;
  }

  public void fireEditSynced() {
    super.fireEditSynced();
  }
}
