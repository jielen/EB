package com.ufgov.gk.client.component.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JPanel;
import com.ufgov.gk.client.component.JSaveableSplitPane;

import com.ufgov.gk.client.common.AsOptionMeta;
import com.ufgov.gk.client.component.JFuncToolBar;
import com.ufgov.gk.common.system.constants.BusinessOptionConstants;

/**
 * <p>Title: GK</p>
 * <p>Description: 抽象账表，作为所有编制单据的列表页面的基类</p>
 * <p>Copyright: Copyright 2009 ufgov, Inc.</p>
 * <p>Company: ufgov</p>
 * <p>创建时间: 2009-4-20</p>
 * @author 刘永伟(manlge)
 * @version 1.0
 */
public abstract class AbstractAuditListBill extends JComponent {
  /**
   * 顶部工具栏
   */
  private JFuncToolBar toolBar = new JFuncToolBar();

  /**
   * 显示上、下页签的分隔组件
   */
  protected JSaveableSplitPane splitVsPane = new JSaveableSplitPane(JSaveableSplitPane.VERTICAL_SPLIT);//上下分隔

  /**
   * 显示左右页签的分隔组件
   */
  protected JSaveableSplitPane splitHsPane = new JSaveableSplitPane(JSaveableSplitPane.HORIZONTAL_SPLIT);//左右分隔

  /**
   * 左边数据展示区
   */
  protected JComponent leftComponent; //左边数据展示区;

  /**
   * 顶部数据展示区
   */
  protected AbstractDataDisplay topDataDisplay;//右上方数据展示区

  /**
   * 下面数据展示区
   */
  protected AbstractDataDisplay bottomDataDisplay;//右下方数据展示区

  private boolean isShowLeftPanel = "0".equals(AsOptionMeta
    .getOptVal(BusinessOptionConstants.OPT_IS_SHOW_LEFT_COMPANY)) ? true : false;

  public AbstractAuditListBill() {
  }

  /**
   * @param topDataDisplay 显示在上面的DataDisplay
   * @param bottomDataDisplay 显示在下面的DataDisplay
   */
  protected void init(JComponent leftTreePanel, AbstractDataDisplay topDataDisplay,
    AbstractDataDisplay bottomDataDisplay) {
    this.leftComponent = leftTreePanel;
    this.topDataDisplay = topDataDisplay;
    this.bottomDataDisplay = bottomDataDisplay;
    setLayout(new BorderLayout());
    addToolBarComponent(toolBar);
    splitVsPane.setDividerDefaultLocation(this.getClass().getName() + "_VS_splitPane_dividerLocation", 380);
    splitVsPane.setOneTouchExpandable(true);
    JPanel dataDisplayPane = new JPanel(new BorderLayout());
    dataDisplayPane.add(toolBar, BorderLayout.NORTH);
    dataDisplayPane.add(topDataDisplay, BorderLayout.CENTER);
    splitVsPane.setDividerSize(8);

    dataDisplayPane.setMinimumSize(new Dimension(0, 0));
    if (bottomDataDisplay != null) {
      bottomDataDisplay.setMinimumSize(new Dimension(0, 0));
    }
    splitVsPane.setLeftComponent(dataDisplayPane);
    splitVsPane.setRightComponent(bottomDataDisplay);
    if (topDataDisplay == null || bottomDataDisplay == null) {
      splitVsPane.setDividerSize(0);
    }
    splitVsPane.setMinimumSize(new Dimension(0, 0));
    if (isShowLeftPanel) {
      splitHsPane.setDividerLocation(0);
    } else {
      splitHsPane.setDividerDefaultLocation(this.getClass().getName() + "_HS_splitPane_dividerLocation", 0.2);
    }
    splitHsPane.setOneTouchExpandable(true);
    splitHsPane.setDividerSize(8);
    if (leftTreePanel != null) {
      leftTreePanel.setMinimumSize(new Dimension(0, 0));
      if (!leftTreePanel.isVisible()) {
        splitHsPane.setDividerSize(0);
      }
    } else {
      splitHsPane.setDividerSize(0);
    }
    splitHsPane.setLeftComponent(leftTreePanel);
    splitHsPane.setRightComponent(splitVsPane);
    if (topDataDisplay == null || splitVsPane == null) {
      splitHsPane.setDividerSize(0);
    }
    add(splitHsPane);
  }

  /**
   * 添加工具栏按钮
   */
  protected abstract void addToolBarComponent(JFuncToolBar toolBar);

}
