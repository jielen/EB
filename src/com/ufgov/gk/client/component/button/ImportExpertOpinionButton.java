/**   
* @(#) project: ZFCG
* @(#) file: ImportExpertOpinionButton.java
* 
* Copyright 2011 UFGOV, Inc. All rights reserved.
* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
* 
*/
package com.ufgov.gk.client.component.button;

/**
* @ClassName: ImportExpertOpinionButton
* @Description: TODO(这里用一句话描述这个类的作用)
* @date: 2011-4-1 下午10:07:41
* @version: V1.0 
* @since: 1.0
* @author: fanpl
* @modify: 
*/
public class ImportExpertOpinionButton extends FuncButton {
  /**
   * 
   */
  private static final long serialVersionUID = -2564446291342163428L;

  public ImportExpertOpinionButton() {
    super();
  }

  protected void init() {
    this.funcId = "fImportOpinion";
    this.defaultText = "是否送主任审核";
    this.iconName = "send.jpg";
    super.init();
  }
}
