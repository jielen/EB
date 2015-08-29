package com.ufgov.gk.client.util;

import com.ufgov.smartclient.component.table.PreferenceStore;

public class GkPreferencesStore implements PreferenceStore {

  private UserPreferencesUtil userPreferencesUtil = UserPreferencesUtil
    .getInstance();

  private static PreferenceStore preferenceStore;

  private GkPreferencesStore() {

  }

  public byte[] load(String key) {
    return userPreferencesUtil.getByteArray(key, null);
  }

  public void save(String key, byte[] value) {
    userPreferencesUtil.putByteArray(key, value);
  }

  public static synchronized PreferenceStore preferenceStore() {
    if (preferenceStore == null) {
      preferenceStore = new GkPreferencesStore();
    }
    return preferenceStore;
  }

}
