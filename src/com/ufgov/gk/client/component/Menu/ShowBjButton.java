/**   
* @(#) project: ZFCG
* @(#) file: ShowBjButton.java
* 
* Copyright 2011 UFGOV, Inc. All rights reserved.
* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
* 
*/
package com.ufgov.gk.client.component.Menu;

/**
* @ClassName: ShowBjButton
* @Description: TODO(这里用一句话描述这个类的作用)
* @date: 2011-6-9 下午02:19:35
* @version: V1.0 
* @since: 1.0
* @author: fanpl
* @modify: 
*/
public class ShowBjButton extends FuncMenuButton {

  private static final long serialVersionUID = 8176162602374543497L;

  public ShowBjButton() {
    super();
  }

  @Override
  protected void init() {
    this.funcCtrl = true;
    this.funcId = "fshowBj";
    this.defaultText = "查看供应商报价";
    this.iconName = "sendBill.png";
    super.init();
  }

}
