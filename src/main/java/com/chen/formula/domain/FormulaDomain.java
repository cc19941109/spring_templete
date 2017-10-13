package com.chen.formula.domain;


import java.util.Date;
import java.util.List;

import com.chen.formula.constant.TimeEnum;


/**
 * 计算公式
 * 
 * @author chengchen2
 *
 */
public class FormulaDomain {

	private Long id;
	private String name;
	// 别名
	private String alias;

	// 公式
	private String expression;

	// 行政级别id
	private long administrateId;
	
	// 时间统计口径 
	private TimeEnum timeLevel;

	// 是否为最后一个
	private boolean isFinal;
	
	
	
	// JQ_Category 案件类别集合
	// private List<Integer> categories;

	// 时间day
	// private String day;

}
