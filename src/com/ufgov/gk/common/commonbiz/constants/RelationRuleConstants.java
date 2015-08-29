package com.ufgov.gk.common.commonbiz.constants;

import java.util.ArrayList;
import java.util.List;

public class RelationRuleConstants {

  public final static String PLAIN_RELATION="PLAIN_RELATION";

  public static final String CLEAR_ACCOUNTER = "CLEAR_ACCOUNTER";

  public static final String ZERO_BAL_ACCOUNTER = "ZERO_BAL_ACCOUNTER";

  public static final String BASE_ACCOUNTER = "BASE_ACCOUNTER";//������

  public static final String PR_ACCOUNTER = "PR_ACCOUNTER";


  public final static List ruleTypeList = new ArrayList();

  static {
//    ruleTypeMap.put(PLAIN_RELATION, "��ͨ����");
//    ruleTypeList.add(ruleTypeMap);
    Object[] ruleInfo = null;
    

    ruleInfo = new Object[]{PLAIN_RELATION, "��ͨ����", "com.ufgov.gk.client.console.elementrule.plain.PlainRuleView"};
    ruleTypeList.add(ruleInfo);
    
    ruleInfo = new Object[]{CLEAR_ACCOUNTER, "�����˻�", "com.ufgov.gk.client.console.elementrule.accounter.AccounterRuleView"};
    ruleTypeList.add(ruleInfo);

    ruleInfo = new Object[]{ZERO_BAL_ACCOUNTER, "������˻�", "com.ufgov.gk.client.console.elementrule.accounter.AccounterRuleView"};
    ruleTypeList.add(ruleInfo);
    
    ruleInfo = new Object[]{BASE_ACCOUNTER, "��ͨ�˻�", "com.ufgov.gk.client.console.elementrule.accounter.AccounterRuleView"};
    ruleTypeList.add(ruleInfo);

    ruleInfo = new Object[]{PR_ACCOUNTER, "�����˻�", "com.ufgov.gk.client.console.elementrule.accounter.AccounterRuleView"};
    ruleTypeList.add(ruleInfo);


  }


}
