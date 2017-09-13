package com.chen.IOTest;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Test {
	static class HeapOOM{
		
	}
	
	private int length = 1;
	public void stackLeak(){
		length++;
		stackLeak();
	}
	
	public static void main(String[] args) {

		String s1 = "a";
		String s2 = new String("a");
		System.out.println(s1 == s2);
		System.out.println(s2.intern() == s1);
	
		System.out.println(s2.intern() == s1.intern());
		
		Test test = new Test();
		try {
			test.stackLeak();
		} catch (Throwable e) {
			System.out.println("stack length :"+test.length);
			throw e;
			
		}
		
	}
}
