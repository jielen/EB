package com.ufgov.gk.client.component;

import javax.swing.JPanel;

public class JBasePanel extends JPanel {

  private String panelId;
  

  public JBasePanel() {
    super();
  }

  public JBasePanel(String key) {
    super();
    panelId = key;
  }

  public String getPanelId() {
    return panelId;
  }

  public void setPanelId(String panelId) {
    this.panelId = panelId;
  }
  
  public void init(){
    
  }
  
  public void refreshData() {

  }


  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((panelId == null) ? 0 : panelId.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    final JBasePanel other = (JBasePanel) obj;
    if (panelId == null) {
      if (other.panelId != null)
        return false;
    } else if (!panelId.equals(other.panelId))
      return false;
    return true;
  }


}
