package com.ufgov.gk.server.commonbiz.dao.ibatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.gk.common.commonbiz.model.Company;
import com.ufgov.gk.common.system.constants.NumLimConstants;
import com.ufgov.gk.common.system.dto.ElementConditionDto;
import com.ufgov.gk.server.commonbiz.dao.ICompanyDao;
import com.ufgov.gk.server.system.util.NumLimUtil;

public class CompanyDao extends SqlMapClientDaoSupport implements ICompanyDao {
  public List getRootCompany(int nd) {
    return this.getSqlMapClientTemplate().queryForList("Company.getRootCompany", new Integer(nd));
  }

  public List getChildrenCompany(int nd) {
    return this.getSqlMapClientTemplate().queryForList("Company.getChildrenCompany", new Integer(nd));
  }

  public List getCompany(ElementConditionDto dto) {
    return this.getSqlMapClientTemplate().queryForList("Company.getCompany", dto);
  }
  
  public Company getDirectorCompany(ElementConditionDto dto) {
    return (Company)this.getSqlMapClientTemplate().queryForObject("Company.getDirectorCompany", dto);
  }

  public List getCompanyByUserId(String userId, int nd) {
    Map params = new HashMap();
    params.put("userId", userId);
    params.put("nd", new Integer(nd));
    return this.getSqlMapClientTemplate().queryForList("Company.getCompanyByUserId", params);
  }

  public Company getCompanyByCoCode(int nd, String coCode) {
    Map params = new HashMap();
    params.put("nd", new Integer(nd));
    params.put("coCode", coCode);
    return (Company) this.getSqlMapClientTemplate().queryForObject("Company.getCompanyByCoCode", params);
  }

  public List getCompanyNumLimTree(ElementConditionDto dto) {
    String str = NumLimUtil.getInstance().getNumLimCondByCoType(dto.getNumLimCompoId(),
      NumLimConstants.FWATCH, NumLimConstants.CO_CODE);
    Map params = new HashMap();
    params.put("nd", new Integer(dto.getNd()));
    params.put("numLimitStr", str);
    params.put("dataRuleCondiStr", dto.getDataRuleCondiStr());
    params.put("coCode", dto.getCoCode());
    //System.out.println(dto.getContent()+"......................");
    
    return this.getSqlMapClientTemplate().queryForList("Company.getCompanyNumLimTree", params);
  }

  public List getCompanyChildren(int nd, String coCode) {
    Map params = new HashMap();
    params.put("nd", new Integer(nd));
    params.put("coCode", coCode);
    return (List) this.getSqlMapClientTemplate().queryForList("Company.getCompanyChildrenCode", params);
  }

}
