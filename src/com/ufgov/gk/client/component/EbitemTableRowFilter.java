/**
 * HastTableRowFilter.java
 * com.ufgov.gk.client.component
 * Administrator
 * Jul 5, 2012
 */
package com.ufgov.gk.client.component;

import java.math.BigDecimal;
import java.util.Hashtable;

import javax.swing.RowFilter;
import javax.swing.table.TableModel;

import com.ufgov.gk.client.common.LangTransMeta;
import com.ufgov.gk.common.ebay.model.EbItemChecked;
import com.ufgov.gk.common.system.constants.ZcElementConstants;
import com.ufgov.gk.common.system.constants.ZcSettingConstants;

/**
 * @author Administrator
 *
 */
public class EbitemTableRowFilter extends RowFilter {

  private Hashtable<EbFilterKey, Object> filts;

  private TableModel tableModel;

  public EbitemTableRowFilter(Hashtable<EbFilterKey, Object> filts, TableModel tableModel) {
    this.filts = filts;
    this.tableModel = tableModel;
  }

  @Override
  public boolean include(Entry entry) {
    // TODO Auto-generated method stub
    //    for (EbFilterKey key : filts.keySet()) {
    //      for (int i = 0; i < tableModel.getColumnCount(); i++) {
    //        String columnName = tableModel.getColumnName(i);
    //        if (key.getFieldName().equals(columnName)) {
    //          if (key.getFieldType() == EbFilterKey.TYPE_NUMBER) {
    //            BigDecimal val = new BigDecimal(entry.getStringValue(i));
    //            BigDecimal filtVal = (BigDecimal) filts.get(key);
    //            if (val.doubleValue() >= filtVal.doubleValue()) {
    //              return true;
    //            } else {
    //              return false;
    //            }
    //          }
    //        }
    //      }
    //    }
    if (filts == null || filts.keySet().size() == 0)
      return true;

    int bing = 0;//���д���
    for (int i = 0; i < tableModel.getColumnCount(); i++) {
      String columnName = tableModel.getColumnName(i);
      for (EbFilterKey key : filts.keySet()) {
        if (key.getFieldName().equals(columnName)) {
          if (key.getFieldType() == EbFilterKey.TYPE_DATE) {

          } else if (key.getFieldType() == EbFilterKey.TYPE_NUMBER) {
            BigDecimal val = new BigDecimal(entry.getStringValue(i));
            BigDecimal filtVal = (BigDecimal) filts.get(key);
            if (val.doubleValue() >= filtVal.doubleValue()) {
              ++bing;
            }
          } else if (key.getFieldType() == EbFilterKey.TYPE_STRING) {
            //            if (key.getFieldName().equals(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_CANDIDATE_STATUS))) {
            //              boolean f = ((Boolean) filts.get(key)).booleanValue();
            //              if (f) {//ֻ��ʾ��ѡ������
            //                String str = entry.getStringValue(i);
            //                if (str == null || str.trim().isEmpty()) {
            //                  ++bing;
            //                }
            //              } else {//ȫ�����ݣ������Ѿ�ѡ���δѡ���
            //                ++bing;
            //              }
            //            } 
            if (key.getFieldName().equals(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_CANDIDATE_STATUS))) {
              String status = (String) filts.get(key);
              if (status.equals(EbItemChecked.ALL)) {//��ʾȫ��
                ++bing;
              } else {
                String str = entry.getStringValue(i);
                //                System.out.println("str=" + str);
                if (EbItemChecked.WAITING_CHECK.equals(status)) {//ֻ��ʾ���������
                  status = "";
                }
                if (status.equals(str)) {
                  ++bing;
                }
              }
            } else if (key.getFieldName().equals(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_TIME_LEFT))) {
              boolean f = ((Boolean) filts.get(key)).booleanValue();
              if (f) {//ֻ��ʾ��������
                String str = entry.getStringValue(i);
                str = str == null ? "" : str.trim();
                if (!str.equals(ZcSettingConstants.TIME_LEFT_ZERO)) {//����ʣ��ʱ��
                  ++bing;
                }
              } else {//ȫ�����ݣ��������ۺ����۵�����
                ++bing;
              }
            }
          }
        }
      }
    }
    if (bing == filts.keySet().size()) {
      return true;
    } else {
      return false;
    }
  }
}
