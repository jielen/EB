/**   
* @(#) project: ZFCG
* @(#) file: showBjMenuItem.java
* 
* Copyright 2011 UFGOV, Inc. All rights reserved.
* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
* 
*/
package com.ufgov.gk.client.component.Menu;

/**
* @ClassName: showBjMenuItem
* @Description: TODO(������һ�仰��������������)
* @date: 2011-6-9 ����02:29:36
* @version: V1.0 
* @since: 1.0
* @author: fanpl
* @modify: 
*/
public class ShowBjMenuItem extends FuncMenuItem {

  private static final long serialVersionUID = 8176162602374543497L;

  public ShowBjMenuItem() {
    super();
  }

  @Override
  protected void init() {
    this.funcCtrl = false;
    this.funcId = "fShowBjResult";
    this.defaultText = "��ʾ��Ӧ�̱�����Ϣ";
    super.init();
  }

}
