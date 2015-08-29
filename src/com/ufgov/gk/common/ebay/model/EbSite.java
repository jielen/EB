package com.ufgov.gk.common.ebay.model;

import com.ufgov.gk.common.commonbiz.model.BaseBill;

public class EbSite extends BaseBill {
  /**
   * This field was generated by Abator for iBATIS.
   * This field corresponds to the database column EB_SITE.SITE_ID
   *
   * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
   */
  private String siteId;

  /**
   * This field was generated by Abator for iBATIS.
   * This field corresponds to the database column EB_SITE.SITE_NAME
   *
   * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
   */
  private String siteName;

  /**
   * This field was generated by Abator for iBATIS.
   * This field corresponds to the database column EB_SITE.SITE_URL
   *
   * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
   */
  private String siteUrl;

  /**
   * This method was generated by Abator for iBATIS.
   * This method returns the value of the database column EB_SITE.SITE_ID
   *
   * @return the value of EB_SITE.SITE_ID
   *
   * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
   */
  public String getSiteId() {
    return siteId;
  }

  /**
   * This method was generated by Abator for iBATIS.
   * This method sets the value of the database column EB_SITE.SITE_ID
   *
   * @param siteId the value for EB_SITE.SITE_ID
   *
   * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
   */
  public void setSiteId(String siteId) {
    this.siteId = siteId;
  }

  /**
   * This method was generated by Abator for iBATIS.
   * This method returns the value of the database column EB_SITE.SITE_NAME
   *
   * @return the value of EB_SITE.SITE_NAME
   *
   * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
   */
  public String getSiteName() {
    return siteName;
  }

  /**
   * This method was generated by Abator for iBATIS.
   * This method sets the value of the database column EB_SITE.SITE_NAME
   *
   * @param siteName the value for EB_SITE.SITE_NAME
   *
   * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
   */
  public void setSiteName(String siteName) {
    this.siteName = siteName;
  }

  /**
   * This method was generated by Abator for iBATIS.
   * This method returns the value of the database column EB_SITE.SITE_URL
   *
   * @return the value of EB_SITE.SITE_URL
   *
   * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
   */
  public String getSiteUrl() {
    return siteUrl;
  }

  /**
   * This method was generated by Abator for iBATIS.
   * This method sets the value of the database column EB_SITE.SITE_URL
   *
   * @param siteUrl the value for EB_SITE.SITE_URL
   *
   * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
   */
  public void setSiteUrl(String siteUrl) {
    this.siteUrl = siteUrl;
  }
}