package com.ufgov.gk.client.component.zc.fieldeditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.ufgov.gk.client.component.event.ValueChangeListener;
import com.ufgov.gk.client.component.ui.fieldeditor.AbstractFieldEditor;
import com.ufgov.gk.common.commonbiz.model.BaseBill;
import com.ufgov.gk.common.system.util.BeanUtil;

public class CheckBoxFieldEditor extends AbstractFieldEditor {
  /**
   * 
   */
  private static final long serialVersionUID = -9126316741144675929L;

  private JCheckBox field;

  private boolean minusAllow = false;

  public CheckBoxFieldEditor(String name, String fieldName) {
    this.fieldName = fieldName;
    init(name);
  }

  public CheckBoxFieldEditor(String name, boolean minusAllow, String fieldName) {
    this.fieldName = fieldName;
    this.minusAllow = minusAllow;
    init(name);
  }

  public void addValueChangeListener(ValueChangeListener l) {
    this.listenerList.add(ValueChangeListener.class, l);
  }

  public CheckBoxFieldEditor(String name, String fieldName, boolean isEditable) {
    this.fieldName = fieldName;
    init(name);
    this.field.setEnabled(isEditable);
  }

  public Object getValue() {
    return field.getText();
  }

  public void setValue(Object value) { //在选择的上面的行发生改变的时候所触发的事件    
    if (value == null) {
      field.setSelected(false);
      field.setToolTipText(null);
    } else if (value instanceof BaseBill) {
      String v = (String) BeanUtil.get(fieldName, value);

      if (v != null) {
        if (v.equalsIgnoreCase("Y")) {
          field.setSelected(true);
        } else {
          field.setSelected(false);
        }
      } else {
        field.setSelected(false);
      }
    }
  }

  protected JComponent createEditorComponent() { //生成下面的控件，并将改变的内容同步到对象中
    field = new JCheckBox();

    field.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        syncEditObject();
        checkBoxFieldValueChanged(e);
      }
    });

    field.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub        
        syncEditObject();
        checkBoxFieldActionPerformed(field);
      }
    });
    return field;
  }

  protected void checkBoxFieldActionPerformed(JCheckBox field) {
    // TODO Auto-generated method stub

  }

  protected void syncEditObject() {
    if (getEditObject() != null) {
      String v = "N";
      if (field.isSelected()) {
        v = "Y";
      }
      BeanUtil.set(fieldName, v, getEditObject());
    }
    this.fireEditSynced();
  }

  /*
   * 当选择或取消对Checkbox字段的选择时候，调用此方法。在程序中生成对象时覆盖此方法写入自己的判断逻辑
   */
  protected void checkBoxFieldValueChanged(ChangeEvent e) {

  }

  public void setEnabled(boolean enabled) {
    field.setEnabled(enabled);
  }

  public boolean isSelected() {
    boolean flag = false;
    if (field.isSelected())
      flag = true;
    return flag;
  }
}
