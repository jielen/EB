package com.ufgov.gk.server.system.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.gk.common.system.dto.ElementConditionDto;
import com.ufgov.gk.server.system.dao.IForeignEntityDao;

public class ForeignEntityDao extends SqlMapClientDaoSupport implements IForeignEntityDao {

  @Override
  public List getForeignEntitySelectedData(String sqlMapSelectedId, ElementConditionDto elementConditionDto) {
    // TODO Auto-generated method stub
    return this.getSqlMapClientTemplate().queryForList(sqlMapSelectedId, elementConditionDto);
  }

}
