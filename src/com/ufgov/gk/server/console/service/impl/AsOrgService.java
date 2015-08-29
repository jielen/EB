package com.ufgov.gk.server.console.service.impl;

import java.util.List;

import com.ufgov.gk.server.console.dao.IAsOrgDao;
import com.ufgov.gk.server.console.service.IAsOrgService;

public class AsOrgService implements IAsOrgService {

	private IAsOrgDao asOrgDao;

	public IAsOrgDao getAsOrgDao() {
		return asOrgDao;
	}

	public void setAsOrgDao(IAsOrgDao asOrgDao) {
		this.asOrgDao = asOrgDao;
	}

	public List getAsOrg(int nd) {
		return asOrgDao.getAsOrg(nd);
	}
	public List getAsOrg(int nd,String coCode){
	  return asOrgDao.getAsOrg(nd,coCode);
	}

  public List getAsOrgByCocode(String cocode, String nd) {
    // TODO Auto-generated method stub
    return asOrgDao.getAsOrgByCocode(cocode, nd);
  }
}
