package com.ufgov.gk.client.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.text.NumberFormat;

import javax.swing.Timer;

public class EbMemoryBar extends EbProgressBar {

  private static final int kilo = 1024;

  private static final String mega = "M";

  private static MemoryMXBean memorymbean = ManagementFactory.getMemoryMXBean();

  private static NumberFormat format = NumberFormat.getInstance();

  private int delay = 2000;
  
  private StringBuffer usedMega=new StringBuffer();
  private StringBuffer totalMega=new StringBuffer();
  private StringBuffer message=new StringBuffer();
  private StringBuffer topTips=new StringBuffer();

  public EbMemoryBar() {
    super(0, 0, 100);
    ActionListener taskPerformer = new ActionListener() {

      public void actionPerformed(ActionEvent evt) {
        final long usedMemory = memorymbean.getHeapMemoryUsage().getUsed();
        final long totalMemory = memorymbean.getHeapMemoryUsage().getMax();
        updateMemoryUsage(usedMemory, totalMemory);
      }
    };
    new Timer(delay, taskPerformer).start();
  }

  private void updateMemoryUsage(long usedMemory, long totalMemory) {
    int percent = (int) (usedMemory * 100 / totalMemory);
    this.setValue(percent);
    
    usedMega=new StringBuffer();
    usedMega.append("").append(format.format(usedMemory / kilo / kilo)).append(mega);
    
    totalMega = new StringBuffer();
    totalMega.append("").append(format.format(totalMemory / kilo / kilo)).append(mega);
    
    message = new StringBuffer();
    message.append("").append(percent).append("% ").append(usedMega).append("/").append(totalMega);
    
    topTips=new StringBuffer();
    
    topTips.append("Memory used ").append(format.format(usedMemory)).append(" of total ").append(format.format(totalMemory));
    
    this.setString(message.toString());
    this.setToolTipText(topTips.toString());
  }

}
