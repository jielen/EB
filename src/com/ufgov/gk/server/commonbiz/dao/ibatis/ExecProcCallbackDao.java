package com.ufgov.gk.server.commonbiz.dao.ibatis;

import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.gk.server.commonbiz.dao.IExecProcCallback;

public class ExecProcCallbackDao extends SqlMapClientDaoSupport implements IExecProcCallback {

  /**
   * ����֮��ִ�д洢���̻ص�
   */
  public String after(Map map) {
    this.getSqlMapClientTemplate().insert("ExecProcCallback.SP_GK_EDIT_BILL", map);
    return (String) map.get("info");
  }

  /**
   * ����֮ǰִ�д洢���̻ص�
   */
  public String before(Map map) {
    this.getSqlMapClientTemplate().insert("ExecProcCallback.SP_GK_EDIT_BILL", map);
    return (String) map.get("info");
  }

}
