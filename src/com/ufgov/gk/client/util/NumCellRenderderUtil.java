package com.ufgov.gk.client.util;

import javax.swing.JTable;

import com.ufgov.gk.client.common.LangTransMeta;
import com.ufgov.gk.client.component.table.cellrenderer.NumberCellRenderer;
import com.ufgov.gk.common.system.constants.AmElementConstants;
import com.ufgov.gk.common.system.constants.BiElementConstants;
import com.ufgov.gk.common.system.constants.CpElementConstants;
import com.ufgov.gk.common.system.constants.DpElementConstants;

public class NumCellRenderderUtil {



  /**
   * 处理千分位问题
   * @param table
   * @param name
   */
  public static void setNumberCellRenderer(JTable table, String fieldTransName) {
    try {
      table.getColumn(fieldTransName).setCellRenderer(new NumberCellRenderer());
    } catch (IllegalArgumentException e) {
    }
  }

  public static void setCpDpTableNumCellRenderer(JTable table) {
    setNumberCellRenderer(table, LangTransMeta.translate(CpElementConstants.FIELD_TRANS_ORG_MONEY));
    setNumberCellRenderer(table, LangTransMeta.translate(CpElementConstants.FIELD_TRANS_CUR_MONEY));
    setNumberCellRenderer(table, LangTransMeta.translate(CpElementConstants.FIELD_TRANS_DP_BALANCE));
    setNumberCellRenderer(table, LangTransMeta.translate(CpElementConstants.FIELD_TRANS_DP_PAY_MONEY));
    setNumberCellRenderer(table, LangTransMeta.translate(CpElementConstants.FIELD_TRANS_DP_TOTAL_MONEY));
  }

  public static void setAmApplyTableNumCellRenderer(JTable table) {
    setNumberCellRenderer(table, LangTransMeta.translate(AmElementConstants.FIELD_TRANS_ORG_MONEY));
    setNumberCellRenderer(table, LangTransMeta.translate(AmElementConstants.FIELD_TRANS_CUR_MONEY));
    setNumberCellRenderer(table, LangTransMeta.translate(AmElementConstants.FIELD_TRANS_BI_MONEY));
    setNumberCellRenderer(table, LangTransMeta.translate(AmElementConstants.FIELD_TRANS_BI_BALANCE));
    setNumberCellRenderer(table, LangTransMeta.translate(AmElementConstants.FIELD_TRANS_BI_PAYSUM));
  }

  public static void setAmVoucherTableNumCellRenderer(JTable table) {
    setNumberCellRenderer(table, LangTransMeta.translate(AmElementConstants.FIELD_TRANS_ORG_MONEY));
    setNumberCellRenderer(table, LangTransMeta.translate(AmElementConstants.FIELD_TRANS_CUR_MONEY));
    setNumberCellRenderer(table, LangTransMeta.translate(AmElementConstants.FIELD_TRANS_DP_MONEY));
    setNumberCellRenderer(table, LangTransMeta.translate(AmElementConstants.FIELD_TRANS_DP_BALANCE));
    setNumberCellRenderer(table, LangTransMeta.translate(AmElementConstants.FIELD_TRANS_DP_PAYSUM));
  }

  public static void setDpDetailTableNumCellRenderer(JTable table) {
    setNumberCellRenderer(table, LangTransMeta.translate(DpElementConstants.FIELD_TRANS_ORG_MONEY));
    setNumberCellRenderer(table, LangTransMeta.translate(DpElementConstants.FIELD_TRANS_CUR_MONEY));
    setNumberCellRenderer(table, LangTransMeta.translate(DpElementConstants.FIELD_TRANS_BI_MONEY));
    setNumberCellRenderer(table, LangTransMeta.translate(DpElementConstants.FIELD_TRANS_BI_BALANCE));
    setNumberCellRenderer(table, LangTransMeta.translate(DpElementConstants.FIELD_TRANS_BI_PAYSUM));
  }

  public static void setBiBalanceNumCellRenderer(JTable table) {
    setNumberCellRenderer(table, LangTransMeta.translate(BiElementConstants.FIELD_TRANS_BI_BALANCE));
    setNumberCellRenderer(table, LangTransMeta.translate(BiElementConstants.FIELD_TRANS_BI_PAYSUM));
    setNumberCellRenderer(table, LangTransMeta.translate(BiElementConstants.FIELD_TRANS_BI_MONEY));
  }

  public static void setBiTrackNumCellRenderer(JTable table) {
    setNumberCellRenderer(table, LangTransMeta.translate(BiElementConstants.FIELD_TRANS_CUR_MONEY));
    setNumberCellRenderer(table, LangTransMeta.translate(BiElementConstants.FIELD_TRANS_ORG_MONEY));
  }

  public static void setDpBalanceTableNumCellRenderer(JTable table) {
    setNumberCellRenderer(table, LangTransMeta.translate(DpElementConstants.FIELD_TRANS_DP_BALANCE));
    setNumberCellRenderer(table, LangTransMeta.translate(DpElementConstants.FIELD_TRANS_DP_PAY_MONEY));
    setNumberCellRenderer(table, LangTransMeta.translate(DpElementConstants.FIELD_TRANS_DP_TOTAL_MONEY));
  }

  public static void setBiPayQueryTableNumCellRenderer(JTable table, String optStr) {
    String[] queryContent = optStr.split(",");
    for (int i = 0; i < queryContent.length; i++) {
      final String key = queryContent[i];
      if (key.equalsIgnoreCase("DP")) {
        setNumberCellRenderer(table, CpElementConstants.FIELD_TRANS_UNAUDITDP0201);
        setNumberCellRenderer(table, CpElementConstants.FIELD_TRANS_UNAUDITDP0202);
        setNumberCellRenderer(table, CpElementConstants.FIELD_TRANS_AUDITDP0201);
        setNumberCellRenderer(table, CpElementConstants.FIELD_TRANS_AUDITDP0202);
      } else if (key.equalsIgnoreCase("ACPVOU")) {
        setNumberCellRenderer(table, CpElementConstants.FIELD_TRANS_EFFECTDP0202);
        setNumberCellRenderer(table, CpElementConstants.FIELD_TRANS_AUDITCPVOU0202);
      } else if (key.equalsIgnoreCase("DCPVOU")) {
        setNumberCellRenderer(table, CpElementConstants.FIELD_TRANS_UNAUDITCPVOU0201);
        setNumberCellRenderer(table, CpElementConstants.FIELD_TRANS_AUDITCPVOU0201);
      } else if (key.equalsIgnoreCase("ACPAPPLY")) {
        setNumberCellRenderer(table, CpElementConstants.FIELD_TRANS_UNAUDITCPAPPLY);
        setNumberCellRenderer(table, CpElementConstants.FIELD_TRANS_AUDITCPAPPLY);
      } else if (key.equalsIgnoreCase("BI")) {
        setNumberCellRenderer(table, CpElementConstants.FIELD_TRANS_TOTALBI);
        setNumberCellRenderer(table, CpElementConstants.FIELD_TRANS_UNAUDITBI);
        setNumberCellRenderer(table, CpElementConstants.FIELD_TRANS_AUDITBI);
        setNumberCellRenderer(table, CpElementConstants.FIELD_TRANS_FREEZEBI);
        setNumberCellRenderer(table, CpElementConstants.FIELD_TRANS_ADJUSTADDBI);
        setNumberCellRenderer(table, CpElementConstants.FIELD_TRANS_ADJUSTDELBI);
      } else if (key.equalsIgnoreCase("AMVOU")) {
        setNumberCellRenderer(table, CpElementConstants.FIELD_TRANS_UNAUDITAMVOU);
        setNumberCellRenderer(table, CpElementConstants.FIELD_TRANS_AUDITAMVOU);
      } else if (key.equalsIgnoreCase("AMAPPLY")) {
        setNumberCellRenderer(table, CpElementConstants.FIELD_TRANS_UNAUDITAMAPPLY);
        setNumberCellRenderer(table, CpElementConstants.FIELD_TRANS_AUDITAMAPPLY);
      }
    }

    setNumberCellRenderer(table, CpElementConstants.FIELD_TRANS_LEFTBI);
    setNumberCellRenderer(table, CpElementConstants.FIELD_TRANS_LEFTDP0202);
  }

  public static void setBiPayQueryDpdetailTableNumCellRenderer(JTable table) {
    setNumberCellRenderer(table, LangTransMeta.translate(CpElementConstants.FIELD_TRANS_UNAUDITBI));
    setNumberCellRenderer(table, LangTransMeta.translate(CpElementConstants.FIELD_TRANS_AUDITBI));
    setNumberCellRenderer(table, LangTransMeta.translate(CpElementConstants.FIELD_TRANS_FREEZEBI));
    setNumberCellRenderer(table, LangTransMeta.translate(CpElementConstants.FIELD_TRANS_ADJUSTADDBI));
    setNumberCellRenderer(table, LangTransMeta.translate(CpElementConstants.FIELD_TRANS_ADJUSTDELBI));
  }

  public static void setBiPayQueryCpvoucher0202TableNumCellRenderer(JTable table) { //授权支付凭证情况--ACPVOU
    setNumberCellRenderer(table, LangTransMeta.translate(CpElementConstants.FIELD_TRANS_AUDITCPVOU0202));
  }

  public static void setBiPayQueryCpvoucher0201TableNumCellRenderer(JTable table) { //直接支付凭证情况--DCPVOU
    setNumberCellRenderer(table, LangTransMeta.translate(CpElementConstants.FIELD_TRANS_UNAUDITCPVOU0201));
    setNumberCellRenderer(table, LangTransMeta.translate(CpElementConstants.FIELD_TRANS_AUDITCPVOU0201));
  }

  public static void setBiPayQueryCpapplyTableNumCellRenderer(JTable table) { //直接支付申请情况--ACPAPPLY
    setNumberCellRenderer(table, LangTransMeta.translate(CpElementConstants.FIELD_TRANS_UNAUDITCPAPPLY));
    setNumberCellRenderer(table, LangTransMeta.translate(CpElementConstants.FIELD_TRANS_AUDITCPAPPLY));
  }

  public static void setBiPayQueryBitrackTableNumCellRenderer(JTable table) { //指标情况--BI
    setNumberCellRenderer(table, LangTransMeta.translate(CpElementConstants.FIELD_TRANS_UNAUDITBI));
    setNumberCellRenderer(table, LangTransMeta.translate(CpElementConstants.FIELD_TRANS_AUDITBI));
    setNumberCellRenderer(table, LangTransMeta.translate(CpElementConstants.FIELD_TRANS_FREEZEBI));
    setNumberCellRenderer(table, LangTransMeta.translate(CpElementConstants.FIELD_TRANS_ADJUSTADDBI));
    setNumberCellRenderer(table, LangTransMeta.translate(CpElementConstants.FIELD_TRANS_ADJUSTDELBI));
  }

  public static void setBiPayQueryAmvoucherTableNumCellRenderer(JTable table) { //拨款凭证情况--AMVOU
    setNumberCellRenderer(table, LangTransMeta.translate(CpElementConstants.FIELD_TRANS_UNAUDITAMVOU));
    setNumberCellRenderer(table, LangTransMeta.translate(CpElementConstants.FIELD_TRANS_AUDITAMVOU));
  }

  public static void setBiPayQueryAmapplyTableNumCellRenderer(JTable table) { //拨款申请情况--AMAPPLY
    setNumberCellRenderer(table, LangTransMeta.translate(CpElementConstants.FIELD_TRANS_UNAUDITAMAPPLY));
    setNumberCellRenderer(table, LangTransMeta.translate(CpElementConstants.FIELD_TRANS_AUDITAMAPPLY));
  }

  public static void setCpAuditTableNumCellRenderer(JTable table){
    setNumberCellRenderer(table, LangTransMeta.translate(CpElementConstants.FIELD_TRANS_ORG_MONEY));
    setNumberCellRenderer(table, LangTransMeta.translate(CpElementConstants.FIELD_TRANS_DP_PAY_MONEY));
    setNumberCellRenderer(table, LangTransMeta.translate(CpElementConstants.FIELD_TRANS_DP_TOTAL_MONEY));
    setNumberCellRenderer(table, LangTransMeta.translate(DpElementConstants.FIELD_TRANS_DP_BALANCE));
    setNumberCellRenderer(table, LangTransMeta.translate(DpElementConstants.FIELD_TRANS_ORG_MONEY));
    setNumberCellRenderer(table, LangTransMeta.translate(DpElementConstants.FIELD_TRANS_DP_PAY_MONEY));
    setNumberCellRenderer(table, LangTransMeta.translate(DpElementConstants.FIELD_TRANS_DP_TOTAL_MONEY));
    setNumberCellRenderer(table, LangTransMeta.translate(DpElementConstants.FIELD_TRANS_DP_BALANCE));
    setNumberCellRenderer(table, LangTransMeta.translate(DpElementConstants.FIELD_TRANS_BI_BALANCE));
    setNumberCellRenderer(table, LangTransMeta.translate(DpElementConstants.FIELD_TRANS_BI_MONEY));
    setNumberCellRenderer(table, LangTransMeta.translate(DpElementConstants.FIELD_TRANS_BI_PAYSUM));
  }

}
