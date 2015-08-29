package com.ufgov.gk.client.component.element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ufgov.gk.common.commonbiz.model.BaseElement;

public class BaseElementDataFilter {

	public static  List doFilter(List dataBufferList, boolean randomEdit, String prefix,
			boolean levelCtrl, int ctrlLevelNum) {

		List prefixFilteredList = new ArrayList();
		List levelCtrlFilteredList = new ArrayList();
		
		if (!randomEdit ) {
		  prefixFilteredList=doNonRandomEditFilter(dataBufferList, prefix);
		}
		if (levelCtrl && ctrlLevelNum >= 1) {
		 levelCtrlFilteredList=doLevelCtrlFilter(dataBufferList, ctrlLevelNum);
		}

		List filteredList = null;
		if (randomEdit && !levelCtrl) {
			filteredList = dataBufferList;
		} else if (!randomEdit && !levelCtrl) {
			filteredList = prefixFilteredList;
		} else if (randomEdit && levelCtrl) {
			filteredList = levelCtrlFilteredList;
		} else {
			filteredList = new ArrayList();
			for (Object o : prefixFilteredList) {
				if (levelCtrlFilteredList.contains(o)) {
					filteredList.add(o);
				}
			}
		}

		return filteredList;
	}
	
  private static List doNonRandomEditFilter(List dataBufferList, String prefix) {
    List prefixFilteredList = new ArrayList();
    if(prefix==null){
      prefix="";
    }
    for (Object o : dataBufferList) {
      BaseElement temp = (BaseElement) o;
      if (temp.getCode().startsWith(prefix)) {
        prefixFilteredList.add(temp);
      }
    }
    return prefixFilteredList;
  }

  private static List doLevelCtrlFilter(List dataBufferList, int ctrlLevelNum) {
     List treeDataList = genTreeData(dataBufferList);
     List levelCtrlFilteredList = new ArrayList(); 
     
     for(int i=0;i<treeDataList.size();i++){
       
        BaseElement element=(BaseElement) treeDataList.get(i);
        handleChildren(element,levelCtrlFilteredList,ctrlLevelNum);
     }

    return levelCtrlFilteredList;
  }
  
  private static void handleChildren(BaseElement element,List levelCtrlFilteredList, int ctrlLevelNum){
       if(element.getChildren()==null||element.getChildren().size()==0){
         levelCtrlFilteredList.add(element);
       }else{
         if(element.getLevel()==ctrlLevelNum){
           levelCtrlFilteredList.add(element);
           return ;
         }
         List childrenList =element.getChildren();
         for(int i=0;i<childrenList.size();i++){
           handleChildren((BaseElement)childrenList.get(i),levelCtrlFilteredList,ctrlLevelNum);
         }
         
       }
       
  }
  
  private static  List genTreeData(List dataBufferList){
    List rootList = getRootList(dataBufferList);
    Map childrenMap = getChildrenMap(dataBufferList);
    
    for (int i = 0; i < rootList.size(); i++) {
      BaseElement element = (BaseElement) rootList.get(i);
      setChildren(element, childrenMap);
    }
    return rootList;
  }
  
  private static List getRootList(List dataBufferList){
    List rootList = new ArrayList();
    for(int i=0;i<dataBufferList.size();i++){
      BaseElement element = (BaseElement)dataBufferList.get(i);
      if(element.getParentCode()==null||element.getParentCode().trim().equals("")){
        rootList.add(element);
      }
    }
    return rootList;
  }
  
  private static Map getChildrenMap(List dataBufferList){
    
    List allChildrenList = new ArrayList();
    for(int i=0;i<dataBufferList.size();i++){
      BaseElement element = (BaseElement)dataBufferList.get(i);
      if(element.getParentCode()!=null&&!element.getParentCode().trim().equals("")){
        allChildrenList.add(element);
      }
    }
    Map childrenMap = new HashMap();
    
  for (int i = 0; i < allChildrenList.size(); i++) {
      
      BaseElement child = (BaseElement) allChildrenList.get(i);
      
      List childrenList = (List) childrenMap.get(child.getParentCode());
      if (childrenList != null) {
        childrenList.add(child);
      } else {
        List tempList = new ArrayList();
        tempList.add(child);
        childrenMap.put(child.getParentCode(), tempList);
      }
    }
    return childrenMap;
  }
  
  private  static void setChildren(BaseElement element, Map childrenMap) {
    List childrenList = (List) childrenMap.get(element.getCode());
    if (childrenList != null) {
      element.setChildren(childrenList);
      for (int i = 0; i < childrenList.size(); i++) {
        BaseElement c = (BaseElement) childrenList.get(i);
        setChildren(c, childrenMap);
      }
    }
  }
  
  

  
  public static  List doNumLimFilter(List dataList,List numLimDataList){
    List list = new ArrayList();
     for(Object o:dataList){
       if(numLimDataList.contains(o)){
         list.add(o);
       }
     }
    return list;
  }

}
