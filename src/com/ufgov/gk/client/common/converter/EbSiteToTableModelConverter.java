package com.ufgov.gk.client.common.converter;

import java.util.List;
import java.util.Vector;

import javax.swing.table.TableModel;

import com.ufgov.gk.client.common.LangTransMeta;
import com.ufgov.gk.client.common.MyTableModel;
import com.ufgov.gk.common.ebay.model.EbSite;
import com.ufgov.gk.common.system.constants.ZcElementConstants;

public class EbSiteToTableModelConverter {

  public TableModel convertToTableModel(List zcEbPlanLst) {
    MyTableModel tableModel = null;
    Vector names = new Vector();
    Vector values = new Vector();

    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_SITE_SITE_ID));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_SITE_SITE_NAME));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_SITE_SITE_URL));

    if (zcEbPlanLst != null && zcEbPlanLst.size() > 0) {
      for (int i = 0; i < zcEbPlanLst.size(); i++) {
        Vector rowData = new Vector();
        EbSite bt = (EbSite) zcEbPlanLst.get(i);
        rowData.add(bt.getSiteId());
        rowData.add(bt.getSiteName());
        rowData.add(bt.getSiteUrl());
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
    tableModel.setList(zcEbPlanLst);
    return tableModel;
  }
}
