/**   
* @(#) project: ZFCG
* @(#) file: ShowEvalComplResultMenuItem.java
* 
* Copyright 2011 UFGOV, Inc. All rights reserved.
* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
* 
*/
package com.ufgov.gk.client.component.Menu;

/**
* @ClassName: ShowEvalComplResultMenuItem
* @Description: TODO(这里用一句话描述这个类的作用)
* @date: 2011-6-8 下午06:09:58
* @version: V1.0 
* @since: 1.0
* @author: fanpl
* @modify: 
*/
public class ShowEvalComplResultMenuItem extends FuncMenuItem {

  private static final long serialVersionUID = 8176162602374553497L;

  public ShowEvalComplResultMenuItem() {
    super();
  }

  @Override
  protected void init() {
    this.funcCtrl = false;
    this.funcId = "fShowEvalComlResult";
    this.defaultText = "显示符合性评审汇总表";
    super.init();
  }

}
