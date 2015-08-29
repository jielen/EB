package com.ufgov.gk.server.commonbiz.dao;

import java.util.List;

public interface IMaBankDao {
  public List getAllBank(int nd);

  public List getZeroBalanceBank(int nd);

  public List getAgentBank(int nd, String accoType, String userId);
}
