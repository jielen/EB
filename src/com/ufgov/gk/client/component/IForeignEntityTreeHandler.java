/**
 * IForeignEntityTreeHandler.java
 * com.ufgov.gk.common.zc.foreignentity
 * Administrator
 * 2010-5-6
 */
package com.ufgov.gk.client.component;

import java.util.List;

import javax.swing.table.TableModel;
import javax.swing.tree.TreeModel;

/**
 * �����ⲿ����ѡ�������ҵ����ӿ�,
 * @author Administrator
 *
 */
public interface IForeignEntityTreeHandler {
  /**
   * ҵ����ӿ�
   * @param selectedDatas �ⲿ����ѡ��ʱ���صĽ����list�����е����ݶ�����
   * ��ʾ�ⲿ������sql�������ݶ��󣬺�sqlmap�е�Ҫһ�£����򽫲��ܴ���.
   * Administrator
   * 2010-4-30
   */
    void excute(List selectedDatas);
    
    /**
     * �Ƿ����ѡ���������
     * @return
     * Administrator
     * 2010-4-30
     */
    boolean isMultipleSelect();
    /**
     * �Ƿ�ֻ��ѡ��ĩ��Ҷ��
     * @return
     * Administrator
     * 2010-5-6
     */
    boolean isSelectLeaf();
}
