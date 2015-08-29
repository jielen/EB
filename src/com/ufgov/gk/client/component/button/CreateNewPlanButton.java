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
    this.defaultText = "新增计划管理";
    this.iconName = "add.jpg";
    super.init();

  }
}
