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
   * ��ȡowner������propertyNameָ�����Ե�ʵ������ֵ
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
   * ���ö����ĳ������
   * @param owner��Ҫ���÷�����ʵ��
   * @param methodName�����õķ�������
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
   * ��ö���ԭ���͵����е����� 
   * @param ownerΪ����ȡ���ԵĶ���
   * @param fields�ö����������е����Դ�Ŵ�
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
   * ����ָ���ķ���
   * @param owner�������÷�����ʵ��
   * @param methodName��Ҫ�����õķ�������
   * @param args�÷���֧�ֵĲ���
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
