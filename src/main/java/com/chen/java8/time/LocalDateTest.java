package com.chen.java8.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.MonthDay;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalUnit;

public class LocalDateTest {

	public static void main(String[] args) {

		LocalDate today = LocalDate.now();
		LocalDate longlongage = today.minusDays(1);
		LocalDate testMin = today.minus(1, ChronoUnit.MONTHS).minus(1,ChronoUnit.DAYS).plus(1, ChronoUnit.YEARS);
		DayOfWeek dayOfWeek = testMin.getDayOfWeek();
		System.out.println(dayOfWeek);
		System.out.println(testMin);
		boolean after = testMin.isAfter(today);
		System.out.println(after);
	}

	public void test3() {
		LocalDate firstDayOfMonth = LocalDate.parse("2017-07-20").with(TemporalAdjusters.firstDayOfMonth());
		System.out.println("这个月的第一天: " + firstDayOfMonth);
		firstDayOfMonth = firstDayOfMonth.withDayOfMonth(2);
		System.out.println("这个月的第二天: " + firstDayOfMonth);

		LocalDate birthday = LocalDate.of(2009, 07, 20);
		MonthDay birthdayMd = MonthDay.of(birthday.getMonth(), birthday.getDayOfMonth());
		System.out.println("monthDay:" + birthdayMd);
		MonthDay today = MonthDay.from(LocalDate.now());
		System.out.println(today);
		System.out.println("今天是否是我的生日: " + today.equals(birthdayMd));

	}

	public void test2() {

		DayOfWeek thursday = LocalDate.parse("2017-07-20").getDayOfWeek();
		System.out.println("周四: " + thursday);
		int twenty = LocalDate.parse("2017-07-20").getDayOfMonth();
		System.out.println("twenty: " + twenty);

		boolean leapYear = LocalDate.now().isLeapYear();
		System.out.println("是否闰年: " + leapYear);

		boolean notBefore = LocalDate.parse("2017-07-20").isBefore(LocalDate.parse("2017-07-22"));
		System.out.println("isBefore: " + notBefore);
		boolean isAfter = LocalDate.parse("2017-07-20").isAfter(LocalDate.parse("2017-07-22"));
		System.out.println("isAfter: " + isAfter);

	}

	public void test1() {
		LocalDate localDate = LocalDate.now();
		System.out.println("localDate: " + localDate);

		LocalDate t1 = LocalDate.of(2017, 07, 20);
		System.out.println("t1:" + t1);
		LocalDate t2 = LocalDate.parse("2017-07-20");
		System.out.println(t2);
		LocalDate tomorrow = t1.plusDays(1);

		System.out.println("tomorrow:" + tomorrow);

		LocalDate prevMonth = LocalDate.now().minus(1, ChronoUnit.MONTHS);

		System.out.println(prevMonth);
	}

}
