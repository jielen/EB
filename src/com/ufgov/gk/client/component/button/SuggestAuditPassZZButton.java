package com.ufgov.gk.client.component.button;

public class SuggestAuditPassZZButton extends FuncButton {

  private static final long serialVersionUID = 8989591315991814536L;

  public SuggestAuditPassZZButton() {
    super();
  }

  protected void init() {
    this.funcId = "fmanualcommitZZ";
    this.defaultText = "填写意见并审核通过";
    this.iconName = "commit.jpg";
    super.init();
  }

}
