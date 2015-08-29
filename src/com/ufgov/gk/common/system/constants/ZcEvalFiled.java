/**   
* @(#) project: GK
* @(#) file: ZcEvalFiled.java
* 
* Copyright 2010 UFGOV, Inc. All rights reserved.
* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
* 
*/
package com.ufgov.gk.common.system.constants;

/**
* @ClassName: ZcEvalFiled
* @Description:评标模块表字段属性常量。
* @date: 2010-4-23 下午12:05:37
* @version: V1.0 
* @since: 1.0
* @author: tianly1
* @modify: 
*/
public interface ZcEvalFiled {
  String FIELD_NAME_FORMULA = "FORMULA";

  String FIELD_NAME_PROVIDER_TOTAL_PRICE = "PROVIDER_TOTAL_PRICE";

  String FIELD_NAME_EVAL_SCORE = "EVAL_SCORE";

  String FIELD_NAME_ROW_INDEX = "ROW_INDEX";

  String FIELD_NAME_PARAM_CODE = "PARAM_CODE";

  String FIELD_NAME_PARAM_NAME = "PARAM_NAME";

  String FIELD_NAME_VALUE = "VALUE";

  String FIELD_NAME_DEFAULT_VALUE = "DEFAULT_VALUE";

  String FIELD_NAME_STANDARD_SCORE = "STANDARD_SCORE";

  String FIELD_NAME_MAX_MINUS_SCORE = "MAX_MINUS_SCORE";

  String FIELD_NAME_MAX_ADD_SCORE = "MAX_ADD_SCORE";

  String FIELD_NAME_IS_ADD_SCORE = "IS_ADD_SCORE";

  String FIELD_NAME_BASE_SCORE = "BASE_SCORE";

  String FIELD_NAME_IS_PRICE_TARGET = "IS_PRICE_TARGET";

  /**
   * 分项评审结果记录代码
   */
  String FIELD_NAME_RESULT_CODE = "RESULT_CODE";

  /**
   * 采购项目代码
   */
  String FIELD_NAME_PROJ_CODE = "PROJ_CODE";

  /**
   * 采购项目名称
   */
  String FIELD_NAME_PROJ_NAME = "PROJ_NAME";

  /**
   * 采购项目标段代码
   */
  String FIELD_NAME_PACK_CODE = "PACK_CODE";

  /**
   * 采购项目标段名称
   */
  String FIELD_NAME_PACK_NAME = "PACK_NAME";

  /**
   * 采购项目标段投标供应商代码
   */
  String FIELD_NAME_PROVIDER_CODE = "PROVIDER_CODE";

  /**
   * 采购项目标段投标供应商名称
   */
  String FIELD_NAME_PROVIDER_NAME = "PROVIDER_NAME";

  /**
   * 指标项代码
   */
  String FIELD_NAME_ITEM_CODE = "ITEM_CODE";

  /**
   * 指标项代码
   */
  String FIELD_NAME_ITEM_NAME = "ITEM_NAME";

  /**
   * 指标项索引序号
   */
  String FIELD_NAME_INDX = "INDX";

  /**
   *评审专家 
   */
  String FIELD_NAME_EVAL_EXPERT = "EXPERT_NAME";

  String FIELD_NAME_EVAL_EXPERT_1 = "EVAL_EXPERT";

  /**
   * 评审专家代码
   */
  String FIELD_NAME_EVAL_EXPERT_CODE = "EVAL_EXPERT_CODE";

  /**
   * 评审日期 
   */
  String FIELD_NAME_EVAL_DATE = "EVAL_DATE";

  /**
   * 符合性指标项评审结果 
   */
  String FIELD_NAME_COMPLIANCE_EVAL_VALUE = "COMPLIANCE_EVAL_VALUE";

  /**
   * 符合性指标项评审不通过原因
   */
  String FIELD_NAME_COMPLIANCE_UNPASS_REASON = "COMPLIANCE_UNPASS_REASON";

  /**
   * 评分性指标专家平评审值 
   */
  String FIELD_NAME_EXPERT_EVAL_SCORE = "EXPERT_EVAL_SCORE";

  /**
   * 调整得分
   */
  String FIELD_NAME_ADJUST_SCORE = "ADJUST_SCORE";

  /**
   * 调整得分原因
   */
  String FIELD_NAME_ADJUST_REASON = "ADJUST_REASON";

  /**
   * 最终供应商评审结果:1,废标;2,未中标；3,中标候选人;4,中标人
   */
  String FIELD_NAME_EVAL_RESULT = "EVAL_RESULT";

  /**
   *备注
   */
  String FIELD_NAME_REMARK = "REMARK";

  /**
   *指标描述
   */
  String FIELD_NAME_DESCRIPTION = "DESCRIPTION";

  /**
   * 分项评审结果记录代码
   */
  String PROPERTY_NAME_RESULT_CODE = "resultCode";

  /**
   * 采购项目代码
   */
  String PROPERTY_NAME_PROJ_CODE = "projCode";

  /**
   * 采购项目名称
   */
  String PROPERTY_NAME_PROJ_NAME = "projName";

  /**
   * 采购项目标段代码
   */
  String PROPERTY_NAME_PACK_CODE = "packCode";

  /**
   * 采购项目标段名称
   */
  String PROPERTY_NAME_PACK_NAME = "packName";

  /**
   * 采购项目标段投标供应商代码
   */
  String PROPERTY_NAME_PROVIDER_CODE = "providerCode";

  /**
   * 采购项目标段投标供应商名称
   */
  String PROPERTY_NAME_PROVIDER_NAME = "providerName";

  /**
   * 指标项代码
   */
  String PROPERTY_NAME_ITEM_CODE = "itemCode";

  /**
   * 指标项名称
   */
  String PROPERTY_NAME_ITEM_NAME = "itemName";

  /**
   * 指标项索引序号
   */
  String PROPERTY_NAME_INDX = "indx";

  /**
   *评审专家 
   */
  String PROPERTY_NAME_EVAL_EXPERT = "expertName";

  String PROPERTY_NAME_EVAL_EXPERT_1 = "evalExpert";

  /**
   * 评审专家代码
   */
  String PROPERTY_NAME_EVAL_EXPERT_CODE = "evalExpertCode";

  /**
   * 评审日期 
   */
  String PROPERTY_NAME_EVAL_DATE = "evalDate";

  /**
   * 符合性指标项评审结果 
   */
  String PROPERTY_NAME_COMPLIANCE_EVAL_VALUE = "complianceEvalValue";

  /**
   * 符合性指标项评审不通过原因
   */
  String PROPERTY_NAME_COMPLIANCE_UNPASS_REASON = "complianceUnpassReason";

  /**
   * 评分性指标专家平评审值 
   */
  String PROPERTY_NAME_EXPERT_EVAL_SCORE = "expertEvalScore";

  /**
   * 调整得分
   */
  String PROPERTY_NAME_ADJUST_SCORE = "adjustScore";

  /**
   * 调整得分原因
   */
  String PROPERTY_NAME_ADJUST_REASON = "adjustReason";

  /**
   * 最终供应商评审结果:1,废标;2,未中标；3,中标候选人;4,中标人
   */
  String PROPERTY_NAME_EVAL_RESULT = "evalResult";

  /**
   *备注
   */
  String PROPERTY_NAME_REMARK = "remark";

  /**
   *指标描述
   */
  String PROPERTY_NAME_DESCRIPTION = "description";

  String PROPERTY_NAME_STANDARD_SCORE = "standardScore";

  String PROPERTY_NAME_MAX_MINUS_SCORE = "maxMinusScore";

  String PROPERTY_NAME_MAX_ADD_SCORE = "maxAddScore";

  String PROPERTY_NAME_IS_ADD_SCORE = "isAddScore";

  String PROPERTY_NAME_BASE_SCORE = "baseScore";

  String PROPERTY_NAME_IS_PRICE_TARGET = "isPriceTarget";

  String PROPERTY_NAME_PARAM_CODE = "paramCode";

  String PROPERTY_NAME_PARAM_NAME = "paramName";

  String PROPERTY_NAME_DEFAULT_VALUE = "defaultValue";

  String PROPERTY_NAME_VALUE = "value";

  String PROPERTY_NAME_EVAL_SCORE = "evalScore";

  String PROPERTY_NAME_PROVIDER_TOTAL_PRICE = "providerTotalPrice";

  String PROPERTY_NAME_FORMULA = "formula";

  //符合性评标添加采购中心初审结果

  String ZHONGXIN_AUDIT_VALUE = "auditValue";

  String FIELD_NAME_ZHONGXIN_AUDIT_VALUE = "AUDIT_VALUE";

  String ZHONGXIN_AUDIT_NO_PASS_REASON = "noPassReason";

  String FIELD_NAME_ZHONGXIN_AUDIT_NO_PASS_REASON = "NO_PASS_REASON";

  String PROPERTY_NAME_FORMULA_ITEM_REMARK = "formulaItemRemark";

  String FIELD_NAME_FORMULA_ITEM_REMARK = "FORMULA_ITEM_REMARK";

}
