package com.ufgov.gk.client.component;

import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.math.BigDecimal;
import java.text.NumberFormat;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class MoneyField extends JTextField {

  public static final String ZERO_STRING = "0.00";

  int zeoLength = 2;

  public MoneyField() {
    this.setDocument(new MoneyDoc(this, zeoLength));
    this.setColumns(25);
  }

  public MoneyField(int col) {
    this.setDocument(new MoneyDoc(this, zeoLength));
    this.setColumns(col);
  }

  public MoneyField(boolean minusAllow) {
    this.setDocument(new MoneyDoc(this, minusAllow, zeoLength));
    this.setColumns(25);
  }

  public MoneyField(boolean allowMinus, int len) {
    // TODO Auto-generated constructor stub
    this.setDocument(new MoneyDoc(this, allowMinus, len));
    this.setColumns(25);
    this.zeoLength = len;
  }

  public MoneyField(boolean allowMinus, int len, int columns) {
    // TODO Auto-generated constructor stub
    this.setDocument(new MoneyDoc(this, allowMinus, len));
    this.setColumns(columns);
    this.zeoLength = len;
  }

  public void setMoney(BigDecimal d) {

    if (d == null || d.compareTo(BigDecimal.ZERO) == 0) {
      super.setText(ZERO_STRING);
    } else {
      NumberFormat numberFormat;
      numberFormat = NumberFormat.getInstance();
      numberFormat.setMinimumFractionDigits(2);
      numberFormat.setMaximumFractionDigits(2);
      String s = numberFormat.format(d);
      super.setText(s);
    }

  }

  public BigDecimal getMoney() {
    String s = this.getText();
    if (s == null || "".equals(s.trim())) {
      return new BigDecimal(ZERO_STRING);
    } else {
      return new BigDecimal(s);
    }
  }

  public BigDecimal getValue() {
    return getMoney();
  }

  public void setValue(BigDecimal value) {
    setMoney(value);
  }

}

class MoneyDoc extends PlainDocument {

  private String regex;

  boolean minusAllow = false;

  private Toolkit toolkit = Toolkit.getDefaultToolkit();

  private JTextField textField;

  private int zeorLen = 2;

  public MoneyDoc(JTextField t, int zeoLen) {
    super();
    this.textField = t;
    this.zeorLen = zeoLen;
    init();
  }

  public MoneyDoc(JTextField t, boolean minusAllow, int zeoLen) {
    super();
    this.textField = t;
    this.minusAllow = minusAllow;
    this.zeorLen = zeoLen;
    init();

  }

  private void init() {
    textField.setHorizontalAlignment(JTextField.RIGHT);
    textField.addFocusListener(new FocusListener() {
      public void focusGained(FocusEvent e) {
        String s = textField.getText();
        s = s.replace(",", "");
        textField.setText(s);
      }

      public void focusLost(FocusEvent e) {

        SwingUtilities.invokeLater(new Runnable() {

          public void run() {

            String s = textField.getText();

            if (s == null || "".equals(s.trim())) {
              textField.setText("");
              return;
            }

            s = s.replace(",", "");
            NumberFormat numberFormat;
            numberFormat = NumberFormat.getInstance();
            numberFormat.setMinimumFractionDigits(zeorLen);
            numberFormat.setMaximumFractionDigits(zeorLen);
            s = numberFormat.format(new BigDecimal(s));
            textField.setText(s);
          }

        });

      }
    });

    regex = "[0-9]*\\.?[0-9]{0," + zeorLen + "}";
    if (minusAllow) {
      regex = "-?" + regex;
    }
  }

  public void insertString(int offs, String str, AttributeSet a) throws BadLocationException, NumberFormatException {
    if (this.textField.hasFocus()) {

      if (str == null) {
        return;
      }
      StringBuffer oldStr = new StringBuffer(this.getText(0, this.getLength()));

      StringBuffer newStr = oldStr.insert(offs, str);
      if (this.regex != null && !this.regex.trim().equals("")) {
        if (!newStr.toString().matches(this.regex)) {
          toolkit.beep();
          return;
        }
      }
      String[] parts = oldStr.toString().split("\\.");
      if (parts[0].length() > 15) {
        toolkit.beep();
        return;
      }
    }
    super.insertString(offs, str, a);
  }

  public void insertString2(int offs, String str, AttributeSet a) throws BadLocationException, NumberFormatException {
    super.insertString(offs, str, a);
  }

  public String getText(int offset, int length) throws BadLocationException {
    String s = super.getText(offset, length);
    s = s.replace(",", "");
    return s;
  }
}
