package com.ufgov.gk.server.commonbiz.dao.ibatis;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.ufgov.gk.common.commonbiz.model.MaCpElementMapping;
import com.ufgov.gk.common.system.dto.ElementConditionDto;
import com.ufgov.gk.server.commonbiz.dao.IMaCpElementMappingDao;

public class MaCpElementMappingDao extends SqlMapClientDaoSupport implements IMaCpElementMappingDao {

  public List getMaCpElementMapping(ElementConditionDto dto) {
    return this.getSqlMapClientTemplate().queryForList("MaCpElementMapping.getMaCpElementMapping",dto);
  }

  public void insert(MaCpElementMapping maCpElementMapping) {
    this.getSqlMapClientTemplate().insert("MaCpElementMapping.insert",maCpElementMapping);
  }

  public int update(MaCpElementMapping maCpElementMapping) {
    return   this.getSqlMapClientTemplate().update("MaCpElementMapping.update",maCpElementMapping);
  }

  public void delete(int nd, String type,String useType) {
    Map map = new HashMap();
    map.put("nd", new Integer(nd));
    map.put("type", type);
    map.put("useType", useType);
    this.getSqlMapClientTemplate().delete("MaCpElementMapping.delete",map);
  }

  public void insert(List maCpElementMappingList) {
    final List list = maCpElementMappingList;
    this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
      public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
        executor.startBatch();
        for (int i = 0; i < list.size(); i++) {
          executor.insert("MaCpElementMapping.insert",  list.get(i));
        }
        executor.executeBatch();
        return null;
      }
    });
  
  }

}
