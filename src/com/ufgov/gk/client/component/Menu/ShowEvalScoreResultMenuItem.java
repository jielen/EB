/**   
* @(#) project: ZFCG
* @(#) file: showEvalScoreResultMenuItem.java
* 
* Copyright 2011 UFGOV, Inc. All rights reserved.
* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
* 
*/
package com.ufgov.gk.client.component.Menu;

/**
* @ClassName: showEvalScoreResultMenuItem
* @Description: TODO(这里用一句话描述这个类的作用)
* @date: 2011-6-9 下午03:32:10
* @version: V1.0 
* @since: 1.0
* @author: fanpl
* @modify: 
*/
public class ShowEvalScoreResultMenuItem extends FuncMenuItem {
  private static final long serialVersionUID = 8176162602374553497L;

  public ShowEvalScoreResultMenuItem() {
    super();
  }

  @Override
  protected void init() {
    this.funcCtrl = false;
    this.funcId = "fShowEvalResult";
    this.defaultText = "评分汇总表";
    super.init();
  }
}
