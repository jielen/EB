package com.ufgov.gk.client.component.button;

public class IsSendToNextButton extends FuncButton {
  /**
   * 
   */
  private static final long serialVersionUID = -2564446291342163428L;

  public IsSendToNextButton() {
    super();
  }

  protected void init() {
    this.funcId = "fsendnextcommit";
    this.defaultText = "ÀÕ÷˜»Œ…Û∫À";
    this.iconName = "send.jpg";
    super.init();
  }

}
