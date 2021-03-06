package com.ufgov.gk.common.system.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;

public class ObjectUtil {
  

  public static byte[] objectToBytes(Object object) {
    byte[] data = null;
    try {
      if (object != null) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos;
        oos = new ObjectOutputStream(bos);
        oos.writeObject(object);
        oos.flush();
        data = bos.toByteArray();
        oos.close();
        bos.close();
      }

    } catch (IOException e) {
      throw new RuntimeException(e.getMessage(), e);
    }
    return data;
  }

  /**
   *
   * @param bytes
   *            用objectToBytes生成的字节
   * @return
   */
  public static Object bytesToObject(byte[] bytes) {
    Object object = null;

    try {
      ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
      ObjectInputStream ois = new ObjectInputStream(bis);
      object = ois.readObject();
      ois.close();
      bis.close();
    } catch (IOException e) {
      throw new RuntimeException(e.getMessage(), e);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e.getMessage(), e);
    }

    return object;
  }

  public static Object deepCopy(Object object) {
    if(object==null){
      return null;
    }
    return bytesToObject(objectToBytes(object));
  }

  public static byte[] getBytesFromFile(File f) throws IOException {
    FileInputStream fo = null;
    try {
      fo = new FileInputStream(f);
      return inputStreamToBytes(fo);
    } finally {
      fo.close();
    }
  }

  public static byte[] inputStreamToBytes(InputStream in) throws IOException {
    byte[] buffer = new byte[255];
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    int offset = 0;
    while ((offset = in.read(buffer)) >= 0) {
      out.write(buffer, 0, offset);
    }
    return out.toByteArray();
  }

  public static void writeObject(Object source, OutputStream output) throws IOException {
    if (source != null) {
      ObjectOutputStream objectOutput = new ObjectOutputStream(output);
      objectOutput.writeObject(source);
      objectOutput.flush();
      objectOutput.close();
      output.close();
    }
  }

  public static Object readObject(InputStream input) throws IOException, ClassNotFoundException {
    ObjectInputStream objectInput = new ObjectInputStream(input);
    Object object = objectInput.readObject();
    objectInput.close();
    input.close();
    return object;
  }

  public static Object invokeMethod(Object source, String method, Object[] params) {
    Method m = null;
    try {
      BeanInfo info = Introspector.getBeanInfo(source.getClass());
      MethodDescriptor[] methods = info.getMethodDescriptors();
      MethodDescriptor methodDesc = null;
      for (int i = 0; i < methods.length; i++) {
        methodDesc = methods[i];
        if (methodDesc.getName().equals(method)) {
          m = methodDesc.getMethod();
          break;
        }
      }
      if (m != null) {
        return m.invoke(source, params);
      } else {
        return null;
      }
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }

  public static Object getProperty(Object source, String propertyName) {
    Object result = null;
    try {
      BeanInfo info = Introspector.getBeanInfo(source.getClass());
      PropertyDescriptor[] descriptors = info.getPropertyDescriptors();
      for (int i = 0; i < descriptors.length; i++) {
        PropertyDescriptor property = descriptors[i];
        if (property.getName().equals(propertyName)) {
          result = property.getReadMethod().invoke(source, new Object[] {});
          break;
        }
      }
      return result;
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }

  public static void setProperty(Object source, String propName, Object value) {
    try {
      BeanInfo info = Introspector.getBeanInfo(source.getClass());
      PropertyDescriptor[] descriptors = info.getPropertyDescriptors();
      for (int i = 0; i < descriptors.length; i++) {
        PropertyDescriptor property = descriptors[i];
        if (property.getName().equals(propName)) {
          property.getWriteMethod().invoke(source, new Object[] { value });
          break;
        }
      }
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }

}
