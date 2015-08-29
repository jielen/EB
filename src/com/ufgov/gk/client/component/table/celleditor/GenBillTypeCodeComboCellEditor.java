package com.ufgov.gk.client.component.table.celleditor;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import com.ufgov.gk.client.component.GenBillTypoeComboBox;
import com.ufgov.gk.common.system.model.AsVal;

public class GenBillTypeCodeComboCellEditor extends AbstractCellEditor implements TableCellEditor {
  
  private GenBillTypoeComboBox genBillTypecombox = new GenBillTypoeComboBox();

  private GenBillTypeCodeComboCellEditor self = this;
  

  public GenBillTypeCodeComboCellEditor() {
    genBillTypecombox.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        self.stopCellEditing();
      }
    });
  }

  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
    int column) {
    if (value instanceof AsVal) {
      AsVal asVal = (AsVal) value;
      genBillTypecombox.setSelectedAsValByCode(asVal.getValId());
    } else {
      if (value != null)
        genBillTypecombox.setSelectedAsValByCode(value.toString());
    }
    return genBillTypecombox;
  }

  public Object getCellEditorValue() {
    Object obj = genBillTypecombox.getSelectedAsVal();
    if (obj != null) {
      AsVal asVal = (AsVal) obj;
      return asVal;
    } else {
      return genBillTypecombox.getSelectedItem();
    }
  }

}
