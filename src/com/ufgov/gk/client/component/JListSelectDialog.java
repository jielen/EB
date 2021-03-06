package com.ufgov.gk.client.component;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.ufgov.smartclient.component.JClassifyList;

public abstract class JListSelectDialog extends GkBaseDialog{
  
  JClassifyList classifyList = new JClassifyList();
  private List leftDataList=new ArrayList();
  private List rightDataList=new ArrayList();
  protected JPanel bottomPanel = new JPanel();

  protected JButton okButton = new JButton("确定");

  public JListSelectDialog(Dialog dialog ,boolean modal,String title){
    super(dialog,modal);
    this.setTitle(title);
    this.setSize(360,260);
    this.moveToScreenCenter();
    initGUI();
  }
  
  private void initGUI(){
    Container contentPane = this.getContentPane();
    contentPane.setLayout(new BorderLayout());
    bottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    bottomPanel.add(okButton);
    okButton.addActionListener(new ActionListener(){

      public void actionPerformed(ActionEvent e) {
        doOk();
      }
      
    });
    contentPane.add(classifyList,BorderLayout.CENTER);
    contentPane.add(bottomPanel,BorderLayout.SOUTH);
  }
  
  public void setLeftList(List leftList){
   this.leftDataList=leftList;
   updateGUI();
  }
  
  public void setRightList(List rightList){
    this.rightDataList=rightList;
    updateGUI();
  }
  
  private void updateGUI(){
    List<Object> tempList = new ArrayList<Object>();
    for(Object o:leftDataList){
      if(!rightDataList.contains(o)){
        tempList.add(o);
      }
    }
    classifyList.setLeftObjects(tempList.toArray());
    classifyList.setRightObjects(rightDataList.toArray());
  }
  
  /**
   * 
   * @return 返回已选择项列表
   */
  public List getSelectList(){
    Object[] itemList = classifyList.getRightObjects();
    List tmpList=new ArrayList();
    for(int i=0;i<itemList.length;i++){
      tmpList.add(itemList[i].toString().trim());
    }
    return tmpList;
  }
  
  public List getSelectedItem(){
       return  Arrays.asList(classifyList.getRightObjects());
  }
  
  /**
   * 
   * @return 返回已选择项数组
   */
  public Object[] getSelectArray(){
    List<Object> tmpList=getSelectList();
    return tmpList.toArray(new Object[tmpList.size()]);
  }
  
  
  public void close(){
    this.closeDialog();
  }
  
  public abstract void doOk();
  
  public static void main(String []arg){
    
    JListSelectDialog dlg =new JListSelectDialog(null,false,"test"){

      private static final long serialVersionUID = 1L;

      @Override
      public void doOk() {
       System.out.println(getSelectList());
       close();
      }
      
    };
    dlg.setLeftList(Arrays.asList(new Object[]{"a","b","c"}));
    dlg.setRightList(Arrays.asList(new Object[]{"b","c"}));
    dlg.setVisible(true);
  }
}
