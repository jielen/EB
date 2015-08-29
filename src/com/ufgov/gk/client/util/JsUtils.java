package com.ufgov.gk.client.util;

import java.applet.Applet;

import netscape.javascript.JSException;
import netscape.javascript.JSObject;
/**
 * ִ��applet����ҳ���js����
 * @author liubo
 *
 */
public class JsUtils {
  public static String invokeJsFunc(String funcName, Object[] params, Applet applet) throws JSException {
    JSObject jo = JSObject.getWindow(applet);
    Object result = jo.call(funcName, params);
    return result.toString();
  }
}
