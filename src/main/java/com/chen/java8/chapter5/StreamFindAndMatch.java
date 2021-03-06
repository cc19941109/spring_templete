package com.chen.java8.chapter5;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import com.chen.java8.chapter4.Dish;
import com.chen.java8.chapter4.Dish.Type;

public class StreamFindAndMatch {

	public static void main(String[] args) {

		List<Dish> dishes = Dish.menu;
		System.out.println(dishes.stream().anyMatch(s->s.getName()=="rice"));
		System.out.println(dishes.stream().allMatch(s->s.getCalories()<1000));
		System.out.println(dishes.stream().noneMatch(s->s.getCalories()>1000));
		System.out.println(dishes.stream().findAny().get().toString());
		Dish dish = new Dish("meat", false, 3000, Type.MEAT);
		System.out.println(dishes.stream().filter(s->s.getCalories()>1000).findAny().orElse(dish));
		System.out.println(dishes.stream().findFirst());
		
		
		dishes.stream().sorted(Comparator.comparing(Dish::getCalories)).forEach(System.out::println);
		System.out.println("--------------------");
		Optional<Integer> sum = dishes.stream().map(Dish::getCalories).reduce(Integer::sum);
		System.out.println();
		
		
		OptionalInt s = dishes.stream().mapToInt(Dish::getCalories).max();
		
		System.out.println(s.orElse(2));
		
		
	}

}
