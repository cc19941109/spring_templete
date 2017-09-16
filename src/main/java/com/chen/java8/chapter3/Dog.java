package com.chen.java8.chapter3;

@FunctionalInterface
public interface Dog {
	public void run();
	default public void eat(){
		System.out.println("eat meat....");
	}
}
