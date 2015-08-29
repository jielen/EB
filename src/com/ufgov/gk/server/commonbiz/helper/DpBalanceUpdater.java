package com.ufgov.gk.server.commonbiz.helper;

import java.math.BigDecimal;
import java.util.Date;

import com.ufgov.gk.common.system.constants.BusinessOptionConstants;
import com.ufgov.gk.server.commonbiz.dao.IDpBalanceDao;
import com.ufgov.gk.server.system.SpringContext;
import com.ufgov.gk.server.system.dao.IAsOptionDao;

public class DpBalanceUpdater {

  private static IAsOptionDao asOptionDao = (IAsOptionDao) SpringContext.getBean("asOptionDao");

  private static IDpBalanceDao dpBalanceDao = (IDpBalanceDao) SpringContext.getBean("dpBalanceDao");

  public static int updateForCp(DpBalanceUpdaterRowData rowData) {
    int updateCount = 0;

    String optCpdpExec = asOptionDao.getAsOption(BusinessOptionConstants.OPT_CP_CDP_EXEC).getOptVal();
    CpdpBalancePolicy policy = new CpdpBalancePolicy();
    String balanceStr = policy.getBalanceString(rowData.getProcDate(), optCpdpExec);
    String action = rowData.getAction();
    BigDecimal adjustMoney = null, newRequest = null, oldDpCdUseMoney = null;
    if (action.equalsIgnoreCase("insert")) {
      adjustMoney = rowData.getNewCurMoney();
      newRequest = rowData.getNewCurMoney();
      oldDpCdUseMoney = BigDecimal.valueOf(0);
      updateCount = dpBalanceDao.updateDpBalanceForCp(adjustMoney, newRequest, oldDpCdUseMoney, balanceStr,
        rowData.getDpBalanceId());
    } else if (action.equalsIgnoreCase("update")) {
      String aStatusCode = rowData.getAstatusCode();
      BigDecimal oldMoney = null;
      if (aStatusCode.equalsIgnoreCase("4")) {
        oldMoney = rowData.getOldOrgMoney();
      } else {
        oldMoney = rowData.getOldCurMoney();
      }
      adjustMoney = rowData.getNewCurMoney().subtract(oldMoney);
      newRequest = rowData.getNewCurMoney();
      oldDpCdUseMoney = rowData.getOldDpCdUseMoney();
      updateCount = dpBalanceDao.updateDpBalanceForCp(adjustMoney, newRequest, oldDpCdUseMoney, balanceStr,
        rowData.getDpBalanceId());
    } else if (action.equalsIgnoreCase("delete")) {
      adjustMoney = rowData.getOldCurMoney().negate();
      newRequest = rowData.getOldCurMoney().negate();
      oldDpCdUseMoney = rowData.getOldDpCdUseMoney();
      updateCount = dpBalanceDao.updateDpBalanceForCp(adjustMoney, newRequest, oldDpCdUseMoney, balanceStr,
        rowData.getDpBalanceId());
    }

    return updateCount;
  }

  /**
   * �����ڱ���ʱռ���ҽ�Ϊ��������µĴ���(�����Զ�ÿ���Ķ����ֵ)
   * @param nowCurMoney
   * @param nowOrgMoney
   * @param procDate
   * @param dpBalanceId
   * @param oldDpCdUseMoney
   * @return
   */
  public static int updateForCpAuditOrRework(BigDecimal nowCurMoney, BigDecimal nowOrgMoney, Date procDate,
    String dpBalanceId, BigDecimal oldDpCdUseMoney, String reworkOrAudit) {
    int updateCount = 0;
    String optCpdpExec = asOptionDao.getAsOption(BusinessOptionConstants.OPT_CP_CDP_EXEC).getOptVal();
    CpdpBalancePolicy policy = new CpdpBalancePolicy();
    String balanceStr = policy.getBalanceString(procDate, optCpdpExec);
    BigDecimal adjustMoney = null, newRequest = null;
    if ("audit".equalsIgnoreCase(reworkOrAudit)) {
      adjustMoney = nowCurMoney.subtract(nowOrgMoney);
      newRequest = nowCurMoney;
    } else if ("rework".equalsIgnoreCase(reworkOrAudit)) {
      adjustMoney = nowOrgMoney.subtract(nowCurMoney);
      newRequest = nowOrgMoney;
    }
    updateCount = dpBalanceDao.updateDpBalanceForCp(adjustMoney, newRequest, oldDpCdUseMoney, balanceStr,
      dpBalanceId);
    return updateCount;
  }
}
