package com.ufgov.gk.client.component.button;

public class SecondPriceButton extends FuncButton {
  /**
   * 
   */
  private static final long serialVersionUID = 8176162602374553497L;

  public SecondPriceButton() {
    super();
  }

  protected void init() {
    this.funcCtrl = false;
    // this.funcId = "fexit";
    this.defaultText = "���α���";
    this.iconName = "export.jpg";
    super.init();
  }

}
