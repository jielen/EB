package com.ufgov.gk.server.commonbiz.dao.ibatis;

import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.gk.server.commonbiz.dao.IExecProcCallback;

public class ExecProcCallbackDao extends SqlMapClientDaoSupport implements IExecProcCallback {

  /**
   * 更新之后执行存储过程回调
   */
  public String after(Map map) {
    this.getSqlMapClientTemplate().insert("ExecProcCallback.SP_GK_EDIT_BILL", map);
    return (String) map.get("info");
  }

  /**
   * 更新之前执行存储过程回调
   */
  public String before(Map map) {
    this.getSqlMapClientTemplate().insert("ExecProcCallback.SP_GK_EDIT_BILL", map);
    return (String) map.get("info");
  }

}
