package com.ufgov.gk.client.component;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.ufgov.smartclient.component.JComboBoxEx;

public class ExportStatusComboBox extends JComboBoxEx {

  private static final long serialVersionUID = 6607767220408963818L;

  private Map<String, String> dataMap = new HashMap<String, String>();
  {
    dataMap.put("ALL", "全部");
    dataMap.put("Y", "已导出");
    dataMap.put("N", "未导出");
  }

  private List<String> dataList = new ArrayList<String>();
  {
    dataList.add("ALL");
    dataList.add("Y");
    dataList.add("N");
  }

  public ExportStatusComboBox() {
    this.init();
  }

  public void init() {
    Iterator<String> it = dataList.iterator();
    while (it.hasNext()) {
      String key = it.next();
      this.addItem(key);
      this.addItemDisplaLable(key, dataMap.get(key));
    }
  }

  public static void main(String[] args) {
    JFrame f = new JFrame();
    final ExportStatusComboBox textField = new ExportStatusComboBox();
    textField.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        System.out.println(textField.getSelectedItem());
      }

    });
    JPanel panel = new JPanel();
    panel.add(textField);
    f.getContentPane().add(panel, BorderLayout.NORTH);
    f.setSize(400, 300);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
    f.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }
}
