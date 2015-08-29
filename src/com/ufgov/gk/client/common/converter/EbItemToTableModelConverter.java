package com.ufgov.gk.client.common.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.TableModel;

import com.ufgov.gk.client.common.LangTransMeta;
import com.ufgov.gk.client.common.MyTableModel;
import com.ufgov.gk.client.component.table.BeanTableModel;
import com.ufgov.gk.client.component.table.ColumnBeanPropertyPair;
import com.ufgov.gk.common.ebay.model.EbItem;
import com.ufgov.gk.common.system.constants.ZcElementConstants;

public class EbItemToTableModelConverter {

  public TableModel convertToTableModel(List ebItemLst) {
    MyTableModel tableModel = null;
    Vector names = new Vector();
    Vector values = new Vector();

    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_ITEM_ID));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_START_TIME));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_END_TIME));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_SELLING_DAYS));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_SOLD_QUALITY));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_SELLING_PER_DAY));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_PRICE));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_BID_COUNT));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_NAME));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_URL));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_SELLING_DAYS));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_SELLER_ID));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_CURRENCY_ID));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_SITE_ID));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_SHIPPING_TYPE));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_SHIPPING_FEE));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_IMAGE_URL));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_COUNTRY));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_CATEGORY_ID));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_CATEGORY_NAME));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_LOCATION));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_TIME_LEFT));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_SKU));
    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_LISTING_TYPE));

    if (ebItemLst != null && ebItemLst.size() > 0) {
      for (int i = 0; i < ebItemLst.size(); i++) {
        Vector rowData = new Vector();
        EbItem item = (EbItem) ebItemLst.get(i);
        rowData.add(item.getItemId());
        rowData.add(item.getStartTime());
        rowData.add(item.getEndTime());
        rowData.add(item.getSellingDays());
        rowData.add(item.getSoldQuality());
        rowData.add(item.getSellingPerDay());
        rowData.add(item.getPrice());
        rowData.add(item.getBidCount());
        rowData.add(item.getName());
        rowData.add(item.getUrl());
        rowData.add(item.getSellerId());
        rowData.add(item.getCurrencyId());
        rowData.add(item.getSiteId());
        rowData.add(item.getShippingType());
        rowData.add(item.getShippingFee());
        rowData.add(item.getImageUrl());
        rowData.add(item.getCountry());
        rowData.add(item.getCategoryId());
        rowData.add(item.getCategoryName());
        rowData.add(item.getLocation());
        rowData.add(item.getTimeLeft());
        rowData.add(item.getSku());
        rowData.add(item.getListingType());
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
        if (getColumnName(colum).equals(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_URL))
          || getColumnName(colum).equals(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_NAME))
          || getColumnName(colum).equals(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_PRICE))) {
          return true;
        }
        return false;
      }
    };
    tableModel.setList(ebItemLst);
    return tableModel;
  }

  public TableModel convertToTableModelNew(List taskLst) {
    // TODO Auto-generated method stub

    BeanTableModel tm = createModel(taskLst);
    String[] colums = new String[] { LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_ITEM_ID),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_CANDIDATE_STATUS),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_START_TIME), LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_END_TIME),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_SELLING_DAYS), LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_SOLD_QUALITY),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_SELLING_PER_DAY), LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_PRICE),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_BID_COUNT), LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_URL),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_SITE_ID), LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_NAME),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_SELLER_ID), LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_CURRENCY_ID),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_SHIPPING_TYPE),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_SHIPPING_FEE), LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_IMAGE_URL),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_COUNTRY), LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_CATEGORY_ID),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_CATEGORY_NAME), LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_LOCATION),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_TIME_LEFT), LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_SKU),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_LISTING_TYPE) };
    String[] names = new String[] { "itemId", "candidateStatus", "startTime", "endTime", "sellingDays", "soldQuality", "sellingPerDay", "price",
      "bidCount", "url", "siteId", "name", "sellerId", "currencyId", "shippingType", "shippingFee", "imageUrl", "country", "categoryId",
      "categoryName", "location", "timeLeft", "sku", "listingType" };
    tm.setDataBean(taskLst, createColumnBeanPropertyPairs(colums, names));
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

        if (identifier.equals(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_URL))
          || identifier.equals(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_NAME))
          || identifier.equals(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_SKU))
          || identifier.equals(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_IMAGE_URL))) {
          return true;
        }
        //        return false;
        return false;
      }

    };
    tm.setOidFieldName("itemId");
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

  public TableModel convertToTableModelGroup(List taskGroupLst) {
    // TODO Auto-generated method stub

    BeanTableModel tm = createModel(taskGroupLst);
    String[] colums = new String[] { LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_ITEMS),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_ITEM_ID), LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_START_TIME),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_END_TIME), LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_SELLING_DAYS),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_SOLD_QUALITY),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_SELLING_PER_DAY), LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_PRICE),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_BID_COUNT), LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_URL),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_SITE_ID), LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_NAME),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_SELLER_ID), LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_CURRENCY_ID),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_SHIPPING_TYPE),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_SHIPPING_FEE), LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_IMAGE_URL),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_COUNTRY), LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_CATEGORY_ID),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_CATEGORY_NAME), LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_LOCATION),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_TIME_LEFT), LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_SKU),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_LISTING_TYPE) };
    String[] names = new String[] { "items", "itemId", "startTime", "endTime", "sellingDays", "soldQuality", "sellingPerDay", "price", "bidCount",
      "url", "siteId", "name", "sellerId", "currencyId", "shippingType", "shippingFee", "imageUrl", "country", "categoryId", "categoryName",
      "location", "timeLeft", "sku", "listingType" };
    tm.setDataBean(taskGroupLst, createColumnBeanPropertyPairs(colums, names));
    return tm;
  }

}
