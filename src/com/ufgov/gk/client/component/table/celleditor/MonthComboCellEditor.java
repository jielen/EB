package com.ufgov.gk.client.component.table.celleditor;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import com.ufgov.gk.client.component.MonthComboBox;
import com.ufgov.gk.common.system.model.AsVal;

public class MonthComboCellEditor extends AbstractCellEditor implements TableCellEditor {
  private MonthComboBox planMothCombox = new MonthComboBox();

  private MonthComboCellEditor self = this;

  public MonthComboCellEditor(int curMonth) {
    planMothCombox.setSelectedAsValByCode(Integer.toString(curMonth));
    planMothCombox.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        self.stopCellEditing();
      }
    });
  }

  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
    int column) {
    if (value instanceof AsVal) {
      AsVal asVal = (AsVal) value;
      planMothCombox.setSelectedAsValByCode(asVal.getValId());
    } else {
      if (value != null)
        planMothCombox.setSelectedAsValByCode(value.toString());
    }
    return planMothCombox;
  }

  public Object getCellEditorValue() {
    Object obj = planMothCombox.getSelectedAsVal();
    if (obj != null) {
      AsVal asVal = (AsVal) obj;
      return asVal;
    } else {
      return planMothCombox.getSelectedItem();
    }
  }

}
