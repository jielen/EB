package com.ufgov.gk.common.system.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;

public class BeanUtil {

  public static void commonFieldsCopy(Object sourceBean, Object destBean) {
    List fieldNames = getCommonFieldNames(sourceBean, destBean);
    for (int i = 0; i < fieldNames.size(); i++) {
      String fieldName = (String) fieldNames.get(i);
      Object fieldValue = get(fieldName, sourceBean);
      set(fieldName, fieldValue, destBean);
    }

  }

  private static List getCommonFieldNames(Object sourceBean, Object destBean) {
    PropertyDescriptor[] sourceProps = new PropertyDescriptor[0];
    PropertyDescriptor[] destProps = new PropertyDescriptor[0];
    PropertyDescriptor[] ObjectProps = new PropertyDescriptor[0];
    try {
      sourceProps = Introspector.getBeanInfo(sourceBean.getClass()).getPropertyDescriptors();
      destProps = Introspector.getBeanInfo(destBean.getClass()).getPropertyDescriptors();
      ObjectProps = Introspector.getBeanInfo(new Object().getClass()).getPropertyDescriptors();

    } catch (IntrospectionException e) {
      throw new RuntimeException(e);
    }

    List sourceFieldNames = new ArrayList();
    List destFieldNames = new ArrayList();
    for (int i = 0; i < sourceProps.length; i++) {
      sourceFieldNames.add(sourceProps[i].getName());
    }
    for (int i = 0; i < destProps.length; i++) {
      destFieldNames.add(destProps[i].getName());
    }

    List commonFieldNames = new ArrayList();

    for (int i = 0; i < sourceFieldNames.size(); i++) {
      if (destFieldNames.contains(sourceFieldNames.get(i))
        && getPropertyType((String) sourceFieldNames.get(i), sourceBean.getClass()).equals(
          getPropertyType((String) sourceFieldNames.get(i), destBean.getClass()))) {
        commonFieldNames.add(sourceFieldNames.get(i));
      }
    }
    for (int i = 0; i < ObjectProps.length; i++) {
      commonFieldNames.remove(ObjectProps[i].getName());
    }
    return commonFieldNames;
  }

  public static Object get(String fieldName, Object target) {
    if (target == null) {
      return null;
    }
    try {
      //      System.out.println(fieldName + "============" + target);
      if (fieldName != null && fieldName.length() > 0) {
        /*
        BeanInfo info = Introspector.getBeanInfo(target.getClass());
        PropertyDescriptor[] props = info.getPropertyDescriptors();
        PropertyDescriptor prop = null;
        for (int i = 0; i < props.length; i++) {
          prop = props[i];
          if (prop.getName().equals(fieldName)) {
            Method method = prop.getReadMethod();
            if (method == null) {
              throw new RuntimeException("field " + fieldName + ": no getter method ");
            }
            return method.invoke(target, new Object[] {});
          }
        }
        */
        /*
         * edit by kongqian 
         * 改用apache的 PropertyUtils,主要是支持深层赋值
         */
        return PropertyUtils.getNestedProperty(target, fieldName);
      }
      throw new RuntimeException("no such property " + fieldName);
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }

  public static void set(String fieldName, Object fieldValue, Object target) {
    try {
      if (fieldName != null && fieldName.length() > 0) {
        /*
        BeanInfo info = Introspector.getBeanInfo(target.getClass());
        PropertyDescriptor[] props = info.getPropertyDescriptors();
        PropertyDescriptor prop = null;
        for (int i = 0; i < props.length; i++) {
          prop = props[i];
          if (prop.getName().equals(fieldName)) {
            Method method = prop.getWriteMethod();
            if (method == null) {
              throw new RuntimeException("field " + fieldName + ": no setter method ");
            }
            method.invoke(target, new Object[] { fieldValue });
            return;
            
          }
          */
        /*
        * edit by kongqian 
        * 改用apache的 PropertyUtils,主要是支持深层赋值
        */
        PropertyUtils.setProperty(target, fieldName, fieldValue);
      }
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }

  public static Class getPropertyType(String fieldName, Class clazz) {
    try {
      if (fieldName != null && fieldName.length() > 0) {
        int headIndex = fieldName.indexOf(".");
        if (headIndex == -1) {
          BeanInfo info = Introspector.getBeanInfo(clazz);
          PropertyDescriptor[] props = info.getPropertyDescriptors();
          PropertyDescriptor prop = null;
          for (int i = 0; i < props.length; i++) {
            prop = props[i];
            if (prop.getName().equals(fieldName)) {
              Class type = prop.getPropertyType();
              if (type.isPrimitive()) {
                if (Boolean.TYPE == type) {
                  type = Boolean.class;
                } else if (Character.TYPE == type) {
                  type = Character.class;
                } else if (Byte.TYPE == type) {
                  type = Byte.class;
                } else if (Short.TYPE == type) {
                  type = Short.class;
                } else if (Integer.TYPE == type) {
                  type = Integer.class;
                } else if (Long.TYPE == type) {
                  type = Long.class;
                } else if (Float.TYPE == type) {
                  type = Float.class;
                } else if (Double.TYPE == type) {
                  type = Double.class;
                }

              }
              return type;
            }
          }
        } else {
          String head = fieldName.substring(0, headIndex);
          String tail = fieldName.substring(headIndex + 1, fieldName.length());
          Class c = PropertyUtils.getPropertyType(clazz.newInstance(), head);
          return getPropertyType(tail, c);
        }
      }
      throw new RuntimeException("no such property " + fieldName);
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }
}
