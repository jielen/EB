package com.ufgov.gk.server.ebay.service;

import java.util.List;

import com.ufgov.gk.common.ebay.model.EbRetrievalTask;
import com.ufgov.gk.common.ebay.model.EbRetrievalTaskExample;
import com.ufgov.gk.common.system.RequestMeta;

public interface IEbRetrievalTaskService {

  List<EbRetrievalTask> getRetrievalTask(EbRetrievalTaskExample ebRetrievalTaskExample, RequestMeta requestMeta);

  void saveEbRetrievalTask(EbRetrievalTask currentTask, RequestMeta requestMeta, String pageStatus);

  int deleteEbRetrievalTask(EbRetrievalTask task, RequestMeta requestMeta);

  void saveTaskAndItems(EbRetrievalTask task, RequestMeta requestMeta);

}
