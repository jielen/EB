package com.ufgov.gk.client.common.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.TableModel;

import com.ufgov.gk.client.common.LangTransMeta;
import com.ufgov.gk.client.common.MyTableModel;
import com.ufgov.gk.client.component.table.BeanTableModel;
import com.ufgov.gk.client.component.table.ColumnBeanPropertyPair;
import com.ufgov.gk.common.ebay.model.EbSeller;
import com.ufgov.gk.common.system.constants.ZcElementConstants;

public class EbSellerToTableModelConverter {

  public TableModel convertToTableModel(List ebSellerLst) {
    MyTableModel tableModel = null;
    Vector names = new Vector();
    Vector values = new Vector();

    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_SELLER_SELLER_ID));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_SELLER_ATTENTION_STATUS));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_SELLER_REGISTER_DATE));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_SELLER_FEEDBACK));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_SELLER_GROUP_ID));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_SELLER_CONTRY));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_SELLER_CITY));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_SELLER_REMARK));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_SELLER_IMAGE_SITE));

    if (ebSellerLst != null && ebSellerLst.size() > 0) {
      for (int i = 0; i < ebSellerLst.size(); i++) {
        Vector rowData = new Vector();
        EbSeller seller = (EbSeller) ebSellerLst.get(i);
        rowData.add(seller.getSellerId());
        rowData.add(seller.getAttentionStatus());
        rowData.add(seller.getRegisterDate());
        rowData.add(seller.getFeedback());
        rowData.add(seller.getGroupId());
        rowData.add(seller.getContry());
        rowData.add(seller.getCity());
        rowData.add(seller.getRemark());
        rowData.add(seller.getImageSite());
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
    tableModel.setList(ebSellerLst);
    return tableModel;
  }

  public TableModel convertEbSellerToBeanTableModel(List sellerLst) {
    // TODO Auto-generated method stub

    BeanTableModel tm = createModel(sellerLst);
    String[] colums = new String[] { LangTransMeta.translate(ZcElementConstants.FIELD_EB_SELLER_SELLER_ID),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_SELLER_ATTENTION_STATUS),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_SELLER_CONTRY), LangTransMeta.translate(ZcElementConstants.FIELD_EB_SELLER_REGISTER_DATE),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_SELLER_FEEDBACK), LangTransMeta.translate(ZcElementConstants.FIELD_EB_SELLER_GROUP_ID),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_SELLER_CITY), LangTransMeta.translate(ZcElementConstants.FIELD_EB_SELLER_REMARK),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_SELLER_IMAGE_SITE) };
    String[] names = new String[] { "sellerId", "attentionStatus", "contry", "registerDate", "feedback", "groupId", "city", "remark", "imageSite" };
    tm.setDataBean(sellerLst, createColumnBeanPropertyPairs(colums, names));
    return tm;
  }

  private BeanTableModel createModel(List taskLst) {
    BeanTableModel tm = new BeanTableModel() {

      /* (non-Javadoc)
       * @see com.ufgov.gk.client.component.table.BeanTableModel#isCellEditable(int, int)
       */
      @Override
      public boolean isCellEditable(int row, int column) {
        String identifier = this.getColumnIdentifier(column);

        if (identifier.equals(LangTransMeta.translate(ZcElementConstants.FIELD_EB_SELLER_SELLER_ID))) {
          return true;
        }
        return false;
      }

    };
    tm.setOidFieldName("sellerId");
    return tm;
  }

  private List<ColumnBeanPropertyPair> createColumnBeanPropertyPairs(String[] colums, String[] names) {
    List<ColumnBeanPropertyPair> pairList = new ArrayList<ColumnBeanPropertyPair>();
    for (int i = 0; i < colums.length; i++) {

      ColumnBeanPropertyPair pair = new ColumnBeanPropertyPair();
      pair.setColumnIdentifier(colums[i]);
      pair.setBeanPropertyName(names[i]);
      pairList.add(pair);
    }
    return pairList;
  }
}
