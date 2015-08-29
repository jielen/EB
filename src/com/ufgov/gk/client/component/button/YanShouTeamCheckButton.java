package com.ufgov.gk.client.component.button;

public class YanShouTeamCheckButton extends FuncButton {
  private static final long serialVersionUID = 8989591315991814536L;

  public YanShouTeamCheckButton() {
    super();
  }

  protected void init() {
    this.funcId = "fyanshouteamcheck";
    this.defaultText = "验收小组验收";
    this.iconName = "commit.jpg";
    super.init();
  }
}
