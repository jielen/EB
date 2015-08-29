package com.ufgov.gk.server.system.service;

import java.util.List;
import java.util.Map;

public interface ILangTransService {
  Map getLangTrans(String resId);

  List getAsLangTrans(String resId);

  void updateAslangTrans(List langTranList);
}
