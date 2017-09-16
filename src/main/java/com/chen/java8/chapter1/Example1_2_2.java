package com.chen.java8.chapter1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;


public class Example1_2_2 {

	public static void main(String[] args) {
		List<Apple> apples = new ArrayList<>();
		apples.add(new Apple("apple1", 170, "red"));
		apples.add(new Apple("apple2", 160, "green"));
		apples.add(new Apple("apple3", 120, "red"));
		apples.add(new Apple("apple4", 200, "red"));
		apples.add(new Apple("apple5", 210, "green"));
		apples.add(new Apple("apple6", 420, "red"));
		apples.add(new Apple("apple7", 120, "green"));
		apples.add(new Apple("apple8", 140, "green"));
		apples.add(new Apple("apple9", 160, "red"));
		System.out.println("test success " + apples.size());

		List<Apple> list = filterApples(apples, Apple::isGreenApple);
		List<Apple> list1 =apples.parallelStream().filter(Apple::isGreenApple ).collect(Collectors.toList());
//		List<Apple> list2 = filterApples(apples, (Apple a) -> "green".equals(a.getColor()) && a.getWeight() >= 140);
		List<Apple> list3 = filterApples(apples, (Apple a) -> a.getWeight() < 200 || "green".equals(a.getColor()));
		List<Apple> list4 =apples.stream().filter((Apple a) -> a.getWeight() < 200 ).collect(Collectors.toList());
		List<Apple> list5 =apples.parallelStream().filter((Apple a) -> a.getWeight() < 200 ).collect(Collectors.toList());
		Thread thread = new Thread(() -> System.out.println("hello world!"+Thread.currentThread().getName()));
		thread.start();
//		Comparator<Apple> byWeight = (Apple a1,Apple a2)->a1.getWeight().compareTo(a2.getWeight());
//		list5.sort((Apple a1,Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
		
		List<Apple> inventory = apples;
        inventory.sort(new Comparator<Apple>() {
            public int compare(Apple a1, Apple a2){
                return a1.getWeight().compareTo(a2.getWeight()); 
        }});
		
		for (Apple apple : inventory) {
			System.out.println(apple+" in thread-"+Thread.currentThread().getName());
		}
		
		
		
	}
	
	static class AppleComparator implements Comparator<Apple> {
        public int compare(Apple a1, Apple a2){
            return a1.getWeight().compareTo(a2.getWeight());
        }
    }

	static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> predicate) {
		List<Apple> apples = new ArrayList<>();
		for (Apple apple : inventory) {
			if (predicate.test(apple)) {
				apples.add(apple);
			}
		}
		return apples;
	}
}
