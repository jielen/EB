package com.ufgov.gk.client.component.button;

public class ScoreEvalButton extends FuncButton {
  private static final long serialVersionUID = 8176162602374553497L;

  public ScoreEvalButton() {
    super();
  }

  protected void init() {
    this.funcCtrl = false;
    this.funcId = "fscoreEval";
    this.defaultText = "�������";
    this.iconName = "commit.jpg";
    super.init();
  }
}
