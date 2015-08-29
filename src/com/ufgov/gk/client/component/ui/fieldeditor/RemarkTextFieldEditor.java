package com.ufgov.gk.client.component.ui.fieldeditor;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JTextField;

import com.ufgov.gk.client.common.AsOptionMeta;
import com.ufgov.gk.client.component.RegexDocument;
import com.ufgov.gk.common.commonbiz.model.BaseBill;
import com.ufgov.gk.common.system.constants.BusinessOptionConstants;

public class RemarkTextFieldEditor extends AbstractFieldEditor {
  private JTextField field;

  private int remarkMaxLength;

  public RemarkTextFieldEditor(String name) {
    super(name);
  }

  public RemarkTextFieldEditor(String name, boolean isEditable) {
    super(name);
    this.field.setEditable(isEditable);
  }

  public Object getValue() {
    return field.getText();
  }

  public void setValue(Object value) { //��ѡ���������з����ı��ʱ�����������¼�
    if (value == null || value instanceof String) {
      field.setText((String) value);
    } else if (value instanceof BaseBill) {
      BaseBill bill = (BaseBill) value;
      field.setText(bill.getRemark());
      return;
    }
  }

  protected JComponent createEditorComponent() { //��������Ŀؼ��������ı������ͬ����������
    field = new JTextField();
    String remarkLength = AsOptionMeta.getOptVal(BusinessOptionConstants.OPT_REMARK_LENGTH);
    this.remarkMaxLength = "".equals(remarkLength) ? 0 : Integer.parseInt(remarkLength);
    if (this.remarkMaxLength > 0) {
      RegexDocument rd = new RegexDocument();
      rd.setMaxLength(this.remarkMaxLength);
      field.setDocument(rd);
    }
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
        String fieldValue = field.getText();
        if (fieldValue != null) {
          bill.setRemark(fieldValue);
        } else {
          bill.setRemark(null);
        }
      }
    }
    this.fireEditSynced();
  }

  public void setFieldEditorCode() {
    this.FieldEditorCode = FieldEditorCodeConstants.REMARK;
  }
}
