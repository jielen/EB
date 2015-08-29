package com.ufgov.gk.server.commonbiz.dao.ibatis;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.ufgov.gk.common.commonbiz.model.MaTzdSumElement;
import com.ufgov.gk.server.commonbiz.dao.IMaTzdSumElementDao;

public class MaTzdSumElmentDao extends SqlMapClientDaoSupport implements IMaTzdSumElementDao {

  public List getMaTzdSumElement(int nd, String billTypeCode) {
    Map map = new HashMap();
    map.put("nd", new Integer(nd));
    map.put("billTypeCode", billTypeCode);
    return this.getSqlMapClientTemplate().queryForList("MaTzdSumElement.getMaTzdSumElement", map);
  }
  
  public List getMaUserTzdSumElement(int nd, String billTypeCode,String userId) {
    Map map = new HashMap();
    map.put("nd", new Integer(nd));
    map.put("billTypeCode", billTypeCode);
    map.put("userId", userId);
    List list= this.getSqlMapClientTemplate().queryForList("MaTzdSumElement.getMaUserTzdSumElement", map);
    if(list.isEmpty()){
      list=this.getSqlMapClientTemplate().queryForList("MaTzdSumElement.getMaTzdSumElement", map);
    }
    return list;
  }

  public Map getMaTzdSumElementMap(int nd, String billTypeCode, String userId) {
    Map result=getMaUserTzdSumElementMap(nd,billTypeCode,userId);
    
    if(result.isEmpty()){
      
      Map map = new HashMap();
      map.put("nd", new Integer(nd));
      map.put("billTypeCode", billTypeCode);
      
      result=this.getSqlMapClientTemplate().queryForMap("MaTzdSumElement.getMaTzdSumElementMap", map,
      "elementCode");
    }
    return  result;
  }
  
  private Map getMaUserTzdSumElementMap(int nd, String billTypeCode,String userId){
    Map map = new HashMap();
    map.put("nd", new Integer(nd));
    map.put("billTypeCode", billTypeCode);
    map.put("userId", userId);
    return this.getSqlMapClientTemplate().queryForMap("MaTzdSumElement.getMaUserTzdSumElementMap", map,
      "elementCode");
  }

  public MaTzdSumElement getMaTzdSumElement(int nd, String billTypeCode, String elementCode) {
    Map map = new HashMap();
    map.put("nd", new Integer(nd));
    map.put("billTypeCode", billTypeCode);
    map.put("elementCode", elementCode);
    return (MaTzdSumElement) this.getSqlMapClientTemplate().queryForObject(
      "MaTzdSumElement.getMaTzdSumElement", map);
  }

  public void updateMaTzdSumElement(MaTzdSumElement maTzdSumElement) {
    this.getSqlMapClientTemplate().update("MaTzdSumElement.updateMaTzdSumElement", maTzdSumElement);
  }

  public void updateMaTzdSum(MaTzdSumElement maTzdSumElement) {
    this.getSqlMapClientTemplate().update("MaTzdSumElement.updateMaTzdSum", maTzdSumElement);
  }

  public void updateMaTzdSumElements(List maTzdSumElementList) {
    final List list = maTzdSumElementList;

    this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
      public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
        executor.startBatch();
        for (int i = 0; i < list.size(); i++) {
          MaTzdSumElement maTzdSumElement = (MaTzdSumElement) list.get(i);
          executor.update("MaTzdSumElement.updateMaTzdSumElementForBb", maTzdSumElement);
        }
        executor.executeBatch();
        return null;
      }
    });
  }
  
  
  public void updateMaUserTzdSumElements(List maTzdSumElementList) {
    final List list = maTzdSumElementList;
    
    if(!list.isEmpty()){
      this.getSqlMapClientTemplate().delete("MaTzdSumElement.deleteMaUserTzdSumElement", list.get(0));
    }

    this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
      public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
        executor.startBatch();
        for (int i = 0; i < list.size(); i++) {
          MaTzdSumElement maTzdSumElement = (MaTzdSumElement) list.get(i);
          executor.update("MaTzdSumElement.insertMaUserTzdSumElement", maTzdSumElement);
        }
        executor.executeBatch();
        return null;
      }
    });
  }

}
