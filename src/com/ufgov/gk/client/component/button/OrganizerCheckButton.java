package com.ufgov.gk.client.component.button;

public class OrganizerCheckButton extends FuncButton {
  private static final long serialVersionUID = 8989591315991814536L;

  public OrganizerCheckButton() {
    super();
  }

  protected void init() {
    this.funcId = "forganizercheck";
    this.defaultText = "��֯����";
    this.iconName = "commit.jpg";
    super.init();
  }
}
