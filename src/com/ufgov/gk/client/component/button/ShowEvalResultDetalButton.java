package com.ufgov.gk.client.component.button;

public class ShowEvalResultDetalButton extends FuncButton {

  private static final long serialVersionUID = 8176162602374543497L;

  public ShowEvalResultDetalButton() {
    super();
  }

  protected void init() {
    this.funcCtrl = false;
    this.funcId = "fShowEvalResultDetal";
    this.defaultText = "��ʾר�����ֱ�";
    this.iconName = "sendBill.png";
    super.init();
  }
}
