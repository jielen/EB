package com.ufgov.gk.server.commonbiz.dao;

import java.util.Map;

public interface IExecProcCallback {
  String before(Map map);

  String after(Map map);

}
