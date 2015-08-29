package com.ufgov.gk.client.component.button;

public class ResponseButton extends FuncButton {

  private static final long serialVersionUID = 1L;

  public ResponseButton() {
    super();
  }

  @Override
  protected void init() {
    this.funcId = "fresponse";
    this.defaultText = "�ص�ȷ��";
    super.init();
  }

}
