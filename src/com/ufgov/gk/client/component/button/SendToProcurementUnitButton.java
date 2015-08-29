package com.ufgov.gk.client.component.button;

public class SendToProcurementUnitButton extends FuncButton {

  private static final long serialVersionUID = 8989591315991814536L;

  public SendToProcurementUnitButton() {
    super();
  }

  protected void init() {
    this.funcId = "fsendprocuunit";
    this.defaultText = "�Ͳɹ���λȷ��";
    this.iconName = "commit.jpg";
    super.init();
  }

}
