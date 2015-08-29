package com.ufgov.gk.server.console.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.gk.common.console.model.AsEmp;
import com.ufgov.gk.common.system.dto.ElementConditionDto;
import com.ufgov.gk.server.console.dao.IAsEmpDao;

public class AsEmpDao extends SqlMapClientDaoSupport implements IAsEmpDao {

  public AsEmpDao() {
    super();
  }

  public List getOrgAsEmp(ElementConditionDto dto) {
    return this.getSqlMapClientTemplate().queryForList("AsEmp.getOrgAsEmp", dto);
  }

  public AsEmp getProviderInfoByCA(ElementConditionDto dto) {
    return (AsEmp) this.getSqlMapClientTemplate().queryForObject("AsEmp.getProviderInfoByCA", dto);
  }

  public AsEmp getProviderInfoByUserId(ElementConditionDto dto) {
    return (AsEmp) this.getSqlMapClientTemplate().queryForObject("AsEmp.getProviderInfoByUserId", dto);
  }

  public AsEmp insert(AsEmp po) {
    AsEmp record = (AsEmp) this.getSqlMapClientTemplate().insert("AsEmp.insertAsEmp", po);
    return record;
  }

  public List getAsEmp(AsEmp emp) {
    return (List) this.getSqlMapClientTemplate().queryForList("AsEmp.getAsEmp", emp);
  }
}
