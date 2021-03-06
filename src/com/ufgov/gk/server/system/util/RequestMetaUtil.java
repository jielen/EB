package com.ufgov.gk.server.system.util;

import java.util.Date;

import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.server.system.ThreadLocalContext;

public class RequestMetaUtil {

  public static RequestMeta getRequestMeta() {
    return (RequestMeta) ThreadLocalContext.getAttribute(RequestMeta.class.getName());
  }

  public static String getToken() {
    return getRequestMeta().getToken();
  }

  public static String getClientIP() {
    return getRequestMeta().getClientIP();
  }

  public static String getCompoId() {
    return getRequestMeta().getCompoId();
  }

  public static String getFuncId() {
    return getRequestMeta().getFuncId();
  }

  public static String getSvUserID() {
    return getRequestMeta().getSvUserID();
  }

  public static String getSvCoCode() {
    return getRequestMeta().getSvCoCode();
  }

  public static String getSvOrgCode() {
    return getRequestMeta().getSvOrgCode();
  }

  public static String getSvPoCode() {
    return getRequestMeta().getSvPoCode();
  }

  public static String getSvOrgPoCode() {

    String orgPoCode = getRequestMeta().getSvOrgPoCode();

    //    if(orgPoCode==null||orgPoCode.trim().equals("")){
    //      IWorkflowDao workflowDao = (IWorkflowDao) SpringContext
    //      .getBean("workflowDao");
    //      orgPoCode=workflowDao.getOrgPosiId(getRequestMeta().getSvCoCode(), getRequestMeta().getSvOrgCode(),
    //        getRequestMeta().getSvPoCode(), getRequestMeta().getSvNd());
    //    }
    return orgPoCode;
  }

  public static String getSvCoTypeCode() {
    return getRequestMeta().getSvCoTypeCode();
  }

  public static int getSvNd() {
    return getRequestMeta().getSvNd();
  }

  public static Date getTransDate() {
    return getRequestMeta().getTransDate();
  }

  public static Date getSysDate() {
    return getRequestMeta().getSysDate();
  }

  public static int getSvMonth() {
    return getRequestMeta().getSvMonth();
  }

  public static String getPrintCompoId() {
    return getRequestMeta().getPrintCompoId();
  }

  public static String getPageType() {
    return getRequestMeta().getPageType();
  }

  public static String getSvUserName() {
    return getRequestMeta().getSvUserName();
  }

  public static String getSvCoName() {
    return getRequestMeta().getSvCoName();
  }
  public static String getSvAccountId(){
    return getRequestMeta().getAccountId();
  }
}
