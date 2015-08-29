package com.ufgov.gk.server.commonbiz.service.impl;

import java.util.List;

import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.dto.ElementConditionDto;
import com.ufgov.gk.server.commonbiz.dao.IManageDao;
import com.ufgov.gk.server.commonbiz.service.IManageService;

public class ManageService implements IManageService {
	private IManageDao manageDao ;

	public IManageDao getManageDao() {
		return manageDao;
	}

	public void setManageDao(IManageDao manageDao) {
		this.manageDao = manageDao;
	}

	public List getManage(ElementConditionDto dto) {

		return manageDao.getManage(dto);
	}

	 public List getManageForBiXJ(ElementConditionDto dto){
	   return manageDao.getManageForBiXJ(dto);
	 }

	 public void saveBiManageXJ(List insertList, List updateList){
	   this.manageDao.updateBiManage(updateList);
	   this.manageDao.insertBiManage(insertList);
	 }

	 public void  deleteManage(List idList){
	   this.manageDao.deleteManage(idList);
	 }

}
