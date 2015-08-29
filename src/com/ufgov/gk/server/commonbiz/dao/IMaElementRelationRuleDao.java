package com.ufgov.gk.server.commonbiz.dao;

import java.util.List;

import com.ufgov.gk.common.commonbiz.model.MaElementRelationRule;
import com.ufgov.gk.common.commonbiz.model.MaElementRelationRuleEntry;

public interface IMaElementRelationRuleDao {
  
   List getElementRelationRule(String compoId,String handleType,String ruleType);
   
    List getElementRelationRuleDetail(List ruleIdList) ;
   
   void insertElementRelationRule(MaElementRelationRule relationRule);
   
   void updateElementRelationRule(MaElementRelationRule realtionRule);
   
   String getElementRelationId();
   
   String getElementEntryId();
   
   void deleteElementRelationRuleById(String ruleId);
   
   void deleteRelationEntryByEntryId(String entryId);
   
   void insertElementRelationEntry(MaElementRelationRuleEntry ruleEntry);
   
   void updateElementRelationEntry(MaElementRelationRuleEntry ruleEntry);

}
