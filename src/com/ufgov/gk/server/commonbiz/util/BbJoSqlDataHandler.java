package com.ufgov.gk.server.commonbiz.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.josql.Query;
import org.josql.QueryResults;

import com.ufgov.gk.common.system.exception.BusinessException;
import com.ufgov.gk.common.system.exception.JoSqlDataHandleException;

public class BbJoSqlDataHandler {

	/**
	 * 分组项可以包含函数如subStr,min等
	 * 
	 * @param pojoList
	 * @param clazz
	 * @param items
	 * @return
	 * @throws BusinessException
	 */
	public static Map getGroupPojo(List pojoList, Class clazz, List items)
			throws BusinessException {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select * from ");
		buffer.append(" " + clazz.getName() + " ");
		if (items == null) {
			items = new ArrayList();
		}
		String groupByStr = "";
		for (int i = 0; i < items.size(); i++) {
			String item = (String) items.get(i);
			groupByStr += "," + item;
		}
		groupByStr = groupByStr.length() == 0 ? groupByStr : groupByStr
				.substring(1);
		if (groupByStr.length() > 0) {
			buffer.append(" group by " + groupByStr);
		}
		Query query = new Query();
		try {
			query.parse(buffer.toString());
			QueryResults results = query.execute(pojoList);
			return results.getGroupByResults();
		} catch (Exception ex) {
			throw new JoSqlDataHandleException(ex);
		}
	}

}
