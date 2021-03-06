/**   
* @(#) project: ZFCG
* @(#) file: ComplCallBackButton.java
* 
* Copyright 2011 UFGOV, Inc. All rights reserved.
* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
* 
*/
package com.ufgov.gk.client.component.button;

/**
* @ClassName: ComplCallBackButton
* @Description: 符合性评审汇总结果收回按钮
* @date: 2011-4-11 下午03:23:07
* @version: V1.0 
* @since: 1.0
* @author: fanpl
* @modify: 
*/
public class ComplCallBackButton extends FuncButton {

  /**
   * 
   */
  private static final long serialVersionUID = -2564446291342163428L;

  public ComplCallBackButton() {
    super();
  }

  protected void init() {
    this.funcId = "fComplcallback";
    this.defaultText = "重置为符合性评审状态";
    this.iconName = "callback.jpg";
    super.init();
  }

}
