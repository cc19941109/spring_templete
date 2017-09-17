package com.chen.java8.chapter3;

import java.util.List;
import java.util.function.Function;

import com.chen.java8.chapter1.Apple;

public class MulFunction {
	public static void main(String[] args) {
		List<Apple> apples = new Apple().getApples();
		Function<Integer, Integer> f1 = x -> x + 1;
		Function<Integer, Integer> f2 = x -> x * 2;
		Function<Integer, Integer> f3 = f1.andThen(f2);
		Function<Integer, Integer> f4 = f1.compose(f2);
		
		int result1 = f3.apply(2);
		System.out.println(result1);
		int result2 = f4.apply(2);
		System.out.println(result2);
		
		Function<String,String> addHeader = Letter::addHeader;
		Function<String,String> addFooter = Letter::addFooter;
		Function<String, String> mul = addHeader.andThen(addFooter);
		
		String result = mul.apply("\t  i am coming!");
		System.out.println(result);
	}
}
