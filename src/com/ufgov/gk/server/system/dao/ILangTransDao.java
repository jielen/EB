package com.ufgov.gk.server.system.dao;

import java.util.List;
import java.util.Map;

import com.ufgov.gk.common.system.model.LangTrans;

public interface ILangTransDao {
  Map getLangTrans(String resId);

  List getAsLangTrans(String resId);

  void updateAslangTrans(List langTranList);
}
