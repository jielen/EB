package com.ufgov.gk.client.component.ui.conditionitem;

/**
 * <p>
 * Title: GK53
 * </p>
 * <p>
 * Description: ���������������࣬������������������
 * </p>
 * <p>
 * Copyright: Copyright 2009 ufgov, Inc.
 * </p>
 * <p>
 * Company: ufgov
 * </p>
 * <p>
 * ����ʱ��: 2009-4-23
 * </p>
 *
 * @author ����ΰ(manlge)
 * @version 1.0
 */
public class SearchConditionItemFactory {
  private SearchConditionItemFactory() {
    // ��׼ʵ��
  }

  /**
   * 2009-5-25 by longrm ֱ��ȡ��ma_search_condition�����Ʒ���
   *
   * @param id
   *            �ֶδ��� CONDITION_FIELD_CODE
   * @param name
   *            �ֶ����� CONDITION_FIELD_NAME
   * @param type
   * @param defaultValue
   * @return
   */

  public static AbstractSearchConditionItem createSearchConditionItem(Object id, String name, Object type, Object defaultValue) {
    return createSearchConditionItem(id, name, type, defaultValue, null);
  }

  public static AbstractSearchConditionItem createSearchConditionItem(Object id, String name, Object type, Object defaultValue, String numLimCompoId) {
    if (id == null) {
      throw new IllegalArgumentException("id����Ϊ��");
    } else if (id.equals(ConditionFieldConstants.TEXT_0)) {
      return new TextConditionItem(name, "zcText0");
    }

    throw new IllegalArgumentException("��Ч��id :" + id);
  }
}
