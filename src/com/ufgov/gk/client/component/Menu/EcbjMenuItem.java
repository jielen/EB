/**   
* @(#) project: ZFCG
* @(#) file: EcbjMenuItem.java
* 
* Copyright 2011 UFGOV, Inc. All rights reserved.
* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
* 
*/
package com.ufgov.gk.client.component.Menu;

/**
* @ClassName: EcbjMenuItem
* @Description: TODO(������һ�仰��������������)
* @date: 2011-6-9 ����11:35:50
* @version: V1.0 
* @since: 1.0
* @author: fanpl
* @modify: 
*/
public class EcbjMenuItem extends FuncMenuItem {

  /**
   * 
   */
  private static final long serialVersionUID = -2564446291342163428L;

  public EcbjMenuItem() {
    super();
  }

  @Override
  protected void init() {
    this.funcCtrl = true;
    this.funcId = "fecbj";
    this.defaultText = "�ٴα���";
    this.iconName = "group_edit.png";
    super.init();
  }

}
