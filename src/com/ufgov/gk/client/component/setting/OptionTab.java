package com.ufgov.gk.client.component.setting;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.apache.log4j.Logger;

public abstract class OptionTab extends JPanel {
  /**
  * Logger for this class
  */
  private static final Logger logger = Logger.getLogger(OptionTab.class);
  
  private static final long serialVersionUID = 1L;

  private String tabId;

  private String tabName;

  private List<AbstractOption> optionList = new ArrayList<AbstractOption>();

  public OptionTab() {

  }

  public OptionTab(String tabId, String tabName, List<AbstractOption> optionListP) {

    this.init(tabId, tabName, optionListP);
  }

  protected void init(String tabId, String tabName, List<AbstractOption> optionListP) {

    this.tabId=tabId;
    
    this.tabName=tabName;
    
    optionList = optionListP;

    JPanel optionPanel = new JPanel();

    GridBagLayout gblBasic = new GridBagLayout();
    optionPanel.setLayout(gblBasic);

    int gridx, gridy, gridwidth, gridheight, anchor, fill, ipadx, ipady;
    double weightx, weighty;
    Insets inset;

    gridwidth = 1;
    gridheight = 1;
    weightx = 1;
    weighty = 1;
    ipadx = 0;
    ipady = 0;
    fill = GridBagConstraints.NONE;
    inset = new Insets(2, 2, 2, 2);

    for (int i = 0; i < this.optionList.size(); i++) {
      AbstractOption ao = optionList.get(i);

      gridx = 0;
      gridy = i;
      anchor = GridBagConstraints.EAST;
      fill = GridBagConstraints.NONE;
      gblBasic.setConstraints(ao.getOptNameLabel(), new GridBagConstraints(gridx,
        gridy, gridwidth, gridheight, weightx, weighty, anchor, fill, inset, ipadx,
        ipady));
      optionPanel.add(ao.getOptNameLabel());

      gridx = 1;
      gridy = i;

      anchor = GridBagConstraints.WEST;
      fill = GridBagConstraints.HORIZONTAL;
      gblBasic.setConstraints(ao.getOptionEditor(), new GridBagConstraints(gridx,
        gridy, gridwidth, gridheight, weightx, weighty, anchor, fill, inset, ipadx,
        ipady));
      optionPanel.add(ao.getOptionEditor());
    }

    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT,1,1));
    JButton okButton = new JButton("确定");
    JButton cancelButton = new JButton("取消");
    JButton applyButton = new JButton("应用");
    
    okButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        doOk();
      }
    });
    
    applyButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        doApply();
      }
    });
    
    cancelButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        doCancel();
      }
    });

    buttonPanel.add(okButton);
    buttonPanel.add(cancelButton);
    buttonPanel.add(applyButton);
  
    JPanel panel = new JPanel();
    panel.add(optionPanel);
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.getViewport().add(panel);
    
    this.setLayout(new BorderLayout());
    this.add(scrollPane, BorderLayout.CENTER);
    this.add(buttonPanel, BorderLayout.SOUTH);
  }

  public String getTabId() {
    return tabId;
  }
  public String getTabName() {
    return tabName;
  }
  public List<AbstractOption> getOptionList() {
    return optionList;
  }
  
  protected void doOk(){
    doApply();
    doCancel();
  }
  
  protected void doApply(){
    StringBuffer errorInfo=new StringBuffer("");
    boolean success=true;
    for(AbstractOption o:optionList){
      
      try{
        o.updateOption();
      }catch(Exception e){
        success=false;
        logger.error(e.getMessage(), e);
        errorInfo.append(o.getOptName()+",");
      }
      
    }
    if(!success){
      String temp=errorInfo.substring(0,errorInfo.lastIndexOf(","))+"更新失败";
      JOptionPane.showMessageDialog(this, temp, "错误", JOptionPane.ERROR_MESSAGE);
    }else{
      JOptionPane.showMessageDialog(this, "更新成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
    }
    
  }
  
  protected abstract void doCancel();
  
}
