package com.ufgov.gk.common.system.util;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionUtil {
  
 public  static String getStackTrace(Throwable ex){
    StringWriter sw = new StringWriter();
    PrintWriter pw = new PrintWriter(sw);
    ex.printStackTrace(pw);
    return sw.toString()+"\n";
  }

}
