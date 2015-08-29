package com.ufgov.gk.server.ebay.service;

import java.util.List;

import com.ufgov.gk.common.ebay.model.EbSeller;
import com.ufgov.gk.common.ebay.model.EbSellerExample;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.dto.ElementConditionDto;

public interface IEbSellerService {

  void saveEbSeller(EbSeller seller, RequestMeta requestMeta, String pageStatus);

  int deleteEbSeller(EbSeller seller, RequestMeta requestMeta);

  EbSeller getEbSellerByID(String sellerId, RequestMeta requestMeta);

  List getEbSeller(ElementConditionDto elementConditionDto, RequestMeta requestMeta);

  void updateEbSeller(EbSeller seller, RequestMeta requestMeta);

  List<EbSeller> getEbSeller(EbSellerExample ex, RequestMeta requestMeta);

boolean changeSellerIdFN(String sellerId, String newSellerId,
		RequestMeta requestMeta);

}
