package com.ufgov.gk.server.ebay.service;

import java.util.List;

import com.ufgov.gk.common.ebay.model.EbSellerGroup;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.dto.ElementConditionDto;

public interface IEbSellerGroupService {

  List getEbSellerGroup(ElementConditionDto elementConditionDto, RequestMeta requestMeta);

  void saveEbSellGroup(EbSellerGroup sellerGroup, RequestMeta requestMeta, String pageStatus);

  int deleteEbSellerGroup(EbSellerGroup sellerGroup, RequestMeta requestMeta);

  EbSellerGroup getebSellerGroupByID(String groupId, RequestMeta requestMeta);

}
