package com.ufgov.gk.client.component.button;

public class SuggestAuditPassCZButton extends FuncButton {

  private static final long serialVersionUID = 8989591315991814536L;

  public SuggestAuditPassCZButton() {
    super();
  }

  protected void init() {
    this.funcId = "fmanualcommitCZ";
    this.defaultText = "填写意见并审核通过";
    this.iconName = "group_edit.png";
    super.init();
  }

}
