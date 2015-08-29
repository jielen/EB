package com.ufgov.gk.common.ebay.model;

import com.ufgov.gk.common.commonbiz.model.BaseBill;

public class EbCandidateItemRef2 extends BaseBill {

  /**
   * 
   */
  private static final long serialVersionUID = -1186089029283796317L;

  private String candidateId;

  public String getCandidateId() {
    return candidateId;
  }

  public void setCandidateId(String candidateId) {
    this.candidateId = candidateId;
  }

  public EbItem getEbItem() {
    return ebItem;
  }

  public void setEbItem(EbItem ebItem) {
    this.ebItem = ebItem;
  }

  private EbItem ebItem = new EbItem();
}
