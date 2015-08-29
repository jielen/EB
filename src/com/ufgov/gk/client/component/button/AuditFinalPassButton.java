package com.ufgov.gk.client.component.button;

public class AuditFinalPassButton extends FuncButton {

  /**
   * 
   */
  private static final long serialVersionUID = 5305864813939234512L;

  public AuditFinalPassButton() {
    super();
  }

  protected void init() {
    this.funcId = "fauditfinal";
    this.defaultText = "����";
    this.iconName = "audit.jpg";
    super.init();

  }

}
