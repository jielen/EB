package com.ufgov.gk.client.component.button;


public class GenerateDocButton extends FuncButton {
  public GenerateDocButton() {
    super();
  }

  protected void init() {
    this.funcId = "f_generatedoc";
    this.defaultText = "�����ļ�";
    super.init();


  }

  public void setToolTipText(String text) {
    String tipText = this.getText() ;
    super.setToolTipText(tipText);
  }
}
