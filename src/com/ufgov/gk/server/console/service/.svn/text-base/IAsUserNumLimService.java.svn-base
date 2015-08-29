package com.ufgov.gk.server.console.service;

import java.util.List;

import com.ufgov.gk.common.console.model.AsUserNumLim;

public interface IAsUserNumLimService {
	
	List getAsUserNumLim(String userId, String compoId, String funcId, String ctrlField);

	int deleteAsUserNumLim(String userId, String compoId, String funcId, String ctrlField);
	
	AsUserNumLim insertAsUserNumLim(AsUserNumLim asUserNumLim);
	
	AsUserNumLim updateAsUserNumLim(AsUserNumLim asUserNumLim);
	
  public String getNumLimCondByCoType(String numLimCompoId, String funcId);
  
  public String getNumLimCondByCoType(String numLimCompoId, String funcId, String ctrlField) ;

  public String getNumLimCondByCoType(String numLimCompoId, String funcId, String ctrlField,
    boolean isTableContainCoCode) ;
  
  public String getNumLimCondByCoType(String numLimCompoId, String funcId, boolean isTableContainCoCode);
  
}
