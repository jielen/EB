/**   
* @(#) project: ZFCG
* @(#) file: PauseBidMenuItem.java
* 
* Copyright 2011 UFGOV, Inc. All rights reserved.
* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
* 
*/
package com.ufgov.gk.client.component.Menu;

/**
* @ClassName: PauseBidMenuItem
* @Description: TODO(������һ�仰��������������)
* @date: 2011-6-9 ����11:10:26
* @version: V1.0 
* @since: 1.0
* @author: fanpl
* @modify: 
*/
public class PauseBidMenuItem extends FuncMenuItem {

  private static final long serialVersionUID = 4054640434388046008L;

  public PauseBidMenuItem() {
    super();
  }

  @Override
  protected void init() {
    this.funcId = "fpauseBid";
    this.defaultText = "��ͣ";
    super.init();
  }

}
