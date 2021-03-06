package com.ufgov.gk.client.util;

import java.applet.Applet;

import netscape.javascript.JSException;
import netscape.javascript.JSObject;
/**
 * 执行applet宿主页面的js函数
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
