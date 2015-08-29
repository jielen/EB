package com.ufgov.gk.server.console.service;

import java.util.List;

import com.ufgov.gk.common.console.model.MaRoleNumLim;

public interface IMaRoleNumLimService {

	List getMaRoleNumLim(String roleId, String compoId, String funcId, String ctrlField);
	
	int deleteMaRoleNumLim(String roleId, String compoId, String funcId, String ctrlField);
	
	MaRoleNumLim insertMaRoleNumLim(MaRoleNumLim maRoleNumLim);
	
	void insertMaRoleNumLimList(List maRoleNumLimList);
	
	void updateMaRoleNumLimList(String roleId, String compoId, String funcId, 
			String ctrlField, List maRoleNumLimList);
	
}
