package com.ufgov.gk.server.console.service.impl;

import java.util.List;

import com.ufgov.gk.server.console.dao.IAsRoleNumLimDao;
import com.ufgov.gk.server.console.service.IAsRoleNumLimService;
import com.ufgov.gk.common.console.model.AsRoleNumLim;

public class AsRoleNumLimService implements IAsRoleNumLimService {

	IAsRoleNumLimDao asRoleNumLimDao;

	public IAsRoleNumLimDao getAsRoleNumLimDao() {
		return asRoleNumLimDao;
	}

	public void setAsRoleNumLimDao(IAsRoleNumLimDao asRoleNumLimDao) {
		this.asRoleNumLimDao = asRoleNumLimDao;
	}

	public List getAsRoleNumLim(String roleId, String compoId, String funcId,
			String ctrlField) {
		return asRoleNumLimDao.getAsRoleNumLim(roleId, compoId, funcId, ctrlField);
	}

	public int deleteAsRoleNumLim(String roleId, String compoId, String funcId, String ctrlField) {
		return asRoleNumLimDao.deleteAsRoleNumLim(roleId, compoId, funcId, ctrlField);
	}

	public AsRoleNumLim insertAsRoleNumLim(AsRoleNumLim asRoleNumLim) {
		return asRoleNumLimDao.insertAsRoleNumLim(asRoleNumLim);
	}

	public AsRoleNumLim updateAsRoleNumLim(AsRoleNumLim asRoleNumLim) {
		asRoleNumLimDao.deleteAsRoleNumLim(asRoleNumLim.getRoleId(),
				asRoleNumLim.getCompoId(), asRoleNumLim.getFuncId(), asRoleNumLim.getCtrlField());
		return asRoleNumLimDao.insertAsRoleNumLim(asRoleNumLim);
	}

	public List getAsRoleNumLimByUserId(String userId, String compoId,
			String funcId, String ctrlField) {
		return asRoleNumLimDao.getAsRoleNumLimByUserId(userId, compoId, funcId, ctrlField);
	}

	public List getAsGrantRoleNumLimByUserId(String userId, String compoId, String funcId, String ctrlField){
	  return asRoleNumLimDao.getAsRoleNumLimByUserId(userId, compoId, funcId, ctrlField);
	}
}
