/**   
* @(#) project: ZFCG
* @(#) file: showDetailbjMenuItem.java
* 
* Copyright 2011 UFGOV, Inc. All rights reserved.
* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
* 
*/
package com.ufgov.gk.client.component.Menu;

/**
* @ClassName: showDetailbjMenuItem
* @Description: TODO(这里用一句话描述这个类的作用)
* @date: 2011-6-9 下午02:28:37
* @version: V1.0 
* @since: 1.0
* @author: fanpl
* @modify: 
*/
public class ShowDetailbjMenuItem extends FuncMenuItem {

  public ShowDetailbjMenuItem() {
    super();
  }

  @Override
  protected void init() {
    this.funcCtrl = false;
    this.funcId = "fYlbPrint";
    this.defaultText = "显示供应商报价信息";
    super.init();
  }

}
