package com.ufgov.gk.server.commonbiz.dao;

import java.util.List;

public interface IProjectTypeDao {

	
	List getRootProjectType(int nd);

	List getChildrenProjectType(int nd);
	
	List getProjectType(int nd);
}
