package com.ufgov.gk.server.commonbiz.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.gk.common.system.dto.ElementConditionDto;
import com.ufgov.gk.server.commonbiz.dao.IBalModeDao;

public class BalModeDao extends SqlMapClientDaoSupport implements IBalModeDao {

  public List getBalMode(ElementConditionDto dto) {
    return this.getSqlMapClientTemplate().queryForList("BalMode.getBalMode",dto);    
  }

}
