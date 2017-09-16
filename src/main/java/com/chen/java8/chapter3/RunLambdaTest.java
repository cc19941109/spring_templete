package com.chen.java8.chapter3;

public class RunLambdaTest {
	public static void main(String[] args) {
		Runnable r1 = () -> System.out.println("this is r1");
		Runnable r2 = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("this is r2");
			}
		};
		 
		process(r1);
		process(r2);
		process(()-> System.out.println("hello ...."));
	}
	
	public static void process(Runnable r){
		r.run();
	}
}
