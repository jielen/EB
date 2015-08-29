package com.ufgov.gk.common.system.model;

import java.io.Serializable;

public class PrintSetting implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 7833796879529791880L;

  private String userId;

  private String compoId;

  private String pageType;

  private String templateCode;

  private String exportType = "0";

  private String preview = "N";
  
  private String showPrintDialog;

  public String getShowPrintDialog() {
    return showPrintDialog;
  }

  public void setShowPrintDialog(String showPrintDialog) {
    this.showPrintDialog = showPrintDialog;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getCompoId() {
    return compoId;
  }

  public void setCompoId(String compoId) {
    this.compoId = compoId;
  }

  public String getTemplateCode() {
    return templateCode;
  }

  public void setTemplateCode(String templateCode) {
    this.templateCode = templateCode;
  }

  public String getPageType() {
    return pageType;
  }

  public void setPageType(String pageType) {
    this.pageType = pageType;
  }

  public String getExportType() {
    return exportType;
  }

  public void setExportType(String exportType) {
    this.exportType = exportType;
  }

  public String getPreview() {
    return preview;
  }

  public void setPreview(String preview) {
    this.preview = preview;
  }

}
