package com.ufgov.gk.client.component.setting;

import javax.swing.JTextField;

import com.ufgov.gk.client.common.AsOptionMeta;

public class TextFieldOption  extends AbstractOption<JTextField> {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  protected JTextField createOptionEditor() {
    
    String value = AsOptionMeta.getOptVal(this.optId);
    oldValue=value;
    
    final JTextField editor = new JTextField(20);
    editor.setText(value);
    
    return editor;
  }
  
  public  void updateOption(){
    String val = optionEditor.getText();
    if(!val.equals(oldValue)){
      AsOptionMeta.updateOptVal(optId, val);
      oldValue=val;
    }
  }
}