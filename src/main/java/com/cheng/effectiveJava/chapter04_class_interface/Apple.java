package com.cheng.effectiveJava.chapter04_class_interface;

/**
 * P68
 * 使用私有的构造方法,用public的静态工厂方法取代构造器,
 * 
 * 
 * @author chencheng
 *
 */

public class Apple {

	private final Integer size;

	private Apple(Integer size) {
		this.size = size;
	}
	
	public static Apple getAppleBySize(Integer size){
		return new Apple(size);
	}
	
	public static Apple getAppleByHigh(Integer high){
		return new Apple(high*high);
	}

	
}
