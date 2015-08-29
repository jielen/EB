package com.ufgov.gk.client.component.button;

/**
 * 
 * @author fanpl
 *
 */
public class ProviderCheckButton extends FuncButton {
  private static final long serialVersionUID = 8989591315991814536L;

  public ProviderCheckButton() {
    super();
  }

  protected void init() {
    this.funcId = "fprovidercheck";
    this.defaultText = "供应商验收";
    this.iconName = "commit.jpg";
    super.init();
  }
}
