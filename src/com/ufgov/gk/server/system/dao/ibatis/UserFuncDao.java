package com.ufgov.gk.server.system.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.gk.common.system.dto.UserFuncDto;
import com.ufgov.gk.server.system.dao.IUserFuncDao;

public class UserFuncDao extends SqlMapClientDaoSupport implements IUserFuncDao {

  public List getUserGrantFunc(UserFuncDto userFuncDto) {
    return this.getSqlMapClientTemplate().queryForList("UserFunc.getUserGrantFunc",userFuncDto);
  }

  public List getUsedCompoFunc(String compoId) {
    return this.getSqlMapClientTemplate().queryForList("UserFunc.getUsedCompoFunc",compoId);
  }

}
