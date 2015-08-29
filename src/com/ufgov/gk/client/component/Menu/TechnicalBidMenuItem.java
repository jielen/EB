/**   
* @(#) project: ZFCG
* @(#) file: TechnicalBidMenuItem.java
* 
* Copyright 2011 UFGOV, Inc. All rights reserved.
* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
* 
*/
package com.ufgov.gk.client.component.Menu;

/**
* @ClassName: TechnicalBidMenuItem
* @Description: TODO(������һ�仰��������������)
* @date: 2011-6-9 ����11:13:40
* @version: V1.0 
* @since: 1.0
* @author: fanpl
* @modify: 
*/
public class TechnicalBidMenuItem extends FuncMenuItem {

  private static final long serialVersionUID = 4054640434388046008L;

  public TechnicalBidMenuItem() {
    super();
  }

  @Override
  protected void init() {

    this.funcId = "ftechBid";
    this.defaultText = "����������";
    super.init();
  }

}
