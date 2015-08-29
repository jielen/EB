package com.ufgov.gk.server.system.dao.ibatis;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.ufgov.gk.common.commonbiz.model.BaseBill;
import com.ufgov.gk.common.system.model.GkBusinessLog;
import com.ufgov.gk.server.system.dao.IGkBusinessLogDao;
import com.ufgov.gk.server.system.util.RequestMetaUtil;

public class GkBusinessLogDao extends SqlMapClientDaoSupport implements IGkBusinessLogDao {
  public void saveGkBusinessLog(GkBusinessLog log) {
    this.getSqlMapClientTemplate().insert("GkBusinessLog.saveLog", log);
  }

  public void saveGkBusinessLog(final List logList) {
    this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
      public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
        executor.startBatch();
        for (int i = 0; i < logList.size(); i++) {
          executor.insert("GkBusinessLog.saveLog", logList.get(i));
        }
        executor.executeBatch();
        return null;
      }
    });
  }

  public List getGkBusinessLog(BaseBill bill) {
    Map param = new HashMap();
    param.put("billId", bill.getId());
    //    param.put("tableName", GkBusinessLogUtil.getTableName(bill.getClass()));
    param.put("nd", new Integer(RequestMetaUtil.getSvNd()));
    return this.getSqlMapClientTemplate().queryForList("GkBusinessLog.getGkBusinessLog", param);
  }

  public List getGkBusinessLog(String billid, String tabname) {
    Map param = new HashMap();
    param.put("billId", billid);
    param.put("tableName", tabname);
    param.put("nd", new Integer(RequestMetaUtil.getSvNd()));
    return this.getSqlMapClientTemplate().queryForList("GkBusinessLog.getGkBusinessLog", param);
  }

}
