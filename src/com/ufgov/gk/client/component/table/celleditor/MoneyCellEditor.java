package com.ufgov.gk.client.component.table.celleditor;

import java.awt.Component;
import java.math.BigDecimal;
import java.util.HashMap;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;

import com.ufgov.gk.client.component.MoneyDocument;
import com.ufgov.gk.client.component.table.GkAbstractCellEditor;

public class MoneyCellEditor extends GkAbstractCellEditor implements TableCellEditor {

  private JTextField field;

  public JTextField getField() {
    return field;
  }

  private boolean allowMinus = true;

  private boolean isDefaultZreo = true;

  private HashMap<String, BigDecimal> oldValueMap = new HashMap();

  private int currMRow;

  private int currMCol;

  public MoneyCellEditor() {
    this.init();
  }

  public MoneyCellEditor(boolean allowMinus) {
    this.allowMinus = allowMinus;
    init();
  }

  public MoneyCellEditor(boolean allowMinus, boolean isDefaultZreo) {
    this.allowMinus = allowMinus;
    this.isDefaultZreo = isDefaultZreo;
    init();
  }

  private void init() {
    field = new JTextField();
    field.setDocument(new MoneyDocument(this.allowMinus));
    field.setHorizontalAlignment(JTextField.RIGHT);
  }

  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
    currMRow = table.convertRowIndexToModel(row);
    currMCol = table.convertColumnIndexToModel(column);
    String flag = this.getModelIndexFlag();
    if (value == null) {
      field.setText(null);
    } else if (value instanceof BigDecimal) {
      field.setText(((BigDecimal) value).toPlainString());
    }
    if (!oldValueMap.containsKey(flag)) {
      oldValueMap.put(flag, (BigDecimal) value);
    }
    return field;
  }

  public Object getCellEditorValue() {
    Object obj = field.getText();
    if (obj != null && !((String) obj).trim().equals("")) {
      String flag = this.getModelIndexFlag();
      if (oldValueMap.containsKey(flag)) {
        BigDecimal oldValue = oldValueMap.get(flag);
        if (oldValue != null && oldValue.toPlainString().equals((String) obj)) {
          return oldValue;
        }
      }
      return new BigDecimal(field.getText());
    } else {
      if (isDefaultZreo) {
        return new BigDecimal("0.00");
      }
      return null;
    }
  }

  private String getModelIndexFlag() {
    return ((new StringBuilder(Integer.toString(currMRow))).append(Integer.toString(currMCol))).toString();
  }
}
