package com.chen.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ClassMehodTest {
	
	public static void main(String[] args) {
		//不管是实现类还是子类都为true
		
		boolean s = List.class.isAssignableFrom(ArrayList.class);
		
		boolean t  = Collection.class.isAssignableFrom(List.class);
		System.out.println(s+"  "+t);
		
		
	}
}




