package com.chen.java8.time;

import java.time.LocalDate;
import java.time.LocalTime;

public class LocalTimeTest {

	public static void main(String[] args) {

		LocalTimeTest localDateTest = new LocalTimeTest();
		localDateTest.testMax();
		boolean isBefore = LocalTime.now().isBefore(LocalTime.now());
		System.out.println(isBefore);
	}

	public void test1() {
		LocalTime now = LocalTime.now();
		System.out.println("现在的时间: " + now);

		LocalTime nowTime = LocalTime.parse("15:02");
		System.out.println("时间是: " + nowTime);

		LocalTime nowTime1 = LocalTime.of(15, 02);
		System.out.println("时间是: " + nowTime1);

	}

	public void testDate() {
		LocalDate parse = LocalDate.parse("2017-07-20");
		System.out.println(parse);

	}

	public void testMax() {
		System.out.println(LocalTime.MAX);
		System.out.println(LocalTime.MIN);

	}
}
