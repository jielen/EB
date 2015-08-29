package com.ufgov.gk.client.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.Timer;

public class EbStatusTimeLabel extends EbStatusLabel {

  private int delay = 1000;

  public EbStatusTimeLabel() {
    ActionListener taskPerformer = new ActionListener() {

      public void actionPerformed(ActionEvent evt) {
        setText(new Date().toString());
      }
    };
    new Timer(delay, taskPerformer).start();
  }
}
