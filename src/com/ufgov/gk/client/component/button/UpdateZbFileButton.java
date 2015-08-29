/**   
* @(#) project: ZFCG
* @(#) file: UpdateZbFileButton.java
* 
* Copyright 2011 UFGOV, Inc. All rights reserved.
* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
* 
*/
package com.ufgov.gk.client.component.button;

/**
* @ClassName: UpdateZbFileButton
* @Description: TODO(这里用一句话描述这个类的作用)
* @date: 2011-3-23 下午05:28:27
* @version: V1.0 
* @since: 1.0
* @author: fanpl
* @modify: 
*/
public class UpdateZbFileButton extends FuncButton {
  /**
   * 
   */
  private static final long serialVersionUID = -2564446291342163428L;

  public UpdateZbFileButton() {
    super();
  }

  protected void init() {
    this.funcCtrl = true;
    this.funcId = "fupdateZbFile";
    this.defaultText = "同步招标文件到服务器";
    this.iconName = "export.jpg";
    super.init();

  }

}
