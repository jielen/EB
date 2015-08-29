package com.ufgov.gk.client.component.table.celleditor;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;

import com.ufgov.gk.client.component.IntDocument;
import com.ufgov.gk.client.component.table.GkAbstractCellEditor;

public class IntCellEditor extends GkAbstractCellEditor implements TableCellEditor {
  private JTextField field;

  private boolean allowMinus = true;

  public IntCellEditor() {
  this.init();
  }

  public IntCellEditor(boolean allowMinus) {
    this.allowMinus=allowMinus;
    init();
  }

  private void init() {
    field = new JTextField();
    field.setDocument(new IntDocument(this.allowMinus));
  }

  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
    int column) {
    if (value == null) {
      field.setText(null);
    } else if (value instanceof Integer) {
      field.setText(((Integer) value).toString());
    }
    return field;
  }

  public Object getCellEditorValue() {
    Object obj = field.getText();
    if (obj != null && !((String) obj).trim().equals("")) {
      return new Integer(field.getText());
    } else
      return null;
  }

}
