package com.ufgov.gk.client.component.zc.fieldeditor;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;

import javax.swing.JComponent;

import com.ufgov.gk.client.component.DateField;
import com.ufgov.gk.client.component.event.ValueChangeEvent;
import com.ufgov.gk.client.component.event.ValueChangeListener;
import com.ufgov.gk.client.component.ui.fieldeditor.AbstractFieldEditor;
import com.ufgov.gk.common.commonbiz.model.BaseBill;
import com.ufgov.gk.common.system.util.BeanUtil;

public class DateFieldEditor extends AbstractFieldEditor {
  private static final long serialVersionUID = -8002760379481660801L;

  private DateField field;

  private boolean isDateTime = false;

  private String timeType = "";

  private boolean isZeroSecond = false;

  private Integer[] allowMinutes = null;

  public static final String TimeTypeH24 = DateField.TimeTypeH24;

  public static final String TimeTypeH12 = DateField.TimeTypeH12;

  public DateFieldEditor(String name, String fieldName) {
    this.fieldName = fieldName;
    init(name);
  }

  public DateFieldEditor(String name, String fieldName, String timeType) {
    this.fieldName = fieldName;
    if (timeType != null && (timeType.equals(DateField.TimeTypeH12) || timeType.equals(DateField.TimeTypeH24))) {
      this.isDateTime = true;
      this.timeType = timeType;
    }
    init(name);
  }

  public DateFieldEditor(String name, String fieldName, String timeType, Integer[] allowMinutes, boolean isZeroSecond) {
    this.fieldName = fieldName;
    if (timeType != null && (timeType.equals(DateField.TimeTypeH12) || timeType.equals(DateField.TimeTypeH24))) {
      this.isDateTime = true;
      this.timeType = timeType;
      this.isZeroSecond = isZeroSecond;
      this.allowMinutes = allowMinutes;
    }
    init(name);
  }

  public void setEnabled(boolean enabled) {
    field.setEnabled(enabled);
  }

  public void setEditable(boolean enabled) {
    field.setEditable(enabled);
  }

  public Object getValue() {
    return field.getDate();
  }

  public void setValue(Object value) { //在选择的上面的行发生改变的时候所触发的事件
    if (value == null) {
      field.setDate(null);
    } else if (value instanceof BaseBill) {
      Date v = (Date) BeanUtil.get(fieldName, value);
      field.setDate(v);
    }
  }

  protected JComponent createEditorComponent() { //生成下面的控件，并将改变的内容同步到对象中
    if (this.isDateTime) {
      if (allowMinutes != null) {
        field = new DateField(this.timeType, this.allowMinutes, this.isZeroSecond);
      } else {
        field = new DateField(this.timeType);
      }
    } else {
      field = new DateField();
    }
    field.addValueChangeListener(new ValueChangeListener() {
      public void valueChanged(ValueChangeEvent e) {
        syncEditObject();
      }
    });
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
        BeanUtil.set(fieldName, field.getDate(), getEditObject());
      }
    }
    this.fireEditSynced();
  }

  public DateField getField() {
    return field;
  }
}
