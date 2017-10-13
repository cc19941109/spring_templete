package com.chen.formula.dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class SearchDto {

	// 案件类别ID
	private long caseId;

	// 具体行政ID,可以查到行政等级,和具体的下属派出所
	private long administrateId;

	// 时间段
	private LocalDate from;
	private LocalDate to;
	private long timeId;

	// 查询时间
	private Date searchTime;

}
