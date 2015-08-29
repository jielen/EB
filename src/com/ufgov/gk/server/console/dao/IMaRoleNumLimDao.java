package com.ufgov.gk.server.console.dao;

import java.util.List;

import com.ufgov.gk.common.console.model.MaRoleNumLim;

public interface IMaRoleNumLimDao {

	List getMaRoleNumLim(String roleId, String compoId, String funcId, String ctrlField);
	
	int deleteMaRoleNumLim(String roleId, String compoId, String funcId, String ctrlField);
	
	MaRoleNumLim insertMaRoleNumLim(MaRoleNumLim maRoleNumLim);
	
	void insertMaRoleNumLimList(final List maRoleNumLimList);
	
}
