package com.ufgov.gk.client.component.button;

public class CreateNewPlanButton extends FuncButton {
  /**
   * 
   */
  private static final long serialVersionUID = -2564446291342163428L;

  public CreateNewPlanButton() {
    super();
  }

  protected void init() {

    this.funcId = "fnewPlan";
    this.defaultText = "�����ƻ�����";
    this.iconName = "add.jpg";
    super.init();

  }
}
