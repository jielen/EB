/**   
* @(#) project: ZFCG
* @(#) file: ShowEvalComplResultDetalItem.java
* 
* Copyright 2011 UFGOV, Inc. All rights reserved.
* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
* 
*/
package com.ufgov.gk.client.component.Menu;

/**
* @ClassName: ShowEvalComplResultDetalItem
* @Description: TODO(������һ�仰��������������)
* @date: 2011-6-8 ����06:11:22
* @version: V1.0 
* @since: 1.0
* @author: fanpl
* @modify: 
*/
public class ShowEvalComplResultDetalItem extends FuncMenuItem {

  private static final long serialVersionUID = 8176162602374543497L;

  public ShowEvalComplResultDetalItem() {
    super();
  }

  @Override
  protected void init() {
    this.funcCtrl = false;
    this.funcId = "fShowEvalComlResultDetal";
    this.defaultText = "1231313131";
    super.init();
  }

}
