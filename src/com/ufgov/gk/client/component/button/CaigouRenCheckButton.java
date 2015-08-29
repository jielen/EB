package com.ufgov.gk.client.component.button;

public class CaigouRenCheckButton extends FuncButton {
  private static final long serialVersionUID = 8989591315991814536L;

  public CaigouRenCheckButton() {
    super();
  }

  protected void init() {
    this.funcId = "fcaigourencheck";
    this.defaultText = "�ɹ�������";
    this.iconName = "commit.jpg";
    super.init();
  }
}
