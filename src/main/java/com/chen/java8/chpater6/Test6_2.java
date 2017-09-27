package com.chen.java8.chpater6;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.chen.java8.chapter4.Dish;

public class Test6_2 {

	public static void main(String[] args) {

		List<Dish> list = Dish.menu;
		testJoining();
		testSummarizingInt();
		testSummingInt();
		testMaxBy();
	}
	
	public static void testJoining() {
		List<Dish> list = Dish.menu;
		String collect = list.stream().map(Dish::getName).collect(Collectors.joining(", "));
		System.out.println(collect);
		
		
	}
	

	public static void testSummarizingInt() {
		
		List<Dish> list = Dish.menu;
		IntSummaryStatistics summaryStatistics = list.stream().collect(Collectors.summarizingInt(Dish::getCalories));
		System.out.println(summaryStatistics);
	}
	
	public static void testSummingInt() {

		List<Dish> list = Dish.menu;
		Integer sum = list.stream().collect(Collectors.summingInt(Dish::getCalories));
		System.out.println(sum);
	}

	public static void testCount() {

		List<Dish> list = Dish.menu;

		Stream<Dish> dishes1 = list.stream();
		Long count = dishes1.collect(Collectors.counting());
		System.out.println(count);
	}

	public static void testMaxBy() {

		List<Dish> list = Dish.menu;

		Stream<Dish> dishes2 = list.stream();
		Optional<Dish> optional1 = dishes2.collect(Collectors.maxBy(Comparator.comparing(Dish::getCalories)));
		System.out.println(optional1.orElse(null));

	}

}
