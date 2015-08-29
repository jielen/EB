/**   
* @(#) project: ZFCG
* @(#) file: SumScoreMenuItem.java
* 
* Copyright 2011 UFGOV, Inc. All rights reserved.
* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
* 
*/
package com.ufgov.gk.client.component.Menu;

/**
* @ClassName: SumScoreMenuItem
* @Description: TODO(������һ�仰��������������)
* @date: 2011-6-9 ����02:11:31
* @version: V1.0 
* @since: 1.0
* @author: fanpl
* @modify: 
*/
public class SumScoreMenuItem extends FuncMenuItem {

  private static final long serialVersionUID = 8176162602374553497L;

  public SumScoreMenuItem() {
    super();
  }

  @Override
  protected void init() {
    this.funcCtrl = false;
    this.funcId = "fsumScoreEvalResult";
    this.defaultText = "����������������";
    super.init();
  }
}
