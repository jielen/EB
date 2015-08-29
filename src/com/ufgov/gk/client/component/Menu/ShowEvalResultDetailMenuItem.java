/**   
* @(#) project: ZFCG
* @(#) file: ShowEvalResultDetailMenuItem.java
* 
* Copyright 2011 UFGOV, Inc. All rights reserved.
* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
* 
*/
package com.ufgov.gk.client.component.Menu;

/**
* @ClassName: ShowEvalResultDetailMenuItem
* @Description: TODO(这里用一句话描述这个类的作用)
* @date: 2011-6-8 下午06:05:10
* @version: V1.0 
* @since: 1.0
* @author: fanpl
* @modify: 
*/
public class ShowEvalResultDetailMenuItem extends FuncMenuItem {

  private static final long serialVersionUID = 8176162602374543497L;

  public ShowEvalResultDetailMenuItem() {
    super();
  }

  @Override
  protected void init() {
    this.funcCtrl = false;
    this.funcId = "fShowEvalResultDetal";
    this.defaultText = "显示专家评分表";
    super.init();
  }

}
