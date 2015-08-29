package com.ufgov.gk.client.util;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

public class ListUtil {
  
  /**
   * 
   * @param dataList
   * @param view ���뱣֤��ǰview ����dataList ���ɵ�,view��dataList����Ҫ��֤һ���� 
   * @return
   */
  public static List convertToTableViewOrderList(List dataList,JTable view){
     List viewOrderList = new ArrayList();
     int rowCount=view.getRowCount();
     for(int row=0;row<rowCount;row++){
       viewOrderList.add(dataList.get(view.convertRowIndexToModel(row)));
     }
     return viewOrderList;
  }

}
