package com.ufgov.gk.client.common.converter;

import java.util.List;
import java.util.Vector;

import javax.swing.table.TableModel;

import com.ufgov.gk.client.common.LangTransMeta;
import com.ufgov.gk.client.common.MyTableModel;
import com.ufgov.gk.common.ebay.model.EbCategory;
import com.ufgov.gk.common.system.constants.ZcElementConstants;

public class EbCategoryToTableModelConverter {

  public TableModel convertToTableModel(List ebCategoryLst) {
    MyTableModel tableModel = null;
    Vector names = new Vector();
    Vector values = new Vector();

    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CATEGORY_CATEGORY_ID));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CATEGORY_CATEGORY_NAME));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CATEGORY_PARENT_ID));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CATEGORY_PARENT_NAME));

    if (ebCategoryLst != null && ebCategoryLst.size() > 0) {
      for (int i = 0; i < ebCategoryLst.size(); i++) {
        Vector rowData = new Vector();
        EbCategory bt = (EbCategory) ebCategoryLst.get(i);
        rowData.add(bt.getCategoryId());
        rowData.add(bt.getCategoryName());
        rowData.add(bt.getParentId());
        rowData.add(bt.getParentName());
        values.add(rowData);
      }
    }
    tableModel = new MyTableModel(values, names) {
      public Class getColumnClass(int column) {
        if ((column >= 0) && (column < getColumnCount()) && this.getRowCount() > 0) {
          for (int row = 0; row < this.getRowCount(); row++) {
            if (getValueAt(row, column) != null) {
              return getValueAt(row, column).getClass();
            }
          }
        }
        return Object.class;
      }

      public boolean isCellEditable(int row, int colum) {
        return false;
      }
    };
    tableModel.setList(ebCategoryLst);
    return tableModel;
  }
}
