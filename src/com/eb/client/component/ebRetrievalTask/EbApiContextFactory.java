package com.eb.client.component.ebRetrievalTask;

import java.util.ArrayList;
import java.util.List;

import com.ebay.sdk.ApiAccount;
import com.ebay.sdk.ApiContext;
import com.ebay.sdk.ApiCredential;
import com.ebay.sdk.CallRetry;
import com.ufgov.gk.client.common.ServiceFactory;
import com.ufgov.gk.client.common.WorkEnv;
import com.ufgov.gk.common.ebay.model.EbAppAccount;
import com.ufgov.gk.common.ebay.model.EbAppServer;
import com.ufgov.gk.common.ebay.publish.IEbayServiceDelegate;
import com.ufgov.gk.common.system.dto.ElementConditionDto;

public class EbApiContextFactory {

  private static List<ApiContext> productApiLst = new ArrayList<ApiContext>();

  private static List<ApiContext> sandboxApiLst = new ArrayList<ApiContext>();
  
  private static final int API_USE_NUM_LIMIT_5000=5000;

  private EbApiContextFactory() {

  }

  public static ApiContext getApiContext() {
    if (productApiLst.size() == 0) {
      initApiContext();
    }
    if (productApiLst.size() == 0) {
      return null;
    }
    return productApiLst.get(0);
  }

  public static ApiContext getSandboxApiContext() {
    if (sandboxApiLst.size() == 0) {
      initApiContext();
    }
    if (sandboxApiLst.size() == 0) {
      return null;
    }
    return sandboxApiLst.get(0);
  }

  private static void initApiContext() {
    // TODO Auto-generated method stub
    IEbayServiceDelegate ebayServiceDelegate = (IEbayServiceDelegate) ServiceFactory.create(IEbayServiceDelegate.class, "ebayServiceDelegate");
    List<EbAppServer> ebAppServerLst = ebayServiceDelegate.getEbAppServer(new ElementConditionDto(), WorkEnv.getInstance().getRequestMeta());
    List<EbAppAccount> appAccountLst = ebayServiceDelegate.getEbAppAccount(new ElementConditionDto(), WorkEnv.getInstance().getRequestMeta());
    if (appAccountLst == null || appAccountLst.size() == 0 || ebAppServerLst == null || ebAppServerLst.size() == 0) {
      return;
    }
    _initProductAccount(appAccountLst, ebAppServerLst);
    _initSandboxAccount(appAccountLst, ebAppServerLst);
  }

  private static void _initSandboxAccount(List<EbAppAccount> appAccountLst, List<EbAppServer> ebAppServerLst) {

    for (EbAppAccount ebAppAccount : appAccountLst) {

      ApiAccount ac = new ApiAccount();
      ac.setDeveloper(ebAppAccount.getSandboxDevid());
      ac.setApplication(ebAppAccount.getSandboxAppid());
      ac.setCertificate(ebAppAccount.getSandboxCertid());

      ApiCredential apiCred = new ApiCredential();
      apiCred.setApiAccount(ac);

      apiCred.seteBayToken(ebAppAccount.getSandboxToken());

      for (EbAppServer ebAppServer : ebAppServerLst) {

        ApiContext apiContext = new ApiContext();
        apiContext.setApiServerUrl("https://api.sandbox.ebay.com/wsapi");
        apiContext.setEpsServerUrl("https://api.sandbox.ebay.com/ws/api.dll");
        apiContext.setSignInUrl("https://signin.sandbox.ebay.com/ws/eBayISAPI.dll?SignIn");

        CallRetry cr = new CallRetry();
        cr.setMaximumRetries(3);
        cr.setDelayTime(1000); // Wait for one second between each retry-call.
        String[] apiErrorCodes = new String[] { "10007", // "Internal error to the application."
          "931", // "Validation of the authentication token in API request failed."
          "521", // Test of Call-Retry: "The specified time window is invalid."
          "124" // Test of Call-Retry: "Developer name invalid."
        };
        cr.setTriggerApiErrorCodes(apiErrorCodes);

        // Set trigger exceptions for CallRetry.
        // Build a dummy SdkSoapException so that we can get its Class.
        java.lang.Class[] tcs = new java.lang.Class[] { com.ebay.sdk.SdkSoapException.class };
        cr.setTriggerExceptions(tcs);

        apiContext.setCallRetry(cr);

        apiContext.setTimeout(3600000);
        apiContext.setApiCredential(apiCred);
        sandboxApiLst.add(apiContext);
      }

    }
  }

  private static void _initProductAccount(List<EbAppAccount> appAccountLst, List<EbAppServer> ebAppServerLst) {

    for (EbAppAccount ebAppAccount : appAccountLst) {

      ApiAccount ac = new ApiAccount();
      ac.setDeveloper(ebAppAccount.getProductionDevid());
      ac.setApplication(ebAppAccount.getProductionAppid());
      ac.setCertificate(ebAppAccount.getProductionCertid());

      ApiCredential apiCred = new ApiCredential();
      apiCred.setApiAccount(ac);

      apiCred.seteBayToken(ebAppAccount.getProductionToken());

      for (EbAppServer ebAppServer : ebAppServerLst) {

        ApiContext apiContext = new ApiContext();
        apiContext.setApiServerUrl(ebAppServer.getServerUrl());
        apiContext.setEpsServerUrl(ebAppServer.getEpsServerUrl());
        apiContext.setSignInUrl(ebAppServer.getSignInUrl());

        CallRetry cr = new CallRetry();
        cr.setMaximumRetries(3);
        cr.setDelayTime(1000); // Wait for one second between each retry-call.
        String[] apiErrorCodes = new String[] { "10007", // "Internal error to the application."
          "931", // "Validation of the authentication token in API request failed."
          "521", // Test of Call-Retry: "The specified time window is invalid."
          "124" // Test of Call-Retry: "Developer name invalid."
        };
        cr.setTriggerApiErrorCodes(apiErrorCodes);

        // Set trigger exceptions for CallRetry.
        // Build a dummy SdkSoapException so that we can get its Class.
        java.lang.Class[] tcs = new java.lang.Class[] { com.ebay.sdk.SdkSoapException.class };
        cr.setTriggerExceptions(tcs);

        apiContext.setCallRetry(cr);

        apiContext.setTimeout(3600000);
        apiContext.setApiCredential(apiCred);
        productApiLst.add(apiContext);
      }

    }
  }
}
