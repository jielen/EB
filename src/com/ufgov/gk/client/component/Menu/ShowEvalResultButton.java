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
* @Description: TODO(这里用一句话描述这个类的作用)
* @date: 2011-6-8 下午06:29:51
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
    this.defaultText = "打印";
    this.iconName = "print.gif";
    super.init();
  }

}
