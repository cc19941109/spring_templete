package com.chen.java8.chapter5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.codehaus.jackson.map.util.Comparators;

public class Reducing {
	public static void main(String[] args) {
		
		List<Integer> list1  = Arrays.asList(1,2,3,4,5,6,7);
		Integer sum = list1.stream().reduce(0, Integer::sum);
		System.out.println(sum);
		Integer mul = list1.stream().reduce(1, (a,b)->a*b);
		System.out.println(mul);
		Integer x=  list1.stream().reduce((a,b)->a*b).get();
		System.out.println("x = "+x);
		Integer max = list1.stream().reduce(Integer::max).get();
		System.out.println("max: "+max);	
		
	}
	
	
	public static void print(Stream stream){
		stream.forEach(System.out::println);
		
	}
}
