package com.ufgov.gk.common.ebay.publish;

import java.util.List;

import com.ufgov.gk.common.ebay.model.EbItem;
import com.ufgov.gk.common.ebay.model.EbItemExample;
import com.ufgov.gk.common.ebay.model.EbRetrievalTask;
import com.ufgov.gk.common.ebay.model.EbRetrievalTaskExample;
import com.ufgov.gk.common.ebay.model.EbSeller;
import com.ufgov.gk.common.system.RequestMeta;

public interface IEbayRetrievalTaskDelegate {

  public List<EbRetrievalTask> getRetrievalTask(EbRetrievalTaskExample ebRetrievalTaskExample, RequestMeta requestMeta);

  public void saveEbRetrievalTask(EbRetrievalTask currentTask, RequestMeta requestMeta, String pageStatus);

  public int deleteEbRetrievalTask(EbRetrievalTask task, RequestMeta requestMeta);

  public void saveEbItems(List<EbItem> ebItemLst, RequestMeta requestMeta);

  public void saveTaskAndItems(EbRetrievalTask task, RequestMeta requestMeta);

  public void deleteEbItems(EbItemExample ebItemExample, RequestMeta requestMeta);

  public void updateEbSeller(EbSeller seller, RequestMeta requestMeta);

  EbSeller getEbSellerBySellerId(String sellerId, RequestMeta requestMeta);

  public void saveEbSeller(EbSeller ebSeller, RequestMeta requestMeta, String pageStatus);

public boolean changeSellerIdFN(String sellerId, String newSellerId,
		RequestMeta requestMeta);

}
