package com.ufgov.gk.common.system.model;

import java.math.BigDecimal;

public class AsWfDraft {
    private BigDecimal wfDraftId;

    private String wfDraftName;

    private String compoId;

    private String masterTabId;

    private String userId;

    private String userName;

    private String saveTime;

    private String status;

    public BigDecimal getWfDraftId() {
        return wfDraftId;
    }

    public void setWfDraftId(BigDecimal wfDraftId) {
        this.wfDraftId = wfDraftId;
    }


    public String getWfDraftName() {
        return wfDraftName;
    }


    public void setWfDraftName(String wfDraftName) {
        this.wfDraftName = wfDraftName;
    }


    public String getCompoId() {
        return compoId;
    }


    public void setCompoId(String compoId) {
        this.compoId = compoId;
    }

    public String getMasterTabId() {
        return masterTabId;
    }


    public void setMasterTabId(String masterTabId) {
        this.masterTabId = masterTabId;
    }


    public String getUserId() {
        return userId;
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getSaveTime() {
        return saveTime;
    }


    public void setSaveTime(String saveTime) {
        this.saveTime = saveTime;
    }


    public String getStatus() {
        return status;
    }

  
    public void setStatus(String status) {
        this.status = status;
    }
}