package com.ufgov.gk.client.component.button;


public class PayButton extends FuncButton {

  private static final long serialVersionUID = -4220724045871305900L;
  
  public PayButton() {
    super();
  }
  
  protected void init() {
    this.funcId = "fpay";
    this.defaultText="Ö§¸¶";
    super.init();
  }

}
