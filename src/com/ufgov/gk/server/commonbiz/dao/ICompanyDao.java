package com.ufgov.gk.server.commonbiz.dao;

import java.util.List;

import com.ufgov.gk.common.commonbiz.model.Company;
import com.ufgov.gk.common.system.dto.ElementConditionDto;

public interface ICompanyDao {

  List getRootCompany(int nd);

  List getChildrenCompany(int nd);

  List getCompany(ElementConditionDto dto);

  List getCompanyNumLimTree(ElementConditionDto dto);
  
  Company getDirectorCompany(ElementConditionDto dto);

  Company getCompanyByCoCode(int nd, String coCode);

  List getCompanyChildren(int nd, String coCode);

  List getCompanyByUserId(String userId, int nd);
}
