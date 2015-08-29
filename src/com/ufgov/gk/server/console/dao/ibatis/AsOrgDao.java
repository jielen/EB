package com.ufgov.gk.server.console.dao.ibatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.gk.server.console.dao.IAsOrgDao;

public class AsOrgDao extends SqlMapClientDaoSupport implements IAsOrgDao {

	public List getAsOrg(int nd) {
		return getSqlMapClientTemplate().queryForList("AsOrg.getAsOrg",new Integer(nd));
	}

	public List getAsOrg(int nd,String coCode) {
	  Map map = new HashMap();
	  map.put("nd", new Integer(nd));
	  map.put("coCode", coCode);
    return getSqlMapClientTemplate().queryForList("AsOrg.getChildAsOrg",map);
  }

  public List getAsOrgByCocode(String cocode, String nd) {
    // TODO Auto-generated method stub
    Map param = new HashMap();
    param.put("cocode", cocode);
    param.put("nd", nd);
    return getSqlMapClientTemplate().queryForList("AsOrg.getAsOrgByCocode", param);
  }

}
