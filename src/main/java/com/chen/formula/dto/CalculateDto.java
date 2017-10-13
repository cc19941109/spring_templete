package com.chen.formula.dto;


import java.util.Map;

import com.chen.formula.domain.FormulaDomain;


public class CalculateDto {
	
	private FormulaDomain formulaDomain;
	private Map<String, Double> values;
	
	//是否已经完成
	private boolean isFinished;	
	
	
}
