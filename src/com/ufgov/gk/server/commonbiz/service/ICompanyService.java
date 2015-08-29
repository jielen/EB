package com.ufgov.gk.server.commonbiz.service;

import java.util.List;

import com.ufgov.gk.common.commonbiz.model.Company;
import com.ufgov.gk.common.system.dto.ElementConditionDto;

public interface ICompanyService {
  
  Company getDirectorCompany(ElementConditionDto dto);

  List getCompanyTree(int nd);

  List getCompany(ElementConditionDto dto);

  List getCompanyNumLimTree(ElementConditionDto dto);

  Company getCompanyByCoCode(int nd, String coCode);

  List getCompanyChildren(int nd, String coCode);

  List getCompanyByUserId(String userId, int nd);

}
