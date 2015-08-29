/**
 * GetEbayCategory.java
 * com.eb.client.component.test
 * Administrator
 * Aug 24, 2012
 */
package com.eb.client.component.test;

import org.apache.log4j.Logger;

import com.eb.client.component.ebRetrievalTask.EbApiContextFactory;
import com.ebay.sdk.ApiContext;
import com.ebay.sdk.ApiException;
import com.ebay.sdk.SdkException;
import com.ebay.sdk.call.GetCategoriesCall;
import com.ebay.sdk.call.GetCategory2CSCall;
import com.ebay.soap.eBLBaseComponents.CategoryType;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;
import com.ebay.soap.eBLBaseComponents.SiteCodeType;

/**
 * @author Administrator
 *
 */
public class GetEbayCategory {
  private static Logger log = Logger.getLogger(GetEbayCategory.class);

  /**
   * @param args
   * Administrator
   * Aug 24, 2012
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    ApiContext context = EbApiContextFactory.getApiContext();
    //    GetCategoriesCall api=new GetCategoriesCall(context);
    GetEbayCategory m = new GetEbayCategory();
    //    m.getCategory2CS(context);
    m.getCategory(context);

  }

  private void getCategory(ApiContext context) {

    GetCategoriesCall api = new GetCategoriesCall(context);
    api.setSite(SiteCodeType.US);
    api.setDetailLevel(new DetailLevelCodeType[] { DetailLevelCodeType.RETURN_ALL });
    api.setViewAllNodes(true);
    api.setLevelLimit(1);
    try {
      CategoryType[] categorys = api.getCategories();
      for (CategoryType categoryType : categorys) {
        StringBuffer sb = new StringBuffer();
        if (categoryType.getCategoryParentID().length > 0) {
          for (int i = 0; i < categoryType.getCategoryParentID().length; i++) {
            sb.append(categoryType.getCategoryParentID(i));
            //            sb.append(" ");
            //            sb.append(categoryType.getCategoryParentName(i));
            sb.append(":");
          }
        }
        System.out.println(categoryType.getCategoryID() + " " + categoryType.getCategoryName() + " " + sb.toString());
      }
    } catch (ApiException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (SdkException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  private void getCategory2CS(ApiContext context) {

    GetCategory2CSCall api = new GetCategory2CSCall(context);
    try {
      CategoryType[] categorys = api.getCategory2CS();
      for (CategoryType categoryType : categorys) {
        System.out.println(categoryType.getCategoryID() + " " + categoryType.getCategoryName());
      }
    } catch (ApiException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (SdkException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
