/**
 * ForeignEntityFieldPanel.java
 * com.ufgov.gk.client.component.zc.fieldeditor
 * Administrator
 * 2010-5-4
 */
package com.ufgov.gk.client.component.zc.fieldeditor;

import java.awt.BorderLayout;

import javax.swing.JComponent;

import com.ufgov.gk.client.component.FileUploader;
import com.ufgov.gk.client.component.event.ValueChangeEvent;
import com.ufgov.gk.client.component.event.ValueChangeListener;
import com.ufgov.gk.client.component.ui.fieldeditor.AbstractFieldEditor;
import com.ufgov.gk.common.commonbiz.model.BaseBill;
import com.ufgov.gk.common.system.util.BeanUtil;

/**
 * @author Administrator
 *
 */
public class SelectFileFieldEditor extends AbstractFieldEditor {
  private FileUploader field;

  private boolean isDeleteOldFile = false;

  private boolean uploadButton = true;

  private boolean deleteButton = true;

  private boolean downloadButton = true;

  private String blobId = "Blobid";

  public SelectFileFieldEditor(String name, String fieldName) {
    this.fieldName = fieldName;
    init(name);
  }

  public SelectFileFieldEditor(String name, String fieldName, String blobId) {
    this.fieldName = fieldName;
    this.blobId = blobId;
    init(name);
  }

  public SelectFileFieldEditor(String name, String fieldName, String blobId, boolean isDeleteOldFile) {
    this.fieldName = fieldName;
    this.blobId = blobId;
    this.isDeleteOldFile = isDeleteOldFile;
    init(name);
  }

  public SelectFileFieldEditor(String name, String fieldName, String blobId, boolean isDeleteOldFile, boolean uploadButton, boolean deleteButton,
    boolean downloadButton) {
    this.fieldName = fieldName;
    this.blobId = blobId;
    this.isDeleteOldFile = isDeleteOldFile;
    this.uploadButton = uploadButton;
    this.deleteButton = deleteButton;
    this.downloadButton = downloadButton;
    init(name);
  }

  protected void init(String name) {
    setName(name);
    setBorder(null);
    setLayout(new BorderLayout());
    editorComponent = createEditorComponent();
    setFieldEditorCode();
    add(editorComponent);
  }

  public void setEnabled(boolean enabled) {
    field.setEditable(enabled);
    field.setEnabled(enabled);
  }

  public Object getValue() {
    return field.getText();
  }

  public void setValue(Object value) { //��ѡ���������з����ı��ʱ�����������¼�
    if (value == null) {
      field.setText(null);
      field.setToolTipText(null);
    } else if (value instanceof BaseBill) {
      String fileName = (String) BeanUtil.get(fieldName, value);
      String fileId = (String) BeanUtil.get(this.blobId, value);
      field.setText(fileName);
      field.setFileId(fileId, true);
      if (fileName == null || fileName.trim().equals("")) {
        field.setToolTipText(null);
      } else {
        field.setToolTipText(fileName);
      }
    }
  }

  protected JComponent createEditorComponent() { //��������Ŀؼ��������ı������ͬ����������
    field = new FileUploader(this.uploadButton, this.deleteButton, this.downloadButton, this.isDeleteOldFile);

    field.addValueChangeListener(new ValueChangeListener() {
      public void valueChanged(ValueChangeEvent e) {
        syncEditObject();
      }
    });
    return field;
  }

  protected void syncEditObject() {
    if (getEditObject() != null) {
      BeanUtil.set(fieldName, field.getText(), getEditObject());
    }
    this.fireEditSynced();
  }

  public FileUploader getFileUploader() {
    return field;
  }

  public void setFileBlobName(FileUploader fileUploader) {
    this.field = fileUploader;
  }

  public void addValueChangeListener(ValueChangeListener l) {
    this.field.addValueChangeListener(l);
  }
}
