package com.ufgov.gk.client.component;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import com.ufgov.gk.client.common.UIConstants;

public class InfoDialog extends GkBaseDialog {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private JTextArea textArea = new JTextArea(8, 70);

  private InfoDialog self = this;

  private JButton okButton;

  private  InfoDialog() {
  }
  
  public static void show(String info,String title){
    InfoDialog  dialog = new InfoDialog();
    dialog.init();
    dialog.setTitle(title);
    dialog.setText(info);
    
    dialog.setModal(true);
    dialog.setSize((int)(UIConstants.SCREEN_WIDTH*0.5), (int)(UIConstants.SCREEN_HEIGHT*0.4));
  
    dialog.moveToScreenCenter();
    dialog.setVisible(true);
  }

  private void init() {

    this.textArea.setEditable(false);
    JPanel p1 = new JPanel();
    p1.setLayout(new GridLayout(1, 1));
    p1.setBorder(BorderFactory.createTitledBorder(""));

    JScrollPane jsp = new JScrollPane(textArea);
    jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
    p1.add(jsp);
    this.getContentPane().setLayout(new BorderLayout());
    this.getContentPane().add(p1, BorderLayout.CENTER);

    JPanel panel_2 = new JPanel();
    okButton = new JButton("ȷ��");
    panel_2.add(okButton);

    this.getContentPane().add(panel_2, BorderLayout.SOUTH);

    okButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        self.dispose();
      }
    });

    addWindowListener(new WindowAdapter() {
      public void windowOpened(WindowEvent e) {
        okButton.requestFocusInWindow();
      }
    });
  }

  private void setText(String text) {
    textArea.setText(text);
  }
}
