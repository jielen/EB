/**   
* @(#) project: ZFCG
* @(#) file: FuncMenuItem.java
* 
* Copyright 2011 UFGOV, Inc. All rights reserved.
* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
* 
*/
package com.ufgov.gk.client.component.Menu;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;

import com.ufgov.gk.client.common.AsCompoMeta;
import com.ufgov.gk.client.common.CompoFuncBean;
import com.ufgov.gk.client.common.LangTransMeta;
import com.ufgov.gk.client.common.UserFuncBean;
import com.ufgov.gk.client.common.WorkEnv;
import com.ufgov.gk.common.system.model.UserFunc;

/**
* @ClassName: FuncMenuItem
* @Description: TODO(这里用一句话描述这个类的作用)
* @date: 2011-6-8 下午05:49:43
* @version: V1.0 
* @since: 1.0
* @author: fanpl
* @modify: 
*/
public class FuncMenuItem extends JMenuItem {

  /**
   * 
   */
  private static final long serialVersionUID = -2548570776006252996L;

  protected String moduleCode;

  protected String compoId;

  protected String funcId;

  protected boolean funcCtrl = true;

  protected String defaultText = "";

  protected String iconName = "default.gif";

  public String getCompoId() {
    return compoId;
  }

  public void setCompoId(String compoId) {
    this.compoId = compoId;
    this.setVisible(true);

  }

  public String getFuncId() {
    return funcId;
  }

  public void setFuncId(String funcId) {
    this.funcId = funcId;
  }

  public FuncMenuItem() {
    super();
    init();
  }

  public FuncMenuItem(Action a) {
    super(a);
    init();
  }

  public FuncMenuItem(Icon icon) {
    super(icon);
    init();

  }

  public FuncMenuItem(String text) {
    super(text);
    init();
  }

  public FuncMenuItem(String text, Icon icon) {
    super(text, icon);
    init();
  }

  protected void init() {
    this.setFocusable(false);
    //this.setVisible(true);
    this.setModuleCode("ZC");
    this.setButtonIcon();
  }

  public void setButtonIcon() {
    if (iconName != null && !iconName.trim().equals("")) {
      this.setIcon(new ImageIcon(this.getClass().getResource("/img/func/" + iconName)));
    } else {
      this.setIcon(new ImageIcon(this.getClass().getResource("/img/func/default.gif")));
    }
  }

  public void setFuncCtrl(boolean funcCtrl) {
    this.funcCtrl = funcCtrl;
  }

  @Override
  public void setVisible(boolean aFlag) {
    if (compoId != null && !"".equals(compoId.trim()) && funcCtrl) {//当是功能按钮时
      if (AsCompoMeta.isFuncControl(compoId)) {
        UserFunc userFunc = new UserFunc();
        userFunc.setUserId(WorkEnv.getInstance().getCurrUserId());
        userFunc.setCompoId(compoId);
        userFunc.setFuncId(funcId);

        if (!UserFuncBean.isGrant(userFunc)) {
          super.setVisible(false);
        } else {
          super.setVisible(aFlag);
        }

      } else {

        if (!CompoFuncBean.isUsed(compoId, funcId)) {
          super.setVisible(false);
        } else {
          super.setVisible(aFlag);
        }

      }
    } else {
      super.setVisible(aFlag);
    }
  }

  public String getModuleCode() {
    return moduleCode;
  }

  public void setModuleCode(String moduleCode) {
    this.moduleCode = moduleCode;
    if (moduleCode != null && !moduleCode.trim().equals("") && funcId != null && !funcId.trim().equals("")) {
      String name0 = this.moduleCode + "_" + this.compoId + "_FUNC_" + this.funcId;
      String name1 = LangTransMeta.translate(name0);
      String name = name1;
      if (name.equals(name0)) {
        name = LangTransMeta.translate(this.moduleCode + "_FUNC_" + this.funcId);
      }
      this.setText(name);
    } else {
      this.setText(this.defaultText);
    }
    if (this.getText() != null && !this.getText().trim().equals("")) {
      setToolTipText(this.getText());
    }

  }

  public String getDefaultText() {
    return defaultText;
  }

  public void setDefaultText(String defaultText) {
    this.defaultText = defaultText;
  }

}
