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
* @Description: TODO(这里用一句话描述这个类的作用)
* @date: 2010-9-20 下午01:45:19
* @version: V1.0 
* @since: 1.0
* @author: fanpeile
* @modify: 
*/
public class DelayBidButton extends FuncButton {
  /**
   * 
   */
  private static final long serialVersionUID = 4054640434388046008L;

  public DelayBidButton() {
    super();
  }

  protected void init() {

    this.funcId = "fdelayBid";
    this.defaultText = "延期计划管理";
    super.init();
  }

}
