package com.ufgov.gk.server.system.dao.ibatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.gk.server.system.dao.IAsValDao;

public class AsValDao extends SqlMapClientDaoSupport implements IAsValDao {

  public List getAsVal(String valSetId) {
    return this.getSqlMapClientTemplate().queryForList("AsVal.getAsVal", valSetId);
  }

  public Map getAsValMap(String valSetId) {
    return this.getSqlMapClientTemplate().queryForMap("AsVal.getAsValMap", valSetId, "valId", "val");
  }

  public List getCompanyLevel(String sqlId) {
    Map map = new HashMap();
    map.put("sqlId", sqlId);
    return this.getSqlMapClientTemplate().queryForList("AsVal.getCompanyLevel", map);
  }

}
