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
* @Description: TODO(������һ�仰��������������)
* @date: 2011-7-27 ����10:59:44
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
    this.defaultText = "����ָ���ֵ";
    this.iconName = "sendBill.png";
    super.init();
  }

}
