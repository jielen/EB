package com.ufgov.gk.client.component.setting;

import com.ufgov.gk.client.common.AsOptionMeta;
import com.ufgov.gk.common.system.constants.SystemOptionConstants;
import com.ufgov.smartclient.component.JComboBoxEx;

public class LookAndFeelComboBoxOption  extends AbstractOption<JComboBoxEx> {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  
  
  public  LookAndFeelComboBoxOption(){
    this.init(SystemOptionConstants.OPT_SYS_LOOK_AND_FEEL, "界面风格：");
  }

  protected JComboBoxEx createOptionEditor() {
    
    String value = AsOptionMeta.getOptVal(optId); 
    this.oldValue=value;
    
    final JComboBoxEx editor = new JComboBoxEx();
    
    editor.addItem("0");
    editor.addItem("1");
    editor.addItemDisplaLable("0", "系统默认");
    editor.addItemDisplaLable("1", "水天一色");
    
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