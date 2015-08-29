/**   
* @(#) project: ZFCG
* @(#) file: SumEvalResult.java
* 
* Copyright 2011 UFGOV, Inc. All rights reserved.
* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
* 
*/
package com.ufgov.gk.client.component.Menu;

/**
* @ClassName: SumEvalResult
* @Description: TODO(������һ�仰��������������)
* @date: 2011-6-9 ����02:06:00
* @version: V1.0 
* @since: 1.0
* @author: fanpl
* @modify: 
*/
public class SumEvalResult extends FuncMenuButton {

  private static final long serialVersionUID = 8176162602374543497L;

  public SumEvalResult() {
    super();
  }

  @Override
  protected void init() {
    this.funcCtrl = true;
    this.funcId = "fSumEvalResult";
    this.defaultText = "����������";
    this.iconName = "check.jpg";
    super.init();
  }

}
