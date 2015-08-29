package com.ufgov.gk.server.commonbiz.dao.ibatis;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.ufgov.gk.common.console.model.GkGetdataRule;
import com.ufgov.gk.common.system.exception.DaoException;
import com.ufgov.gk.server.commonbiz.dao.IGkGetdataRuleDao;
import com.ufgov.gk.server.system.util.Util;

public class GkGetdataRuleDao extends SqlMapClientDaoSupport implements IGkGetdataRuleDao {

  public List getGkGetdataRule() {
    return this.getSqlMapClientTemplate().queryForList("GkGetdataRule.getGkGetdataRule");
  }

  public void updateGkGetdataRule(List gkGetdataRuleList) {
    final List list = gkGetdataRuleList;
    this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
      public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
        executor.startBatch();
        for (int i = 0; i < list.size(); i++) {
          GkGetdataRule gkGetdataRule = (GkGetdataRule) list.get(i);
          executor.update("GkGetdataRule.updateGkGetdataRule", gkGetdataRule);
        }
        executor.executeBatch();
        return null;
      }
    });
  }

  public GkGetdataRule getGkGetDataRuleById(String ruleId) {
    GkGetdataRule rule=(GkGetdataRule) this.getSqlMapClientTemplate().queryForObject(
      "GkGetdataRule.getGkGetDataRuleById", ruleId);
    if(rule==null){
      throw new  DaoException("can not find DataRule: "+ruleId);
    }
    rule.setRuleSqlOracle(Util.handleSv(rule.getRuleSqlOracle()));
    return rule;
  }
  
  public GkGetdataRule getGkGetDataRule(String ruleId) {
    GkGetdataRule rule=(GkGetdataRule) this.getSqlMapClientTemplate().queryForObject(
      "GkGetdataRule.getGkGetDataRuleById", ruleId);
    if(rule==null){
      throw new  DaoException("can not find DataRule: "+ruleId);
    }
    rule.setRuleSqlOracle(Util.handleSv(rule.getRuleSqlOracle()));
    return rule;
  }

}
