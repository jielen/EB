
package com.ufgov.gk.client.component.button;


public class UnauditButton extends FuncButton{

  private static final long serialVersionUID = -7040866162918717533L;

  public UnauditButton() {
    super();
  }

  protected void init() {
    this.funcId="funaudit";
    this.defaultText="œ˙…Û";
    this.iconName="unaudit.jpg";
    super.init();
  }

}
