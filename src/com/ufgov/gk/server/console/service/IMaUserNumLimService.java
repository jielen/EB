package com.ufgov.gk.server.console.service;

import java.util.List;

import com.ufgov.gk.common.console.model.MaUserNumLim;

public interface IMaUserNumLimService {

	List getMaUserNumLim(String userId, String compoId, String funcId, String ctrlField);
	
	int deleteMaUserNumLim(String userId, String compoId, String funcId, String ctrlField);
	
	MaUserNumLim insertMaUserNumLim(MaUserNumLim maUserNumLim);
	
	void insertMaUserNumLimList(List maUserNumLimList);
	
	void updateMaUserNumLimList(String userId, String compoId, String funcId, 
			String ctrlField, List maUserNumLimList);
	
}
