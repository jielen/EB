package com.ufgov.gk.server.console.service;

import java.util.List;

public interface IAsOrgService {

	List getAsOrg(int nd);

	List getAsOrg(int nd,String coCode);
	
	List getAsOrgByCocode(String cocode, String nd);

}
