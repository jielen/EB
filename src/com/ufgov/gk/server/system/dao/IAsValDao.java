package com.ufgov.gk.server.system.dao;

import java.util.List;
import java.util.Map;

public interface IAsValDao {

  List getAsVal(String valSetId);

  Map getAsValMap(String valSetId);

  List getCompanyLevel(String sqlId);

}
