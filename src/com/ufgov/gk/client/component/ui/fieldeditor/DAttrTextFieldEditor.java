package com.ufgov.gk.client.component.ui.fieldeditor;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JTextField;

import com.ufgov.gk.common.commonbiz.model.BaseBill;

public class DAttrTextFieldEditor extends AbstractFieldEditor {
  private JTextField field;

  private String dattrType;

  public DAttrTextFieldEditor(String name) {
    super(name);
  }

  public DAttrTextFieldEditor(String name, String dattrType, boolean isEditable) {
    this.dattrType = dattrType;
    init(name);
    this.field.setEnabled(isEditable);
  }

  public DAttrTextFieldEditor(String name, String dattrType) {
    this.dattrType = dattrType;
    init(name);
  }

  public Object getValue() {
    return field.getText();
  }

  public void setValue(Object value) { //��ѡ���������з����ı��ʱ�����������¼�
    if (value instanceof BaseBill) {
      BaseBill bill = (BaseBill) value;
      String s = "";
      if ("01".equals(dattrType)) {
        s = bill.getDattr1();
      } else if ("02".equals(dattrType)) {
        s = bill.getDattr2();
      } else if ("03".equals(dattrType)) {
        s = bill.getDattr3();
      } else if ("04".equals(dattrType)) {
        s = bill.getDattr4();
      } else if ("05".equals(dattrType)) {
        s = bill.getDattr5();
      }
      field.setText(s);
    }
  }

  protected JComponent createEditorComponent() { //��������Ŀؼ��������ı������ͬ����������
    field = new JTextField();
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
        if ("01".equals(dattrType)) {
          bill.setDattr1(fieldValue);
        } else if ("02".equals(dattrType)) {
          bill.setDattr2(fieldValue);
        } else if ("03".equals(dattrType)) {
          bill.setDattr3(fieldValue);
        } else if ("04".equals(dattrType)) {
          bill.setDattr4(fieldValue);
        } else if ("05".equals(dattrType)) {
          bill.setDattr5(fieldValue);
        }
      }
    }
    this.fireEditSynced();
  }

  public void setEnabled(boolean enabled) {
    field.setEditable(enabled);
    field.setEnabled(enabled);
  }

}
