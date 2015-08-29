package com.ufgov.gk.server.commonbiz.dao.ibatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.gk.common.system.model.AsNoRule;
import com.ufgov.gk.common.system.model.AsNumTool;
import com.ufgov.gk.common.system.model.AsNumToolNo;
import com.ufgov.gk.server.commonbiz.dao.INumDao;

public class NumDao extends SqlMapClientDaoSupport implements INumDao {

  public AsNoRule getAsNoRule(String compoId, String noField) {
    Map map = new HashMap();
    map.put("compoId", compoId);
    map.put("noField", noField);
    return (AsNoRule) this.getSqlMapClientTemplate().queryForObject(
      "AsNoRule.getAsNoRule", map);
  }

  public AsNoRule getAsNoRuleByCompoId(String compoId) {
    return (AsNoRule) this.getSqlMapClientTemplate().queryForObject(
      "AsNoRule.getAsNoRuleByCompoId", compoId);
  }

  public List getAsNoRuleSeg(String compoId, String ruleCode) {
    Map map = new HashMap();
    map.put("compoId", compoId);
    map.put("ruleCode", ruleCode);
    return this.getSqlMapClientTemplate().queryForList("AsNoRuleSeg.getAsNoRuleSeg",
      map);
  }

  public AsNumTool getAsNumTool(String numToolId) {
    return (AsNumTool) this.getSqlMapClientTemplate().queryForObject(
      "AsNumTool.getAsNumTool", numToolId);
  }

  public List getAsNumToolNo(String numToolId, String altPrefix, String fixPrefix) {
    Map map = new HashMap();
    map.put("numToolId", numToolId);
    map.put("altPrefix", altPrefix);
    map.put("fixPrefix", fixPrefix);
    return this.getSqlMapClientTemplate().queryForList("AsNumToolNo.getAsNumToolNo",
      map);
  }

  public int incNumNo(String numToolId, String altPrefix, String fixPrefix) {
    Map map = new HashMap();
    map.put("numToolId", numToolId);
    map.put("altPrefix", altPrefix);
    map.put("fixPrefix", fixPrefix);
    return this.getSqlMapClientTemplate().update("AsNumToolNo.incNumNo", map);
  }

  public AsNumToolNo insertAsNumToolNo(AsNumToolNo asNumToolNo) {
    return (AsNumToolNo) this.getSqlMapClientTemplate().insert(
      "AsNumToolNo.insertAsNumToolNo", asNumToolNo);
  }

  public int updateNumNo(int numNo, String numToolId, String altPrefix,
    String fixPrefix) {
    Map map = new HashMap();
    map.put("numNo", new Integer(numNo));
    map.put("numToolId", numToolId);
    map.put("altPrefix", altPrefix);
    map.put("fixPrefix", fixPrefix);
    return this.getSqlMapClientTemplate().update("AsNumToolNo.incNumNo", map);
  }

  public int updateAsNo(String compoId, String fixPrefix) {
    Map map = new HashMap();
    map.put("compoId", compoId);
    map.put("fixSegs", fixPrefix);
    return this.getSqlMapClientTemplate().update("AsNumToolNo.updateAsNo", map);
  }

  public void insertAsNo(String compoId, String fixPrefix) {
    Map map = new HashMap();
    map.put("compoId", compoId);
    map.put("fixSegs", fixPrefix);
    this.getSqlMapClientTemplate().insert("AsNumToolNo.insertAsNo", map);
  }
  public Long getAsNoCurIndex(String compoId, String fixPrefix) {
    Map map = new HashMap();
    map.put("compoId", compoId);
    map.put("fixSegs", fixPrefix);
   return (Long) this.getSqlMapClientTemplate().queryForObject("AsNumToolNo.getAsNoCurIndex", map);
  }
}
