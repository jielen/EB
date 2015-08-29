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
    this.init(SystemOptionConstants.OPT_SYS_LOOK_AND_FEEL, "������");
  }

  protected JComboBoxEx createOptionEditor() {
    
    String value = AsOptionMeta.getOptVal(optId); 
    this.oldValue=value;
    
    final JComboBoxEx editor = new JComboBoxEx();
    
    editor.addItem("0");
    editor.addItem("1");
    editor.addItemDisplaLable("0", "ϵͳĬ��");
    editor.addItemDisplaLable("1", "ˮ��һɫ");
    
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