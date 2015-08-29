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
 * <p>Description: �����˱���Ϊ���б��Ƶ��ݵ��б�ҳ��Ļ���</p>
 * <p>Copyright: Copyright 2009 ufgov, Inc.</p>
 * <p>Company: ufgov</p>
 * <p>����ʱ��: 2009-4-20</p>
 * @author ����ΰ(manlge)
 * @version 1.0
 */
public abstract class AbstractAuditListBill extends JComponent {
  /**
   * ����������
   */
  private JFuncToolBar toolBar = new JFuncToolBar();

  /**
   * ��ʾ�ϡ���ҳǩ�ķָ����
   */
  protected JSaveableSplitPane splitVsPane = new JSaveableSplitPane(JSaveableSplitPane.VERTICAL_SPLIT);//���·ָ�

  /**
   * ��ʾ����ҳǩ�ķָ����
   */
  protected JSaveableSplitPane splitHsPane = new JSaveableSplitPane(JSaveableSplitPane.HORIZONTAL_SPLIT);//���ҷָ�

  /**
   * �������չʾ��
   */
  protected JComponent leftComponent; //�������չʾ��;

  /**
   * ��������չʾ��
   */
  protected AbstractDataDisplay topDataDisplay;//���Ϸ�����չʾ��

  /**
   * ��������չʾ��
   */
  protected AbstractDataDisplay bottomDataDisplay;//���·�����չʾ��

  private boolean isShowLeftPanel = "0".equals(AsOptionMeta
    .getOptVal(BusinessOptionConstants.OPT_IS_SHOW_LEFT_COMPANY)) ? true : false;

  public AbstractAuditListBill() {
  }

  /**
   * @param topDataDisplay ��ʾ�������DataDisplay
   * @param bottomDataDisplay ��ʾ�������DataDisplay
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
   * ��ӹ�������ť
   */
  protected abstract void addToolBarComponent(JFuncToolBar toolBar);

}
