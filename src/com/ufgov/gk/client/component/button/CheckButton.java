package com.ufgov.gk.client.component.button;


public class CheckButton extends FuncButton {

  private static final long serialVersionUID = -4220724045871305900L;
  
  public CheckButton() {
    super();
  }
  
  protected void init() {
    this.funcId = "fcheck";
    this.defaultText="�˶�";
    super.init();
  }

}
