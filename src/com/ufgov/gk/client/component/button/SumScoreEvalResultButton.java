/**   
* @(#) project: ZC
* @(#) file: SumScoreEvalResultButton.java
* 
* Copyright 2010 UFGOV, Inc. All rights reserved.
* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
* 
*/
package com.ufgov.gk.client.component.button;

/**
* @ClassName: SumScoreEvalResultButton
* @Description: TODO(������һ�仰��������������)
* @date: 2010-12-20 ����05:30:15
* @version: V1.0 
* @since: 1.0
* @author: fanpl
* @modify: 
*/
public class SumScoreEvalResultButton extends FuncButton {
  private static final long serialVersionUID = 8176162602374553497L;

  public SumScoreEvalResultButton() {
    super();
  }

  protected void init() {
    this.funcCtrl = false;
    this.funcId = "fsumScoreEvalResult";
    this.defaultText = "����������������";
    this.iconName = "send.jpg";
    super.init();
  }
}
