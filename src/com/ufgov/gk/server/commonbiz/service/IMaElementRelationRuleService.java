package com.ufgov.gk.server.commonbiz.service;

import java.util.List;

import com.ufgov.gk.common.commonbiz.model.MaElementRelationRule;
import com.ufgov.gk.common.commonbiz.model.MaElementRelationRuleEntry;

public interface IMaElementRelationRuleService {
  
  void insertElementRelationRule(MaElementRelationRule relationRule);
  
  void updateElementRelationRule(MaElementRelationRule realtionRule);
  
  String getElementRelationId();
  
  public List getElementRelationRules(String compoId,String handleType,String ruleType);
  
  void deleteElementRelationRuleById(String ruleId);
  
  void deleteRelationEntityByEntryId(String entityId);
  
  void insertElementRelationEntry(MaElementRelationRuleEntry ruleEntry);
  
  void updateElementRelationEntry(MaElementRelationRuleEntry ruleEntry);
  
  String getElementEntryId();
}
