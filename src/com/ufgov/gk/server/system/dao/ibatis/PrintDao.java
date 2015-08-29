package com.ufgov.gk.server.system.dao.ibatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.gk.common.system.model.PrintSetting;
import com.ufgov.gk.common.system.model.PrintTemplate;
import com.ufgov.gk.server.system.dao.IPrintDao;
import com.ufgov.gk.server.system.util.RequestMetaUtil;

public class PrintDao extends SqlMapClientDaoSupport implements IPrintDao {

  public PrintSetting getCurrentPrintSetting() {
    Map params = new HashMap();
    params.put("userId", RequestMetaUtil.getSvUserID());
    params.put("compoId", RequestMetaUtil.getPrintCompoId());
    params.put("pageType", RequestMetaUtil.getPageType());

    return (PrintSetting) this.getSqlMapClientTemplate().queryForObject(
      "Print.getPrintSetting", params);
  }

  public List getCurrentPrintTemplate() {
    Map params = new HashMap();
    params.put("compoId", RequestMetaUtil.getPrintCompoId());
    params.put("coCode", RequestMetaUtil.getSvCoCode());
    
    List list = this.getSqlMapClientTemplate().queryForList(
      "Print.getPrintTemplate", params);

    if (list.size() == 0) {
      params.put("coCode", "*");
      list = this.getSqlMapClientTemplate().queryForList("Print.getPrintTemplate",
        params);
    }

    return list;
  }
  
  public PrintTemplate getCurrentPrintTemplateByCode(String templateCode) {
    Map params = new HashMap();
    params.put("compoId", RequestMetaUtil.getPrintCompoId());
    params.put("coCode", RequestMetaUtil.getSvCoCode());
    params.put("templateCode", templateCode);
    
    PrintTemplate template = (PrintTemplate)this.getSqlMapClientTemplate().queryForObject(
      "Print.getPrintTemplateByCode", params);

    if (template==null) {
      params.put("coCode", "*");
      template = (PrintTemplate)this.getSqlMapClientTemplate().queryForObject(
        "Print.getPrintTemplateByCode", params);
    }

    return template;
  }

  public void savePrintSetting(PrintSetting printSetting) {
    Map params = new HashMap();
    params.put("userId", printSetting.getUserId());
    params.put("compoId", printSetting.getCompoId());
    params.put("pageType", printSetting.getPageType());
    this.getSqlMapClientTemplate().delete("Print.deletePrintSetting", params);
    if(printSetting.getTemplateCode()!=null&&!printSetting.getTemplateCode().trim().equals("")){
      this.getSqlMapClientTemplate().insert("Print.insertPrintSetting", printSetting);
    }
  }
  
  public List getRareWord(){
    return  this.getSqlMapClientTemplate().queryForList("Print.getRareWord");
  }

}
