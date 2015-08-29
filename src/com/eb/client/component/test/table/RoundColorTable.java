package com.eb.client.component.test.table;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class RoundColorTable extends JFrame {
  private String[] colname = { "第1列", "第2列", "第3列", "第4列", "第5列" }; //表头信息 

  private String[][] data = new String[10][5]; //表内容 

  //界面组件----------------------// 
  private JScrollPane scroPanel = new JScrollPane(); //中底层滚动面板 

  private DefaultTableModel model; //列表默认TableModel 

  private JTable table;

  int r = 0, c = 1;//      用于控制变色区域

  /** 
   * 构造方法 SelectionDemo() 
   */
  public RoundColorTable() {
    makeFace();
    addListener();
    showFace();
  }

  /** 
   * 方法: 界面构建 makeFace() 
   */
  private void makeFace() {

    //表内容数组 data[][] 赋值------------// 
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 5; j++) {
        data[i][j] = "( " + (j + 1) + ", " + (i + 1) + " )";
      }
    }

    table = new JTable(model = new DefaultTableModel(data, colname));
    table.setEnabled(true);

    //新建列表现器------------------------// 
    DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
      public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (row == r && column == c && cell.isBackgroundSet()) //设置变色的单元格
          cell.setBackground(Color.GRAY);
        return cell;
      }
    };
    //设置列表现器------------------------// 
    for (int i = 0; i < colname.length; i++) {
      table.getColumn(colname[i]).setCellRenderer(tcr);
    }

    scroPanel.getViewport().setBackground(Color.white);
    scroPanel.getViewport().add(table);

    //总体界面布局------------------------// 
    getContentPane().add(scroPanel, BorderLayout.CENTER);
  }

  /** 
   * 方法: 界面显示 showFace() 
   */
  private void showFace() {
    setSize(500, 400);
    Toolkit tmpTK = Toolkit.getDefaultToolkit();
    Dimension dime = tmpTK.getScreenSize();

    setLocation(200, 300);
    setVisible(true);
    //show(); 
  }

  /** 
   * 方法: 添加事件监听 addListener() 
   */
  private void addListener() {
    this.addWindowListener(new WindowAdapter() { //添加窗口关闭事件 
        public void windowClosing(WindowEvent e) {
          setVisible(false);
          dispose();
          System.exit(0);
        }
      });
  }

  /** 
   * 程序入口 main() 
   */
  public static void main(String args[]) {
    //获取设置系统风格-------------------// 
    try {
      String laf = UIManager.getSystemLookAndFeelClassName();
      UIManager.setLookAndFeel(laf);
    } catch (Exception e) {
    }

    new RoundColorTable();
  }
}
