package com.ufgov.gk.client.component.button;

public class ViewButton extends FuncButton {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public ViewButton() {
    super();
  }

  protected void init() {
    this.funcId = "fview";
    this.defaultText = "²é¿´";
    this.iconName = "accepted.png";
    super.init();
  }
}
