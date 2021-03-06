package com.ufgov.gk.client.component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import com.ufgov.gk.client.component.event.ValueChangeEvent;
import com.ufgov.gk.client.component.event.ValueChangeListener;
import com.ufgov.smartclient.plaf.BigButtonSplitPaneUI;

public class SelectFileTxtField extends JTextField {

  private static final long serialVersionUID = -5110185192763557910L;

  private JButton button = new JButton("ѡ��");

  private JFileChooser fileChooser;

  public SelectFileTxtField(int columns) {
    super(columns);
    initUI();
  }

  private void initUI() {
    this.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
    button.setBorderPainted(false);
    button.setPreferredSize(new Dimension(18, 15));
    button.setFocusable(false);
    super.setEditable(false);
    setBackground(Color.white);
    setPreferredSize(new Dimension(0, 20));

    this.add(button);
    JSeparator separator2 = new JSeparator(SwingConstants.VERTICAL);
    this.add(separator2);

    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        doSelect();
      }
    });


  }

  public JFileChooser getFileChooser(){
      return fileChooser;
  }


  private void doSelect() {

    fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("ѡ���ļ�");
    fileChooser.addChoosableFileFilter(new ExtFileFilter("xls"));
    fileChooser.setAcceptAllFileFilterUsed(false);
    int result = fileChooser.showOpenDialog(this);
    if (result == JFileChooser.APPROVE_OPTION) {
      File file = fileChooser.getSelectedFile();
     this.setText(file.getName());
   }
  }

  public void addValueChangeListener(ValueChangeListener l) {
    this.listenerList.add(ValueChangeListener.class, l);
  }

  public void removeValueChangeListener(ValueChangeListener l) {
    this.listenerList.remove(ValueChangeListener.class, l);
  }

  protected void fireValueChanged() {
    ValueChangeEvent e = null;
    ValueChangeListener[] listeners = listenerList
      .getListeners(ValueChangeListener.class);
    for (ValueChangeListener l : listeners) {
      if (e == null) {
        e = new ValueChangeEvent(this);
      }
      l.valueChanged(e);
    }
  }



  public static void main(String[] args) {

        SelectFileTxtField fileField = new SelectFileTxtField(20);
        UIManager.getDefaults().put("SplitPaneUI", BigButtonSplitPaneUI.class.getName());
        JFrame frame = new JFrame("frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout( new FlowLayout());
        frame.getContentPane().add(fileField);

        frame.setVisible(true);

  }

}
