/*
Copyright (c) 2007 eBay, Inc.

This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent
version thereof released by eBay.  The then-current version of the License
can be found at https://www.codebase.ebay.com/Licenses.html and in the
eBaySDKLicense file that is under the eBay SDK install directory.
*/

package example.apicallsdemo;

import com.ebay.sdk.TokenEventListener;
import com.ebay.sdk.util.eBayUtil;
 
public class DemoTokenEventListener implements TokenEventListener {

  FrameDemo mainFrame;

  public DemoTokenEventListener(FrameDemo mainFrame) {
    this.mainFrame = mainFrame;
  }

  public void renewToken(String newToken)
  {
    mainFrame.showInfoMessage("eBay Token has been renewed successfully!");
  }

  public void warnHardExpiration(java.util.Date expirationDate)
  {
    mainFrame.showInfoMessage("Received token hard-expiration-warning: " + eBayUtil.toAPITimeString(expirationDate));
  }
}
