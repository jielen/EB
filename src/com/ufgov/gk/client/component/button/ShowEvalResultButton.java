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
* @Description: TODO(符合性评审汇总按钮)
* @date: 2010-12-5 下午12:24:26
* @version: V1.0 
* @since: 1.0
* @author: fanpl
* @modify: 
*/
public class ShowEvalResultButton extends FuncButton {
  private static final long serialVersionUID = 8176162602374553497L;

  public ShowEvalResultButton() {
    super();
  }

  protected void init() {
    this.funcCtrl = false;
    this.funcId = "fShowEvalResult";
    this.defaultText = "显示评分汇总表";
    this.iconName = "import.jpg";
    super.init();
  }
}
