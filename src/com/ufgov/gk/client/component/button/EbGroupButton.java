package com.ufgov.gk.client.component.button;

public class EbGroupButton extends FuncButton {

  /**
   * 
   */
  private static final long serialVersionUID = -6341561880180388896L;

  public EbGroupButton() {
    super();
  }

  protected void init() {
    this.funcCtrl = false;
    this.funcId = "febgroup";
    this.defaultText = "Âô¼Ò¼¯";
    //    this.iconName = "exit.jpg";
    super.init();
  }
}
