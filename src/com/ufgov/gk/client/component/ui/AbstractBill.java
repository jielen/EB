
package com.ufgov.gk.client.component.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JComponent;
import com.ufgov.gk.client.component.JSaveableSplitPane;
import javax.swing.JToolBar;

/**
 * <p>Title: GK</p>
 * <p>Description: �����˱���Ϊ���б��Ƶ��ݵ��б�ҳ��Ļ���</p>
 * <p>Copyright: Copyright 2009 ufgov, Inc.</p>
 * <p>Company: ufgov</p>
 * <p>����ʱ��: 2009-4-20</p>
 * @author ����ΰ(manlge)
 * @version 1.0
 */
public abstract class AbstractBill extends JComponent {
  /**
   * ����������
   */
  private JToolBar toolBar = new JToolBar();

  /**
   * ��ʾ�ϡ���ҳǩ�ķָ����
   */
  private JSaveableSplitPane splitPane = new JSaveableSplitPane(JSaveableSplitPane.VERTICAL_SPLIT);

  /**
   * ��������չʾ��
   */
  private AbstractDataDisplay topDataDisplay;

  /**
   * ��������չʾ��
   */
  private AbstractDataDisplay bottomDataDisplay;

  /**
   * @param topDataDisplay ��ʾ�������DataDisplay
   * @param bottomDataDisplay ��ʾ�������DataDisplay
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
   * ��ӹ�������ť
   */
  protected abstract void addToolBarComponent(JToolBar toolBar);

}
