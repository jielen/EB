package com.ufgov.gk.client.common.converter;

import java.util.List;
import java.util.Vector;

import javax.swing.table.TableModel;

import com.ufgov.gk.client.common.LangTransMeta;
import com.ufgov.gk.client.common.MyTableModel;
import com.ufgov.gk.common.ebay.model.EbAppServer;
import com.ufgov.gk.common.system.constants.ZcElementConstants;

public class EbAppServerToTableModelConverter {

  public TableModel convertToTableModel(List ebAppServerLst) {
    MyTableModel tableModel = null;
    Vector names = new Vector();
    Vector values = new Vector();

    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_APP_SERVER_SITE_ID));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_APP_SERVER_SERVER_URL));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_APP_SERVER_EPS_SERVER_URL));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_APP_SERVER_SIGN_IN_URL));

    if (ebAppServerLst != null && ebAppServerLst.size() > 0) {
      for (int i = 0; i < ebAppServerLst.size(); i++) {
        Vector rowData = new Vector();
        EbAppServer bt = (EbAppServer) ebAppServerLst.get(i);
        rowData.add(bt.getSiteId());
        rowData.add(bt.getServerUrl());
        rowData.add(bt.getEpsServerUrl());
        rowData.add(bt.getSignInUrl());
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
    tableModel.setList(ebAppServerLst);
    return tableModel;
  }
}
