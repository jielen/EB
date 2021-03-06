package com.ufgov.gk.server.console.service.impl;

import java.util.List;

import com.ufgov.gk.common.console.model.AsUserNumLim;
import com.ufgov.gk.server.console.dao.IAsUserNumLimDao;
import com.ufgov.gk.server.console.service.IAsUserNumLimService;
import com.ufgov.gk.server.system.util.NumLimUtil;

public class AsUserNumLimService implements IAsUserNumLimService {
	
	IAsUserNumLimDao asUserNumLimDao;

	public IAsUserNumLimDao getAsUserNumLimDao() {
		return asUserNumLimDao;
	}

	public void setAsUserNumLimDao(IAsUserNumLimDao asUserNumLimDao) {
		this.asUserNumLimDao = asUserNumLimDao;
	}

	public List getAsUserNumLim(String userId, String compoId, String funcId,
			String ctrlField) {
		return asUserNumLimDao.getAsUserNumLim(userId, compoId, funcId, ctrlField);
	}

	public int deleteAsUserNumLim(String userId, String compoId, String funcId, String ctrlField) {
		return asUserNumLimDao.deleteAsUserNumLim(userId, compoId, funcId, ctrlField);
	}

	public AsUserNumLim insertAsUserNumLim(AsUserNumLim asUserNumLim) {
		return asUserNumLimDao.insertAsUserNumLim(asUserNumLim);
	}

	public AsUserNumLim updateAsUserNumLim(AsUserNumLim asUserNumLim) {
		asUserNumLimDao.deleteAsUserNumLim(asUserNumLim.getUserId(), 
				asUserNumLim.getCompoId(), asUserNumLim.getFuncId(), asUserNumLim.getCtrlField());
		return asUserNumLimDao.insertAsUserNumLim(asUserNumLim);
	}

  public String getNumLimCondByCoType(String numLimCompoId, String funcId, boolean isTableContainCoCode) {
    return NumLimUtil.getInstance().getNumLimCondByCoType(numLimCompoId, funcId,isTableContainCoCode);
  }
  
  public String getNumLimCondByCoType(String numLimCompoId, String funcId) {
    return NumLimUtil.getInstance().getNumLimCondByCoType(numLimCompoId, funcId);
  }

  public String getNumLimCondByCoType(String numLimCompoId, String funcId,
    String ctrlField) {
    return NumLimUtil.getInstance().getNumLimCondByCoType(numLimCompoId, funcId, ctrlField);
  }
  public String getNumLimCondByCoType(String numLimCompoId, String funcId, String ctrlField,
    boolean isTableContainCoCode) {
    return NumLimUtil.getInstance().getNumLimCondByCoType(numLimCompoId, funcId, ctrlField,isTableContainCoCode);
  }

}
