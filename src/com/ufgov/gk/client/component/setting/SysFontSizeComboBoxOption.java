package com.ufgov.gk.client.component.setting;

import com.ufgov.gk.client.common.AsOptionMeta;
import com.ufgov.gk.common.system.constants.SystemOptionConstants;
import com.ufgov.smartclient.component.JComboBoxEx;

public class SysFontSizeComboBoxOption  extends AbstractOption<JComboBoxEx> {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  
  
  public  SysFontSizeComboBoxOption(){
    this.init(SystemOptionConstants.OPT_PREFERRED_FONT_SIZE, "×ÖÌå´óÐ¡£º");
  }

  protected JComboBoxEx createOptionEditor() {
    
    String value = AsOptionMeta.getOptVal(optId); 
    this.oldValue=value;
    
    final JComboBoxEx editor = new JComboBoxEx();
    
    for (int i = 12; i <= 20; i++) {
      editor.addItem(i + "");
    }
    editor.setSelectedItem(value);
    
    return editor;
  }

  public void updateOption() {
    String size = (String) this.optionEditor.getSelectedItem();
    if(!size.equals(oldValue)){
      AsOptionMeta.updateOptVal(optId, size);
      oldValue=size;
    }
  }

}