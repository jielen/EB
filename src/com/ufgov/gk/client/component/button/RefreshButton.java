package com.ufgov.gk.client.component.button;



public class RefreshButton extends FuncButton {

  private static final long serialVersionUID = -4220724045871305900L;
  
  public RefreshButton() {
    super();
  }

  protected void init() {
    this.funcId = "frefresh";
    this.defaultText="Ë¢ÐÂ";
    this.iconName="refresh.jpg";
    super.init();
  }

}
