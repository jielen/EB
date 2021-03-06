package com.ufgov.gk.common.system.model;
import java.io.Serializable;

public class UserSearchStore implements Serializable {
  private String storeId;

  private String conditionId;

  private String userId;

  private int nd;

  private String desc;

  private String searchInfo;

  private String groupInf;

  public String getStoreId() {
    return storeId;
  }

  public void setStoreId(String storeId) {
    this.storeId = storeId;
  }

  public String getConditionId() {
    return conditionId;
  }

  public void setConditionId(String conditionId) {
    this.conditionId = conditionId;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public int getNd() {
    return nd;
  }

  public void setNd(int nd) {
    this.nd = nd;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public String getSearchInfo() {
    return searchInfo;
  }

  public void setSearchInfo(String searchInfo) {
    this.searchInfo = searchInfo;
  }

  public String getGroupInf() {
    return groupInf;
  }

  public void setGroupInf(String groupInf) {
    this.groupInf = groupInf;
  }

  public UserSearchStore() {
  }
  
  public String toString() {
    return this.desc;
  }
}
