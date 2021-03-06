package com.ufgov.gk.client.component.button;

public class ConfirmSupplyButton extends FuncButton {

  /**
   * 文件名：ConfirmSupplyButton.java
   *
   * 版本信息：
   * 日期：Sep 22, 2009
   * Copyright ufgov Corporation 2009 
   * 版权所有
   *
   */
  private static final long serialVersionUID = 3343425486390873899L;

  public ConfirmSupplyButton() {
    super();
  }

  protected void init() {
    this.funcId = "fconfirmsup";
    this.defaultText = "确认供货";
    super.init();
  }

}
