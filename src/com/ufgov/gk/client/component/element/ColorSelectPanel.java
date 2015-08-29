package com.ufgov.gk.client.component.element;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ColorSelectPanel extends JPanel {

  private static final long serialVersionUID = -2390637689044126845L;

  private JLabel label = new JLabel("                  ");

  private int value = -20561;

  private JButton button = new JButton(" ") {
    private static final long serialVersionUID = -7456400999981871987L;
    {
      this.setCursor(Cursor.getDefaultCursor());
      this.setFocusable(false);
    }

    public Insets getInsets() {
      return new Insets(0, 0, 0, 0);
    }

    public Dimension getPreferredSize() {
      Dimension size = new Dimension(18, 18);
      //     size.height -= 6;
      //     size.width = size.height;
      return size;
    }

    public void paint(Graphics g) {
      super.paint(g);
      int width = 3;
      int height = 3;

      Rectangle rect = g.getClipBounds();
      int x = rect.width / 4;
      int y = rect.height / 2;

      for (int i = 0; i < 3;) {
        g.fillOval(++i * x, y, width, height);
      }
    }

  };

  Color color = null;

  public ColorSelectPanel(String color) {
    if(color != null && !color.equals("")){
      this.value = Integer.parseInt(color);
    }
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        doSelect();
      }
    });
    label.setOpaque(true);
    label.setSize(10, 5);
    label.setBackground(new Color(value));
    this.setLayout(new FlowLayout(FlowLayout.LEFT));
    this.add(label);
    this.add(button);
  }

  private void doSelect() {
    color = JColorChooser.showDialog(this, "", new Color(value));
    if (color != null) {
      label.setBackground(new Color(color.getRGB()));
      value = color.getRGB();
    }
  }

  public static void main(String[] args) {

    JFrame f = new JFrame();
    f.getContentPane().add(new ColorSelectPanel("-20561"));
    f.setSize(400, 300);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
    f.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

  }

  public String getColor() {
    return Integer.toString(value);
  }

  public void setColor(String color) {
    label.setBackground(new Color(Integer.parseInt(color)));
  }

}