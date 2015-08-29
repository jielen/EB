/**
 * 
 */
package com.ufgov.gk.server.system.service.impl;

import com.kingdrive.workflow.model.runtime.TraceInfoModel;
import com.ufgov.gk.server.system.service.IWorkflowTraceService;
import com.ufgov.gk.server.system.workflow.WFEngineAdapter;


/**
 * @author ufwangfei
 *  Á÷³Ì¸ú×Ù
 */
public class WorkflowTraceService implements IWorkflowTraceService {

  private WFEngineAdapter wfEngineAdapter;

  public TraceInfoModel getTraceInfo(Long instanceId) {
    return wfEngineAdapter.getTraceInfo(instanceId);
  }

  public WFEngineAdapter getWfEngineAdapter() {
    return wfEngineAdapter;
  }

  public void setWfEngineAdapter(WFEngineAdapter wfEngineAdapter) {
    this.wfEngineAdapter = wfEngineAdapter;
  }
  
}
