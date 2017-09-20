package com.chen.java8.chapter5;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.xpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SqrtTest {

	public static void main(String[] args) {

		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
		Stream<Integer> stream1 = list1.stream().map(x -> x * x);
		stream1.forEach(System.out::println);

		List<Integer> s1 = Arrays.asList(1, 2, 3);
		List<Integer> s2 = Arrays.asList(4, 5);
		Stream<int[]> stream2 = 	s1.stream().flatMap(i -> s2.stream().map(j -> new int[] { i, j }));
		stream2.filter(p->(p[0]+p[1])%3==0).forEach(p->System.out.println(p[0]+","+p[1]));

//		stream2.forEach(System.out::println);//stream has already been operated upon or closed
	}

}
