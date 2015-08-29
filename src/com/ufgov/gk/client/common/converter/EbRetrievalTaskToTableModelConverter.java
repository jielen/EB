package com.ufgov.gk.client.common.converter;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.TableModel;

import com.ufgov.gk.client.common.LangTransMeta;
import com.ufgov.gk.client.component.table.BeanTableModel;
import com.ufgov.gk.client.component.table.ColumnBeanPropertyPair;
import com.ufgov.gk.common.system.constants.ZcElementConstants;

public class EbRetrievalTaskToTableModelConverter {

  public TableModel convertEbRetrievalTaskToTableModel(List taskLst) {
    // TODO Auto-generated method stub

    BeanTableModel tm = createModel(taskLst);
    String[] colums = new String[] { LangTransMeta.translate(ZcElementConstants.FIELD_EB_RETRIEVAL_TASK_SELLER_ID),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_RETRIEVAL_TASK_GROUP_ID),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_RETRIEVAL_TASK_TASK_START_TIME),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_RETRIEVAL_TASK_RETRIEVAL_TYPE),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_RETRIEVAL_TASK_SELLING_ITEM_QUALITY),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_RETRIEVAL_TASK_STATUS),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_RETRIEVAL_TASK_TOTAL_ITEM_QUALITY),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_RETRIEVAL_TASK_RETRIEVAL_ANCHOR_TIME),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_RETRIEVAL_TASK_STEP),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_RETRIEVAL_TASK_TIME_CONSUMING),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_RETRIEVAL_TASK_RETRIEVAL_MONTHS),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_RETRIEVAL_TASK_TOTAL_SOLD_AMOUNT),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_RETRIEVAL_TASK_TOTAL_SOLD_QUALITY),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_RETRIEVAL_TASK_CREATE_TIME),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_RETRIEVAL_TASK_ANALYSE_STATUS),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_RETRIEVAL_TASK_ANALYSE_TIME),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_SELLER_ATTENTION_STATUS),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_SELLER_CONTRY), LangTransMeta.translate(ZcElementConstants.FIELD_EB_SELLER_FEEDBACK),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_SELLER_REMARK) };
    String[] names = new String[] { "sellerId", "groupId", "taskStartTime", "retrievalType", "sellingItemQuality", "status", "totalItemQuality",
      "retrievalAnchorTime", "step", "timeConsuming", "retrievalMonths", "totalSoldAmount", "totalSoldQuality", "createTime", "analyseStatus",
      "analyseTime", "attentionStatus", "contry", "feedback", "remark" };
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

        //        if (identifier.equals("PACK_NAME")) {
        //          return true;
        //        }
        //        return false;
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
