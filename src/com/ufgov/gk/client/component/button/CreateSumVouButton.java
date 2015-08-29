package com.ufgov.gk.client.component.button;

public class CreateSumVouButton extends FuncButton {

  public CreateSumVouButton() {
    super();
  }
  
  @Override
  protected void init() {
    this.funcId = "fgensumvou";
    this.defaultText="生成汇总凭证";
    super.init();
  }
  
}
