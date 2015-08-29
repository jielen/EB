/**   
* @(#) project: ZC
* @(#) file: SumComplEvalResultButton.java
* 
* Copyright 2010 UFGOV, Inc. All rights reserved.
* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
* 
*/
package com.ufgov.gk.client.component.button;

/**
* @ClassName: SumComplEvalResultButton
* @Description: TODO(������������ܰ�ť)
* @date: 2010-12-5 ����12:24:26
* @version: V1.0 
* @since: 1.0
* @author: fanpl
* @modify: 
*/
public class SumComplEvalResultButton extends FuncButton {
  private static final long serialVersionUID = 8176162602374553497L;

  public SumComplEvalResultButton() {
    super();
  }

  protected void init() {
    this.funcCtrl = false;
    this.funcId = "fsumComplEvalResult";
    this.defaultText = "���ܷ�����������";
    this.iconName = "send.jpg";
    super.init();
  }
}
