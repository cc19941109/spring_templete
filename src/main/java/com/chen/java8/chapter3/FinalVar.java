package com.chen.java8.chapter3;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import com.chen.java8.chapter1.Apple;

public class FinalVar {
	// private int s = 10;

	public static void main(String[] args) {

		int var = 12;
		// var = 13;
		Runnable runnable = () -> System.out.println(var);
		runnable.run();

		Consumer<String> c = System.out::println;
		c.accept("casf");

		List<String> str = Arrays.asList("a", "b", "A", "B","a","C","c");
//		str.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
		str.sort(String::compareToIgnoreCase);
		LambdaTest.forEach(str, System.out::println);
		
		Supplier<Apple> c1 = Apple::new;
		Apple apple  = c1.get();
		
		Function<Integer, Apple> f1 = Apple::new;
		Apple apple2 = f1.apply(1213);
		System.out.println(apple2.getWeight());
		
		BiFunction<String, Integer, Apple> f = Apple::new;
		Apple apple3  = f.apply("chen", 120);
		System.out.println(apple3);
		
	}

}
