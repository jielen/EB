package com.ufgov.gk.server.console.service.impl;

import java.util.List;

import com.ufgov.gk.server.console.dao.ibatis.AsRoleDao;
import com.ufgov.gk.server.console.service.IAsRoleService;
import com.ufgov.gk.common.console.model.AsRole;

public class AsRoleService implements IAsRoleService {
	
	AsRoleDao asRoleDao;

	public AsRoleDao getAsRoleDao() {
		return asRoleDao;
	}

	public void setAsRoleDao(AsRoleDao asRoleDao) {
		this.asRoleDao = asRoleDao;
	}

	public List getAsRole(int nd) {
		return asRoleDao.getAsRole(nd);
	}

	public AsRole getAsRoleById(String id) {
		return asRoleDao.getAsRoleById(id);
	}
	
	public List getAsRoleByPosi(String posi) {
	  return asRoleDao.getAsRoleByPosi(posi);
	}

}
