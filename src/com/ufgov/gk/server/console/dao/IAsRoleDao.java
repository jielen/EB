package com.ufgov.gk.server.console.dao;

import java.util.List;

import com.ufgov.gk.common.console.model.AsRole;

public interface IAsRoleDao {

	List getAsRole(int nd);
	
	AsRole getAsRoleById(String id);
	
	public List getAsRoleByPosi(String posi);
	
}
