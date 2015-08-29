package com.ufgov.gk.server.commonbiz.dao.ibatis;

import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.gk.server.system.dao.IMacpRuleDetailDao;

public class MacpRuleDetailDao extends SqlMapClientDaoSupport implements IMacpRuleDetailDao {

  public Map getMacpRuleDetail(Map params) {
    // TODO Auto-generated method stub
    //List result = this.getSqlMapClientTemplate().queryForList("MacpRuleDetail.getMacpRuleDetail", params);
    Map result = this.getSqlMapClientTemplate().queryForMap("MacpRuleDetail.getMacpRuleDetail", params, "sourceValueCode");
    return result;
  }

}
