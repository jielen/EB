package com.ufgov.gk.client.component;

import java.awt.Toolkit;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class MoneyDocument extends PlainDocument {

  private String regex ;
  boolean minusAllow=false;
  
  private Toolkit toolkit = Toolkit.getDefaultToolkit();

  public MoneyDocument() {
    super();
    init();
  }
  public MoneyDocument( boolean minusAllow){
    super();
    this.minusAllow=minusAllow;
    init();
    
  }
  private void init(){
    regex = "[0-9]*\\.?[0-9]{0,2}";
    if(minusAllow){
      regex="-?"+regex;
    }
  }
  

  public void insertString(int offs, String str, AttributeSet a)
    throws BadLocationException, NumberFormatException {
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
    super.insertString(offs, str, a);
  }
}