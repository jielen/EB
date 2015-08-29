package com.ufgov.gk.client.component.setting;

import com.ufgov.gk.common.system.constants.SystemOptionConstants;

public class SysUseFreeStyleDialogOption extends CheckBoxOption {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public SysUseFreeStyleDialogOption() {
    this.init(SystemOptionConstants.OPT_FREE_STYLE_DIALOG, "使用Free风格对话框：", "1", "0");
  }
}
