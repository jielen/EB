package com.ufgov.gk.server.commonbiz.dao;

import java.util.List;

import com.ufgov.gk.common.commonbiz.model.Project;
import com.ufgov.gk.common.system.dto.ElementConditionDto;

public interface IProjectDao {

  List getRootProject(int nd);

  List getChildrenProject(int nd);

  List getProject(int nd);

  List getProject(ElementConditionDto dto);

  List getProjectBiXJ(int nd);

  List getProjectDetail();

  List getProjectBalance();

  List getPdProject(int nd);

  void insertForProject(Project project);

  void updateForProject(Project project);

  void deletePdProject(List dList);

  List getProjectByCode(String pCode);

  void updateBiProject(List uList);

  void insertBiProject(List iList);

  void deleteProject(List idList);
  
  
  boolean codeExist(Project project);
  
  boolean nameExist(Project project);
  
  /**
   * ����ǰcode��Ӧname��� �Ƿ��ظ�
   * @param nd
   * @param currentCode
   * @return
   */
  boolean nameExistSelfExcluded(Project project);
  
  boolean projectUsed(Project project);
  
  void deleteProjectWithChildren(Project project);

}
