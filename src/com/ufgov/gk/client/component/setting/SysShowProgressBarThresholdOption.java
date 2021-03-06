package com.ufgov.gk.client.component.setting;

import javax.swing.JTextField;

import com.ufgov.gk.client.component.IntDocument;
import com.ufgov.gk.common.system.constants.BusinessOptionConstants;

public class SysShowProgressBarThresholdOption extends TextFieldOption{

  public SysShowProgressBarThresholdOption(){
    this.init(BusinessOptionConstants.OPT_GK_SHOW_PROGRESS_BAR_THRESHOLD, "显示进度条的阀值：");
  }

  protected JTextField createOptionEditor() {
    JTextField field=super.createOptionEditor();
    String v=field.getText();
    field.setDocument(new IntDocument());
    field.setText(v);
    return  field;
  }
}
