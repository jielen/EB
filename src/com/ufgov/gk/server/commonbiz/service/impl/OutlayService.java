package com.ufgov.gk.server.commonbiz.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ufgov.gk.server.commonbiz.dao.IOutlayDao;
import com.ufgov.gk.server.commonbiz.service.IOutlayService;
import com.ufgov.gk.common.commonbiz.model.Outlay;
import com.ufgov.gk.common.system.dto.ElementConditionDto;

public class OutlayService implements IOutlayService {
    private IOutlayDao outlayDao ;
    

	public IOutlayDao getOutlayDao() {
		return outlayDao;
	}

	public void setOutlayDao(IOutlayDao outlayDao) {
		this.outlayDao = outlayDao;
	}

	public List getOutlayTree(int nd) {
		
		  List rootOutlayList = outlayDao.getRootOutlay(nd);
		  List childrenOutlayList=outlayDao.getChildrenOutlay(nd);
		  
		  Map childrenMap = new HashMap();
		  
		  for (int i=0;i<childrenOutlayList.size();i++) {
				Outlay child =(Outlay) childrenOutlayList.get(i);
				
				List childrenList = (List)childrenMap.get(child.getParentCode());
				if (childrenList != null) {
					childrenList.add(child);
				} else {
					List tempList = new ArrayList();
					tempList.add(child);
					childrenMap.put(child.getParentCode(), tempList);
				}
			}
		  
			for(int i=0;i<rootOutlayList.size();i++){
				Outlay outlay= (Outlay) rootOutlayList.get(i);
				this.setChildren(outlay, childrenMap);
			}
		  
		  return rootOutlayList;
		}
	
	private void setChildren(Outlay outlay,
			Map childrenMap) {
		List childrenList = (List)childrenMap.get(outlay.getCode());
		if (childrenList != null) {
			outlay.setChildren(childrenList);
			for (int i=0;i<childrenList.size();i++) {
				Outlay c =(Outlay) childrenList.get(i);
				setChildren(c, childrenMap);
			}
		}

	}
	
	public List getOutlay(ElementConditionDto dto){
		return outlayDao.getOutlay(dto);
	}

}
