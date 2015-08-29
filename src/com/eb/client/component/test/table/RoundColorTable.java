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
  private String[] colname = { "��1��", "��2��", "��3��", "��4��", "��5��" }; //��ͷ��Ϣ 

  private String[][] data = new String[10][5]; //������ 

  //�������----------------------// 
  private JScrollPane scroPanel = new JScrollPane(); //�еײ������� 

  private DefaultTableModel model; //�б�Ĭ��TableModel 

  private JTable table;

  int r = 0, c = 1;//      ���ڿ��Ʊ�ɫ����

  /** 
   * ���췽�� SelectionDemo() 
   */
  public RoundColorTable() {
    makeFace();
    addListener();
    showFace();
  }

  /** 
   * ����: ���湹�� makeFace() 
   */
  private void makeFace() {

    //���������� data[][] ��ֵ------------// 
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 5; j++) {
        data[i][j] = "( " + (j + 1) + ", " + (i + 1) + " )";
      }
    }

    table = new JTable(model = new DefaultTableModel(data, colname));
    table.setEnabled(true);

    //�½��б�����------------------------// 
    DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
      public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (row == r && column == c && cell.isBackgroundSet()) //���ñ�ɫ�ĵ�Ԫ��
          cell.setBackground(Color.GRAY);
        return cell;
      }
    };
    //�����б�����------------------------// 
    for (int i = 0; i < colname.length; i++) {
      table.getColumn(colname[i]).setCellRenderer(tcr);
    }

    scroPanel.getViewport().setBackground(Color.white);
    scroPanel.getViewport().add(table);

    //������沼��------------------------// 
    getContentPane().add(scroPanel, BorderLayout.CENTER);
  }

  /** 
   * ����: ������ʾ showFace() 
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
   * ����: ����¼����� addListener() 
   */
  private void addListener() {
    this.addWindowListener(new WindowAdapter() { //��Ӵ��ڹر��¼� 
        public void windowClosing(WindowEvent e) {
          setVisible(false);
          dispose();
          System.exit(0);
        }
      });
  }

  /** 
   * ������� main() 
   */
  public static void main(String args[]) {
    //��ȡ����ϵͳ���-------------------// 
    try {
      String laf = UIManager.getSystemLookAndFeelClassName();
      UIManager.setLookAndFeel(laf);
    } catch (Exception e) {
    }

    new RoundColorTable();
  }
}
