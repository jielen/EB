package com.ufgov.gk.client.component;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

public class JPopupMenuEx extends JPopupMenu {
  /**
   * 
   */
  private static final long serialVersionUID = 2805893148384477277L;

  JPopupMenu self = this;

  private int mousex;

  private int mousey;

  public int getMousex() {
    return mousex;
  }

  public void setMousex(int mousex) {
    this.mousex = mousex;
  }

  public int getMousey() {
    return mousey;
  }

  public void setMousey(int mousey) {
    this.mousey = mousey;
  }

  public JPopupMenuEx() {
    super();
  }

  public JPopupMenuEx(String label) {
    super(label);
  }

  public JPopupMenuEx(Component trigger) {
    this();
    setTrigger(trigger);
  }

  public void setTrigger(Component trigger) {
    trigger.addMouseListener(new PopupListener());
  }

  protected void maybeShowPopup(MouseEvent e) {
    JPopupMenuEx menu = (JPopupMenuEx)self;
    if (e.isPopupTrigger()) {
      menu.setMousex(e.getX());
      menu.setMousey(e.getY());
      menu.show(e.getComponent(), e.getX(), e.getY());
    }
  }

  class PopupListener extends MouseAdapter {

    public void mouseClicked(MouseEvent e) {
      //      if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 2) {
      //        self.show(e.getComponent(), e.getX(), e.getY());
      //      }
    }

    public void mousePressed(MouseEvent e) {
      maybeShowPopup(e);
    }

    public void mouseReleased(MouseEvent e) {
      maybeShowPopup(e);
    }

  }

  public static void main(String[] args) {
    JToolBar toolBar = new JToolBar();
    JFrame f = new JFrame("");
    Container contentPane = f.getContentPane();
    JTextArea jta = new JTextArea(20, 29);
    contentPane.add(jta, BorderLayout.CENTER);
    f.setSize(300, 200);
    f.setVisible(true);

    JPopupMenuEx jp = new JPopupMenuEx(jta);
    jp.add(new JMenuItem("ddd"));
    ;

    f.addWindowListener(new WindowAdapter() {
      public void WindowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }

}