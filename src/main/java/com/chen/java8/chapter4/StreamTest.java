package com.chen.java8.chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.chen.java8.chapter1.Apple;
import com.chen.java8.utils.ListUtils;

public class StreamTest {
	
	public static void main(String[] args) {
		
		List<Dish> dishes = Dish.menu;
		List<String> filterDishes = dishes.stream().filter(d->d.getCalories()>300)
			.map(Dish::getName)
			.limit(3)
			.collect(Collectors.toList());
		
//		ListUtils.forEach(filterDishes, System.out::println);
		
		Stream<String> stream1 = dishes.stream().map(Dish::getName).distinct().skip(1);
		stream1.forEach(System.out::println);
//		stream1.forEach(System.out::println);

		List<String> words = new ArrayList<>();
		words.add("hello");
		words.add("world");
		
		Stream<Stream<String>> ss =   words.parallelStream().map(w->w.split("")).map(Arrays::stream).distinct();
		Stream<String> ss1 =   words.parallelStream().map(w->w.split("")).flatMap(Arrays::stream).distinct();
		ss1.forEach(System.out::println);
			
	}
	
}	
