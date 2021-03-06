package com.ufgov.gk.client.util;

import java.util.HashMap;
import java.util.Map;

import com.ufgov.gk.client.common.AsOptionMeta;
import com.ufgov.gk.client.common.ServiceFactory;
import com.ufgov.gk.client.common.WorkEnv;
import com.ufgov.gk.common.commonbiz.publish.IBaseDataServiceDelegate;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.constants.SystemOptionConstants;
import com.ufgov.gk.common.system.model.UserPreferences;
import com.ufgov.gk.common.system.util.Base64;

public class UserPreferencesUtil {

  private IBaseDataServiceDelegate baseDataServiceDelegate = (IBaseDataServiceDelegate) ServiceFactory
    .create(IBaseDataServiceDelegate.class, "baseDataServiceDelegate");

  private static UserPreferencesUtil userPreferencesUtil;

  private UserPreferencesUtil() {

  }

  public static synchronized UserPreferencesUtil getInstance() {
    if (userPreferencesUtil == null) {
      userPreferencesUtil = new UserPreferencesUtil();
    }

    return userPreferencesUtil;
  }

  private boolean isSetDefault() {
    boolean setDefault = false;
    String value = AsOptionMeta.getOptVal(SystemOptionConstants.OPT_PREFER_SET_DEFAULT);
    if (value.equals("1")) {
      setDefault = true;
    } else {
      setDefault = false;
    }
    return setDefault;
  }

  public void putByteArray(String key, byte[] value) {
    String data = new String(Base64.encode(value));
    if (isSetDefault()) {
      putUserPreferences("*", key, data);
    } else {
      putUserPreferences(WorkEnv.getInstance().getCurrUserId(), key, data);
    }
  }

  public byte[] getByteArray(String key, byte[] def) {
    byte[] value = null;
    byte[] data = null;
    String sdata = getUserPreferences(WorkEnv.getInstance().getCurrUserId(), key);
    if (sdata != null) {
      data = Base64.decode(sdata.getBytes());
    }
    if (data == null) {
      String sysValue = getUserPreferences("*", key);
      if (sysValue == null) {
        value = def;
      } else {
        value = Base64.decode(sysValue.getBytes());
      }
    } else {
      value = data;
    }
    return value;
  }

  public void putLong(String key, Long value) {
    if (isSetDefault()) {
      putUserPreferences("*", key, value.toString());
    } else {
      putUserPreferences(WorkEnv.getInstance().getCurrUserId(), key, value.toString());
    }
  }

  public Long getLong(String key, Long def) {
    Long value = null;
    String data = getUserPreferences(WorkEnv.getInstance().getCurrUserId(), key);
    if (data == null) {
      String sysValue = getUserPreferences("*", key);
      if (sysValue == null) {
        value = def;
      } else {
        value = Long.valueOf(sysValue);
      }
    } else {
      value = Long.valueOf(data);
    }
    return value;
  }

  public void putBoolean(String key, boolean value) {
    putString(key, value + "");
  }

  public boolean getBoolean(String key, boolean def) {
    return Boolean.parseBoolean(getString(key, def + ""));
  }

  public void putString(String key, String value) {
    if (isSetDefault()) {
      putUserPreferences("*", key, value);

    } else {

      putUserPreferences(WorkEnv.getInstance().getCurrUserId(), key, value);
    }
  }

  public String getString(String key, String def) {
    String value = null;

    String data = getUserPreferences(WorkEnv.getInstance().getCurrUserId(), key);
    if (data == null) {
      String sysValue = getUserPreferences("*", key);
      if (sysValue == null) {
        value = def;
      } else {
        value = sysValue;
      }
    } else {
      value = data;
    }
    return value;
  }

  public void putInt(String key, Integer value) {
    if (isSetDefault()) {
      putUserPreferences("*", key, value.toString());

    } else {

      putUserPreferences(WorkEnv.getInstance().getCurrUserId(), key, value.toString());
    }
  }

  public Integer getInt(String key, Integer def) {
    Integer value = null;

    String data = getUserPreferences(WorkEnv.getInstance().getCurrUserId(), key);
    if (data == null) {
      String sysValue = getUserPreferences("*", key);
      if (sysValue == null) {
        value = def;
      } else {
        value = Integer.valueOf(sysValue);
      }
    } else {
      value = Integer.valueOf(data);
    }
    return value;
  }

  public String getUserPreferences0(String userId, String key) {
    RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();
    String value = null;
    UserPreferences p = baseDataServiceDelegate.getUserPreferences(userId, key, requestMeta);
    if (p != null) {
      value = p.getPreferValue();
    }
    return value;
  }

  public synchronized String getUserPreferences(String userId, String key) {
    String k = userId + key;
    String registedKey = registryMap.get(k);
    if (registedKey != null) { // 这样可以处理可以处理null值  避免当值本身是null时再查库
      return dataCache.get(k);
    } else {
      String value = this.getUserPreferences0(userId, key);
      dataCache.put(k, value);
      registryMap.put(k, k);
      return value;
    }
  }

  public synchronized void removeUserPreferences(String userId, String key) {
    removeUserPreferences0(userId, key);
    String k = userId + key;
    dataCache.remove(k);
    registryMap.remove(k);
  }

  public synchronized void putUserPreferences(String userId, String key, String value) {
    String k = userId + key;
    String oldValue=dataCache.get(k);
    if(!(oldValue!=null&&value!=null&&oldValue.equals(value))){
      this.putUserPreferences0(userId, key, value);
      registryMap.put(k, k);
      dataCache.put(k, value);
    }
  }

  private static Map<String, String> registryMap = new HashMap<String, String>();

  private static Map<String, String> dataCache = new HashMap<String, String>();

  public void putUserPreferences0(String userId, String key, String value) {
    RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();
    UserPreferences userPreferences = new UserPreferences();
    userPreferences.setPreferId(key);
    userPreferences.setUserId(userId);
    userPreferences.setPreferValue(value);
    baseDataServiceDelegate.putUserPreferences(userPreferences, requestMeta);
  }

  private void removeUserPreferences0(String userId, String key) {
    RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();
    UserPreferences userPreferences = new UserPreferences();
    userPreferences.setPreferId(key);
    userPreferences.setUserId(userId);
    baseDataServiceDelegate.removeUserPreferences(userPreferences, requestMeta);
  }

}
