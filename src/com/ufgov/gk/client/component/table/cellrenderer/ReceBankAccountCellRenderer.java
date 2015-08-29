package com.ufgov.gk.client.component.table.cellrenderer;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import com.ufgov.gk.common.commonbiz.model.BankAccount;

public class ReceBankAccountCellRenderer extends JLabel implements TableCellRenderer {

  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
    boolean hasFocus, int row, int column) {
    if (value != null) {
      if (value instanceof BankAccount) {
        setText(((BankAccount) value).getBankAccCode());
      } else if (value instanceof String) {
        setText(value.toString());
      }
    } else {
      setText(null);
    }
    return this;

  }
}
