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
* @Description: TODO(������һ�仰��������������)
* @date: 2011-6-9 ����02:28:37
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
    this.defaultText = "��ʾ��Ӧ�̱�����Ϣ";
    super.init();
  }

}
