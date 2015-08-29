/**
 * WorkplaceTabedPanel.java
 * com.eb.client.component
 * Administrator
 * Jun 22, 2012
 */
package com.eb.client.component;

import java.util.HashMap;

import javax.swing.JComponent;
import javax.swing.JTabbedPane;

import org.apache.log4j.Logger;

import com.ufgov.gk.client.common.LangTransMeta;
import com.ufgov.gk.client.common.ParentWindowAware;
import com.ufgov.gk.common.system.model.AsMenuCompo;

/**
 * @author Administrator
 *
 */
public class WorkplaceTabedPanel extends JTabbedPane {
  private static Logger log = Logger.getLogger(WorkplaceTabedPanel.class);

  EbMain parent;

  private HashMap<String, JComponent> compos = new HashMap<String, JComponent>();

  public WorkplaceTabedPanel(EbMain ebMain) {
    // TODO Auto-generated constructor stub
    this.parent = ebMain;
    setTabPlacement(JTabbedPane.BOTTOM);
  }

  public void setCompo(AsMenuCompo menuCompo) {
    // TODO Auto-generated method stub
    //如果已经创建，显示
    if (compos.containsKey(menuCompo.getCompoId())) {
      setSelectedComponent(compos.get(menuCompo.getCompoId()));
      IAppMenuCompo mc = (IAppMenuCompo) compos.get(menuCompo.getCompoId());
      mc.refresh();
    } else {
      //如果没有则创建并显示
      Class panelClass;
      try {
        panelClass = Class.forName(menuCompo.getUrl());
        Object panelInstance = panelClass.newInstance();
        JComponent panel = (JComponent) panelInstance;
        if (panel instanceof ParentWindowAware) {
          ParentWindowAware parentWindow = (ParentWindowAware) panel;
          parentWindow.setParentWindow(this.parent);
        }
        compos.put(menuCompo.getCompoId(), panel);
        add(panel, LangTransMeta.translate(menuCompo.getCompoId()));
        setSelectedComponent(panel);
      } catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        log.error(e.getMessage(), e);
      } catch (InstantiationException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        log.error(e.getMessage(), e);
      } catch (IllegalAccessException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        log.error(e.getMessage(), e);
      }

    }
  }
}
