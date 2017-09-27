package com.chen.java8.chapter5;

import java.util.stream.Stream;

public class IterateTest {
	public static void main(String[] args) {
		testIterate();
		testGenerate();
	}
	
	
	public static void testGenerate(){
		
		Stream.generate(Math::random).limit(10).forEach(System.out::println);
		
	}
	
	public static void testIterate(){
		Stream.iterate(new int[]{0,1}, t->new int[]{t[1],t[0]+t[1]}).skip(10).limit(10).forEach(t->System.out.println(t[0]+"  "+t[1]));
		
	}
}
