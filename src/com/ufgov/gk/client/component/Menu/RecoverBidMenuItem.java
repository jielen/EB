/**   
* @(#) project: ZFCG
* @(#) file: RecoverBidMenuItem.java
* 
* Copyright 2011 UFGOV, Inc. All rights reserved.
* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
* 
*/
package com.ufgov.gk.client.component.Menu;

/**
* @ClassName: RecoverBidMenuItem
* @Description: TODO(这里用一句话描述这个类的作用)
* @date: 2011-6-9 上午11:11:45
* @version: V1.0 
* @since: 1.0
* @author: fanpl
* @modify: 
*/
public class RecoverBidMenuItem extends FuncMenuItem {

  private static final long serialVersionUID = 4054640434388046008L;

  public RecoverBidMenuItem() {
    super();
  }

  @Override
  protected void init() {
    this.funcId = "frecoverBid";
    this.defaultText = "恢复";
    super.init();
  }

}
