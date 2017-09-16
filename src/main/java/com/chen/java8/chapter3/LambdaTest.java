package com.chen.java8.chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import com.chen.java8.chapter1.Apple;

public class LambdaTest {
	
	public static void main(String[] args) {
		List<Apple> apples = new Apple().getApples();
		
		List<Apple> aList = LambdaTest.filter(apples, (Apple a)-> a.getWeight()>100);
		System.out.println("test ..");
		LambdaTest.forEach(aList, (Apple a)->System.out.println(a));
		List<Integer> nums = get(Arrays.asList("dasd","dada2rewq","dar21v","das"),(String s)->s.length());
		LambdaTest.forEach(nums, (Integer i )->System.out.println(i));
	}
	
	public static <T> List<T> filter(List<T> list,Predicate<T> p){
		
		List<T> result = new ArrayList<>();
		for(T s:list){
			if(p.test(s)){
				result.add(s);
			}
		}
		return result ;
		
	}
	
	public static <T> void forEach(List<T> list,Consumer<T> c){
		for (T t : list) {
			c.accept(t);
		}
		
	}
	
	public static <T,R> List<R> get(List<T> list,Function<T,R> f){
		
		List<R> result = new ArrayList<>();
		for(T s:list){
			result.add(f.apply(s));
		}
		return result;
	}
	
}



