package com.ufgov.gk.server.system.dao.ibatis;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.ufgov.gk.common.system.model.LangTrans;
import com.ufgov.gk.server.system.dao.ILangTransDao;

public class LangTransDao extends SqlMapClientDaoSupport implements ILangTransDao {

  public Map getLangTrans(String resId) {
    return this.getSqlMapClientTemplate().queryForMap("LangTrans.getLangTrans",
      resId, "resId");
  }

  public List getAsLangTrans(String resId) {
    return this.getSqlMapClientTemplate().queryForList("LangTrans.getLangTrans",
      resId);
  }

  public void updateAslangTrans(List langTranList) {
    final List list = langTranList;
    this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
      public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
        executor.startBatch();
        for (int i = 0; i < list.size(); i++) {
          LangTrans langTrans = (LangTrans) list.get(i);
          executor.update("LangTrans.updateAsLangTrans", langTrans);
        }
        executor.executeBatch();
        return null;
      }
    });
  }

}
