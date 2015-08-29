package com.ufgov.gk.client.common.converter;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.TableModel;

import com.ufgov.gk.client.common.LangTransMeta;
import com.ufgov.gk.client.component.table.BeanTableModel;
import com.ufgov.gk.client.component.table.ColumnBeanPropertyPair;
import com.ufgov.gk.common.system.constants.ZcElementConstants;

public class EbCandidateItemRefToTableModelConverter {

  public TableModel convertToTableModel(List taskLst) {
    // TODO Auto-generated method stub

    BeanTableModel tm = createModel(taskLst);
    String[] colums = new String[] { LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_ITEM_ID),
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
    String[] names = new String[] { "ebItem.itemId", "ebItem.startTime", "ebItem.endTime", "ebItem.sellingDays", "ebItem.soldQuality",
      "ebItem.sellingPerDay", "ebItem.price", "ebItem.bidCount", "ebItem.url", "ebItem.siteId", "ebItem.name", "ebItem.sellerId",
      "ebItem.currencyId", "ebItem.shippingType", "ebItem.shippingFee", "ebItem.imageUrl", "ebItem.country", "ebItem.categoryId",
      "ebItem.categoryName", "ebItem.location", "ebItem.timeLeft", "ebItem.sku", "ebItem.listingType" };
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
    tm.setOidFieldName("ebItem.itemId");
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
