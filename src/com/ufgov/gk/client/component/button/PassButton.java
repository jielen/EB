/**   
* @(#) project: ZFCG
* @(#) file: PassButton.java
* 
* Copyright 2011 UFGOV, Inc. All rights reserved.
* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
* 
*/
package com.ufgov.gk.client.component.button;

/**
* @ClassName: PassButton
* @Description: TODO(������һ�仰��������������)
* @date: 2011-6-7 ����06:11:49
* @version: V1.0 
* @since: 1.0
* @author: fanpl
* @modify: 
*/
public class PassButton extends FuncButton {

  public PassButton() {
    super();
  }

  @Override
  protected void init() {
    this.funcId = "f_pass";
    this.defaultText = "ͨ��";
    this.iconName = "audit.jpg";
    super.init();
  }

}
