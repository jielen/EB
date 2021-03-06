package com.ufgov.gk.client.component.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MessageBoard extends JDialog implements ActionListener {
  private JEditorPane editorPanel;
  private JPanel bottomPanel;

  public MessageBoard(Component parent, String title, String message, boolean modal) {
    super(JOptionPane.getRootFrame(), title, modal);
    init(message);
  }

  public void showMe() {
    this.setLocationRelativeTo(null);
    this.setAlwaysOnTop(true);
    this.setVisible(true);
  }

  private void init(String mess) {
    this.setLayout(new BorderLayout());
    editorPanel = new JEditorPane();
    editorPanel.setText(mess);
    this.add(new JScrollPane(editorPanel), BorderLayout.CENTER);
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  }

  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    this.dispose();
  }

}
