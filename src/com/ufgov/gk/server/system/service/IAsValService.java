package com.ufgov.gk.server.system.service;

import java.util.List;
import java.util.Map;

public interface IAsValService {

  List getAsVal(String valSetId);

  Map getAsValMap(String valSetId);

  List getCompanyLevel(String sqlId);
}
