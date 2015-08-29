package com.ufgov.gk.client.component.zc.fieldeditor;

import javax.swing.JComponent;

import com.ufgov.gk.client.component.FileUploader;
import com.ufgov.gk.client.component.event.ValueChangeEvent;
import com.ufgov.gk.client.component.event.ValueChangeListener;
import com.ufgov.gk.client.component.ui.fieldeditor.AbstractFieldEditor;
import com.ufgov.gk.common.commonbiz.model.BaseBill;
import com.ufgov.gk.common.system.util.BeanUtil;

public class FileFieldEditor extends AbstractFieldEditor {

  private static final long serialVersionUID = 530635732275237298L;

  private FileUploader field;

  private String fileId;

  private String fieldBlobId;

  public FileFieldEditor(String name, String fieldName, String fieldBlobId) {
    this.fieldBlobId = fieldBlobId;
    this.fieldName = fieldName;
    init(name);
  }

  public void setEnabled(boolean enabled) {
    //field.setEditable(enabled);
    //field.setEnabled(enabled);
    this.field.setFileId(this.fileId, enabled);
  }

  public Object getValue() {
    return field.getFileId();
  }

  public void setValue(Object value) {
    if (value == null) {
      field.setFileId(null, true);
      this.fileId = null;
    } else {
      this.fileId = (String) BeanUtil.get(fieldBlobId, value);
      field.setFileId(this.fileId, true);
      field.getFileId();
    }

  }

  protected JComponent createEditorComponent() {
    field = new FileUploader();
    field.addValueChangeListener(new ValueChangeListener() {
      public void valueChanged(ValueChangeEvent e) {
        BaseBill bill = (BaseBill) getEditObject();
        if (bill != null) {
          BeanUtil.set(fieldName, field.getFileName(), bill);
          BeanUtil.set(fieldBlobId, field.getFileId(), bill);
        }
        fireEditSynced();
      }
    });
    return field;
  }

}
