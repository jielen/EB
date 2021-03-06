package com.ufgov.gk.client.component.button;

public class FinishScoreEvalButton extends FuncButton {
  /**
   * 
   */
  private static final long serialVersionUID = -2564446291342163428L;

  public FinishScoreEvalButton() {
    super();
  }

  protected void init() {

    this.funcId = "f_finishScore";
    this.defaultText = "完成评分性评标";
    super.init();

  }

  public void setToolTipText(String text) {
    String tipText = this.getText();
    super.setToolTipText(tipText);
  }

}
