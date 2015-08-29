package com.eb.client.component.ebRetrievalTask;

import java.util.List;

import com.ufgov.gk.common.ebay.model.EbCandidateItem;

public class CandidateUtil {

  public String getCandidateStatus(List<EbCandidateItem> candidateLst, String candidateId) {
    // TODO Auto-generated method stub
    for (EbCandidateItem ebCandidateItem : candidateLst) {
      if (ebCandidateItem.getCandidateId().equals(candidateId)) {
        return ebCandidateItem.getStatus();
      }
    }
    return null;
  }

}
