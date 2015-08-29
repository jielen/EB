
package com.ufgov.gk.client.component.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JComponent;
import com.ufgov.gk.client.component.JSaveableSplitPane;
import javax.swing.JToolBar;

/**
 * <p>Title: GK</p>
 * <p>Description: 抽象账表，作为所有编制单据的列表页面的基类</p>
 * <p>Copyright: Copyright 2009 ufgov, Inc.</p>
 * <p>Company: ufgov</p>
 * <p>创建时间: 2009-4-20</p>
 * @author 刘永伟(manlge)
 * @version 1.0
 */
public abstract class AbstractBill extends JComponent {
  /**
   * 顶部工具栏
   */
  private JToolBar toolBar = new JToolBar();

  /**
   * 显示上、下页签的分隔组件
   */
  private JSaveableSplitPane splitPane = new JSaveableSplitPane(JSaveableSplitPane.VERTICAL_SPLIT);

  /**
   * 顶部数据展示区
   */
  private AbstractDataDisplay topDataDisplay;

  /**
   * 下面数据展示区
   */
  private AbstractDataDisplay bottomDataDisplay;

  /**
   * @param topDataDisplay 显示在上面的DataDisplay
   * @param bottomDataDisplay 显示在下面的DataDisplay
   */
  public AbstractBill(AbstractDataDisplay topDataDisplay,
    AbstractDataDisplay bottomDataDisplay) {
    this.topDataDisplay = topDataDisplay;
    this.bottomDataDisplay = bottomDataDisplay;
    addComponent();
  }

  private void addComponent() {
    setLayout(new BorderLayout());
    addToolBarComponent(toolBar);
    add(toolBar, BorderLayout.NORTH);
    splitPane.setDividerDefaultLocation(this.getClass().getName()+"_splitPane_dividerLocation",240);
    splitPane.setOneTouchExpandable(true);
    splitPane.setDividerSize(6); 
    if(topDataDisplay!=null){
      topDataDisplay.setMinimumSize(new Dimension(0,0));
    }
    if(bottomDataDisplay!=null){
      bottomDataDisplay.setMinimumSize(new Dimension(0,0));
    }
    
    splitPane.setLeftComponent(topDataDisplay);
    splitPane.setRightComponent(bottomDataDisplay);
    add(splitPane);
  }

  /**
   * 添加工具栏按钮
   */
  protected abstract void addToolBarComponent(JToolBar toolBar);

}
