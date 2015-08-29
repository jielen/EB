/**   
* @(#) project: ZFCG
* @(#) file: ShowEvalComplResultDetalButton.java
* 
* Copyright 2011 UFGOV, Inc. All rights reserved.
* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
* 
*/
package com.ufgov.gk.client.component.button;

/**
* @ClassName: ShowEvalComplResultDetalButton
* @Description: TODO(这里用一句话描述这个类的作用)
* @date: 2011-4-17 上午10:11:12
* @version: V1.0 
* @since: 1.0
* @author: fanpl
* @modify: 
*/
public class ShowEvalComplResultDetalButton extends FuncButton {

  private static final long serialVersionUID = 8176162602374543497L;

  public ShowEvalComplResultDetalButton() {
    super();
  }

  protected void init() {
    this.funcCtrl = false;
    this.funcId = "fShowEvalComlResultDetal";
    this.defaultText = "显示专家符合性评审结果";
    this.iconName = "sendBill.png";
    super.init();
  }

}
