package com.chen.formula.service;


import java.util.Map;

import com.chen.formula.domain.FormulaDomain;


public interface ExpressService {
	
	
	/**
	 * 
	 * @param administrateId
	 * @param timeId
	 * @return
	 */
	Map<String, Double> getContent(long administrateId,long timeId);
	/**
	 * 
	 * @param values
	 * @param formula
	 * @return
	 */
	double calculate(Map<String , Double> values,FormulaDomain formula);
	
	
}
