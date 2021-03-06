/**   
* @(#) project: ZFCG_ST
* @(#) file: CalItemButton.java
* 
* Copyright 2011 UFGOV, Inc. All rights reserved.
* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
* 
*/
package com.ufgov.gk.client.component.button;

/**
* @ClassName: CalItemButton
* @Description: TODO(这里用一句话描述这个类的作用)
* @date: 2011-7-27 上午10:59:44
* @version: V1.0 
* @since: 1.0
* @author: fanpl
* @modify: 
*/
public class CalItemButton extends FuncButton {

  public CalItemButton() {
    super();
  }

  protected void init() {
    this.funcId = "fcalcItem";
    this.defaultText = "计算指标分值";
    this.iconName = "sendBill.png";
    super.init();
  }

}
