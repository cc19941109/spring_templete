package com.chen.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ClassMehodTest {
	
	public static void main(String[] args) {
		//������ʵ���໹�����඼Ϊtrue
		
		boolean s = List.class.isAssignableFrom(ArrayList.class);
		
		boolean t  = Collection.class.isAssignableFrom(List.class);
		System.out.println(s+"  "+t);
		
		
	}
}




