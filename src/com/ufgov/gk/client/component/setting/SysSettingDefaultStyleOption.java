package com.ufgov.gk.client.component.setting;

import com.ufgov.gk.common.system.constants.SystemOptionConstants;

public class SysSettingDefaultStyleOption extends CheckBoxOption {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public SysSettingDefaultStyleOption() {
    this.init(SystemOptionConstants.OPT_PREFER_SET_DEFAULT, "����Ĭ�Ϸ��", "1", "0");
  }
}
