package com.ufgov.gk.common.ebay.publish;

import java.util.List;

import com.ufgov.gk.common.ebay.model.EbAppAccount;
import com.ufgov.gk.common.ebay.model.EbAppServer;
import com.ufgov.gk.common.ebay.model.EbCandidateItem;
import com.ufgov.gk.common.ebay.model.EbCandidateItemExample;
import com.ufgov.gk.common.ebay.model.EbCandidateItemRef;
import com.ufgov.gk.common.ebay.model.EbCandidateItemRef2;
import com.ufgov.gk.common.ebay.model.EbCandidateItemRefExample;
import com.ufgov.gk.common.ebay.model.EbCategory;
import com.ufgov.gk.common.ebay.model.EbCurrency;
import com.ufgov.gk.common.ebay.model.EbItem;
import com.ufgov.gk.common.ebay.model.EbItemChecked;
import com.ufgov.gk.common.ebay.model.EbItemCheckedExample;
import com.ufgov.gk.common.ebay.model.EbItemExample;
import com.ufgov.gk.common.ebay.model.EbItemGroup;
import com.ufgov.gk.common.ebay.model.EbSeller;
import com.ufgov.gk.common.ebay.model.EbSellerExample;
import com.ufgov.gk.common.ebay.model.EbSellerGroup;
import com.ufgov.gk.common.ebay.model.EbSite;
import com.ufgov.gk.common.system.Publishable;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.dto.ElementConditionDto;

public interface IEbayServiceDelegate extends Publishable {

  public List getEbSite(ElementConditionDto elementConditionDto, RequestMeta requestMeta);

  public EbSite getebSiteByID(String siteId, RequestMeta requestMeta);

  public int deleteEbSite(EbSite site, RequestMeta requestMeta);

  public void saveEbSite(EbSite site, RequestMeta requestMeta, String pageStatus);

  public void saveEbAppServer(EbAppServer server, RequestMeta requestMeta, String pageStatus);

  public int deleteEbAppServer(EbAppServer server, RequestMeta requestMeta);

  public EbAppServer getEbAppServerByID(String siteId, RequestMeta requestMeta);

  public List getEbAppServer(ElementConditionDto elementConditionDto, RequestMeta requestMeta);

  public List getEbAppAccount(ElementConditionDto elementConditionDto, RequestMeta requestMeta);

  public void saveEbAppAccount(EbAppAccount account, RequestMeta requestMeta, String pageStatus);

  public int deleteEbAppAccount(EbAppAccount account, RequestMeta requestMeta);

  public EbAppAccount getEbAppAccountByID(String appAccount, RequestMeta requestMeta);

  public List getEbCategory(ElementConditionDto elementConditionDto, RequestMeta requestMeta);

  public void saveEbCategory(EbCategory server, RequestMeta requestMeta, String pageStatus);

  public int deleteEbCategory(EbCategory server, RequestMeta requestMeta);

  public EbCategory getEbCategoryByID(String categoryId, RequestMeta requestMeta);

  public List getEbSellerGroup(ElementConditionDto elementConditionDto, RequestMeta requestMeta);

  public void saveEbSellGroup(EbSellerGroup sellerGroup, RequestMeta requestMeta, String pageStatus);

  public int deleteEbSellerGroup(EbSellerGroup sellerGroup, RequestMeta requestMeta);

  public EbSellerGroup getebSellerGroupByID(String groupId, RequestMeta requestMeta);

  public List getEbCurrency(ElementConditionDto elementConditionDto, RequestMeta requestMeta);

  public void saveEbCurrency(EbCurrency currency, RequestMeta requestMeta, String pageStatus);

  public int deleteEbCurrency(EbCurrency currency, RequestMeta requestMeta);

  public EbCurrency getebCurrencyByID(String currencyId, RequestMeta requestMeta);

  public void saveEbSeller(EbSeller seller, RequestMeta requestMeta, String pageStatus);

  public int deleteEbSeller(EbSeller seller, RequestMeta requestMeta);

  public EbSeller getEbSellerByID(String sellerId, RequestMeta requestMeta);

  public List getEbSeller(ElementConditionDto elementConditionDto, RequestMeta requestMeta);

  public List getEbItem(ElementConditionDto elementConditionDto, RequestMeta requestMeta);

  public void saveEbItem(EbItem item, RequestMeta requestMeta, String pageStatus);

  public int deleteEbItem(EbItem item, RequestMeta requestMeta);

  public EbItem getEbItemByID(String itemId, RequestMeta requestMeta);

  public List getEbItem(EbItemExample example, RequestMeta requestMeta);

  public List getEbCandidateItem(EbCandidateItemExample example, RequestMeta requestMeta);

  public void saveEbCandidateItem(EbCandidateItem ebCandidateItem, RequestMeta requestMeta, String pageStatus);

  public int deleteEbCandidateItem(EbCandidateItem ebCandidateItem, RequestMeta requestMeta);

  public EbCandidateItem getEbCandidateItemByID(String candidateId, RequestMeta requestMeta);

  public List<EbItemGroup> getEbItemGroup(EbItemExample emex, RequestMeta requestMeta);

  public List<EbCandidateItemRef> getEbCandidateItemRef(String candidateId, RequestMeta requestMeta);

  public List<EbCandidateItemRef> getEbCandidateItemRef(EbCandidateItemRefExample example, RequestMeta requestMeta);

  public EbCandidateItem getEbCandidateItemByRefItemId(String itemId, RequestMeta requestMeta);

  public List<EbCandidateItemRef2> getEbCandidateItemRef2(String candidateId, RequestMeta requestMeta);

  public List<EbItemChecked> getEbItemChecked(EbItemCheckedExample ex, RequestMeta requestMeta);

  public void saveEbItemCheckeds(List<EbItemChecked> itemLst, RequestMeta requestMeta);

  public void deleteEbItemCheckeds(List<String> itemIds, RequestMeta requestMeta);

  public List<EbSeller> getEbSeller(EbSellerExample ex, RequestMeta requestMeta);

  public List<EbCandidateItemRef2> getEbCandidateItemRef2BySeller(String sellerId, RequestMeta requestMeta);

}
