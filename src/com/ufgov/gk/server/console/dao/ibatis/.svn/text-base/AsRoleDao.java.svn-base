package com.ufgov.gk.server.console.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.gk.server.console.dao.IAsRoleDao;
import com.ufgov.gk.common.console.model.AsRole;

public class AsRoleDao extends SqlMapClientDaoSupport implements IAsRoleDao {

	public List getAsRole(int nd) {
		return this.getSqlMapClientTemplate().queryForList("AsRole.getAsRole", new Integer(nd));
	}

	public AsRole getAsRoleById(String id) {
		Object o = this.getSqlMapClientTemplate().queryForObject("AsRole.getAsRoleById", id);
		return (AsRole)o;
	}
	
	public List getAsRoleByPosi(String posi) {
	  return this.getSqlMapClientTemplate().queryForList("AsRole.getAsRoleByPosi", posi);
	}

}
