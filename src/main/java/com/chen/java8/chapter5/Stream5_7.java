package com.chen.java8.chapter5;


import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream5_7 {

	public static void main(String[] args) {
		testStreamof();

	}

	public void testArrayStream(){
		int[] nums = {1,2,3,5,7,3423,141};
		IntStream stream = Arrays.stream(nums);
		
		Stream<Integer> stream2 = Stream.of(1,2,3,4,6);
		IntStream intStream = stream2.mapToInt(Integer::intValue);
		IntStream intStream2 = stream2.mapToInt(x->x);

		Stream<Integer> stream3  = intStream.mapToObj(x->x);
		
		
	}
	
	
	public void testEmptyStream() {
		Stream<Integer> empty = Stream.empty();

	}

	public static void testStreamof() {
		Stream<String> stream = Stream.of("hello", "world", "!");
		stream.map(String::toUpperCase).forEach(System.out::println);
	}
}
