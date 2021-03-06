package com.ufgov.gk.server.commonbiz.dao.ibatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.gk.server.commonbiz.dao.IMaBankDao;

public class MaBankDao extends SqlMapClientDaoSupport implements IMaBankDao {

  public List getAllBank(int nd) {
    return this.getSqlMapClientTemplate().queryForList("MaBank.getAllBank", new Integer(nd));
  }

  public List getZeroBalanceBank(int nd) {

    return this.getSqlMapClientTemplate().queryForList("MaBank.getZeroBalanceBank", new Integer(nd));
  }

  public List getAgentBank(int nd, String accoType, String userId) {
    Map map = new HashMap();
    map.put("nd", new Integer(nd));
    map.put("accoType", accoType);
    map.put("userid", userId);
    return this.getSqlMapClientTemplate().queryForList("MaBank.getZeroBalanceBank", new Integer(nd));
  }

}
