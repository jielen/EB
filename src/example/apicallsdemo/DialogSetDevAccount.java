package example.apicallsdemo;

import java.awt.Frame;

import javax.swing.JDialog;

import com.ebay.sdk.ApiContext;

public class DialogSetDevAccount extends JDialog {
  /**
   * 
   */
  private static final long serialVersionUID = 732291693767430093L;

  private ApiContext _apiContext;

  public DialogSetDevAccount(Frame frame, ApiContext apiContext, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();

      _apiContext = apiContext;
      //      populateUI();

      //
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  private void jbInit() {
    // TODO Auto-generated method stub

  }

}
