package com.ufgov.gk.server.system.util;

import java.util.List;

import com.ufgov.gk.common.commonbiz.model.BaseBill;

public class BillDBDigestUtil {
  
  public static void setBillDBDigest(List billList){
    for(int i=0;i<billList.size();i++){
      BaseBill bill=(BaseBill)billList.get(i);
      bill.setDbDigest(bill.digest());
    }
  }

}
