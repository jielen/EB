package com.ufgov.gk.client.common.converter;

import java.util.List;
import java.util.Vector;

import javax.swing.table.TableModel;

import com.ufgov.gk.client.common.LangTransMeta;
import com.ufgov.gk.client.common.MyTableModel;
import com.ufgov.gk.common.ebay.model.EbCurrency;
import com.ufgov.gk.common.system.constants.ZcElementConstants;

public class EbCurrencyToTableModelConverter {

  public TableModel convertToTableModel(List ebCurrencyLst) {
    MyTableModel tableModel = null;
    Vector names = new Vector();
    Vector values = new Vector();

    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CURRENCY_CURRENCY_ID));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CURRENCY_NAME));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CURRENCY_EXCHANGE_RATE));

    if (ebCurrencyLst != null && ebCurrencyLst.size() > 0) {
      for (int i = 0; i < ebCurrencyLst.size(); i++) {
        Vector rowData = new Vector();
        EbCurrency bt = (EbCurrency) ebCurrencyLst.get(i);
        rowData.add(bt.getCurrencyId());
        rowData.add(bt.getName());
        rowData.add(bt.getExchangeRate());
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
    tableModel.setList(ebCurrencyLst);
    return tableModel;
  }
}
