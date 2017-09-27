package com.chen.java8.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class ConvertDate {
	public static void main(String[] args) {
		
		
		Date today = new Date();
		LocalDate day = LocalDateTime.ofInstant(today.toInstant(), ZoneId.systemDefault()).toLocalDate();
		
	    LocalDateTime localDateTime =day.atStartOfDay();
		Instant instant = localDateTime .atZone(ZoneId.systemDefault()).toInstant();
		Date date = Date.from(instant);
		System.out.println(date);
	}
}
