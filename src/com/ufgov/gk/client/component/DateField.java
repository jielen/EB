package com.ufgov.gk.client.component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Date;

import javax.swing.JDialog;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.ufgov.gk.client.component.event.ValueChangeEvent;
import com.ufgov.gk.client.component.event.ValueChangeListener;
import com.ufgov.gk.client.component.zc.fieldeditor.JDateTimeTextField;
import com.ufgov.gk.common.system.util.DateUtil;

public class DateField extends JDateTimeTextField {

  public static final String TimeTypeH24 = JDateTimeTextField.TimeTypeH24;

  public static final String TimeTypeH12 = JDateTimeTextField.TimeTypeH12;

  /**
   * �Ƿ���ʾʱ����
   */
  private boolean dateTime = false;

  private String timeType = "";

  public DateField(int col) {
    super(col);
    this.setBackground(Color.white);
  }

  public DateField() {
    this.setBackground(Color.white);
  }

  public DateField(String timeType) {
    super("", timeType);
    if (timeType == null) {
      this.setBackground(Color.white);
      return;
    }
    if (timeType.equals(DateField.TimeTypeH12) || timeType.equals(DateField.TimeTypeH24)) {
      this.dateTime = true;
      this.timeType = timeType;
    }
    this.setBackground(Color.white);
  }

  public DateField(String timeType, Integer[] allowMinutes, boolean isZeroSecond) {
    super("", timeType, allowMinutes, isZeroSecond);
    if (timeType == null) {
      this.setBackground(Color.white);
      return;
    }
    if (timeType.equals(DateField.TimeTypeH12) || timeType.equals(DateField.TimeTypeH24)) {
      this.dateTime = true;
      this.timeType = timeType;
    }
    this.setBackground(Color.white);
  }

  public DateField(String timeType, int col) {
    super("", timeType, col);
    if (timeType == null) {
      this.setBackground(Color.white);
      return;
    }
    if (timeType.equals(DateField.TimeTypeH12) || timeType.equals(DateField.TimeTypeH24)) {
      this.dateTime = true;
      this.timeType = timeType;
    }
    this.setBackground(Color.white);
  }

  public void setText(String t) {
    super.setText(t);
    fireValueChanged();
  }

  public Date getDate() {
    String d = this.getText();
    if (d != null && !"".equals(d.trim())) {
      if (this.dateTime) {
        return DateUtil.ssStringToDate(d);
      } else {
        return DateUtil.ddStringToDate(d);
      }
    }
    return null;
  }

  public void setDate(Date d) {
    if (d != null) {
      if (this.dateTime) {
        this.setText(DateUtil.dateToSsString(d));
      } else {
        this.setText(DateUtil.dateToDdString(d));
      }
    } else {
      this.setText("");
    }
  }

  public void addValueChangeListener(ValueChangeListener l) {
    this.listenerList.add(ValueChangeListener.class, l);
  }

  public void removeValueChangeListener(ValueChangeListener l) {
    this.listenerList.remove(ValueChangeListener.class, l);
  }

  protected void fireValueChanged() {
    ValueChangeEvent e = null;
    ValueChangeListener[] listeners = listenerList.getListeners(ValueChangeListener.class);
    for (ValueChangeListener l : listeners) {
      if (e == null) {
        e = new ValueChangeEvent(this);
      }
      l.valueChanged(e);
    }
  }

  public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
    UnsupportedLookAndFeelException {
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    JDialog f = new JDialog();
    //    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setBounds(0, 0, 320, 240);
    DateField dateTextField = new DateField(JDateTimeTextField.TimeTypeH24);
    dateTextField.setText("1998-11-15 12:13:20");
    dateTextField.setEnabled(true);
    f.add(dateTextField, BorderLayout.NORTH);
    SwingUtilities.updateComponentTreeUI(f);
    f.setVisible(true);
  }
}
