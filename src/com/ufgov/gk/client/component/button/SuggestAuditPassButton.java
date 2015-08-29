package com.ufgov.gk.client.component.button;

public class SuggestAuditPassButton extends FuncButton {

  private static final long serialVersionUID = 8989591315991814536L;

  public SuggestAuditPassButton() {
    super();
  }

  protected void init() {
    this.funcId = "fmanualcommit";
    this.defaultText = "填写意见并审核通过";
    this.iconName = "commit.jpg";
    super.init();
  }

}
