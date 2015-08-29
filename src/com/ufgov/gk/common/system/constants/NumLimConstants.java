package com.ufgov.gk.common.system.constants;

public class NumLimConstants {

  // func_id
  public static final String FWATCH = "fwatch";

  public static final String FQUOTE = "fquote";

  // ctrl_field：要素代码or用户设置的sql条件
  public static final String SQL_CONDITION = "SQL_CONDITION";

  public static final String CO_CODE = "CO_CODE";

  public static final String B_ACC_CODE = "B_ACC_CODE";

  public static final String FUND_CODE = "FUND_CODE";

  public static final String PAYOUT_CODE = "PAYOUT_CODE";

  public static final String ORIGIN_CODE = "ORIGIN_CODE";

  public static final String ORG_CODE = "ORG_CODE";

  public static final String PAY_BANK_CODE = "PAY_BANK_CODE";

  public static final String AGENT_BANK_CODE = "AGENT_BANK_CODE";

  public static final String OPERATIONTYPE_CODE = "OPERATION_TYPE_CODE";

  // 其他要素
  public static final String PAYTYPE_CODE = "PAYTYPE_CODE";

  public static final String MANAGE_CODE = "MANAGE_CODE";

  public static final String BAL_MODE_CODE = "BAL_MODE_CODE";

  public static final String D_ATTR1 = "D_ATTR1";

  public static final String D_ATTR2 = "D_ATTR2";

  public static final String D_ATTR3 = "D_ATTR3";

  public static final String D_ATTR4 = "D_ATTR4";

  public static final String D_ATTR5 = "D_ATTR5";

  public static final String[] otherItemCodes = { PAYTYPE_CODE, MANAGE_CODE, BAL_MODE_CODE, D_ATTR1, D_ATTR2,
    D_ATTR3, D_ATTR4, D_ATTR5 };

  // 要素权限表
  public static final String USER_NUMLIM_TABLE = "ma_user_num_lim";

  public static final String ROLE_NUMLIM_TABLE = "ma_role_num_lim";

  // in or not in
  public static final String GRAN = "0";

  public static final String REVO = "1";

  public static final String IS_RELATION = "Y";

  public static final String IS_NOT_RELATION = "N";

  // 部件菜单的业务类型，格式为：%菜单前缀%:#code1#code2#...#
  public static final String[] COMPO_OPERATIONTYPE_CODE = { "CP:#01#03#", "AM:#02#03#" };

}
