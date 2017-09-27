package com.chen.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class TimeUtil {

	public static Date convertToDate(LocalDate localDate) {
		
		Instant instant = localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
		
		return Date.from(instant);
	}

	public static LocalDate convertToLocalDate(Date date) {

		Instant instant = date.toInstant();
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

		return localDateTime.toLocalDate();

	}

}
