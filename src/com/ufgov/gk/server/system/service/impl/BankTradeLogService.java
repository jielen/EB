package com.ufgov.gk.server.system.service.impl;

import com.ufgov.gk.common.system.model.ResultInfo;
import com.ufgov.gk.server.system.dao.IBankTradeLogDao;
import com.ufgov.gk.server.system.service.IBankTradeLogService;

public class BankTradeLogService implements IBankTradeLogService {
  private IBankTradeLogDao bankTradeLogDao;

  public IBankTradeLogDao getBankTradeLogDao() {
    return bankTradeLogDao;
  }

  public void setBankTradeLogDao(IBankTradeLogDao bankTradeLogDao) {
    this.bankTradeLogDao = bankTradeLogDao;
  }

  public BankTradeLogService() {
    super();
  }

  public void saveLog(ResultInfo result) {
    // TODO Auto-generated method stub
    bankTradeLogDao.saveLog(result);
  }
}
