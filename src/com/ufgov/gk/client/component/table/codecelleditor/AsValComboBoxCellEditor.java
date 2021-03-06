package com.ufgov.gk.client.component.table.codecelleditor;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import com.ufgov.gk.client.component.AsValComboBox;
import com.ufgov.gk.client.component.table.GkAbstractCellEditor;
import com.ufgov.gk.common.system.model.AsVal;

public class AsValComboBoxCellEditor extends GkAbstractCellEditor implements TableCellEditor {

  private static final long serialVersionUID = -1014964575090820890L;

  private AsValComboBox editorComponent;

  private String asValSetId = null;

  private int currMRow;

  private int currMCol;

  private HashMap<String, String> oldValueMap = new HashMap();

  public AsValComboBoxCellEditor(String asValSetId) {
    this.asValSetId = asValSetId;
    editorComponent = new AsValComboBox(asValSetId, false);
    editorComponent.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        stopCellEditing();
      }
    });
  }
  //added by mengw 20100719增添手动输入combobox的列表数据 
  public AsValComboBoxCellEditor(String asValSetId,List dataList) {
    this.asValSetId = asValSetId;
    editorComponent = new AsValComboBox(asValSetId, false,dataList);
    editorComponent.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        stopCellEditing();
      }
    });
  }
 

  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
    currMRow = table.convertRowIndexToModel(row);
    currMCol = table.convertColumnIndexToModel(column);
    String flag = this.getModelIndexFlag();
    if (value instanceof AsVal) {
      AsVal asVal = (AsVal) value;
      editorComponent.setSelectedAsValByCode(asVal.getValId());
    } else {
      if (value != null)
        editorComponent.setSelectedAsValByCode(value.toString());
    }
    if (!oldValueMap.containsKey(flag)) {
      oldValueMap.put(flag, value==null?null:value.toString());
    }
    return editorComponent;
  }

  public Object getCellEditorValue() {
    String valId = null;
    AsVal value = editorComponent.getSelectedAsVal();
    if (value != null) {
      String flag = this.getModelIndexFlag();
      if (oldValueMap.containsKey(flag)) {
        String oldValue = oldValueMap.get(flag);
        if (oldValue != null && oldValue.equals(value.getValId())) {
          return oldValue;
        }
      }
      valId = value.getValId();
    }
    return valId;
  }

  private String getModelIndexFlag() {
    return ((new StringBuilder(currMRow)).append(currMCol)).toString();
  }
}
