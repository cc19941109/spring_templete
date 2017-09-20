package com.chen.java8.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class LocalDateTimeTest {

	public static void main(String[] args) {
		LocalDateTimeTest localDateTimeTest = new LocalDateTimeTest();
		localDateTimeTest.test3();
	}

	public void test3(){
		LocalDate initialDate = LocalDate.parse("2017-07-20");
		LocalDate finalDate   = initialDate.plus(Period.ofMonths(2));
		System.out.println("初始化日期: " + initialDate);
		System.out.println("加日期之后: " + finalDate);
		
		long between = ChronoUnit.DAYS.between(initialDate, finalDate);
		System.out.println("差距天数: " + between);

	}
	
	
	public void test1() {
		LocalDateTime now = LocalDateTime.now();
		System.out.println("现在: " + now);

		LocalDateTime time1 = LocalDateTime.parse("2017-07-20T15:18:00");
		System.out.println(time1);
		
		LocalDateTime time2 = LocalDateTime.of(2017, Month.JULY, 20, 15, 18);
//		LocalDateTime time2 = LocalDateTime.of(2017,7, 20, 15, 18);

		System.out.println(time2);
		
	}
	
	public void test2(){
		LocalDateTime now = LocalDateTime.now();
//		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
		DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yy-MM-dd");

		
		System.out.println("默认格式化: " + now);
		System.out.println("自定义格式化: " + now.format(dateTimeFormatter));
		LocalDateTime localDateTime = LocalDateTime.parse("2017.07.20 15:27:44", dateTimeFormatter);
		String today = LocalDateTime.now().format(dateTimeFormatter2);
		System.out.println("today : "+today);
		System.out.println("字符串转LocalDateTime: " + localDateTime);
	}
}
