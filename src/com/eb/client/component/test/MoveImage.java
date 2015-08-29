/**
 * MoveImage.java
 * com.eb.client.component.test
 * Administrator
 * Jul 21, 2012
 */
package com.eb.client.component.test;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author Administrator
 *
 */
public class MoveImage {
  private static int start_X, start_Y, end_X, end_Y;

  private static ImageIcon icon = null;

  public static void main(String[] args) {
    MoveImage img = new MoveImage();
    img.test();
  }

  private void test() {
    // TODO Auto-generated method stub

    try {
      icon = new ImageIcon(ImageIO.read(this.getClass().getResource("/img/testImage.jpg")));
      JLabel label = new JLabel(icon);
      label.setSize(icon.getIconWidth(), icon.getIconHeight());
      label.setBorder(BorderFactory.createLineBorder(Color.RED));
      label.addMouseListener(new MouseAdapter() {
        public void mousePressed(MouseEvent e) {
          start_X = e.getX();
          start_Y = e.getY();
        }
      });
      label.addMouseMotionListener(new MouseAdapter() {
        public void mouseDragged(MouseEvent e) {
          JLabel l = (JLabel) e.getSource();
          end_X = l.getX() + e.getX() - start_X;
          end_Y = l.getY() + e.getY() - start_Y;
          l.setLocation(end_X, end_Y);
        }
      });
      label.addMouseWheelListener(new MouseWheelListener() {

        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
          // TODO Auto-generated method stub
          int num = e.getWheelRotation();//正数表示向下旋转，负数表示向上旋转，绝对值表示转动单位
          JLabel l = (JLabel) e.getSource();
          int width = l.getWidth() - 20 * num;
          int height = l.getHeight() - 20 * num;
          l.setIcon(new ImageIcon(icon.getImage().getScaledInstance(width, height, Image.SCALE_FAST)));
          l.setBounds(end_X, end_Y, width, height);
        }
      });
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);//必须设置成null;
      frame.getContentPane().add(label);
      frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
      frame.setVisible(true);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
