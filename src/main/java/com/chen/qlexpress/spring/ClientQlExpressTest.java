package com.chen.qlexpress.spring;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.ListOrderedMap;

public class ClientQlExpressTest {

	/**
	 * 
	 * @param idList
	 * @param text
	 * @param resultMap
	 * @throws Exception 
	 */
	public void run(List<Long> idList, String text, ListOrderedMap resultMap) throws Exception {

		QlExpressUtil qlExpressUtil = new QlExpressUtil();

		String statement = "2*23" ;
		
		for (Long id : idList) {

			Map<String, Object> innerContext = new HashMap<String, Object>();

			innerContext.put("id", id);

			Object result = qlExpressUtil.execute(statement, innerContext);

			resultMap.put(id, result);

		}

	}

}