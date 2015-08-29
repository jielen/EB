package com.ufgov.gk.client.component.table.celleditor;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import com.ufgov.gk.client.component.FileUploader;
import com.ufgov.gk.client.component.event.ValueChangeEvent;
import com.ufgov.gk.client.component.event.ValueChangeListener;
import com.ufgov.gk.client.component.table.GkAbstractCellEditor;
import com.ufgov.gk.common.system.model.AsFile;

public class FileCellEditor extends GkAbstractCellEditor implements TableCellEditor {
  private FileUploader fileNmaeFiled = new FileUploader();

  private FileCellEditor self = this;

  public FileCellEditor() {
    fileNmaeFiled.addValueChangeListener(new ValueChangeListener() {
      public void valueChanged(ValueChangeEvent e) {
        self.stopCellEditing();
      }
    });
  }

  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
    if (value instanceof AsFile) {
      fileNmaeFiled.setFileId(((AsFile) value).getFileId(), true);
    }
    return fileNmaeFiled;
  }

  public Object getCellEditorValue() {
    Object obj = fileNmaeFiled.getFile();
    if (obj != null) {
      return obj;
    } else {
      return fileNmaeFiled.getFileName();
    }
  }

}
