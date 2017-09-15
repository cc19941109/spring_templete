package com.chen.java8;

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
	
	public static void main(String[] args) {
	    donation(1000, money -> System.out.println("好心的麦乐迪为Blade捐赠了"+money+"元")) ;
	    
	}
	
}


