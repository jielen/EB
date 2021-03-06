package com.ufgov.gk.server.commonbiz.dao.ibatis;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.ufgov.gk.common.commonbiz.model.Fund;
import com.ufgov.gk.common.system.dto.ElementConditionDto;
import com.ufgov.gk.server.commonbiz.dao.IFundDao;

public class FundDao extends SqlMapClientDaoSupport implements IFundDao {

  public List getFund(ElementConditionDto dto) {
    return this.getSqlMapClientTemplate().queryForList("Fund.getFund", dto);
  }

  public List getBiXJFund(ElementConditionDto dto) {
    return this.getSqlMapClientTemplate().queryForList("Fund.getBiXJFund", dto);
  }

  public void insertBiFund(List biList) {
    final List list = biList;
    this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
         public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
                 executor.startBatch();
                 for(int i=0;i<list.size();i++){
                   Fund value =(Fund)list.get(i);
                   executor.insert("Fund.insertBiFund", value);
                 }
                 executor.executeBatch();
                 return null;
         }
 });

  }

  public void updateBiFund(List biList) {
    final List list = biList;
    this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
         public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
                 executor.startBatch();
                 for(int i=0;i<list.size();i++){
                   Fund value =(Fund)list.get(i);
                   executor.update("Fund.updateBiFund", value);
                 }
                 executor.executeBatch();
                 return null;
         }
 });

  }

  public void deleteFund(List idList){
    if(idList.size()==0){
      return ;
    }
    Map map =new HashMap();
    map.put("idList", idList);
    this.getSqlMapClientTemplate().delete("Fund.deleteFund",map);
  }

}
