package com.ufgov.gk.server.ebay.service;

import java.util.List;

import com.ufgov.gk.common.ebay.model.EbAppAccount;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.dto.ElementConditionDto;

public interface IEbAppAccountService {

  List getEbAppAccount(ElementConditionDto elementConditionDto, RequestMeta requestMeta);

  void saveEbAppAccount(EbAppAccount account, RequestMeta requestMeta, String pageStatus);

  int deleteEbAppAccount(EbAppAccount account, RequestMeta requestMeta);

  EbAppAccount getEbAppAccountByID(String appAccount, RequestMeta requestMeta);

}
