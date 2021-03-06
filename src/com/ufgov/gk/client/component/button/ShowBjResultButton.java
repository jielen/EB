/**   
* @(#) project: ZFCG
* @(#) file: ShowBjResultButton.java
* 
* Copyright 2011 UFGOV, Inc. All rights reserved.
* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
* 
*/
package com.ufgov.gk.client.component.button;

/**
* @ClassName: ShowBjResultButton
* @Description: TODO(这里用一句话描述这个类的作用)
* @date: 2011-4-12 上午11:24:20
* @version: V1.0 
* @since: 1.0
* @author: fanpl
* @modify: 
*/
public class ShowBjResultButton extends FuncButton {

  private static final long serialVersionUID = 8176162602374543497L;

  public ShowBjResultButton() {
    super();
  }

  protected void init() {
    this.funcCtrl = false;
    this.funcId = "fShowBjResult";
    this.defaultText = "显示供应商报价信息";
    this.iconName = "sendBill.png";
    super.init();
  }
}
