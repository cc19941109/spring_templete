package com.chen.exp;

public class FormulaManager {

	// 单位:按照每天计算还是每周,每年
	private Unit unit;

	// 提供所需要计算的案情类别数据
	private CateManager cateManager;

	// 提供所需派出所的数据
	private PCSManager pcsManager;

	// 提供所需要的相对时间数据,比如我需要计算准则值,则需要过去三年这一天的数据,要把哪些天放在这里
	private TimeManager timeManager;

	// 这个是单个表达式的计算公式,比如一天中某类案件 的积分值: 数量 乘 类别积分
	private SoloExpression expression;

	// 对于单个表达式的统计,比如计算总和还是计算平均,最大值,最小值..,可能还会出现一些if else
	// 结构的(我想的是用三元运算符),所以这个表达式解析必须足够强大
	private SoloExpression statistic;

}
