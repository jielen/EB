package com.ufgov.gk.client.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EbGarbageCollectButton extends EbToolbarButton {

  public EbGarbageCollectButton() {
    this.setIcon(EbComponentUtil.getIcon("gc.png"));
    this.setToolTipText("Click to call garbage collector");
    this.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        System.gc();
      }
    });
  }

}
