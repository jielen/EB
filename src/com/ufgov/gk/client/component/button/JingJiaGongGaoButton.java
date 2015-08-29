/**   
* @(#) project: ZC
* @(#) file: DelayBidButton.java
* 
* Copyright 2010 UFGOV, Inc. All rights reserved.
* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
* 
*/
package com.ufgov.gk.client.component.button;

/**
* @ClassName: DelayBidButton
* @Description: TODO(������һ�仰��������������)
* @date: 2010-9-20 ����01:45:19
* @version: V1.0 
* @since: 1.0
* @author: fanpeile
* @modify: 
*/
public class JingJiaGongGaoButton extends FuncButton {
  /**
   * 
   */
  private static final long serialVersionUID = 4054640434388046008L;

  public JingJiaGongGaoButton() {
    super();
  }

  protected void init() {

    this.funcId = "fjingJiaGongGao";
    this.defaultText = "�������۹���";
    super.init();
  }

}
