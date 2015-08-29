package com.ufgov.gk.client.component.button;


public class AntiFinishItemButton extends FuncButton {
  private static final long serialVersionUID = 4417056390778652777L;

  public AntiFinishItemButton() {
    super();
  }

  protected void init() {

    this.funcId = "antiffinishitem";
    this.defaultText = "∑¥Ω·œÓ";
    super.init();

  }

  public void setToolTipText(String text) {
    String tipText = this.getText();
    super.setToolTipText(tipText);
  }
}
