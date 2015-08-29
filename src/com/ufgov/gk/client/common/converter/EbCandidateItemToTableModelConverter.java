package com.ufgov.gk.client.common.converter;

import java.util.List;
import java.util.Vector;

import javax.swing.table.TableModel;

import com.ufgov.gk.client.common.LangTransMeta;
import com.ufgov.gk.client.common.MyTableModel;
import com.ufgov.gk.common.ebay.model.EbCandidateItem;
import com.ufgov.gk.common.system.constants.ZcElementConstants;

public class EbCandidateItemToTableModelConverter {

  public TableModel convertToTableModel(List ebCandidateItemLst) {
    MyTableModel tableModel = null;
    Vector names = new Vector();
    Vector values = new Vector();

    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_ITEM_ID));
    //    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_CANDIDATE_ID));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_CATEGORY_ID));
    //    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_WEIGHT));
    //    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_ITEM_SIZE));
    //    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_TB_URL));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_TB_PRICE));
    //    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_TB_REMARK));
    //    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_EB_URL));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_EB_PRICE));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_EB_SOLD_QUALITY));
    //    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_EB_REMARK));
    //    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_TB_SHIPPING_FEE));
    //    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_REMARK));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_STATUS));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_CURRENCY_ID));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_EB_SITE));
    //    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_TB_FULL_NAME));
    //    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_EB_FULL_NAME));
    //    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_EB_SHIPPING_FEE));
    //    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_ALI_URL));
    //    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_ALI_PRICE));
    //    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_ALI_REMARK));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_NAME));

    if (ebCandidateItemLst != null && ebCandidateItemLst.size() > 0) {
      for (int i = 0; i < ebCandidateItemLst.size(); i++) {
        Vector rowData = new Vector();
        EbCandidateItem bt = (EbCandidateItem) ebCandidateItemLst.get(i);
        rowData.add(bt.getItemId());
        //        rowData.add(bt.getCandidateId());
        rowData.add(bt.getCategoryId());
        //        rowData.add(bt.getWeight());
        //        rowData.add(bt.getItemSize());
        //        rowData.add(bt.getTbUrl());
        rowData.add(bt.getTbPrice());
        //        rowData.add(bt.getTbRemark());
        //        rowData.add(bt.getEbUrl());
        rowData.add(bt.getEbPrice());
        rowData.add(bt.getEbSoldQuality());
        //        rowData.add(bt.getEbRemark());
        //        rowData.add(bt.getTbShippingFee());
        //        rowData.add(bt.getRemark());
        rowData.add(bt.getStatus());
        rowData.add(bt.getCurrencyId());
        rowData.add(bt.getEbSite());
        //        rowData.add(bt.getTbFullName());
        //        rowData.add(bt.getEbFullName());
        //        rowData.add(bt.getEbShippingFee());
        //        rowData.add(bt.getAliUrl());
        //        rowData.add(bt.getAliPrice());
        //        rowData.add(bt.getAliRemark());
        rowData.add(bt.getName());
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
    tableModel.setList(ebCandidateItemLst);
    return tableModel;
  }

}
