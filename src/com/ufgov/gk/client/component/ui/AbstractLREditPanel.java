package com.ufgov.gk.client.component.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import com.ufgov.gk.client.component.JSaveableSplitPane;

import com.ufgov.gk.client.common.UIConstants;
import com.ufgov.gk.client.component.JFuncToolBar;

public abstract class AbstractLREditPanel extends JPanel{
  /**
   * 
   */
  private static final long serialVersionUID = 617096549489932050L;

  
  private JFuncToolBar toolBar = new JFuncToolBar();

  private JSaveableSplitPane splitPane = new JSaveableSplitPane(JSaveableSplitPane.HORIZONTAL_SPLIT);
   
  protected AbstractDataDisplay leftComponent;
 
  protected AbstractFieldsEditPanel rightComponent;

  protected void init(AbstractDataDisplay leftComponent, AbstractFieldsEditPanel rightComponent) {
    
    this.leftComponent = leftComponent;
    this.rightComponent = rightComponent;
    setLayout(new BorderLayout());
    
    initToolBarComponent(toolBar);
    
    add(toolBar, BorderLayout.NORTH);
    
    splitPane.setResizeWeight(1);
    splitPane.setOneTouchExpandable(true);
    splitPane.setDividerSize(11);

    splitPane.setDividerDefaultLocation(this.getClass().getName()+"_splitPane_dividerLocation",(int)(UIConstants.SCREEN_WIDTH*0.55));

    if(leftComponent!=null){
      leftComponent.getTabbedPane().setMinimumSize(new Dimension(0,0));
    }
    if(rightComponent!=null){
      rightComponent.setMinimumSize(new Dimension(0,0));
    }
    leftComponent.removeAll();
    
    splitPane.setLeftComponent(leftComponent.getTabbedPane());
    splitPane.setRightComponent(rightComponent);
    splitPane.setBorder( BorderFactory.createEtchedBorder());
    
    leftComponent.setLayout( new BorderLayout());
    leftComponent.add(leftComponent.getConditionArea(),BorderLayout.NORTH);
    leftComponent.add(splitPane,BorderLayout.CENTER);
    
    add(leftComponent,BorderLayout.CENTER);
  }

  /**
   * ���ӹ�������ť
   */
  protected abstract void initToolBarComponent(JFuncToolBar toolBar);

}
