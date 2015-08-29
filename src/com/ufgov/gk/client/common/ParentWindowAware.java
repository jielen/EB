package com.ufgov.gk.client.common;

import java.awt.Window;

public interface ParentWindowAware {

  void setParentWindow(Window window);

  Window getParentWindow();
  

}
