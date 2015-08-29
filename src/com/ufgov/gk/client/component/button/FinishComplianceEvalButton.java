package com.ufgov.gk.client.component.button;

public class FinishComplianceEvalButton extends FuncButton {
  /**
   * 
   */
  private static final long serialVersionUID = -2564446291342163428L;

  public FinishComplianceEvalButton() {
    super();
  }

  protected void init() {

    this.funcId = "f_finishCompliance";
    this.defaultText = "��ɷ���������";
    super.init();

  }

  public void setToolTipText(String text) {
    String tipText = this.getText();
    super.setToolTipText(tipText);
  }

}
