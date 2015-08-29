package com.ufgov.gk.server.commonbiz.dao;

import java.util.List;

import com.ufgov.gk.common.system.dto.ElementConditionDto;

public interface IOrgDao {

  List getCzOrg(int nd);

  List getZcOrg(int nd);

  
  public List getOrg(int nd);

  public List getOrg(ElementConditionDto dto);

  public List getPosition(int nd);

  public List getEmp(int nd);

}
