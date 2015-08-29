package com.ufgov.gk.server.commonbiz.service.impl;

import java.util.List;

import com.ufgov.gk.common.system.dto.ElementConditionDto;
import com.ufgov.gk.server.commonbiz.dao.IMaCpElementMappingDao;
import com.ufgov.gk.server.commonbiz.service.IMaCpElementMappingService;
import com.ufgov.gk.server.system.util.RequestMetaUtil;

public class MaCpElementMappingService  implements IMaCpElementMappingService { 
  private IMaCpElementMappingDao maCpElementMappingDao;
  
	
	public IMaCpElementMappingDao getMaCpElementMappingDao() {
    return maCpElementMappingDao;
  }


  public void setMaCpElementMappingDao(IMaCpElementMappingDao maCpElementMappingDao) {
    this.maCpElementMappingDao = maCpElementMappingDao;
  }


  public List getMaCpElementMapping( ElementConditionDto dto){
    return  maCpElementMappingDao.getMaCpElementMapping(dto);
	}


  public void save(List maCpElementMappingList,String type,String useType) {
    maCpElementMappingDao.delete(RequestMetaUtil.getSvNd(), type,useType);
    maCpElementMappingDao.insert(maCpElementMappingList);
  }

}
