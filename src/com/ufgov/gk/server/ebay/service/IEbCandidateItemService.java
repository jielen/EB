package com.ufgov.gk.server.ebay.service;

import java.util.List;

import com.ufgov.gk.common.ebay.model.EbCandidateItem;
import com.ufgov.gk.common.ebay.model.EbCandidateItemExample;
import com.ufgov.gk.common.system.RequestMeta;

public interface IEbCandidateItemService {

  List getEbCandidateItem(EbCandidateItemExample example, RequestMeta requestMeta);

  void saveEbCandidateItem(EbCandidateItem ebCandidateItem, RequestMeta requestMeta, String pageStatus);

  int deleteEbCandidateItem(EbCandidateItem ebCandidateItem, RequestMeta requestMeta);

  EbCandidateItem getebCandidateItemByID(String candidateId, RequestMeta requestMeta);

  EbCandidateItem getEbCandidateItemByRefItemId(String itemId, RequestMeta requestMeta);

}
