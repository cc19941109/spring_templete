package com.chen.java8;

import java.util.ArrayList;
import java.util.List;

public class LambdaInterface {
	@FunctionalInterface
    interface Predicate<T> {
        boolean test(T t);
    }
	
	@FunctionalInterface
    interface Consumer<T> {
        void accept(T t);
    }
	
	@FunctionalInterface
    interface Supplier<T> {
        T get();
    }
	
	@FunctionalInterface
    interface Function<T, R> {
        R apply(T t);
    }
	
	
	
	public static void donation(Integer money, Consumer<Integer> consumer){
	    consumer.accept(money);  
	}
	
	public static List<Integer> supply(Integer num, Supplier<Integer> supplier){
	       List<Integer> resultList = new ArrayList<Integer>()   ;
	       for(int x=0;x<num;x++)  
	           resultList.add(supplier.get());
	       return resultList ;
	}
	
	public static Integer convert(String str, Function<String, Integer> function) {
	    return function.apply(str);
	}
	
	public static void main(String[] args) {
	    donation(1000, money -> System.out.println("好心的麦乐迪为Blade捐赠了"+money+"元")) ;
	    
	    List<Integer> list = supply(10,() -> (int)(Math.random()*100));
	    list.forEach(System.out::println);
	    
	    Integer value = convert("28", x -> Integer.parseInt(x));
	  
	}
	
}


