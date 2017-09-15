package com.chen.exp;

import java.util.List;
import java.util.Map;

public class SoloExpression {

	private long id;
	private String name;
	// 别名
	private String alias_name;
	private String description;

	// 表达式字符串
	private String expression;

	// 所需变量名
	private List<Object> names;

	// 表达式的值
	private String value;

	// 是否有效
	private boolean isVaild;

}
