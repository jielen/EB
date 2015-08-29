package com.ufgov.gk.server.system.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ufgov.gk.common.commonbiz.model.Company;
import com.ufgov.gk.common.commonbiz.model.NumLimCompo;
import com.ufgov.gk.common.console.model.AsRoleNumLim;
import com.ufgov.gk.common.console.model.AsUserNumLim;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.server.commonbiz.dao.ICompanyDao;
import com.ufgov.gk.server.commonbiz.dao.INumLimCompoDao;
import com.ufgov.gk.server.console.dao.IAsRoleNumLimDao;
import com.ufgov.gk.server.console.dao.IAsUserNumLimDao;
import com.ufgov.gk.server.system.SpringContext;

public class NumLimUtil {

  private IAsUserNumLimDao asUserNumLimDao = (IAsUserNumLimDao) SpringContext.getBean("asUserNumLimDao");

  private IAsRoleNumLimDao asRoleNumLimDao = (IAsRoleNumLimDao) SpringContext.getBean("asRoleNumLimDao");

  private INumLimCompoDao numLimCompoDao = (INumLimCompoDao) SpringContext.getBean("numLimCompoDao");

  private ICompanyDao companyDao = (ICompanyDao) SpringContext.getBean("companyDao");

  private static NumLimUtil numLimUtil = new NumLimUtil();

  private NumLimUtil() {

  }

  public static synchronized NumLimUtil getInstance() {
    return numLimUtil;
  }

  /**
   * ���ݵ�λ���ͷ�����ֵȨ����Ϣ
   * @param numLimCompoId ��ֵȨ�޲���id
   * @param funcId ����id ��fwatch
   * @return
   */
  public String getNumLimCondByCoType(String numLimCompoId, String funcId) {
    return getNumLimCondByCoType(numLimCompoId, funcId, null);
  }

  public String getNumLimCondByCoType(String numLimCompoId, String funcId, boolean isTableContainCoCode) {
    return getNumLimCondByCoType(numLimCompoId, funcId, null, isTableContainCoCode);
  }

  public String getNumLimCondByCoType(String numLimCompoId, String funcId, String ctrlField) {
    return this.getNumLimCondByCoType(numLimCompoId, funcId, ctrlField, true);
  }

  /**
   * ���ݵ�λ���ͷ�����ֵȨ����Ϣ
   * @param numLimCompoId ��ֵȨ�޲���id
   * @param funcId ����id ��fwatch
   * @param ctrlField �����ֶ� ���co_cod����
   * @return
   */

  public String getNumLimCondByCoType(String numLimCompoId, String funcId, String ctrlField,
    boolean isTableContainCoCode) {
    String coCode = RequestMetaUtil.getSvCoCode();
    String coTypeCode = RequestMetaUtil.getSvCoTypeCode();
    String userId = RequestMetaUtil.getSvUserID();
    int nd = RequestMetaUtil.getSvNd();
    if (isTableContainCoCode && "02".equals(coTypeCode)) {//����Ԥ�㵥λ
      return getBaseNumLimCondi(numLimCompoId, funcId, ctrlField);
    } else if (isTableContainCoCode && "03".equals(coTypeCode)) {//���ܵ�λ
      String numLimString = getCommonNumLimCondition(numLimCompoId, funcId, ctrlField, userId);
      //�����ֵȨ��δ��ʱ����co_code����
      if (numLimString == null || "".equals(numLimString)) {
//        if ("CO_CODE".equalsIgnoreCase(ctrlField) || ctrlField == null) {
//          List list = companyDao.getCompanyChildren(nd, coCode);
//          StringBuffer coCodeFilter = new StringBuffer(" ( ");
//          for (int i = 0; i < list.size(); i++) {
//            Company company = (Company) list.get(i);
//            coCodeFilter.append("co_code ='").append(company.getCode()).append("' or ");
//          }
//          coCodeFilter.append(" 1=0 )");
//          return coCodeFilter.toString();
//        } else {
//          return null;
//        }
        return null;
      }
      return numLimString;
    } else {
      return getCommonNumLimCondition(numLimCompoId, funcId, ctrlField, userId);
    }
  }

  private String getCommonNumLimCondition(String numLimCompoId, String funcId, String ctrlField, String userId) {
    if (numLimCompoId == null) {
      numLimCompoId = RequestMetaUtil.getCompoId();
    }
    if (numLimCompoId == null || numLimCompoId.equals("")) {
      return null;
    }
    if (ctrlField == null || ctrlField.equals("")) {
      return getNumLimCondForList(userId, numLimCompoId, funcId);
    } else {
      return getNumLimCondForDialog(userId, numLimCompoId, funcId, ctrlField);
    }
  }

  private String getBaseNumLimCondi(String numLimCompoId, String funcId, String ctrlField) {
    String coCode = RequestMetaUtil.getSvCoCode();
    String userId = RequestMetaUtil.getSvUserID();
    String numLimString = null;

//    if ("CO_CODE".equalsIgnoreCase(ctrlField) || ctrlField == null) {
//      numLimString = " co_code='" + coCode + "' ";
//    }
    String commonNumLim = getCommonNumLimCondition(numLimCompoId, funcId, ctrlField, userId);

    if (numLimString == null && commonNumLim != null) {
      return commonNumLim;
    } else if (numLimString != null && commonNumLim == null) {
      return numLimString;
    } else if (numLimString != null && commonNumLim != null) {
      return numLimString + " and ( " + commonNumLim + " )";
    }
    return numLimString;
  }

  /**
   * ���ҳ�����ֵȨ��
   * @param userId
   * @param compoId
   * @param funcId
   * @return
   */
  private String getNumLimCondForList(String userId, String compoId, String funcId) {
    String condition = getNumLimCond(userId, compoId, funcId, null);
    if (condition == null) {
      NumLimCompo numLimCompo = numLimCompoDao.getNumLimCompoByCompoId(compoId);
      if (numLimCompo == null || isSystemMenu(numLimCompo.getParentCompoId()))
        return null;
      condition = getNumLimCond(userId, numLimCompo.getParentCompoId(), funcId, null);
    }
    return condition;
  }

  /**
   * �������ⲿʵ��ʱ����ֵȨ��
   * @param userId
   * @param compoId
   * @param funcId
   * @param ctrlField
   * @return
   */
  private String getNumLimCondForDialog(String userId, String compoId, String funcId, String ctrlField) {
    if (ctrlField == null || ctrlField.equals(""))
      return null;

    String condition = getNumLimCond(userId, compoId, funcId, ctrlField);
    if (condition == null) {
      NumLimCompo numLimCompo = numLimCompoDao.getNumLimCompoByCompoId(compoId);
      if (numLimCompo == null || isSystemMenu(numLimCompo.getParentCompoId()))
        return null;
      condition = getNumLimCond(userId, numLimCompo.getParentCompoId(), funcId, ctrlField);
    }
    return condition;
  }

  private boolean isSystemMenu(String compoId) {
    List sysList = new ArrayList();
    sysList.add("AM");
    sysList.add("BB");
    sysList.add("BI");
    sysList.add("CP");
    sysList.add("DP");
    return sysList.contains(compoId);
  }

  /**
   * ��ȡȨ������(������Ȩ)
   * @param userId
   * @param compoId
   * @param funcId
   * @param ctrlField
   * @return
   */
  private String getNumLimCond(String userId, String compoId, String funcId, String ctrlField) {
    String condition = this.getNumLimCondOrigin(userId, compoId, funcId, ctrlField);
    List asGrantRoleNumLimList = asRoleNumLimDao.getAsGrantRoleNumLimByUserId(userId, compoId, funcId, ctrlField);
    //������Ȩ��Ϣ
    String userGrantCond = "";
    Map map = new HashMap();
    for(int i=0;i<asGrantRoleNumLimList.size();i++)
    {
      AsRoleNumLim asGrantRoleNumLim = (AsRoleNumLim) asGrantRoleNumLimList.get(i);
      if (map.containsKey(asGrantRoleNumLim.getGrantUserId())) {
        List grantRoleNum = (List)map.get(asGrantRoleNumLim.getGrantUserId());
        grantRoleNum.add(asGrantRoleNumLim);
        map.put(asGrantRoleNumLim.getGrantUserId(), grantRoleNum);
      } else {
        List grantRoleNum = new ArrayList();
        grantRoleNum.add(asGrantRoleNumLim);
        map.put(asGrantRoleNumLim.getGrantUserId(), grantRoleNum);
      }
    }
    Iterator iter =map.keySet().iterator();
    while(iter.hasNext()){
      String userGrantCodTem = "";
      List grantRoleNumList = (ArrayList)map.get(iter.next());
      for (int i = 0; i < grantRoleNumList.size(); i++) {
        AsRoleNumLim asGrantRoleNumLim = (AsRoleNumLim) grantRoleNumList.get(i);
        if (i == 0)
          userGrantCodTem += asGrantRoleNumLim.toSql();
        else
          userGrantCodTem += " and " + asGrantRoleNumLim.toSql();
        String svNd = String.valueOf(RequestMetaUtil.getSvNd());
        String grantUserId=asGrantRoleNumLim.getGrantedUserID();
        String grantCoCode=asGrantRoleNumLim.getGrantUserCoCode();
        String grantOrgCode=asGrantRoleNumLim.getGrantUserOrgCode();
        String grantPoCode=asGrantRoleNumLim.getGrantUserPosiCode();
        String grantOrgPoCode=asGrantRoleNumLim.getGrantUserPosiId();
        String prefix="@@";
        userGrantCodTem = userGrantCodTem.replaceAll(prefix+"[Ss][Vv][Nn][Dd]", svNd);
        userGrantCodTem = userGrantCodTem.replaceAll(prefix+"[Ss][Vv][Cc][Oo][Cc][Oo][Dd][Ee]", grantCoCode);
        userGrantCodTem = userGrantCodTem.replaceAll(prefix+"[Ss][Vv][Oo][Rr][Gg][Cc][Oo][Dd][Ee]", grantOrgCode);
        userGrantCodTem = userGrantCodTem.replaceAll(prefix+"[Ss][Vv][Uu][Ss][Ee][Rr][Ii][Dd]", grantUserId);
        userGrantCodTem = userGrantCodTem.replaceAll(prefix+"[Ss][Vv][Pp][Oo][Cc][Oo][Dd][Ee]", grantPoCode);
        userGrantCodTem = userGrantCodTem.replaceAll(prefix+"[Ss][Vv][Oo][Rr][Gg][Pp][Oo][Cc][Oo][Dd][Ee]", grantOrgPoCode);
      }
      if(userGrantCond==""){
        userGrantCond+=userGrantCodTem;
      }else{
        userGrantCond = "("+userGrantCond+") or (" + userGrantCodTem+")";
      }
    }
    if(condition!=null&&!condition.equals("")&&!userGrantCond.equals("")){
      condition = "(("+condition+") or ("+userGrantCond+"))";
    }else if (condition==null&&!userGrantCond.equals("")){
      condition = "("+userGrantCond+")";
    }
    return condition;
  }
  /**
   * ��ȡȨ������(��������Ȩ)
   * @param userId
   * @param compoId
   * @param funcId
   * @param ctrlField
   * @return
   */
  public String getNumLimCondOrigin(String userId, String compoId, String funcId, String ctrlField) {
    List asUserNumLimList = asUserNumLimDao.getAsUserNumLim(userId, compoId, funcId, ctrlField);
    List asRoleNumLimList = asRoleNumLimDao.getAsRoleNumLimByUserId(userId, compoId, funcId, ctrlField);
    String userCond = "";
    for (int i = 0; i < asUserNumLimList.size(); i++) {
      AsUserNumLim asUserNumLim = (AsUserNumLim) asUserNumLimList.get(i);
      if (i == 0)
        userCond += asUserNumLim.toSql();
      else
        userCond += " and " + asUserNumLim.toSql();
    }
    String roleCond = "";
    for (int i = 0; i < asRoleNumLimList.size(); i++) {
      AsRoleNumLim asRoleNumLim = (AsRoleNumLim) asRoleNumLimList.get(i);
      if (i == 0)
        roleCond += asRoleNumLim.toSql();
      else
        roleCond += " and " + asRoleNumLim.toSql();
    }
    String condition = null;
    if (!userCond.equals("") && !roleCond.equals(""))
      condition = "((" + userCond + ") or (" + roleCond + "))";
    else if (!userCond.equals("") && roleCond.equals(""))
      condition = "(" + userCond + ")";
    else if (userCond.equals("") && !roleCond.equals(""))
      condition = "(" + roleCond + ")";

    condition = Util.handleSv(condition);

    return condition;
  }

  public String getRolesNumLimCond(String roles, String compoId, String funcId, RequestMeta meta) {
    List asRoleNumLimList = asRoleNumLimDao.getRoleNumLimByRoleId(roles, compoId, funcId);
    String roleCond = "";
    for (int i = 0; i < asRoleNumLimList.size(); i++) {
      AsRoleNumLim asUserNumLim = (AsRoleNumLim) asRoleNumLimList.get(i);
      if (i == 0)
        roleCond += asUserNumLim.toSql();
      else
        roleCond += " and " + asUserNumLim.toSql();
    }
    roleCond = Util.handleSv(roleCond, meta);
    return roleCond;
  }

}
