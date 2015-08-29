/**
 * DialogSellerListItems.java
 * example.apicallsdemo
 * Administrator
 * Jun 19, 2012
 */
package example.apicallsdemo;

import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JDialog;

import org.apache.log4j.Logger;

import com.ebay.sdk.ApiContext;

/**
 * @author Administrator
 *
 */
public class DialogSellerListItems extends JDialog {

  private static Logger log = Logger.getLogger(DialogSellerListItems.class);

  /**
   * 
   */
  private static final long serialVersionUID = 409073987055619800L;

  private ApiContext apiContext;

  public DialogSellerListItems(Frame frame, String title, boolean modal) {
    // TODO Auto-generated constructor stub
    super(frame, title, modal);
    try {
      jbInit();

      FrameDemo fd = (FrameDemo) frame;
      this.apiContext = fd.getApiContext();

    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  private void jbInit() {
    // TODO Auto-generated method stub
    this.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height - 30);
  }

}
