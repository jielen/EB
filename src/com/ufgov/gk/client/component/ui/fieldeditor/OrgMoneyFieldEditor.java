package com.ufgov.gk.client.component.ui.fieldeditor;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;

import javax.swing.JComponent;

import com.ufgov.gk.client.component.MoneyField;
import com.ufgov.gk.common.commonbiz.model.BaseBill;

public class OrgMoneyFieldEditor extends AbstractFieldEditor {
  private MoneyField field;

  private boolean allowMinus = true;

  public OrgMoneyFieldEditor(String name) {
    super(name);
  }

  /**
   * @param allowMinus 金额是否可为负数
   * @param name
   */
  public OrgMoneyFieldEditor(boolean allowMinus, String name) {
    super(name);
    this.allowMinus = allowMinus;
  }

  /**
   * 构造函数
   * @param name
   * @param isEditable 是否只读
   */
  public OrgMoneyFieldEditor(String name, boolean isEditable) {
    init(name);
    this.field.setEditable(isEditable);
  }
  
  public void setEnabled(boolean isEnabled) {
    this.field.setEditable(isEnabled);
    this.field.setEnabled(isEnabled);
  }

  /**
   * 构造函数
   * @param name
   * @param isEditable 是否只读
   */
  public OrgMoneyFieldEditor(String name, boolean isEditable, boolean allowMinus) {
    this.allowMinus = allowMinus;
    init(name);
    this.field.setEditable(isEditable);
  }

  public Object getValue() {
    return field.getMoney();
  }

  public void setMoney(BigDecimal money){
    field.setMoney(money);
    syncEditObject();
  }
  
  public void setValue(Object value) { //在选择的上面的行发生改变的时候所触发的事件
    if (value == null) {
      field.setMoney(null);
    } else if (value instanceof BaseBill) {
      BaseBill bill = (BaseBill) value;
        field.setMoney(bill.getOrgMoney());
    }
  }

  protected JComponent createEditorComponent() { //生成下面的控件，并将改变的内容同步到对象中
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
        bill.setOrgMoney(field.getMoney());
        bill.setCurMoney(field.getMoney());
      }
    }
    this.fireEditSynced();
  }

  public void setFieldEditorCode() {
    this.FieldEditorCode = FieldEditorCodeConstants.ORG_MONEY;
  }
}
