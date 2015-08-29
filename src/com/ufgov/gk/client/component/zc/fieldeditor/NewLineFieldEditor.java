package com.ufgov.gk.client.component.zc.fieldeditor;

import javax.swing.JComponent;
import javax.swing.JTextField;

import com.ufgov.gk.client.component.ui.fieldeditor.AbstractFieldEditor;

public class NewLineFieldEditor extends AbstractFieldEditor {
  /**
   * 
   */
  private static final long serialVersionUID = -9126316741144675929L;

  public NewLineFieldEditor() {
    this.init("");
  }

  @Override
  protected JComponent createEditorComponent() {
    return new JTextField();
  }

  @Override
  public Object getValue() {
    return "";
  }

  @Override
  public void setValue(Object value) {

  }
}
