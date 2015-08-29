package com.ufgov.gk.server.system.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.ufgov.gk.common.commonbiz.model.MaExpSerial;
import com.ufgov.gk.server.system.SpringContext;
import com.ufgov.gk.server.system.dao.IMaExpSerialDao;

public class ExpSerialUtil {

  private static final IMaExpSerialDao maExpSerialDao = (IMaExpSerialDao) SpringContext
    .getBean("maExpSerialDao");

  public static String getSerialNo(String date, String type, int nd, int serialLen) {
    Map params = new HashMap();
    params.put(MaExpSerial.EXP_DATE, date);
    params.put(MaExpSerial.EXP_TYPE, type);
    params.put(MaExpSerial.EXP_ND, new BigDecimal(nd));

    MaExpSerial result = maExpSerialDao.getMaExpSerial(params);
    MaExpSerial temp = new MaExpSerial();
    if (result != null) {
      temp.setExpDate(result.getExpDate());
      temp.setExpType(result.getExpType());
      temp.setNd(result.getNd());
      BigDecimal serial = new BigDecimal(1);
      serial = serial.add(result.getSerial());
      temp.setSerial(serial);
      maExpSerialDao.updateMaExpSerial(temp);
    } else {
      String expDate = (String) params.get(MaExpSerial.EXP_DATE);
      String expType = (String) params.get(MaExpSerial.EXP_TYPE);
      temp.setExpDate(expDate);
      temp.setExpType(expType);
      temp.setSerialLen(new BigDecimal(serialLen));
      temp.setNd(new BigDecimal(nd));
      temp.setSerial(new BigDecimal(2));
      maExpSerialDao.insertMaExpSerial(temp);
      temp.setSerial(new BigDecimal(1));
      result = temp;
    }

    String pad = result.getPadMark();
    pad = pad == null ? "0" : pad;

    String serialNo = result.getSerial().intValue() + "";
    if (result.getSerialLen().intValue() > 0) {
      int fillLen = result.getSerialLen().intValue() - serialNo.length();
      if (fillLen > 0) {
        for (int i = 0; i < fillLen; i++) {
          serialNo = pad + serialNo;
        }
      }
    }
    return serialNo;

  }

}
