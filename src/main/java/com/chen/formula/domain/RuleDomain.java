package com.chen.formula.domain;


import java.util.Date;
import java.util.List;

import com.chen.formula.constant.TimeEnum;


public class RuleDomain {

	private String id;
	private String name;
	private String alias;

	// 值
	private double value;

	// 行政级别id
	private long administrateId;
	
	// 时间统计口径
	private TimeEnum timeLevel;


}
