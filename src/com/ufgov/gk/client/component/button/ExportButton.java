package com.ufgov.gk.client.component.button;


public class ExportButton extends FuncButton {

  private static final long serialVersionUID = -4220724045871305900L;
  
  public ExportButton() {
    super();
  }
  
  protected void init() {
    this.funcId = "fexport";
    this.defaultText="µ¼³ö";
    this.iconName="export.jpg";
    super.init();
  }

}
