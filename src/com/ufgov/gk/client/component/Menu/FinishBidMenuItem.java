/**   
* @(#) project: ZFCG
* @(#) file: FinishBidMenuItem.java
* 
* Copyright 2011 UFGOV, Inc. All rights reserved.
* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
* 
*/
package com.ufgov.gk.client.component.Menu;

/**
* @ClassName: FinishBidMenuItem
* @Description: TODO(这里用一句话描述这个类的作用)
* @date: 2011-6-9 上午11:15:51
* @version: V1.0 
* @since: 1.0
* @author: fanpl
* @modify: 
*/
public class FinishBidMenuItem extends FuncMenuItem {

  private static final long serialVersionUID = 4054640434388046008L;

  public FinishBidMenuItem() {
    super();
  }

  @Override
  protected void init() {

    this.funcId = "ffinishBid";
    this.defaultText = "结束评标";
    super.init();
  }

}
