package com.ufgov.gk.server.commonbiz.service;

import java.util.List;
import java.util.Map;

import com.ufgov.gk.common.commonbiz.model.MaTzdSumElement;

public interface IMaTzdSumElementService {
  public List getMaTzdSumElement(int nd, String billTypeCode);
  
  public List getMaUserTzdSumElement(int nd, String billTypeCode,String userId);

  public Map getMaTzdSumElementMap(int nd, String billTypeCode, String userId);

  public MaTzdSumElement getMaTzdSumElement(int nd, String billTypeCode, String elementCode);

  public void updateMaTzdSumElement(MaTzdSumElement maTzdSumElement);

  public void updateMaTzdSum(MaTzdSumElement maTzdSumElement);

  public void updateMaTzdSumElements(List maTzdSumElementList);
  
  public void updateMaUserTzdSumElements(List maTzdSumElementList);
}
