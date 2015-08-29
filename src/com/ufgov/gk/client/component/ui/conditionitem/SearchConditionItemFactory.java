package com.ufgov.gk.client.component.ui.conditionitem;

/**
 * <p>
 * Title: GK53
 * </p>
 * <p>
 * Description: 搜索条件基工厂类，用来创建搜索条件项
 * </p>
 * <p>
 * Copyright: Copyright 2009 ufgov, Inc.
 * </p>
 * <p>
 * Company: ufgov
 * </p>
 * <p>
 * 创建时间: 2009-4-23
 * </p>
 *
 * @author 刘永伟(manlge)
 * @version 1.0
 */
public class SearchConditionItemFactory {
  private SearchConditionItemFactory() {
    // 不准实化
  }

  /**
   * 2009-5-25 by longrm 直接取表ma_search_condition的名称翻译
   *
   * @param id
   *            字段代码 CONDITION_FIELD_CODE
   * @param name
   *            字段名称 CONDITION_FIELD_NAME
   * @param type
   * @param defaultValue
   * @return
   */

  public static AbstractSearchConditionItem createSearchConditionItem(Object id, String name, Object type, Object defaultValue) {
    return createSearchConditionItem(id, name, type, defaultValue, null);
  }

  public static AbstractSearchConditionItem createSearchConditionItem(Object id, String name, Object type, Object defaultValue, String numLimCompoId) {
    if (id == null) {
      throw new IllegalArgumentException("id不能为空");
    } else if (id.equals(ConditionFieldConstants.TEXT_0)) {
      return new TextConditionItem(name, "zcText0");
    }

    throw new IllegalArgumentException("无效的id :" + id);
  }
}
