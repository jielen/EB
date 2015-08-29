/*
Copyright (c) 2007 eBay, Inc.

This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent
version thereof released by eBay.  The then-current version of the License
can be found at https://www.codebase.ebay.com/Licenses.html and in the
eBaySDKLicense file that is under the eBay SDK install directory.
*/

package example.apicallsdemo;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.ebay.sdk.helper.ui.GuiUtil;
import com.ufgov.smartclient.plaf.BlueLookAndFeel;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ApiCallsDemo {
  boolean packFrame = false;

  //Construct the application
  public ApiCallsDemo() {
    FrameDemo frame = new FrameDemo();
    //Validate frames that have preset sizes
    //Pack frames that have useful preferred size info, e.g. from their layout
    if (packFrame) {
      frame.pack();
    } else {
      frame.validate();
    }

    GuiUtil.CenterComponent(frame);
    frame.setVisible(true);
    frame.select();
  }

  //Main method
  public static void main(String[] args) {
    try {
      //      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      UIManager.setLookAndFeel(new BlueLookAndFeel());
    } catch (Exception e) {
      e.printStackTrace();
    }
    SwingUtilities.invokeLater(new Runnable() {

      @Override
      public void run() {
        // TODO Auto-generated method stub
        new ApiCallsDemo();
      }
    });

  }
}
