package com.ufgov.gk.client.component.zc.fieldeditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;

import com.ufgov.gk.client.component.AsValComboBox;
import com.ufgov.gk.client.component.ui.fieldeditor.AbstractFieldEditor;
import com.ufgov.gk.common.commonbiz.model.BaseBill;
import com.ufgov.gk.common.system.model.AsVal;
import com.ufgov.gk.common.system.util.BeanUtil;

public class AsValFieldEditor extends AbstractFieldEditor {
  private AsValComboBox field;

  private String valSetId;

  private boolean firstAddNull = false;

  public AsValFieldEditor(String name, String fieldName, String valSetId) {
    this.fieldName = fieldName;
    this.valSetId = valSetId;
    init(name);
  }

  public AsValFieldEditor(String name, String fieldName, String valSetId, boolean firstAddNull) {
    this.fieldName = fieldName;
    this.valSetId = valSetId;
    this.firstAddNull = firstAddNull;
    init(name);
  }

  public AsValComboBox getField() {
    return field;
  }

  public void setEnabled(boolean enabled) {
    field.setEnabled(enabled);
  }

  public Object getValue() {
    return field.getSelectedAsVal();
  }

  public void setValue(Object value) { //在选择的上面的行发生改变的时候所触发的事件
    if (value == null) {
      field.setSelectedAsVal(null);
    } else if (value instanceof BaseBill) {
      String v = (String) BeanUtil.get(fieldName, value);
      field.setSelectedAsValByCode(v);
    }
  }

  protected JComponent createEditorComponent() { //生成下面的控件，并将改变的内容同步到对象中
    field = new AsValComboBox(valSetId, firstAddNull);
    field.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        syncEditObject();
        afterChange(field);
      }
    });
    return field;
  }

  protected void afterChange(AsValComboBox field) {
  }

  protected void syncEditObject() {
    if (getEditObject() instanceof BaseBill) {
      BaseBill bill = (BaseBill) getEditObject();
      if (bill != null) {
        AsVal val = field.getSelectedAsVal();
        String valId = null;
        if (val != null) {
          valId = val.getValId();
        }
        BeanUtil.set(fieldName, valId, getEditObject());
      }
    }
    this.fireEditSynced();
  }

}
