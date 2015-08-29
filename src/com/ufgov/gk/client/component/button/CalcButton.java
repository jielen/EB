package com.ufgov.gk.client.component.button;

public class CalcButton extends FuncButton {
  public CalcButton() {
    super();
  }

  protected void init() {
    this.funcId = "fcalc";
    this.defaultText = "����";
    this.iconName = "sendBill.png";
    super.init();
  }
}
