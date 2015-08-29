package com.ufgov.gk.server.console.service.impl;

import java.util.List;

import com.ufgov.gk.common.console.model.AsEmp;
import com.ufgov.gk.common.system.dto.ElementConditionDto;
import com.ufgov.gk.server.console.dao.IAsEmpDao;
import com.ufgov.gk.server.console.service.IAsEmpService;

public class AsEmpService implements IAsEmpService {
  private IAsEmpDao asEmpDao;

  public IAsEmpDao getAsEmpDao() {
    return asEmpDao;
  }

  public void setAsEmpDao(IAsEmpDao asEmpDao) {
    this.asEmpDao = asEmpDao;
  }

  public AsEmpService() {
  }

  public List getOrgAsEmp(ElementConditionDto dto) {
    return asEmpDao.getOrgAsEmp(dto);
  }

  public AsEmp getProviderInfoByCA(ElementConditionDto dto) {
    return asEmpDao.getProviderInfoByCA(dto);
  }

  public List getAsEmp(AsEmp emp) {
    return asEmpDao.getAsEmp(emp);
  }
}
