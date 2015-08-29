package com.ufgov.gk.client.common;

import java.applet.Applet;

public interface AppletAware {
  public void setApplet(Applet applet);
  public Applet getApplet();
}
