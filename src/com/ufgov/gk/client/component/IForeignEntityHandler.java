/**
 * IForeignEntityHandler.java
 * com.ufgov.gk.common.zc.foreignentity
 * Administrator
 * 2010-4-30
 */
package com.ufgov.gk.client.component;

import java.util.List;

import javax.swing.table.TableModel;

/**
 * �����ʽ�ⲿ����ѡ�������ҵ����ӿ�
 * @author Administrator
 *
 */
public interface IForeignEntityHandler {
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
     * ���������ĶԻ�������ʾ��tablemodel
     * @param showDatas ��Ҫ�ڱ����չ�ֵ����ݣ�list�����е����ݶ�����
     * ��ʾ�ⲿ������sql�������ݶ��󣬺�sqlmap�е�Ҫһ�£����򽫲��ܴ���
     * @return
     * Administrator
     * 2010-4-30
     */
    TableModel createTableModel(List showDatas);
}
