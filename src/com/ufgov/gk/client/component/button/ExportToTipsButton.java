package com.ufgov.gk.client.component.button;


public class ExportToTipsButton extends FuncButton {

  private static final long serialVersionUID = -4220724045871305900L;
  
  public ExportToTipsButton() {
    super();
  }
  
  protected void init() {
    this.funcId = "fexporttips";
    this.defaultText="µ¼³öTIPS";
    this.iconName="export.jpg";
    super.init();
  }

}
