/**   
* @(#) project: ZC
* @(#) file: ReleaseBulletinButton.java
* 
* Copyright 2010 UFGOV, Inc. All rights reserved.
* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
* 
*/
package com.ufgov.gk.client.component.button;

/**
* @ClassName: ReleaseBulletinButton
* @Description: TODO(������һ�仰��������������)
* @date: 2010-9-26 ����11:52:09
* @version: V1.0 
* @since: 1.0
* @author: fanpeile
* @modify: 
*/
public class ReleaseBulletinButton extends FuncButton {
  /**
   * 
   */
  private static final long serialVersionUID = 4054640434388046008L;

  public ReleaseBulletinButton() {
    super();
  }

  protected void init() {

    this.funcId = "freleaseBulletin";
    this.defaultText = "�����б깫��";
    super.init();
  }

}
