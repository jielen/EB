package com.ufgov.gk.server.system.util;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import com.ufgov.gk.common.commonbiz.fieldmap.FieldMapRegister;
import com.ufgov.gk.common.commonbiz.model.BaseBill;
import com.ufgov.gk.common.system.model.AsCompo;
import com.ufgov.gk.common.system.model.AsNoRule;
import com.ufgov.gk.common.system.model.AsNoRuleSeg;
import com.ufgov.gk.common.system.util.DateUtil;
import com.ufgov.gk.common.system.util.StringTools;
import com.ufgov.gk.server.commonbiz.dao.INumDao;
import com.ufgov.gk.server.system.SpringContext;
import com.ufgov.gk.server.system.dao.IAsCompoDao;

public class AutoNum {

	private IAsCompoDao asCompoDao = (IAsCompoDao) SpringContext
			.getBean("asCompoDao");

	private INumDao numDao = (INumDao) SpringContext.getBean("numDao");

	private String compoId = null;

	private String prefixCompo = null;

	private String masterTableId = null;

	private String noFieldName = null;

	private String ruleCode = null;

	private boolean isCont = false;

	private String preFix = null;

	private int indexLen = 0;

	private String isFillZero = null;

	private  AutoNum() {
	}
	
	
	public static String  genNum(String compoId, BaseBill bill){
	  return  new AutoNum().getNum(compoId, bill);
	}

	/**
	 * 调用的时候要保证getNum包含在事务里
	 * 
	 * @param compoId
	 * @param bill
	 * @return
	 */
	private  String getNum(String compoId, BaseBill bill) {
		initialize(compoId);

		String segPreFix = getSegPreFix(bill);
		String counterPreFix = getCounterPreFix(bill, segPreFix);

		lockCounter(counterPreFix);
		String serNum = String.valueOf(getSerialNumber(counterPreFix));
		if (this.isFillZero.equalsIgnoreCase("Y")) {
			int serNumLen = serNum.length();
			if (indexLen > serNum.length()) {
				for (int i = 0; i < indexLen - serNumLen; i++) {
					serNum = "0" + serNum;
				}
			}
		}
		return preFix + segPreFix + serNum;
	}

	/**
	 * 由部件ID，数据包获得自动编号
	 * 
	 * @param compoId
	 *            部件ID
	 * @param typeField -
	 * @param typeTable -
	 * @param entity
	 * 
	 * @return num 编号
	 * @deprecated {@link #getNum(String, String, String, BaseBill)}
	 */
	public String getNum(String compoId, String typeField, String typeTable,
			BaseBill entity) {
		return getNum(compoId, entity);
	}

	/**
	 * 返回数据库里的计数器前缀
	 * 
	 * @param entity
	 * @param segNum
	 * @return
	 */
	private String getCounterPreFix(BaseBill entity, String segNum) {
		String counterPreFix = null;
		if (isCont) {
			counterPreFix = "noPreFix";
		} else {
			counterPreFix = getAppPreFix(entity) + preFix + segNum;
			if (counterPreFix == null || counterPreFix.equals("")) {
				counterPreFix = "noPreFix";
			}
		}
		return counterPreFix;
	}

	private void initialize(String compoId) {
		this.compoId = compoId;
		initTableAndNoField();
		initRule();
	}

	private void initRule() {

		AsNoRule asNoRule = numDao.getAsNoRuleByCompoId(compoId);
		this.ruleCode = asNoRule.getRuleCode();
		String isContS = asNoRule.getIsCont();
		this.isCont = (isContS != null && isContS.equalsIgnoreCase("Y"));
		this.indexLen = asNoRule.getNoIndexLen().intValue();
		this.preFix = asNoRule.getNoPrefix();
		this.isFillZero = asNoRule.getIsFillZero();
		if (this.preFix == null) {
			this.preFix = "";
		}

	}

	/**
	 * 获得中间段
	 * 
	 * @param compoId
	 *            部件编码
	 * @param ruleCode
	 *            编码规则
	 * @param entity
	 *            TableData数据包
	 * @return segmentNumber
	 */
	private String getSegPreFix(BaseBill bill) {
		StringBuffer result = new StringBuffer();
		List ruleSegList = numDao.getAsNoRuleSeg(compoId, ruleCode);
		for (int n = 0; n < ruleSegList.size(); n++) {
			AsNoRuleSeg ruleSeg = (AsNoRuleSeg) ruleSegList.get(n);
			String segDeli = ruleSeg.getSegDeli();
			if (segDeli == null) {
				segDeli = "";
			}

			String segField = ruleSeg.getSegField();
			Object fieldValue = null;
			if (segField != null && segField.length() > 0) {
				fieldValue = bill.get((String) FieldMapRegister.get(
						bill.getClass()).get(segField));
			}

			String datFmt = ruleSeg.getDateFmt();
			 int segLen =0;
			if(ruleSeg.getSegLen()!=null){
			  segLen = ruleSeg.getSegLen().intValue();
			}
			
			String segPosi = ruleSeg.getSegFillPosi();
			String segFill = ruleSeg.getSegFill();
			// 需要判断segField的数据类型
			if (fieldValue instanceof java.util.Date) {
				fieldValue = transDate(DateUtil
						.dateToDdString((Date) fieldValue), datFmt);
			} else {
				if (fieldValue.toString().length() < segLen) {
					String sf = "";
					for (int i = 0; i < segLen - fieldValue.toString().length(); i++) {
						sf = sf + (null == segFill ? "" : segFill);
					}
					if ("1".equals(segPosi)) {
						fieldValue = sf + fieldValue;
					} else {
						fieldValue = fieldValue + sf;
					}
				}
			}
			if (fieldValue == null) {
				fieldValue = "";
			}
			result.append(fieldValue + segDeli);
		}

		return result.toString();
	}

	private void lockCounter(String prefix) {
		int rows = numDao.updateAsNo(prefixCompo, prefix);
		if (rows == 0) {
			numDao.insertAsNo(prefixCompo, prefix);
		}
	}

	/**
	 * 获得自动编号字段的最大号
	 * 
	 * @param compoId
	 *            String
	 * @param fixSegs
	 *            String
	 * @return long
	 */
	private long getSerialNumber(String fixSegs) {
		return numDao.getAsNoCurIndex(prefixCompo, fixSegs).longValue();
	}

	/**
	 * 把日期转换成指定格式的字符串
	 * 
	 * @param d
	 *            日期
	 * @param dateStr
	 *            日期格式
	 * @return dateStr 日期字符串
	 */
	private String transDate(String d, String dateStr) {
		if (d != null && dateStr != null) {

			String yearStr = "";
			String simpleYearStr = "";

			String monthStr = "";
			String simpleMonthStr = "";

			String dayStr = "";
			String simpleDayStr = "";

			Vector vecDate = StringTools.splitToVector("-", d);// cp.split("-",
																// d);
			if (vecDate != null && vecDate.size() > 0) {
				yearStr = vecDate.elementAt(0).toString();
				simpleMonthStr = vecDate.elementAt(1).toString();
				simpleDayStr = vecDate.elementAt(2).toString();
			}

			if (yearStr.length() > 3) {
				simpleYearStr = yearStr.substring(2);
			} else {
				simpleYearStr = yearStr;
			}

			if (simpleMonthStr.length() < 2) {
				monthStr = "0" + simpleMonthStr;
			} else {
				monthStr = simpleMonthStr;
			}

			if (simpleDayStr.length() < 2) {
				dayStr = "0" + simpleDayStr;
			} else {
				dayStr = simpleDayStr;
			}

			if (dateStr.indexOf("YYYY") > -1) {
				dateStr = StringTools.replaceText(dateStr, "YYYY", yearStr);
			} else if (dateStr.indexOf("YY") > -1) {
				dateStr = StringTools.replaceText(dateStr, "YY", simpleYearStr);
			}

			if (dateStr.indexOf("MM") > -1) {
				dateStr = StringTools.replaceText(dateStr, "MM", monthStr);
			} else if (dateStr.indexOf("M") > -1) {
				dateStr = StringTools.replaceText(dateStr, "M", simpleMonthStr);
			}

			if (dateStr.indexOf("DD") > -1) {
				dateStr = StringTools.replaceText(dateStr, "DD", dayStr);
			} else if (dateStr.indexOf("D") > -1) {
				dateStr = StringTools.replaceText(dateStr, "DD", simpleDayStr);
			}
		}
		if (dateStr == null) {
			dateStr = d;
		}
		return dateStr;
	}

	/**
	 * 如果是在部件表里描述的自动编号字段，把除编号字段之外的其它主键值串联起来在 加上“_APP_”作为前缀
	 * 
	 * @param compoId
	 * @param entity
	 * @return
	 */
	private String getAppPreFix(BaseBill entity) {
		StringBuffer result = new StringBuffer();
		return result.toString();
	}

	private void initTableAndNoField() {
		AsCompo asCompo = asCompoDao.getAsCompo(compoId);
		prefixCompo = asCompo.getMasterTabId() + asCompo.getNoField();
		masterTableId = asCompo.getMasterTabId();
		noFieldName = asCompo.getNoField();
	}


}
