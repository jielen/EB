/**
 * ImageAreaFieldEditor.java
 * com.ufgov.gk.client.component.zc.fieldeditor
 * Administrator
 * Jul 14, 2012
 */
package com.ufgov.gk.client.component.zc.fieldeditor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.border.LineBorder;

import com.ufgov.gk.client.component.ImageArea;
import com.ufgov.gk.client.component.ui.fieldeditor.AbstractFieldEditor;
import com.ufgov.gk.common.commonbiz.model.BaseBill;
import com.ufgov.gk.common.system.constants.ZcSettingConstants;
import com.ufgov.gk.common.system.util.BeanUtil;

/**
 * @author Administrator
 *
 */
public class ImageAreaFieldEditor extends AbstractFieldEditor {
  ImageArea field;

  String defaultImageName = ZcSettingConstants.DEFAULT_IMAGE_NAME;

  String imageUrl = "";

  //  String imageDirect = "/img/candidateitems/";

  public ImageAreaFieldEditor(String name, String fieldName, int occRow, int occCol) {
    this.fieldName = fieldName;
    this.occRow = occRow;
    this.occCol = occCol;
    //    this.maxContentSize = 60;
    init(name);
    //    this.field.setEditable(isEditable);
  }

  /* (non-Javadoc)
   * @see com.ufgov.gk.client.component.ui.fieldeditor.AbstractFieldEditor#setValue(java.lang.Object)
   */
  @Override
  public void setValue(Object value) {
    // TODO Auto-generated method stub
    if (value == null)
      return;
    if (value instanceof BaseBill) {
      imageUrl = (String) BeanUtil.get(fieldName, value);
      this.defaultImageName = imageUrl;
      this.repaint();
    }

    //    if (imageUrl.startsWith("http://")) {
    //      int k = imageUrl.lastIndexOf("\\");
    //      String nameStr = imageUrl.substring(k);
    //      nameStr = imageDirect + nameStr;
    //      if (this.getClass().getResource(nameStr) != null) {
    //        try {
    //          field.setImage(ImageIO.read(this.getClass().getResource(nameStr)));
    //          field.repaint();
    //        } catch (IOException e) {
    //          // TODO Auto-generated catch block
    //          e.printStackTrace();
    //        }
    //      } else {
    //        //download ͼƬ
    //      }
    //    }
  }

  /* (non-Javadoc)
   * @see com.ufgov.gk.client.component.ui.fieldeditor.AbstractFieldEditor#getValue()
   */
  @Override
  public Object getValue() {
    // TODO Auto-generated method stub
    return imageUrl;
  }

  /* (non-Javadoc)
   * @see com.ufgov.gk.client.component.ui.fieldeditor.AbstractFieldEditor#createEditorComponent()
   */
  @Override
  protected JComponent createEditorComponent() {
    // TODO Auto-generated method stub
    try {
      field = new ImageArea(ImageIO.read(this.getClass().getResource(defaultImageName)));
      //      field.setPreferredSize(new Dimension(120 * this.occCol, 23 * this.occRow));
      field.setPreferredSize(new Dimension(400, 400));
      field.setBorder(new LineBorder(Color.red, 2));
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return field;
  }

  public void setImage(Image image) {
    this.field.setImage(image);
    this.field.repaint();
  }
}
