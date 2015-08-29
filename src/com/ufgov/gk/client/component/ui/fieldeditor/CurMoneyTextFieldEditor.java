package com.ufgov.gk.client.component.ui.fieldeditor;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;

import com.ufgov.gk.client.component.MoneyField;
import com.ufgov.gk.common.commonbiz.model.BaseBill;

public class CurMoneyTextFieldEditor extends AbstractFieldEditor {
  private MoneyField field;

  private boolean allowMinus = true;

  public CurMoneyTextFieldEditor(String name) {
    super(name);
  }

  /**
   * @param allowMinus ����Ƿ��Ϊ����
   * @param name
   */
  public CurMoneyTextFieldEditor(boolean allowMinus, String name) {
    this.allowMinus = allowMinus;
    init(name);
  }

  /**
   * ���캯��
   * @param name
   * @param isEditable �Ƿ�ֻ��
   */
  public CurMoneyTextFieldEditor(String name, boolean isEditable) {
    init(name);
    this.field.setEditable(isEditable);
  }

  /**
   * ���캯��
   * @param name
   * @param isEditable �Ƿ�ֻ��
   */
  public CurMoneyTextFieldEditor(String name, boolean isEditable, boolean allowMinus) {
    this.allowMinus = allowMinus;
    init(name);
    this.field.setEditable(isEditable);
  }

  public Object getValue() {
    return field.getMoney();
  }

  public void setValue(Object value) { //��ѡ���������з����ı��ʱ�����������¼�
    if (value == null) {
      field.setMoney(null);
    } else if (value instanceof BaseBill) {
      BaseBill bill = (BaseBill) value;
        field.setMoney(bill.getCurMoney());
    }
  }

  protected JComponent createEditorComponent() { //��������Ŀؼ��������ı������ͬ����������
    field = new MoneyField(this.allowMinus);
    field.addKeyListener(new KeyAdapter() {
      public void keyReleased(KeyEvent e) {
        syncEditObject();
      }
    });
    return field;
  }

  protected void syncEditObject() {
    if (getEditObject() instanceof BaseBill) {
      BaseBill bill = (BaseBill) getEditObject();
      if (bill != null) {
        bill.setCurMoney(field.getMoney());
      }
    }
    this.fireEditSynced();
  }

  @Override
  public void setFieldEditorCode() {
    this.FieldEditorCode = FieldEditorCodeConstants.CUR_MONEY;
  }
}
