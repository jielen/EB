package com.ufgov.gk.server.commonbiz.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ufgov.gk.common.commonbiz.model.Company;
import com.ufgov.gk.common.system.dto.ElementConditionDto;
import com.ufgov.gk.server.commonbiz.dao.ICompanyDao;
import com.ufgov.gk.server.commonbiz.service.ICompanyService;

public class CompanyService implements ICompanyService {

  private ICompanyDao companyDao;

  public ICompanyDao getCompanyDao() {
    return companyDao;
  }

  public void setCompanyDao(ICompanyDao companyDao) {
    this.companyDao = companyDao;
  }

  public List getCompanyTree(int nd) {

    List rootCompanyList = companyDao.getRootCompany(nd);
    List childrenCompanyList = companyDao.getChildrenCompany(nd);

    Map childrenMap = new HashMap();

    for (int i = 0; i < childrenCompanyList.size(); i++) {
      Company child = (Company) childrenCompanyList.get(i);

      List childrenList = (List) childrenMap.get(child.getParentCode());
      if (childrenList != null) {
        childrenList.add(child);
      } else {
        List tempList = new ArrayList();
        tempList.add(child);
        childrenMap.put(child.getParentCode(), tempList);
      }
    }

    for (int i = 0; i < rootCompanyList.size(); i++) {
      Company company = (Company) rootCompanyList.get(i);
      this.setCompanyChildren(company, childrenMap);
    }

    return rootCompanyList;
  }

  private void setCompanyChildren(Company company, Map childrenMap) {

    List childrenList = (List) childrenMap.get(company.getCode());
    if (childrenList != null) {
      company.setChildren(childrenList);
      for (int i = 0; i < childrenList.size(); i++) {
        Company c = (Company) childrenList.get(i);
        setCompanyChildren(c, childrenMap);
      }
    }

  }

  public List getCompany(ElementConditionDto dto) {
    return companyDao.getCompany(dto);
  }

  public List getCompanyByUserId(String userId, int nd) {
    return companyDao.getCompanyByUserId(userId, nd);
  }

  public List getCompanyNumLimTree(ElementConditionDto dto) {
    return companyDao.getCompanyNumLimTree(dto);
  }

  public Company getCompanyByCoCode(int nd, String coCode) {
    return companyDao.getCompanyByCoCode(nd, coCode);
  }

  public List getCompanyChildren(int nd, String coCode) {
    return companyDao.getCompanyChildren(nd, coCode);
  }
  
  public Company getDirectorCompany(ElementConditionDto dto){
    return companyDao.getDirectorCompany(dto);
  }

}
