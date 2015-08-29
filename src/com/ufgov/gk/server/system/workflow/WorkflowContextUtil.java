package com.ufgov.gk.server.system.workflow;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kingdrive.workflow.context.WorkflowContext;
import com.kingdrive.workflow.utils.WFConst;
import com.ufgov.gk.common.system.exception.BusinessException;
import com.ufgov.gk.common.system.model.AsOption;
import com.ufgov.gk.server.system.util.AsOptionUtil;
import com.ufgov.gk.server.system.util.RequestMetaUtil;

public class WorkflowContextUtil {

  public static WorkflowContext genWorkflowContext() {

    WorkflowContext workflowContext = new WorkflowContext();

    workflowContext.setExecutor(RequestMetaUtil.getSvUserID());
    workflowContext.setVariable(WFConst.WF_COMPANY_CODE, RequestMetaUtil.getSvCoCode());
    workflowContext.setVariable(WFConst.WF_ORG_CODE, RequestMetaUtil.getSvOrgCode());
    workflowContext.setVariable(WFConst.WF_POSITION_ID, RequestMetaUtil.getSvOrgPoCode());

    workflowContext.setVariable(WFConst.WF_POSITION_CODE, RequestMetaUtil.getSvPoCode());
    workflowContext.setVariable(WFConst.ND, String.valueOf(RequestMetaUtil.getSvNd()));

    workflowContext.setVariable("svCoCode", RequestMetaUtil.getSvCoCode());
    workflowContext.setVariable("svOrgCode", RequestMetaUtil.getSvOrgCode());
    workflowContext.setVariable("svPoCode", RequestMetaUtil.getSvPoCode());
    workflowContext.setVariable("svUserID", RequestMetaUtil.getSvUserID());
    workflowContext.setVariable("svCoLevel", getCoCodeLevel(RequestMetaUtil.getSvCoCode()));

    return workflowContext;
  }

  private static Integer getCoCodeLevel(String coCode) {
    if (coCode == null || coCode.trim().length() == 0) {
      throw new BusinessException("单位代码为null");
    }
    AsOption asOption = AsOptionUtil.getInstance().getOption("OPT_CO_CODE");
    String coCodeOptVal = "";
    if (asOption == null) {
      throw new BusinessException("没有找到单位代码的编码格式");
    }
    coCodeOptVal = asOption.getOptVal();
    String[] temp = coCodeOptVal.split("-");
    List splitLevels = Arrays.asList(temp);
    int splitLevel = splitLevels.size();
    Map lenAndLevel = new HashMap();
    int levelLen = 0;
    for (int i = 0; i < splitLevel; i++) {
      levelLen = levelLen + Integer.parseInt((String) splitLevels.get(i));
      lenAndLevel.put(String.valueOf(levelLen), String.valueOf(i + 1));
    }
    String coCodeLevelStr = (String) lenAndLevel.get(String.valueOf(coCode.length()));

    if (coCodeLevelStr == null) {
      //throw new BusinessException("单位代码:" + coCode + " 不符合编码格式：" + coCodeOptVal);
      coCodeLevelStr = "0";
    }

    return new Integer(coCodeLevelStr);

  }

}
