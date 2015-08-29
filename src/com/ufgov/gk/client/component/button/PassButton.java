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
* @Description: TODO(这里用一句话描述这个类的作用)
* @date: 2011-6-7 下午06:11:49
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
    this.defaultText = "通过";
    this.iconName = "audit.jpg";
    super.init();
  }

}
