package com.chen.java8.chapter5;

import java.util.List;

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


	}

}
