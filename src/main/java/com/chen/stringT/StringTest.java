package com.chen.stringT;

public class StringTest {
	
	public static void main(String[] args) {
		
		// \d 表示0-9的数字
		System.out.println("5678".matches("-?\\d+"));
		System.out.println("+911".matches("(-|\\+)?\\d+"));
		
	}
}
