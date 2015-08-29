package com.ufgov.gk.client.component.button;

public class CalcButton extends FuncButton {
  public CalcButton() {
    super();
  }

  protected void init() {
    this.funcId = "fcalc";
    this.defaultText = "º∆À„";
    this.iconName = "sendBill.png";
    super.init();
  }
}
