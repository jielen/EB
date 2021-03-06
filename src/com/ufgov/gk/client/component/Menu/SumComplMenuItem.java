/**   
* @(#) project: ZFCG
* @(#) file: SumComplMenuItem.java
* 
* Copyright 2011 UFGOV, Inc. All rights reserved.
* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
* 
*/
package com.ufgov.gk.client.component.Menu;

/**
* @ClassName: SumComplMenuItem
* @Description: TODO(这里用一句话描述这个类的作用)
* @date: 2011-6-9 下午02:09:58
* @version: V1.0 
* @since: 1.0
* @author: fanpl
* @modify: 
*/
public class SumComplMenuItem extends FuncMenuItem {

  private static final long serialVersionUID = 8176162602374553497L;

  public SumComplMenuItem() {
    super();
  }

  @Override
  protected void init() {
    this.funcCtrl = false;
    this.funcId = "fsumComplEvalResult";
    this.defaultText = "汇总符合性评审结果";
    super.init();
  }

}
