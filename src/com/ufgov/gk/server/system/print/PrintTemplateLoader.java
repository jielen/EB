package com.ufgov.gk.server.system.print;

import java.io.File;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import com.ufgov.gk.common.system.exception.PrintException;
import com.ufgov.gk.server.system.util.EnvironmentConfigUtil;

public class PrintTemplateLoader {

  private static final String REPORTSPATH="reportspath";

  public static JasperReport loadJasperReportFromXML(String templateCode){
    JasperReport jasperReport=null;
    try {
      String reportspath=EnvironmentConfigUtil.getInstance().get(REPORTSPATH);
      reportspath+="/"+templateCode+".xml";
      File file = new File(reportspath);
      if(file.exists()){
        jasperReport = JasperCompileManager.compileReport(reportspath);
      }
      else{
        throw new PrintException("û���ҵ���ӡģ��["+templateCode+".xml]");
      }
    } catch (JRException e) {
      throw new PrintException(e.getMessage(),e);
    }
    return jasperReport;
  }

  public static JasperReport loadJasperReport(String templateCode){
    JasperReport jasperReport=null;
    try {
      String reportspath=EnvironmentConfigUtil.getInstance().get(REPORTSPATH);
      reportspath+="/"+templateCode+".jasper";
      File file = new File(reportspath);
      if(file.exists()){
        jasperReport =(JasperReport)JRLoader.loadObject(file);
      }
      else{
        throw new PrintException("û���ҵ���ӡģ��["+templateCode+".jasper]");
      }
    } catch (Exception e) {
      throw new PrintException(e.getMessage(),e);
    }
    return jasperReport;
  }

}
