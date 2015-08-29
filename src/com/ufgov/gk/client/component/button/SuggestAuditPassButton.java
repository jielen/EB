package com.ufgov.gk.client.component.button;

public class SuggestAuditPassButton extends FuncButton {

  private static final long serialVersionUID = 8989591315991814536L;

  public SuggestAuditPassButton() {
    super();
  }

  protected void init() {
    this.funcId = "fmanualcommit";
    this.defaultText = "��д��������ͨ��";
    this.iconName = "commit.jpg";
    super.init();
  }

}