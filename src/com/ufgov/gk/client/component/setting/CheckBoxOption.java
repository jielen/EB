package com.ufgov.gk.client.component.setting;

import javax.swing.JCheckBox;

import com.ufgov.gk.client.common.AsOptionMeta;

public class CheckBoxOption  extends AbstractOption<JCheckBox> {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  protected String trueValue="1";
  
  protected String falseValue="0";
  
  protected void init(String optId,String optName,String trueValue,String falseValue){
    this.trueValue=trueValue;
    this.falseValue=falseValue;
    this.init(optId, optName);
  }
  protected JCheckBox createOptionEditor() {
    
    String value = AsOptionMeta.getOptVal(this.optId);
     oldValue=value;
    
    final JCheckBox checkBox = new JCheckBox();
    
    checkBox.setSelected(trueValue.equals(value) ? true : false);
    
    return checkBox;
  }
  
  public  void updateOption(){
    
    String val = falseValue;
    if (this.optionEditor.isSelected()) {
      val = trueValue;
    }
    
    if(!val.equals(oldValue)){// �����ı��Ÿ���
      AsOptionMeta.updateOptVal(optId, val);
      oldValue=val;
    }
  }

}