package com.chen.java8.chapter5;

import static org.assertj.core.api.Assertions.not;
import static org.hamcrest.CoreMatchers.both;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumRange {
	public static void main(String[] args) {
		
		IntStream num1 = IntStream.rangeClosed(1, 100).filter(n -> n%2==1);
//		System.out.println(num1.count());
		
//		IntStream.rangeClosed(1, 100).boxed().flatMap(a->
//				IntStream.rangeClosed(a, 100)
//						 .filter(b->Math.sqrt(a*a+b*b)%1==0)
//						 .mapToObj(b->new int[] {a,b,(int)Math.sqrt(a*a+b*b)}));
		
		Stream<double[]> p2 = 
				IntStream.rangeClosed(1, 100).boxed()
						 .flatMap(
								 	a->IntStream.rangeClosed(a, 100)
								 			.mapToObj(
								 					b->new double[] {a,b,Math.sqrt(a*a+b*b)}
								 					)
								 			.filter(t->t[2]%1==0)
								 );
		
		p2.forEach(t->System.out.println(t[0]+" "+t[1]+" "+t[2]));
		
	}
}
