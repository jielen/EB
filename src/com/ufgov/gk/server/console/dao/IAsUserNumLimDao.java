package com.ufgov.gk.server.console.dao;

import java.util.List;

import com.ufgov.gk.common.console.model.AsUserNumLim;

public interface IAsUserNumLimDao {

	List getAsUserNumLim(String userId, String compoId, String funcId, String ctrlField);
	
	int deleteAsUserNumLim(String userId, String compoId, String funcId, String ctrlField);
	
	AsUserNumLim insertAsUserNumLim(AsUserNumLim asUserNumLim);
	
}
