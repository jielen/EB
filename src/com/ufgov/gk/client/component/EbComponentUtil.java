package com.ufgov.gk.client.component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import org.apache.log4j.Logger;

public class EbComponentUtil {

  private static Logger log = Logger.getLogger(EbComponentUtil.class);

  public static final Color DEFAULT_TEXT_COLOR = new Color(37, 81, 54);

  public static final Font FONT_14_BOLD = new Font("Calibri", Font.BOLD, 14);

  public static final Font FONT_12_BOLD = new Font("Calibri", Font.BOLD, 12);

  public static final Font FONT_14_PLAIN = new Font("Calibri", Font.PLAIN, 14);

  public static final Font FONT_12_PLAIN = new Font("Calibri", Font.PLAIN, 12);

  private static final String IMAGE_URL_PREFIX = "/img/component/";

  private static final EbComponentUtil ecu = new EbComponentUtil();

  public static final int DEFAULT_BUTTON_SIZE = 20;

  public static final Color BUTTON_ROVER_COLOR = new Color(196, 196, 197);

  public static TexturePaint createTexturePaint(Image image) {
    int imageWidth = image.getWidth(null);
    int imageHeight = image.getHeight(null);
    BufferedImage bi = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2d = bi.createGraphics();
    g2d.drawImage(image, 0, 0, null);
    g2d.dispose();
    return new TexturePaint(bi, new Rectangle(0, 0, imageWidth, imageHeight));
  }

  //  public static String getImageURL(String imageName) {
  //    // TODO Auto-generated method stub
  //    return IMAGE_URL_PREFIX + imageName;
  //  }

  public static ImageIcon getImageIcon(String imageName) {
    // TODO Auto-generated method stub
    EbComponentUtil kk = new EbComponentUtil();
    //    log.debug(EbComponentUtil.getUrl("/img/func/commit.jpg"));
    return new ImageIcon(EbComponentUtil.class.getClass().getResource(IMAGE_URL_PREFIX + imageName));
  }

  private static URL getUrl(String name) {
    return EbComponentUtil.class.getClass().getResource(name);
  }

  public static Image getImage(String imageName) {
    // TODO Auto-generated method stub
    ImageIcon ii = getImageIcon(imageName);
    if (ii != null) {
      return ii.getImage();
    }
    return null;
  }

  public static TexturePaint createTexturePaint(String imageName) {
    // TODO Auto-generated method stub
    Image image = getImage(imageName);
    if (image != null) {
      return createTexturePaint(image);
    }
    return null;
  }

  public static Icon createMovedIcon(Icon icon) {
    return createMovedIcon(icon, 1, 1);
  }

  public static Icon createMovedIcon(final Icon icon, final int offsetX, final int offsetY) {
    return new Icon() {

      public void paintIcon(Component c, Graphics g, int x, int y) {
        icon.paintIcon(c, g, x + offsetX, y + offsetY);
      }

      public int getIconWidth() {
        return icon.getIconWidth();
      }

      public int getIconHeight() {
        return icon.getIconHeight();
      }
    };
  }

  public static Icon getIcon(String imageName) {
    // TODO Auto-generated method stub
    return getImageIcon(imageName);
  }
}
