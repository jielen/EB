package com.ufgov.gk.server.commonbiz.service.impl;

import java.util.List;

import com.ufgov.gk.common.system.dto.ElementConditionDto;
import com.ufgov.gk.server.commonbiz.dao.IOrgDao;
import com.ufgov.gk.server.commonbiz.service.IOrgService;

public class OrgService implements IOrgService {
	private IOrgDao orgDao ;

	public IOrgDao getOrgDao() {
		return orgDao;
	}

	public void setOrgDao(IOrgDao orgDao) {
		this.orgDao = orgDao;
	}

	public List getCzOrg(int nd) {

		return orgDao.getCzOrg(nd);
	}

	 public List getZcOrg(int nd) {

	    return orgDao.getZcOrg(nd);
	  }
	
  public List getOrg(int nd){
    return orgDao.getOrg(nd);
  }

  public List getOrg(ElementConditionDto dto){
    return orgDao.getOrg(dto);
  }

  public List getPosition(int nd){
    return orgDao.getPosition(nd);
  }
  public List getEmp(int nd){
    return orgDao.getEmp(nd);
  }

}
