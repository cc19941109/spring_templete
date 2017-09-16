package com.chen.java8.chapter3;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class TestBoxing {
	
	public static void main(String[] args) {
		Predicate<Integer> predicate = i->i%2==0;
		boolean isOU = predicate.test(1000);
		System.out.println(isOU);
		
		
	}
}	
