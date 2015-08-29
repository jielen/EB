package com.ufgov.gk.client.component.setting;

import com.ufgov.gk.client.common.AsOptionMeta;
import com.ufgov.gk.client.component.element.ColorSelectPanel;
import com.ufgov.gk.common.system.constants.BusinessOptionConstants;

public class SysColorPanelOption extends AbstractOption<ColorSelectPanel> {

  private String colorString;

  public SysColorPanelOption() {
    this.init(BusinessOptionConstants.OPT_UNTREAD_COLOR_OPTION, "�˻ص��ݵ���ɫ��");

    String code = AsOptionMeta.getOptVal(optId);
    this.oldValue = code;
    optionEditor = new ColorSelectPanel(code);
    colorString = (String) this.optionEditor.getColor();
  }

  public void updateOption() {
    colorString = (String) this.optionEditor.getColor();
    String code = "";
    if (colorString != null) {
      code = colorString;
    }
    if (!code.equals(oldValue)) {
      AsOptionMeta.updateOptVal(optId, code);
      oldValue = code;
    }
  }

  @Override
  protected ColorSelectPanel createOptionEditor() {
    return optionEditor;
  }

  public String getColorString() {
    return optionEditor.getColor();
  }

}