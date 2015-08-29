/**   
* @(#) project: ZFCG
* @(#) file: EvalPrintButton.java
* 
* Copyright 2011 UFGOV, Inc. All rights reserved.
* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
* 
*/
package com.ufgov.gk.client.component.Menu;

/**
* @ClassName: EvalPrintButton
* @Description: TODO(������һ�仰��������������)
* @date: 2011-6-8 ����06:29:51
* @version: V1.0 
* @since: 1.0
* @author: fanpl
* @modify: 
*/
public class ShowEvalResultButton extends FuncMenuButton {

  private static final long serialVersionUID = 8176162602374543497L;

  public ShowEvalResultButton() {
    super();
  }

  @Override
  protected void init() {
    this.funcCtrl = true;
    this.funcId = "fevalResult";
    this.defaultText = "��ӡ";
    this.iconName = "print.gif";
    super.init();
  }

}
