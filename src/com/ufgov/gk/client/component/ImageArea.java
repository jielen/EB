package com.ufgov.gk.client.component;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JComponent;

public class ImageArea extends JComponent {

  private static final long serialVersionUID = -3718116452260187306L;

  private Image image;

  private int oldWidth = 0;

  private int oldHeight = 0;

  //  private Image drawImage;

  public Image getImage() {
    return image;
  }

  public void setImage(Image image) {
    this.image = image;
    //    this.drawImage = image;
    //    System.out.println("=================image=" + image);
  }

  public ImageArea(Image image) {
    super();
    this.image = image;
  }

  @Override
  public void paint(Graphics g) {
    //检查是否要重新创建drawImage
    //    if (drawImage == null || oldWidth != this.getWidth() || oldHeight != this.getHeight()) {
    //      oldWidth = this.getWidth();
    //      oldHeight = this.getHeight();
    //      drawImage = image.getScaledInstance(g.getClipBounds().width, g.getClipBounds().height, 0);
    //      drawImage.flush();
    //      //System.err.println("创建图象");
    //    }
    //
    //    //画图象
    //    if (!g.drawImage(drawImage, 0, 0, this)) {
    //      //      System.err.println("画图象失败");
    //    }
    int w = this.getWidth();//383
    int h = this.getHeight();//289
    int iw = this.image.getWidth(this);//400
    int ih = this.image.getHeight(this);//400
    int startX = 0, startY = 0;
    //    System.out.println(">>>>>>>>>>w=" + w + "h=" + h + "iw=" + iw + "ih=" + ih);
    if (w < iw || h < ih) {
      int x = iw - w;
      int y = ih - h;
      double kk = 1.0;//只是在计算过程中，将int转换为double类型，没有其他的作用;
      if (x < y) {

        double tt = (kk * h / ih) * iw;
        iw = new Double(tt).intValue();
        //        System.out.println(">>>>>>>>>>double tt=" + tt + " int tt=" + iw);
        ih = h;
      } else {
        double t = (kk * w / iw) * ih;
        ih = new Double(t).intValue();
        //        System.out.println(">>>>>>>>>>double t=" + t + " int t=" + ih);
        iw = w;
      }
    }

    //    System.out.println("<<<<<<<<<<<<w=" + w + "h=" + h + "iw=" + iw + "ih=" + ih);
    Image di = image.getScaledInstance(iw, ih, Image.SCALE_FAST);
    di.flush();
    g.drawImage(di, 0, 0, this);
    //画边界
    this.paintBorder(g);
  }
}
