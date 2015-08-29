package com.ufgov.gk.common.system.util;


public class LevelControlUtil {

  /**
   * 
   * @param elementCodeTemplate �磺3-2-2
   * @param ctrLevelNum ���Ƽ���
   * @return ���Ƴ���
   */
  public static int getCtrLength(String elementCodeTemplate,int ctrLevelNum){
    int len = 0;
    if (elementCodeTemplate != null && !elementCodeTemplate.trim().equals("")) {
      String[] nums = elementCodeTemplate.split("-");
      for (int i = 0; i < nums.length && (i + 1) <= ctrLevelNum; i++) {
        len += Integer.parseInt(nums[i]);
      }
    }
    return len;
  }
}
