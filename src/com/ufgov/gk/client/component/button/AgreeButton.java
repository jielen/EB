package com.ufgov.gk.client.component.button;

public class AgreeButton extends FuncButton {
  /**
   * 
   */
  private static final long serialVersionUID = 4783499025450922527L;

  public AgreeButton() {
    super();
  }

  protected void init() {
    this.funcId = "fagreecommit";
    this.defaultText = "ЭЌвт";
    this.iconName = "send.jpg";
    super.init();

  }

}
