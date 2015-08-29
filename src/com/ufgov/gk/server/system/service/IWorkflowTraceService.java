/**
 * 
 */
package com.ufgov.gk.server.system.service;

import com.kingdrive.workflow.model.runtime.TraceInfoModel;


/**
 * @author ufwangfei
 *  Á÷³Ì¸ú×Ù
 */
public interface IWorkflowTraceService {
  
  TraceInfoModel getTraceInfo(Long instanceId);
  
}
