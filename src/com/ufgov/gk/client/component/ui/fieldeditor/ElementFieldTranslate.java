/**
 *
 */
package com.ufgov.gk.client.component.ui.fieldeditor;

import com.ufgov.gk.client.common.LangTransMeta;
import com.ufgov.gk.common.system.constants.AmElementConstants;
import com.ufgov.gk.common.system.constants.CpElementConstants;
import com.ufgov.gk.common.system.constants.DpElementConstants;

/**
 * @author ufwangfei
 * 1.按照字段名和产品代码取得不同的字段翻译
 *
 */
public class ElementFieldTranslate {
  /**
   * 按照字段名和产品代码取得不同的字段翻译;
   * @param curFieldName
   * @return
   */
  public static String getCurTransFieldByProduct(String product, String curFieldName) {
    String transName = "";
    if (product == "DP") {
      if (curFieldName.equalsIgnoreCase(DpElementConstants.FIELD_NAME_B_ACC_CODE)) {
        transName = LangTransMeta.translate(DpElementConstants.FIELD_TRANS_B_ACC_NAME);
      }
      if (curFieldName.equalsIgnoreCase(DpElementConstants.FIELD_NAME_OUTLAY_CODE)) {
        transName = LangTransMeta.translate(DpElementConstants.FIELD_TRANS_OUTLAY_NAME);
      }
      if (curFieldName.equalsIgnoreCase(DpElementConstants.FIELD_NAME_REMARK)) {
        transName = LangTransMeta.translate(DpElementConstants.FIELD_TRANS_REMARK);
      }
      if (curFieldName.equalsIgnoreCase(DpElementConstants.FIELD_NAME_FILENAME)) {
        transName = LangTransMeta.translate(DpElementConstants.FIELD_TRANS_FILENAME);
      }
    }
    if (product == "CP") {
      if (curFieldName.equalsIgnoreCase(CpElementConstants.FIELD_NAME_B_ACC_CODE)) {
        transName = LangTransMeta.translate(CpElementConstants.FIELD_TRANS_B_ACC_NAME);
      }
      if (curFieldName.equalsIgnoreCase(CpElementConstants.FIELD_NAME_OUTLAY_CODE)) {
        transName = LangTransMeta.translate(CpElementConstants.FIELD_TRANS_OUTLAY_NAME);
      }
      if (curFieldName.equalsIgnoreCase(CpElementConstants.FIELD_NAME_OPERATION_TYPE_CODE)) {
        transName = LangTransMeta.translate(CpElementConstants.FIELD_TRANS_OPERATION_TYPE_NAME);
      }
      if (curFieldName.equalsIgnoreCase(CpElementConstants.FIELD_NAME_CHECK_NO)) {
        transName = LangTransMeta.translate(CpElementConstants.FIELD_TRANS_CHECK_NO);
      }
      if (curFieldName.equalsIgnoreCase(CpElementConstants.FIELD_NAME_CONTRACT_CODE)) {
        transName = LangTransMeta.translate(CpElementConstants.FIELD_TRANS_CONTRACT_NAME);
      }
      if (curFieldName.equalsIgnoreCase(CpElementConstants.FIELD_NAME_BAL_MODE_CODE)) {
        transName = LangTransMeta.translate(CpElementConstants.FIELD_TRANS_BAL_MODE_NAME);
      }
      if (curFieldName.equalsIgnoreCase(CpElementConstants.FIELD_NAME_REMARK)) {
        transName = LangTransMeta.translate(CpElementConstants.FIELD_TRANS_REMARK);
      }
      if (curFieldName.equalsIgnoreCase(CpElementConstants.FIELD_NAME_FILENAME)) {
        transName = LangTransMeta.translate(CpElementConstants.FIELD_TRANS_FILENAME);
      }
      if (curFieldName.equalsIgnoreCase(CpElementConstants.FIELD_NAME_IS_COUNTERSIGN)) {
        transName = LangTransMeta.translate(CpElementConstants.FIELD_TRANS_IS_COUNTERSIGN);
      }
      if (curFieldName.equalsIgnoreCase(CpElementConstants.FIELD_NAME_COUNTERSIGNER)) {
        transName = LangTransMeta.translate(CpElementConstants.FIELD_TRANS_COUNTERSIGNER);
      }

    }

    if (product == "AM") {
      if (curFieldName.equalsIgnoreCase(AmElementConstants.FIELD_NAME_B_ACC_CODE)) {
        transName = LangTransMeta.translate(AmElementConstants.FIELD_TRANS_B_ACC_NAME);
      }
      if (curFieldName.equalsIgnoreCase(AmElementConstants.FIELD_NAME_OUTLAY_CODE)) {
        transName = LangTransMeta.translate(AmElementConstants.FIELD_TRANS_OUTLAY_NAME);
      }
      if (curFieldName.equalsIgnoreCase(AmElementConstants.FIELD_NAME_OPERATION_TYPE_CODE)) {
        transName = LangTransMeta.translate(AmElementConstants.FIELD_TRANS_OPERATION_TYPE_NAME);
      }
      if (curFieldName.equalsIgnoreCase(AmElementConstants.FIELD_NAME_CHECK_NO)) {
        transName = LangTransMeta.translate(AmElementConstants.FIELD_TRANS_CHECK_NO);
      }
      if (curFieldName.equalsIgnoreCase(AmElementConstants.FIELD_NAME_CONTRACT_CODE)) {
        transName = LangTransMeta.translate(AmElementConstants.FIELD_TRANS_CONTRACT_NAME);
      }
      if (curFieldName.equalsIgnoreCase(AmElementConstants.FIELD_NAME_BAL_MODE_CODE)) {
        transName = LangTransMeta.translate(AmElementConstants.FIELD_TRANS_BAL_MODE_NAME);
      }
      if (curFieldName.equalsIgnoreCase(AmElementConstants.FIELD_NAME_REMARK)) {
        transName = LangTransMeta.translate(AmElementConstants.FIELD_TRANS_REMARK);
      }
      if (curFieldName.equalsIgnoreCase(AmElementConstants.FIELD_NAME_FILENAME)) {
        transName = LangTransMeta.translate(AmElementConstants.FIELD_TRANS_FILENAME);
      }
    }
    return transName;
  }

}
