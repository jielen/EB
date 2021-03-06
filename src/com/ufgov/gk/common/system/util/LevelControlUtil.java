package com.ufgov.gk.common.system.util;


public class LevelControlUtil {

  /**
   * 
   * @param elementCodeTemplate 如：3-2-2
   * @param ctrLevelNum 控制级数
   * @return 控制长度
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
