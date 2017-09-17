package com.chen.java8.chapter3;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.chen.java8.chapter1.Apple;

public class LastLambda {

	public static void main(String[] args) {
		List<Apple> apples = new Apple().getApples();
		//plan A
		apples.sort(new AppleComparator());
		//plan B 调用匿名内部类
		//plan C 
		apples.sort((a1,a2)->a1.getWeight()-a2.getWeight());
		apples.sort((a1,a2)->a1.getWeight().compareTo(a2.getWeight()));
		//plan D 使用方法引用
		apples.sort(Comparator.comparing((a)->a.getWeight()));
		apples.sort(Comparator.comparing(Apple::getWeight));

		//逆序 reversed 是对之前的顺序进行完全的反转
		
		apples.sort(Comparator.comparing(Apple::getWeight).reversed().thenComparing(Apple::getName));
//		apples.sort(Comparator.comparing(Apple::getWeight).reversed());

		Apple.ApplesToString(apples);
		
		Predicate<Apple> p1 = a->a.getWeight()>100;
		Predicate<Apple> p2 = p1.and(a->a.getColor()=="green");
		Stream<Apple> stream = apples.parallelStream().filter(p2);
		
		stream.forEach(a->System.out.println(a));
	}
	
	

}

class AppleComparator implements Comparator<Apple>{

	@Override
	public int compare(Apple o1, Apple o2) {
		
		return o1.getWeight().compareTo(o2.getWeight());
	}
	
}
