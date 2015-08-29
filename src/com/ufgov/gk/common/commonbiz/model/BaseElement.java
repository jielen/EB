package com.ufgov.gk.common.commonbiz.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BaseElement implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  protected int nd;

  protected String code;

  protected String name;

  protected int level;

  protected String parentCode;

  protected List children = new ArrayList();

  public int getNd() {
    return nd;
  }

  public void setNd(int nd) {
    this.nd = nd;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public String getParentCode() {
    return parentCode;
  }

  public void setParentCode(String parentCode) {
    this.parentCode = parentCode;
  }

  public List getChildren() {
    return children;
  }

  public void setChildren(List children) {
    this.children = children;
  }
  
  public String toString() {
    if(this.code==null ||"".equals(this.code.trim())){
      return this.name;
    }
    return "[" + this.code + "]" + this.name;
  }
  
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((code == null) ? 0 : code.hashCode());
    result = prime * result + level;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + nd;
    result = prime * result + ((parentCode == null) ? 0 : parentCode.hashCode());
    return result;
  }

  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    final BaseElement other = (BaseElement) obj;
    if (code == null) {
      if (other.code != null)
        return false;
    } else if (!code.equals(other.code))
      return false;
    if (level != other.level)
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (nd != other.nd)
      return false;
    if (parentCode == null) {
      if (other.parentCode != null)
        return false;
    } else if (!parentCode.equals(other.parentCode))
      return false;
    return true;
  }

}
