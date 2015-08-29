package com.ufgov.gk.server.system.print;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ufgov.gk.common.system.exception.PrintException;
import com.ufgov.gk.common.system.model.PrintSetting;
import com.ufgov.gk.common.system.model.PrintTemplate;
import com.ufgov.gk.common.system.model.RareWord;
import com.ufgov.gk.server.system.SpringContext;
import com.ufgov.gk.server.system.dao.IPrintDao;
import com.ufgov.gk.server.system.util.RequestMetaUtil;

public class PrintUtil {

  private static IPrintDao printDao = (IPrintDao) SpringContext.getBean("printDao");

  public static String getCurrentTemplateCode() {

    PrintSetting currentPrintSetting = printDao.getCurrentPrintSetting();

    String templateCode = "";
    if (currentPrintSetting != null) {
      templateCode = currentPrintSetting.getTemplateCode();
    } else {
      List templateList = printDao.getCurrentPrintTemplate();
      if (templateList.size() == 0) {
        throw new PrintException("����" + RequestMetaUtil.getPrintCompoId() + "û�����ô�ӡģ��");
      }
      PrintTemplate printTemplate = (PrintTemplate) templateList.get(0);
      templateCode = printTemplate.getTemplateCode();
    }
    return templateCode;
  }
  
  public static String[] getCurrentTemplates(){
    String templateCodes = PrintUtil.getCurrentTemplateCode();
    String[] temps=templateCodes.split(",");
    return temps;
  }

  public static PrintSetting getCurrentPrintSetting() {
    return printDao.getCurrentPrintSetting();
  }

  public static String getTemplateType(String templateCode) {
    PrintTemplate template = getPrintTemplate(templateCode);
    String templateType = PrintConstants.TEMPLATE_TYPE_L;

    if (template.getTemplateType().endsWith("_E")) {
      templateType = PrintConstants.TEMPLATE_TYPE_E;
    } else if (template.getTemplateType().endsWith("_C")) {
      templateType = PrintConstants.TEMPLATE_TYPE_C;
    }
    return templateType;
  }

  private static PrintTemplate getPrintTemplate(String templateCode) {

    PrintTemplate template = printDao.getCurrentPrintTemplateByCode(templateCode);
    if (template == null) {
      throw new PrintException("û�в��ҵ�����" + RequestMetaUtil.getPrintCompoId() + "��Ӧ�Ĵ�ӡģ��["
        + templateCode + "]");
    }
    return template;
  }

  public static int getFixRowCount(String templateCode) {
    return getPrintTemplate(templateCode).getFixRowCount();
  }

  /**
   * 
   * @return
   */
  public static Map getRequestMetaMap() {
    Map map = new HashMap();
    map.put("svCoCode", RequestMetaUtil.getSvCoCode());
    map.put("svOrgCode", RequestMetaUtil.getSvOrgCode());
    map.put("svPoCode", RequestMetaUtil.getSvPoCode());
    map.put("svUserID", RequestMetaUtil.getSvUserID());
    map.put("svUserName", RequestMetaUtil.getSvUserName());
    map.put("svCoCode", RequestMetaUtil.getSvCoCode());
    map.put("svCoName", RequestMetaUtil.getSvCoName());
    return map;
  }

  public static Map getRareWord() {
    List list = printDao.getRareWord();
    Map map = new HashMap();
    for (int i = 0; i < list.size(); i++) {
      RareWord word = (RareWord) list.get(i);
      map.put(PrintConstants.RARE_WORD_PREFIX + word.getId(), word.getWord());
    }
    return map;
  }

}
