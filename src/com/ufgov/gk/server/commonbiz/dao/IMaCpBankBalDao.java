package com.ufgov.gk.server.commonbiz.dao;

import java.util.List;

public interface IMaCpBankBalDao {
  public List getMaCpBankBal(int nd, String bankCode, String fundCode);

  public List getMaCpBankBalByView(int nd, String bankCode, String fundCode, String maCpBankBalView);

  public List getMaCpBankBalForTzd(int nd, String payAccNo, String fundCode);

  public List getMaCpBankBalByAuto(int nd, String bankCode, String clearAccNo, String maCpBankBalView);

  public List getMaCpBankBalList(int nd);
}
