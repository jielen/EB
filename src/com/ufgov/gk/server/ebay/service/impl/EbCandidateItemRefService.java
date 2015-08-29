package com.ufgov.gk.server.ebay.service.impl;

import java.util.List;

import com.ufgov.gk.common.ebay.model.EbCandidateItemRef;
import com.ufgov.gk.common.ebay.model.EbCandidateItemRef2;
import com.ufgov.gk.common.ebay.model.EbCandidateItemRefExample;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.server.ebay.dao.EbCandidateItemRefDAO;
import com.ufgov.gk.server.ebay.service.IEbCandidateItemRefService;

public class EbCandidateItemRefService implements IEbCandidateItemRefService {
  private EbCandidateItemRefDAO ebCandidateItemRefDAO;

  @Override
  public List<EbCandidateItemRef> getEbCandidateItemRef(String candidateId, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    EbCandidateItemRefExample ex = new EbCandidateItemRefExample();
    ex.createCriteria().andCandidateIdEqualTo(candidateId);

    return ebCandidateItemRefDAO.selectByExample(ex);
  }

  public EbCandidateItemRefDAO getEbCandidateItemRefDAO() {
    return ebCandidateItemRefDAO;
  }

  public void setEbCandidateItemRefDAO(EbCandidateItemRefDAO ebCandidateItemRefDAO) {
    this.ebCandidateItemRefDAO = ebCandidateItemRefDAO;
  }

  @Override
  public List<EbCandidateItemRef> getEbCandidateItemRef(EbCandidateItemRefExample example, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebCandidateItemRefDAO.selectByExample(example);
  }

  @Override
  public List<EbCandidateItemRef2> getEbCandidateItemRef2(String candidateId, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebCandidateItemRefDAO.selectByPK(candidateId);
  }

  @Override
  public List<EbCandidateItemRef2> getEbCandidateItemRef2BySeller(String sellerId, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebCandidateItemRefDAO.getEbCandidateItemRef2BySeller(sellerId);
  }

}
