package com.ufgov.gk.client.common.converter;

import java.util.List;
import java.util.Vector;

import javax.swing.table.TableModel;

import com.ufgov.gk.client.common.LangTransMeta;
import com.ufgov.gk.client.common.MyTableModel;
import com.ufgov.gk.common.ebay.model.EbAppAccount;
import com.ufgov.gk.common.system.constants.ZcElementConstants;

public class EbAppAccountToTableModelConverter {

  public TableModel convertToTableModel(List ebAppServerLst) {
    MyTableModel tableModel = null;
    Vector names = new Vector();
    Vector values = new Vector();

    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_APP_ACCOUNT_APP_ACCOUNT));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_APP_ACCOUNT_EBAY_ACCOUNT));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_APP_ACCOUNT_CALL_LIMITATION));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_APP_ACCOUNT_TOKEN_EXPIRE_TIME));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_APP_ACCOUNT_PRODUCTION_DEVID));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_APP_ACCOUNT_PRODUCTION_APPID));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_APP_ACCOUNT_PRODUCTION_CERTID));
    //    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_APP_ACCOUNT_PRODUCTION_TOKEN));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_APP_ACCOUNT_SANDBOX_DEVID));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_APP_ACCOUNT_SANDBOX_APPID));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_APP_ACCOUNT_SANDBOX_CERTID));
    //    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_APP_ACCOUNT_SANDBOX_TOKEN));

    if (ebAppServerLst != null && ebAppServerLst.size() > 0) {
      for (int i = 0; i < ebAppServerLst.size(); i++) {
        Vector rowData = new Vector();
        EbAppAccount account = (EbAppAccount) ebAppServerLst.get(i);
        rowData.add(account.getAppAccount());
        rowData.add(account.getEbayAccount());
        rowData.add(account.getCallLimitation());
        rowData.add(account.getTokenExpireTime());
        rowData.add(account.getProductionDevid());
        rowData.add(account.getProductionAppid());
        rowData.add(account.getProductionCertid());
        //        rowData.add(account.getProductionToken());
        rowData.add(account.getSandboxDevid());
        rowData.add(account.getSandboxAppid());
        rowData.add(account.getSandboxCertid());
        //        rowData.add(account.getSandboxToken());
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
