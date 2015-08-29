package com.ufgov.gk.common.system.model;

import java.io.Serializable;

public class PrintTemplate implements Serializable{
  
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private String compoId;

  private String templateCode;
  
  private String templateName;
  
  private String coCode;
  
  private String templateType;
  
  private int fixRowCount;

  public int getFixRowCount() {
    return fixRowCount;
  }

  public void setFixRowCount(int fixRowCount) {
    this.fixRowCount = fixRowCount;
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

  public String getTemplateName() {
    return templateName;
  }

  public void setTemplateName(String templateName) {
    this.templateName = templateName;
  }

  public String getCoCode() {
    return coCode;
  }

  public void setCoCode(String coCode) {
    this.coCode = coCode;
  }

  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((coCode == null) ? 0 : coCode.hashCode());
    result = prime * result + ((compoId == null) ? 0 : compoId.hashCode());
    result = prime * result + ((templateCode == null) ? 0 : templateCode.hashCode());
    result = prime * result + ((templateName == null) ? 0 : templateName.hashCode());
    return result;
  }

  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    final PrintTemplate other = (PrintTemplate) obj;
    if (coCode == null) {
      if (other.coCode != null)
        return false;
    } else if (!coCode.equals(other.coCode))
      return false;
    if (compoId == null) {
      if (other.compoId != null)
        return false;
    } else if (!compoId.equals(other.compoId))
      return false;
    if (templateCode == null) {
      if (other.templateCode != null)
        return false;
    } else if (!templateCode.equals(other.templateCode))
      return false;
    if (templateName == null) {
      if (other.templateName != null)
        return false;
    } else if (!templateName.equals(other.templateName))
      return false;
    return true;
  }

  public String getTemplateType() {
    return templateType;
  }

  public void setTemplateType(String templateType) {
    this.templateType = templateType;
  }
  public String toString(){
    return "["+ getTemplateCode() + "]"+getTemplateName();
  }
	

}
