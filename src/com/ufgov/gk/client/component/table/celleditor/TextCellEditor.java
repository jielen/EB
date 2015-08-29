package com.ufgov.gk.client.component.table.celleditor;

import java.awt.Component;
import java.math.BigDecimal;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;

import com.ufgov.gk.client.component.table.GkAbstractCellEditor;

public class TextCellEditor extends GkAbstractCellEditor implements TableCellEditor {

  private JTextField field;

  public TextCellEditor() {
    this.init();
  }

  private void init() {
    field = new JTextField();
  }

  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
    if (value == null) {
      field.setText(null);
    } else {
      field.setText(value.toString());
    }
    return field;
  }

  public Object getCellEditorValue() {
    Object obj = field.getText();
    if (obj != null && !((String) obj).equals("")) {
      return obj;
    } else
      return null;
  }

}
