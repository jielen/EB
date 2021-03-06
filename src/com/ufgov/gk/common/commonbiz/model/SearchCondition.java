package com.ufgov.gk.common.commonbiz.model;

import java.io.Serializable;

public class SearchCondition implements Serializable {
  /**
   *
   */
  private static final long serialVersionUID = -3084395532923895623L;

  private String compoId;

  private String compoName;

  private String conditionId;

  private String conditionFieldCode;

  private String conditionFieldName;

  private int conditionFieldOrder;

  private String conditionName;

  private String conditionType;

  private String conditionNameOrder;

  public String getConditionType() {
    return conditionType;
  }

  public void setConditionType(String conditionType) {
    this.conditionType = conditionType;
  }

  public String getConditionName() {
    return conditionName;
  }

  public void setConditionName(String conditionName) {
    this.conditionName = conditionName;
  }

  public int getConditionFieldOrder() {
    return conditionFieldOrder;
  }

  public void setConditionFieldOrder(int conditionFieldOrder) {
    this.conditionFieldOrder = conditionFieldOrder;
  }

  public String getCompoId() {
    return compoId;
  }

  public void setCompoId(String compoId) {
    this.compoId = compoId;
  }

  public String getCompoName() {
    return compoName;
  }

  public void setCompoName(String compoName) {
    this.compoName = compoName;
  }



  public String getConditionId() {
    return conditionId;
  }

  public void setConditionId(String conditionId) {
    this.conditionId = conditionId;
  }

  public String getConditionFieldCode() {
    return conditionFieldCode;
  }

  public void setConditionFieldCode(String conditionFieldCode) {
    this.conditionFieldCode = conditionFieldCode;
  }

  public String getConditionFieldName() {
    return conditionFieldName;
  }

  public void setConditionFieldName(String conditionFieldName) {
    this.conditionFieldName = conditionFieldName;
  }




  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((compoId == null) ? 0 : compoId.hashCode());
    result = prime * result + ((compoName == null) ? 0 : compoName.hashCode());
    result = prime * result + ((conditionFieldCode == null) ? 0 : conditionFieldCode.hashCode());
    result = prime * result + ((conditionFieldName == null) ? 0 : conditionFieldName.hashCode());
    result = prime * result + conditionFieldOrder;
    result = prime * result + ((conditionId == null) ? 0 : conditionId.hashCode());
    result = prime * result + ((conditionName == null) ? 0 : conditionName.hashCode());
    return result;
  }


  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    SearchCondition other = (SearchCondition) obj;
    if (compoId == null) {
      if (other.compoId != null)
        return false;
    } else if (!compoId.equals(other.compoId))
      return false;
    if (compoName == null) {
      if (other.compoName != null)
        return false;
    } else if (!compoName.equals(other.compoName))
      return false;
    if (conditionFieldCode == null) {
      if (other.conditionFieldCode != null)
        return false;
    } else if (!conditionFieldCode.equals(other.conditionFieldCode))
      return false;
    if (conditionFieldName == null) {
      if (other.conditionFieldName != null)
        return false;
    } else if (!conditionFieldName.equals(other.conditionFieldName))
      return false;
    if (conditionFieldOrder != other.conditionFieldOrder)
      return false;
    if (conditionId == null) {
      if (other.conditionId != null)
        return false;
    } else if (!conditionId.equals(other.conditionId))
      return false;
    if (conditionName == null) {
      if (other.conditionName != null)
        return false;
    } else if (!conditionName.equals(other.conditionName))
      return false;
    return true;
  }

  public String toString() {
    return conditionFieldName;
  }

  public String getConditionNameOrder() {
    return conditionNameOrder;
  }

  public void setConditionNameOrder(String conditionNameOrder) {
    this.conditionNameOrder = conditionNameOrder;
  }
}
