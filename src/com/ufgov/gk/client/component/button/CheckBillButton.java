package com.ufgov.gk.client.component.button;

import javax.swing.Icon;

public class CheckBillButton extends FuncButton {

  private static final long serialVersionUID = -4220724045871305900L;

  protected String text = "����";

  public CheckBillButton() {
    super();
  }

  public CheckBillButton(String defaultText) {
    super(defaultText);
    this.text = defaultText;
    init();
  }

  protected void init() {
    this.funcId = "fcheckbill";
    this.defaultText = this.text;
    this.iconName = "check.jpg";
    super.init();
  }

}
