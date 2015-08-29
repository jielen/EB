package com.ufgov.gk.client.common.converter;

import java.util.List;
import java.util.Vector;

import javax.swing.table.TableModel;

import com.ufgov.gk.client.common.LangTransMeta;
import com.ufgov.gk.client.common.MyTableModel;
import com.ufgov.gk.common.ebay.model.EbSellerGroup;
import com.ufgov.gk.common.system.constants.ZcElementConstants;

public class EbSellerGroupToTableModelConverter {

  public TableModel convertToTableModel(List ebSellerGroupLst) {
    MyTableModel tableModel = null;
    Vector names = new Vector();
    Vector values = new Vector();

    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_SELLER_GROUP_GROUP_ID));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_SELLER_GROUP_NAME));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_SELLER_GROUP_REMARK));

    if (ebSellerGroupLst != null && ebSellerGroupLst.size() > 0) {
      for (int i = 0; i < ebSellerGroupLst.size(); i++) {
        Vector rowData = new Vector();
        EbSellerGroup bt = (EbSellerGroup) ebSellerGroupLst.get(i);
        rowData.add(bt.getGroupId());
        rowData.add(bt.getName());
        rowData.add(bt.getRemark());
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
    tableModel.setList(ebSellerGroupLst);
    return tableModel;
  }
}
