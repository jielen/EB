package com.ufgov.gk.server.ebay.service;

import java.util.List;

import com.ufgov.gk.common.ebay.model.EbCurrency;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.dto.ElementConditionDto;

public interface IEbCurrencyService {

  List getEbCurrency(ElementConditionDto elementConditionDto, RequestMeta requestMeta);

  void saveEbCurrency(EbCurrency currency, RequestMeta requestMeta, String pageStatus);

  int deleteEbCurrency(EbCurrency currency, RequestMeta requestMeta);

  EbCurrency getebCurrencyByID(String currencyId, RequestMeta requestMeta);

}
