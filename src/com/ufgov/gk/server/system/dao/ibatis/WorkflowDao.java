/**
 * 
 */
package com.ufgov.gk.server.system.dao.ibatis;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.ufgov.gk.common.system.model.AsWfDraft;
import com.ufgov.gk.server.system.dao.IWorkflowDao;

/**
 * @author ufwangfei
 *
 */
public class WorkflowDao extends SqlMapClientDaoSupport implements IWorkflowDao {

  public static final String SEQ_INSTANCE = "SEQ_INSTANCE";

  public Long createDraftId() {
    Long draftId = Long.valueOf(getNextId(this.SEQ_INSTANCE));
    draftId = new Long(draftId.longValue() * (-1));
    return draftId;
  }

  public void insertAsWfdraft(AsWfDraft asWfDraft) {
    this.getSqlMapClientTemplate().insert("WfCommonDraft.insertAsWfDraft", asWfDraft);
  }

  private String getNextId(String sequenceName) {
    return (String) this.getSqlMapClientTemplate().queryForObject("WfCommonDraft.getSeqInstance",
      sequenceName);
  }

  private String getTitleField(String compoId) {
    return (String) this.getSqlMapClientTemplate().queryForObject("WfCommonDraft.getTitleField", compoId);
  }

  public void deleteDraft(String compoId, Long wfDraftId) {
    Map params = new HashMap();
    params.put("compoId", compoId);
    params.put("wfDraftId", wfDraftId);
    this.getSqlMapClientTemplate().delete("WfCommonDraft.deleteAsWfDraft", params);
  }

  public String getWfInstanceIdStatus(Long wfInstanceId) {
    return (String) this.getSqlMapClientTemplate().queryForObject("WfCommonDraft.getWfInstanceIdStatus",
      wfInstanceId);
  }

  public String getOrgPosiId(String coCode, String orgCode, String posiCode, int nd) {
    Map params = new HashMap();
    params.put("CO_CODE", coCode);
    params.put("ORG_CODE", orgCode);
    params.put("POSI_CODE", posiCode);
    params.put("ND", new Integer(nd));
    return (String) this.getSqlMapClientTemplate().queryForObject("WfCommonDraft.getOrgPosiId", params);
  }

  public boolean isFinalAudit(Long processInstId) {
    boolean flag = false;
    String status = this.getWfInstanceIdStatus(processInstId);
    if (status != null && status.trim().equals("9")) {
      flag = true;
    }
    return flag;
  }
  
  public int getWfTemplateNode(String compoId){
    return ((Integer) this.getSqlMapClientTemplate().queryForObject("WfCommonDraft.getWfTemplateNode",compoId)).intValue();
  }
  
  public void updateCurrentTaskSendStatus(Long instanceId, String status) {
    Map params = new HashMap();
    params.put("instanceId", instanceId);
    params.put("status", status);
    this.getSqlMapClientTemplate().update("WfCommonDraft.updateCurrentTaskSendStatus", params);
  }
  
  public void updateCurrentTaskSendStatus(final List instanceIdList, final String status) {
    
    this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
      public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
        executor.startBatch();
        for (int i = 0; i < instanceIdList.size(); i++) {
          Object instanceId = instanceIdList.get(i);
          Map params = new HashMap();
          params.put("instanceId", instanceId);
          params.put("status", status);
          executor.update("WfCommonDraft.updateCurrentTaskSendStatus", params);
        }
        executor.executeBatch();
        return null;
      }
    });
    
  }

}
