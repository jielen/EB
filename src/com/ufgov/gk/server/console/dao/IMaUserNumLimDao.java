package com.ufgov.gk.server.console.dao;

import java.util.List;

import com.ufgov.gk.common.console.model.MaUserNumLim;

public interface IMaUserNumLimDao {

	List getMaUserNumLim(String userId, String compoId, String funcId, String ctrlField);
	
	int deleteMaUserNumLim(String userId, String compoId, String funcId, String ctrlField);
	
	MaUserNumLim insertMaUserNumLim(MaUserNumLim maUserNumLim);
	
	void insertMaUserNumLimList(final List maUserNumLimList);
	
}
