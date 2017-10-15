package com.chen.formula.dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.chen.formula.constant.IndexEnum;
import com.chen.formula.constant.RateEnum;
import com.chen.formula.constant.TimeEnum;

/**
 * 
 * 指数查询 Dto
 * 
 * @author chencheng
 *
 */
public class SearchDto {

	// 行政等级
	private RateEnum rateEnum;

	// 时间口径
	private TimeEnum timeEnum;

	// 指数类型
	private IndexEnum indexEnum;

	// 案件类别ID
	private long caseId;

	// 具体派出所code
	private long pcsCode;

	// 日期
	private LocalDate date;

	// 查询时间
	private Date searchTime;

}
