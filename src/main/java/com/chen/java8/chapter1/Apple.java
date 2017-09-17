package com.chen.java8.chapter1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.chen.java8.chapter3.LambdaTest;

public class Apple {

	private String name;
	private Integer weight;
	private String color;

	public Apple() {
	}

	public Apple(Integer weight) {
		this.weight = weight;
	}

	public Apple(String name, Integer weight) {
		this.name = name;
		this.weight = weight;
	}

	public Apple(String name, Integer weight, String color) {
		super();
		this.name = name;
		this.weight = weight;
		this.color = color;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Apple [name=" + name + ", weight=" + weight + ", color=" + color + "]";
	}

	public static boolean isGreenApple(Apple apple) {
		return "green".equals(apple.getColor());
	}

	public static boolean isHeavyApple(Apple apple) {
		return apple.getWeight() > 150;
	}

	public List<Apple> getApples() {
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
		return apples;
	}
	
	public static void ApplesToString(List<Apple> apples){
		Apple.forEach(apples, (Apple a)->System.out.println(a));
	}
	
	private static <T> void forEach(List<T> list,Consumer<T> c){
		for (T t : list) {
			c.accept(t);
		}
	}
	
	
}
