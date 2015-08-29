package com.ufgov.gk.server.console.service.impl;

import java.util.List;

import com.ufgov.gk.server.console.dao.IMaUserNumLimDao;
import com.ufgov.gk.server.console.service.IMaUserNumLimService;
import com.ufgov.gk.common.console.model.MaUserNumLim;

public class MaUserNumLimService implements IMaUserNumLimService {
	
	IMaUserNumLimDao maUserNumLimDao;
	
	public IMaUserNumLimDao getMaUserNumLimDao() {
		return maUserNumLimDao;
	}

	public void setMaUserNumLimDao(
			IMaUserNumLimDao maUserNumLimDao) {
		this.maUserNumLimDao = maUserNumLimDao;
	}

	public int deleteMaUserNumLim(String userId, String compoId, String funcId, String ctrlField) {
		return maUserNumLimDao.deleteMaUserNumLim(userId, compoId, funcId, ctrlField);
	}

	public List getMaUserNumLim(String userId, String compoId, String funcId, String ctrlField) {
		return maUserNumLimDao.getMaUserNumLim(userId, compoId, funcId, ctrlField);
	}

	public MaUserNumLim insertMaUserNumLim(MaUserNumLim maUserNumLim) {
		return maUserNumLimDao.insertMaUserNumLim(maUserNumLim);
	}

	public void insertMaUserNumLimList(List maUserNumLimList) {
		maUserNumLimDao.insertMaUserNumLimList(maUserNumLimList);
	}

	public void updateMaUserNumLimList(String userId, String compoId, String funcId, 
			String ctrlField, List maUserNumLimList) {
		maUserNumLimDao.deleteMaUserNumLim(userId, compoId, funcId, ctrlField);
		maUserNumLimDao.insertMaUserNumLimList(maUserNumLimList);
	}

}
