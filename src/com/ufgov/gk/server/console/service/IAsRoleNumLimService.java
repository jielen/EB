package com.ufgov.gk.server.console.service;

import java.util.List;

import com.ufgov.gk.common.console.model.AsRoleNumLim;

public interface IAsRoleNumLimService {

	List getAsRoleNumLim(String roleId, String compoId, String funcId, String ctrlField);

	int deleteAsRoleNumLim(String roleId, String compoId, String funcId, String ctrlField);

	AsRoleNumLim insertAsRoleNumLim(AsRoleNumLim asRoleNumLim);

	AsRoleNumLim updateAsRoleNumLim(AsRoleNumLim asRoleNumLim);

	List getAsRoleNumLimByUserId(String userId, String compoId, String funcId, String ctrlField);

	List getAsGrantRoleNumLimByUserId(String userId, String compoId, String funcId, String ctrlField);
}
