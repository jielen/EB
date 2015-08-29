package com.ufgov.gk.client.component.button;


public class ImportButton extends FuncButton {

  private static final long serialVersionUID = -4220724045871305900L;
  
  public ImportButton() {
    super();
  }
  

  protected void init() {
    this.funcId = "fimport";
    this.defaultText="µº»Î";
    this.iconName="import.jpg";
    super.init();
    
  }

}
