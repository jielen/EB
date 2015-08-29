/**   
* @(#) project: ZFCG
* @(#) file: OpenBidMenuItem.java
* 
* Copyright 2011 UFGOV, Inc. All rights reserved.
* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
* 
*/
package com.ufgov.gk.client.component.Menu;

/**
* @ClassName: OpenBidMenuItem
* @Description: TODO(������һ�仰��������������)
* @date: 2011-6-9 ����11:07:09
* @version: V1.0 
* @since: 1.0
* @author: fanpl
* @modify: 
*/
public class OpenBidMenuItem extends FuncMenuItem {

  /**
   * 
   */
  private static final long serialVersionUID = 4054640434388046008L;

  public OpenBidMenuItem() {
    super();
  }

  @Override
  protected void init() {
    this.funcId = "fopenBid";
    this.defaultText = "����";
    super.init();
  }
}
