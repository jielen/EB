package com.ufgov.gk.client.component.button;

public class InvalidButton extends FuncButton {

  public InvalidButton() {
    super();
  }

  protected void init() {
    this.funcId = "finterruptinstance";
    this.defaultText = "×÷·Ï";
    this.iconName = "interruptinstance.jpg";
    super.init();

  }
}
