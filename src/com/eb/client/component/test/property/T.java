package com.eb.client.component.test.property;

import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class T extends JFrame {
  private static final long serialVersionUID = 1L;

  private JPanel jContentPane = null;

  private JProgressBar jProgressBar = null;

  private JProgressBar getJProgressBar() {
    if (jProgressBar == null) {
      jProgressBar = new JProgressBar();
      jProgressBar.setBounds(new Rectangle(47, 94, 201, 19));
      jProgressBar.addPropertyChangeListener("name", new java.beans.PropertyChangeListener() {
        public void propertyChange(java.beans.PropertyChangeEvent e) {
          System.out.println("asd:" + e.getPropertyName() + e.getNewValue());
        }
      });
      jProgressBar.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent e) {
          jProgressBar.setName("asdf=" + e.getPoint().toString());
        }
      });
    }
    return jProgressBar;
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        T thisClass = new T();
        thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        thisClass.setVisible(true);
      }
    });
  }

  public T() {
    super();
    initialize();
  }

  private void initialize() {
    this.setSize(300, 200);
    this.setContentPane(getJContentPane());
    this.setTitle("JFrame");
  }

  private JPanel getJContentPane() {
    if (jContentPane == null) {
      jContentPane = new JPanel();
      jContentPane.setLayout(null);
      jContentPane.add(getJProgressBar(), null);
    }
    return jContentPane;
  }
}
