package com.ufgov.gk.client.component.button;


public class ImportToNextYearButton extends FuncButton {

  private static final long serialVersionUID = -4220724045871305900L;
  
  public ImportToNextYearButton() {
    super();
  }
  

  protected void init() {
    this.funcId = "fimporttonextyear";
    this.defaultText="���뵽����";
    this.iconName="import.jpg";
    super.init();
  }

}
