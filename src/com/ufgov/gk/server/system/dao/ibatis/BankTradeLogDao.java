package com.ufgov.gk.server.system.dao.ibatis;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.gk.common.system.model.ResultInfo;
import com.ufgov.gk.server.system.dao.IBankTradeLogDao;

public class BankTradeLogDao extends SqlMapClientDaoSupport implements IBankTradeLogDao {

  public BankTradeLogDao() {
    super();
  }

  public void saveLog(ResultInfo result) {
    // TODO Auto-generated method stub
    this.getSqlMapClientTemplate().insert("BankTradeLog.saveLog", result);
  }

}
