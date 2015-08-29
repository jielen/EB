package com.ufgov.gk.client.component.button;


public class ConfirmButton extends FuncButton {


  /**
   * 文件名：ConfirmButton.java
   *
   * 版本信息：
   * 日期：Sep 22, 2009
   * Copyright ufgov Corporation 2009 
   * 版权所有
   *
   */
  private static final long serialVersionUID = 3343425486390873907L;

  public ConfirmButton() {
    super();
  }

  protected void init() {
    this.funcCtrl=false;
    this.defaultText="确认";
    super.init();
  }

}
