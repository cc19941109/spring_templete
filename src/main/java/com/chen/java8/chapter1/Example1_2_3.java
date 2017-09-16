package com.chen.java8.chapter1;

import java.util.ArrayList;
import java.util.List;

public class Example1_2_3 {
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
		System.out.println("test success "+apples.size());
			
		
		
		
	}

}
