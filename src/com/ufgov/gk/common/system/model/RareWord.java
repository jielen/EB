package com.ufgov.gk.common.system.model;

import java.io.Serializable;

public class RareWord implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -5020247136964858672L;

  private String id;

  private String word;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getWord() {
    return word;
  }

  public void setWord(String word) {
    this.word = word;
  }
  
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((word == null) ? 0 : word.hashCode());
    return result;
  }

  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    final RareWord other = (RareWord) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (word == null) {
      if (other.word != null)
        return false;
    } else if (!word.equals(other.word))
      return false;
    return true;
  }

}
