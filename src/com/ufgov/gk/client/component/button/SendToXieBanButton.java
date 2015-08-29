package com.ufgov.gk.client.component.button;

public class SendToXieBanButton extends FuncButton {
  /**
   * 
   */
  private static final long serialVersionUID = 4783499025450922527L;

  public SendToXieBanButton() {
    super();
  }

  protected void init() {
    this.funcId = "fsendtoxieban";
    this.defaultText = "ÀÕ–≠∞Ï»À…Û∫À";
    this.iconName = "send.jpg";
    super.init();

  }

}
