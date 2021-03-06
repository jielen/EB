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
 * 树形外部部件选择结果后的业务处理接口,
 * @author Administrator
 *
 */
public interface IForeignEntityTreeHandler {
  /**
   * 业务处理接口
   * @param selectedDatas 外部部件选择时返回的结果，list集合中的数据对象是
   * 显示外部部件的sql语句的数据对象，和sqlmap中的要一致，否则将不能处理.
   * Administrator
   * 2010-4-30
   */
    void excute(List selectedDatas);
    
    /**
     * 是否可以选择多行数据
     * @return
     * Administrator
     * 2010-4-30
     */
    boolean isMultipleSelect();
    /**
     * 是否只能选择末级叶子
     * @return
     * Administrator
     * 2010-5-6
     */
    boolean isSelectLeaf();
}
