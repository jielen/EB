package com.ufgov.gk.server.commonbiz.dao.ibatis;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.ufgov.gk.common.commonbiz.model.Manage;
import com.ufgov.gk.common.system.dto.ElementConditionDto;
import com.ufgov.gk.server.commonbiz.dao.IManageDao;

public class ManageDao extends SqlMapClientDaoSupport implements IManageDao {

	public List getManage(ElementConditionDto dto) {
	return this.getSqlMapClientTemplate().queryForList("Manage.getManage",dto);
	}

	public  List getManageForBiXJ(ElementConditionDto dto){
	  return this.getSqlMapClientTemplate().queryForList("Manage.getManageForBiXJ",dto);
	}

  public void insertBiManage(List biList) {
    final List list = biList;
    this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
         public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
                 executor.startBatch();
                 for(int i=0;i<list.size();i++){
                   Manage value =(Manage)list.get(i);
                   executor.insert("Manage.insertBiManage", value);
                 }
                 executor.executeBatch();
                 return null;
         }
 });

  }

  public void updateBiManage(List biList) {
    final List list = biList;
    this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
         public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
                 executor.startBatch();
                 for(int i=0;i<list.size();i++){
                   Manage value =(Manage)list.get(i);
                   executor.update("Manage.updateBiManage", value);
                 }
                 executor.executeBatch();
                 return null;
         }
 });

  }

  public void deleteManage(List idList){
    if(idList.size()==0){
      return ;
    }
    Map map =new HashMap();
    map.put("idList", idList);
    this.getSqlMapClientTemplate().delete("Manage.deleteManage",map);
  }

}
