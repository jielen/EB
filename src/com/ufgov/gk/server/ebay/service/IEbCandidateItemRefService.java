package com.ufgov.gk.server.ebay.service;

import java.util.List;

import com.ufgov.gk.common.ebay.model.EbCandidateItemRef;
import com.ufgov.gk.common.ebay.model.EbCandidateItemRef2;
import com.ufgov.gk.common.ebay.model.EbCandidateItemRefExample;
import com.ufgov.gk.common.system.RequestMeta;

public interface IEbCandidateItemRefService {

  List<EbCandidateItemRef> getEbCandidateItemRef(String candidateId, RequestMeta requestMeta);

  List<EbCandidateItemRef> getEbCandidateItemRef(EbCandidateItemRefExample example, RequestMeta requestMeta);

  List<EbCandidateItemRef2> getEbCandidateItemRef2(String candidateId, RequestMeta requestMeta);

  List<EbCandidateItemRef2> getEbCandidateItemRef2BySeller(String sellerId, RequestMeta requestMeta);

}
