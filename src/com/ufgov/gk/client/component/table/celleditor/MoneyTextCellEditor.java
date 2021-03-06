package com.ufgov.gk.client.component.table.celleditor;

import java.awt.Component;
import java.math.BigDecimal;

import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;

import com.ufgov.gk.client.component.MoneyDocument;

public class MoneyTextCellEditor extends AbstractCellEditor implements TableCellEditor {
  private JTextField field;

  public MoneyTextCellEditor() {
    field = new JTextField();
    field.setDocument(new MoneyDocument(true));
    field.setHorizontalAlignment(JTextField.RIGHT);
  }

  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
    int column) {
    if (value instanceof BigDecimal) {
      field.setText(value.toString());
    }
    return field;
  }

  public Object getCellEditorValue() {
    Object obj = field.getText();
    if (obj != null) {
      return obj.toString();
    } else
      return null;
  }

}
