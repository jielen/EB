package com.ufgov.gk.common.system.model;

import java.io.Serializable;

public class UserFunc implements Serializable {
	
	/**
   * 
   */
  private static final long serialVersionUID = 6756693422578097035L;
  
  
  private String userId;
	private String compoId;
	private String funcId;
	
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
  public String getFuncId() {
    return funcId;
  }
  public void setFuncId(String funcId) {
    this.funcId = funcId;
  }
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((compoId == null) ? 0 : compoId.hashCode());
    result = prime * result + ((funcId == null) ? 0 : funcId.hashCode());
    result = prime * result + ((userId == null) ? 0 : userId.hashCode());
    return result;
  }
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    final UserFunc other = (UserFunc) obj;
    if (compoId == null) {
      if (other.compoId != null)
        return false;
    } else if (!compoId.equals(other.compoId))
      return false;
    if (funcId == null) {
      if (other.funcId != null)
        return false;
    } else if (!funcId.equals(other.funcId))
      return false;
    if (userId == null) {
      if (other.userId != null)
        return false;
    } else if (!userId.equals(other.userId))
      return false;
    return true;
  }

	

}
