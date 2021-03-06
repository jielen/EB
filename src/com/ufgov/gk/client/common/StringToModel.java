package com.ufgov.gk.client.common;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Vector;

public class StringToModel {
  public static Object stringToInstance(String modelName) throws ClassNotFoundException,
    IllegalAccessException, InstantiationException {
    Class cls = Class.forName(modelName);
    Object instance = cls.newInstance();
    return instance;
  }

  /**
   * 获取owner对象下propertyName指定属性的实例属性值
   * @param owner
   * @param propertyName
   * @return
   */
  public static Object getPropertyValue(Object owner, String propertyName) {
    if (owner == null || propertyName == null)
      return "";
    return invokeMethod(owner, "get" + propertyName.substring(0, 1).toUpperCase()
      + ((propertyName.length() > 1) ? propertyName.substring(1) : ""));
  }

  /**
   * 调用对象的某个方法
   * @param owner将要调用方法的实例
   * @param methodName被调用的方法名称
   * @return
   */
  @SuppressWarnings("unchecked")
  public static Object invokeMethod(Object owner, String methodName) {
    try {
      Class ownerClass = owner.getClass();
      Method method = ownerClass.getMethod(methodName, new Class[] {});
      return method.invoke(owner, new Object[] {});
    } catch (Exception e) {
      e.printStackTrace();
      return "0";
    }
  }

  /**
   * 获得对象原类型的所有的属性 
   * @param owner为被获取属性的对象
   * @param fields该对象类型所有的属性存放处
   */
  @SuppressWarnings("unchecked")
  public static void getPropertys(Object owner, Vector<String> fields) {
    try {
      Class ownerClass = owner.getClass();
      Field[] field = ownerClass.getDeclaredFields();
      for (int i = 0; i < field.length; i++) {
        fields.add(field[i].getName());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 调用指定的方法
   * @param owner用来调用方法的实例
   * @param methodName将要被调用的方法名称
   * @param args该方法支持的参数
   * @return
   */
  @SuppressWarnings("unchecked")
  public static Object invokeMethod(Object owner, String methodName, Object[] args) {
    try {
      Class ownerClass = owner.getClass();
      Class[] argsClass = new Class[args.length];
      for (int i = 0, j = args.length; i < j; i++) {
        argsClass[i] = args[i].getClass();
      }
      Method method = ownerClass.getMethod(methodName, argsClass);
      return method.invoke(owner, args);
    } catch (Exception e) {
      e.printStackTrace();
      return "0";
    }
  }
}
