package com.ufgov.gk.client.component.button;


public class GenButton extends FuncButton {
  public GenButton() {
    super();
  }

  protected void init() {
    this.funcId = "fgen";
    this.defaultText = "Éú³É";
    super.init();
  }

  public void setToolTipText(String text) {
    String tipText = this.getText() ;
    super.setToolTipText(tipText);
  }
}
