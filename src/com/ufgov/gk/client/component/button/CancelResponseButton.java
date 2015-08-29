package com.ufgov.gk.client.component.button;

public class CancelResponseButton extends FuncButton {

  private static final long serialVersionUID = 1L;

  public CancelResponseButton() {
    super();
  }

  @Override
  protected void init() {
    this.funcId = "fcancelresponse";
    this.defaultText = "ȡ���ص�ȷ��";
    super.init();
  }

}
