package com.chen.formula.test;

import com.chen.formula.constant.RateEnum;

public class CorrespondPeriodUtil {
	public static void main(String[] args) {
		test1();
		int compareTo = RateEnum.City.compareTo(RateEnum.SubStation);
		System.out.println("compareTo: " + compareTo);
		RateEnum valueOf = RateEnum.valueOf("City");
		System.out.println(valueOf.ordinal());

	}

	public static void test1() {
		String name = RateEnum.City.name();
		System.out.println(name);
		RateEnum[] values = RateEnum.values();
		int length = values.length;
		System.out.println(length);
		for (RateEnum rateEnum : values) {
			String name2 = rateEnum.name();
			System.out.println(name2);
		}
	}
}
