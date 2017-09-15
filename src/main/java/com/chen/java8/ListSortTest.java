package com.chen.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListSortTest {
	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		list.add(12);
		list.add(23);
		list.add(20);
		list.add(42);
		list.add(30);
		list.sort(Comparator.naturalOrder());
		for (Integer integer : list) {
			
			System.out.println(integer);
		}
	}
}
