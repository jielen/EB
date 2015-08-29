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

public class FractionDigitsField extends JTextField {
  private static final long serialVersionUID = 4734463922766527209L;

  private int length;

  public FractionDigitsField() {
    this.setDocument(new FractionDigitsDoc(this));
    this.setColumns(25);
  }

  public FractionDigitsField(int length) {
    this.setDocument(new FractionDigitsDoc(this));
    this.setColumns(25);
    this.length = length;
  }

  public FractionDigitsField(int col, int length) {
    this.setDocument(new FractionDigitsDoc(this));
    this.setColumns(col);
    this.length = length;
  }

  public FractionDigitsField(boolean minusAllow, int length) {
    this.setDocument(new FractionDigitsDoc(this, minusAllow));
    this.setColumns(25);
    this.length = length;
  }

  public void setValue(BigDecimal d) {
    NumberFormat numberFormat = NumberFormat.getInstance();
    numberFormat.setMinimumFractionDigits(length);
    numberFormat.setMaximumFractionDigits(length);
    if (d == null || d.compareTo(BigDecimal.ZERO) == 0) {
      super.setText(numberFormat.format(0));
    } else {
      super.setText(numberFormat.format(d));
    }
  }

  public BigDecimal getValue() {
    String s = this.getText();
    if (s == null || "".equals(s.trim())) {
      return new BigDecimal(0);
    } else {
      return new BigDecimal(s);
    }
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

}

class FractionDigitsDoc extends PlainDocument {

  private static final long serialVersionUID = 330462945569901186L;

  private String regex;

  boolean minusAllow = false;

  private Toolkit toolkit = Toolkit.getDefaultToolkit();

  private FractionDigitsField textField;

  public FractionDigitsDoc(FractionDigitsField t) {
    super();
    this.textField = t;
    init();
  }

  public FractionDigitsDoc(FractionDigitsField t, boolean minusAllow) {
    super();
    this.textField = t;
    this.minusAllow = minusAllow;
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
            numberFormat.setMinimumFractionDigits(textField.getLength());
            numberFormat.setMaximumFractionDigits(textField.getLength());
            s = numberFormat.format(new BigDecimal(s));
            textField.setText(s);
          }
        });
      }
    });

    regex = "[0-9]*\\.?[0-9]{0,1}";
    if (minusAllow) {
      regex = "-?" + regex;
    }
  }

  public void insertString(int offs, String str, AttributeSet a) throws BadLocationException,
    NumberFormatException {
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

  public void insertString2(int offs, String str, AttributeSet a) throws BadLocationException,
    NumberFormatException {
    super.insertString(offs, str, a);
  }

  public String getText(int offset, int length) throws BadLocationException {
    String s = super.getText(offset, length);
    s = s.replace(",", "");
    return s;
  }
}
