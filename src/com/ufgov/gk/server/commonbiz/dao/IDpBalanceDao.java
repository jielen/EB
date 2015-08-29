package com.ufgov.gk.server.commonbiz.dao;

import java.math.BigDecimal;
import java.util.List;

import com.ufgov.gk.common.commonbiz.model.DpBalance;
import com.ufgov.gk.common.system.dto.ElementConditionDto;

public interface IDpBalanceDao {

  int getBalanceNumByJjPlanDetailOid(String jjPlanDetailOid);

  void updateDpbalanceByJjPlanDetailOid(String moneyField, BigDecimal m, String jjPlanDetailOid);

  DpBalance getDpbalanceByJjPlanDetailOid(String jjPlanDetailOid);

  List getDpBalance();

  DpBalance getDpBalanceById(String id, String dpBalanceView);

  List getDpBalanceForDpAdjust(ElementConditionDto balanceelementConditionDto);

  List getDpBalanceForCpAv(ElementConditionDto elementConditionDto);

  List getDpBalanceForCpDa(ElementConditionDto dto);

  List getDpBalanceForCpDv(ElementConditionDto dto);

  List getDpBalanceForAm(ElementConditionDto dto);

  int updateDpBalance(String instanceId, String montyField, String dpBalanceId, String businessTableName,
    String policy);

  int updateDpBalanceForDpAdjustDecreaseSave(String balmoneyField, BigDecimal adjustMoney, String moneyField,
    String dpBalanceId);

  int updateDpBalanceForDpAdjustDecreaseAudit(String balmoneyField, BigDecimal adjustMoney, String dpBalanceId);

  int updateDpBalanceForDpAdjustFreezeSave(BigDecimal adjustMoney, String moneyField, String dpBalanceId);

  int updateDpBalanceForDpAdjustFreezeAudit(BigDecimal adjustMoney, String moneyField, String dpBalanceId);

  int updateDpBalanceForDpAdjustunFreezeAudit(BigDecimal adjustMoney, String moneyField, String dpBalanceId);

  int updateDpBalanceForCp(BigDecimal adjustMoney, BigDecimal newRequest, BigDecimal oldDpCdUseMoney,
    String balanceStr, String dpBalanceId);

  BigDecimal queryMayUsedDpcdMoney(BigDecimal newCurMoney, BigDecimal oldCdUseMoney, String dpBalanceId);

  BigDecimal queryDpCdUseMoney(String dpBalanceId);

  String queryMaxDpBalance(String elementWhere);

  void insertDpBalance(DpBalance dpBalance);

  void updateDpbalanceByOid(DpBalance dpBalance);

  int updateDpBalanceForDpEditAudit(String setStr, BigDecimal curMoney, String dpBalanceId);

  int updateDpBalanceForCpApplyUnDo(String cpApplyId, String dpBalanceId);//作废时余额更新

  int updateDpBalanceForCpVoucherUnDo(String cpVoucherId, String dpBalanceId);//作废时余额更新

  int updateDpBalanceForCpApplyUnAudit(BigDecimal curMoney, BigDecimal dpCdUseMoney, String dpBalanceId);//销审时余额更新

  int updateDpBalanceForDpDecreaseUnaudit(String moneyField, String calcField, String monthField,
    String dpDetailId, String dpBalanceId);

  int updateDpBalanceForDpEditUnaudit(String moneyField, String monthField, String dpDetailId,
    String dpBalanceId);

  int updateDpBalanceForDpFreezeUnaudit(String calcField, String dpDetailId, String dpBalanceId);

  int updateDpBalanceForDpFreezeUnaudit0(String calcField, String dpDetailId, String dpBalanceId,
    String monthField);

  int updateDpBalanceForDpUnFreezeUnaudit(String dpDetailId, String dpBalanceId, String monthField);

  int updateDpBalanceForDpUnFreezeInterrupt(BigDecimal curMoney, String dpBalanceId);

  int updateDpBalanceForAm(BigDecimal curMoney, String dpBalanceId, int monthId);

  List getDpBalanceForDpCarry(ElementConditionDto dto);

  String handleDpBalanceForCarry(String dpBalanceIds, int nd, String inputor, String procDate);

  String handleDpBalanceForUpdate(List dpBalanceIds);

  void handleDpBalanceForUnUpdate(List dpBalanceIds);

  int updateDpbalanceForUnUpdate(String moneyField, BigDecimal money, String dpBalanceid);

  String handleDpBalanceForCarryCancel(String dpBalanceIds);

  DpBalance getDpBalanceForJjPlan(String dpBalanceId);

  int updateDpBalanceForAmVoucherDelete(String amVoucherId, String dpBalanceId) ;
}
