package com.ufgov.gk.client.component.setting;

import javax.swing.JComponent;
import javax.swing.JLabel;

public abstract class AbstractOption<T extends JComponent>{
  
  protected  String optId;
  
  protected  String optName;
  
  protected  JLabel optNameLabel;
  
  protected  T optionEditor;
  
  protected String oldValue="";
  
  protected void init(String optId,String optName){
    this.optId=optId;
    this.optName=optName;
    this.optNameLabel=new JLabel(optName);
    this.optionEditor=createOptionEditor();
  }
  
  protected abstract T createOptionEditor();
  
  public abstract void updateOption();
  
  
  public String getOptId() {
    return optId;
  }

  public String getOptName() {
    return optName;
  }

  public JLabel getOptNameLabel() {
    return optNameLabel;
  }

  public T getOptionEditor() {
    return optionEditor;
  }
}
