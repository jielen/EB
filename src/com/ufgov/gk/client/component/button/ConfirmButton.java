package com.ufgov.gk.client.component.button;


public class ConfirmButton extends FuncButton {


  /**
   * �ļ�����ConfirmButton.java
   *
   * �汾��Ϣ��
   * ���ڣ�Sep 22, 2009
   * Copyright ufgov Corporation 2009 
   * ��Ȩ����
   *
   */
  private static final long serialVersionUID = 3343425486390873907L;

  public ConfirmButton() {
    super();
  }

  protected void init() {
    this.funcCtrl=false;
    this.defaultText="ȷ��";
    super.init();
  }

}
