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
* @Description: TODO(������һ�仰��������������)
* @date: 2011-6-8 ����06:09:58
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
    this.defaultText = "��ʾ������������ܱ�";
    super.init();
  }

}
