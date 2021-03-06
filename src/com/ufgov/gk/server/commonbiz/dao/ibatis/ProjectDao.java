package com.ufgov.gk.server.commonbiz.dao.ibatis;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.ufgov.gk.common.commonbiz.model.Project;
import com.ufgov.gk.common.system.dto.ElementConditionDto;
import com.ufgov.gk.server.commonbiz.dao.IProjectDao;

public class ProjectDao extends SqlMapClientDaoSupport implements IProjectDao {

  public List getChildrenProject(int nd) {
    return this.getSqlMapClientTemplate().queryForList("Project.getChildrenProject", new Integer(nd));
  }

  public List getProject(int nd) {
    Map map = new HashMap();
    map.put("nd", new Integer(nd));
    return this.getSqlMapClientTemplate().queryForList("Project.getProject", map);
  }

  public List getProject(ElementConditionDto dto){
    return this.getSqlMapClientTemplate().queryForList("Project.getProjectByRule",dto);
  }

  public List getProjectBiXJ(int nd){
    Map map = new HashMap();
    map.put("nd", new Integer(nd));
    return this.getSqlMapClientTemplate().queryForList("Project.getProjectBiXJ", map);
  }

  public List getProjectDetail() {
    return this.getSqlMapClientTemplate().queryForList("Project.getProjectDetail");
  }

  public List getProjectBalance() {
    Map map = new HashMap();
    return this.getSqlMapClientTemplate().queryForList("Project.getProjectBalance", map);
  }

  public List getPdProject(int nd) {
    return this.getSqlMapClientTemplate().queryForList("Project.getPdProject", new Integer(nd));
  }

  public List getRootProject(int nd) {
    return this.getSqlMapClientTemplate().queryForList("Project.getRootProject", new Integer(nd));
  }

  public void insertForProject(Project project) {
    this.getSqlMapClientTemplate().insert("Project.insertForProject", project);
  }

  public void updateForProject(Project project) {
    this.getSqlMapClientTemplate().update("Project.updateForProject", project);
  }

  public void deletePdProject(List dList) {
    final List list = dList;
    this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
      public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
        executor.startBatch();
        for (int i = 0; i < list.size(); i++) {
          Project project = (Project) list.get(i);
          executor.delete("Project.deletePdProject", project);
        }
        executor.executeBatch();
        return null;
      }
    });
  }

  public List getProjectByCode(String pCode) {
    Map map = new HashMap();
    map.put("code", pCode);
    return this.getSqlMapClientTemplate().queryForList("Project.getProjectByCode", map);
  }

  public void insertBiProject(List biList) {
    final List list = biList;
    this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
         public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
                 executor.startBatch();
                 for(int i=0;i<list.size();i++){
                   Project value =(Project)list.get(i);
                   executor.insert("Project.insertBiProject", value);
                 }
                 executor.executeBatch();
                 return null;
         }
 });

  }

  public void updateBiProject(List biList) {
    final List list = biList;
    this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
         public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
                 executor.startBatch();
                 for(int i=0;i<list.size();i++){
                   Project value =(Project)list.get(i);
                   executor.update("Project.updateBiProject", value);
                 }
                 executor.executeBatch();
                 return null;
         }
 });

  }

  public void deleteProject(List idList){
    if(idList.size()==0){
      return ;
    }
    Map map =new HashMap();
    map.put("idList", idList);
    this.getSqlMapClientTemplate().delete("Project.deleteProject",map);
  }
  
  public boolean codeExist(Project project) {
    return ((Integer) this.getSqlMapClientTemplate().queryForObject(
      "Project.codeExist", project)).intValue() > 0 ? true : false;
  }

  public boolean nameExist(Project project) {
    return ((Integer) this.getSqlMapClientTemplate().queryForObject(
      "Project.nameExist", project)).intValue() > 0 ? true : false;
  }

  public boolean nameExistSelfExcluded(Project project) {
    return ((Integer) this.getSqlMapClientTemplate().queryForObject(
      "Project.nameExisteSelfExcluded", project)).intValue() > 0 ? true : false;
  }
  
  public boolean projectUsed(Project project){
    return ((Integer) this.getSqlMapClientTemplate().queryForObject(
      "Project.getUsedProjectNum", project)).intValue() > 0 ? true : false;
  }
  
  public void deleteProjectWithChildren(Project project){
    this.getSqlMapClientTemplate().delete("Project.deleteProjectWithChildren", project);
  }

}
