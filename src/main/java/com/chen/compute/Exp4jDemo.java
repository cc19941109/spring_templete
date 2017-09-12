package com.chen.compute;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Exp4jDemo {

	public static void main(String[] args) throws Exception {
		Exp4jDemo eDemo = new Exp4jDemo();
		eDemo.test2();
	}
	
	public void test7() {
		
	}
	public void test6() {
		
	}
	public void test5() {
		
	}
	public void test4() {
		
	}
	public void test3() {
		
	}
	public void test2() throws InterruptedException, ExecutionException {
		//For evaluating expressions asynchronously the user only has to 
		//supply a java.util.concurrent.ExecutorService.

		ExecutorService exec = Executors.newFixedThreadPool(1);
		Expression e = new ExpressionBuilder("3log(y)/(x+1)")
		        .variables("x", "y")
		        .build()
		        .setVariable("x", 2.3)
		        .setVariable("y", 3.14);
		Future<Double> future = e.evaluateAsync(exec);
		double result = future.get();
		System.out.println(result);
	}
	public void test1() {
		Expression e = new ExpressionBuilder("3 * sin(y) - 2 / (x - 2)")
		        .variables("x", "y")
		        .build()
		        .setVariable("x", 2.3)
		        .setVariable("y", 3.14);
		double result = e.evaluate();
		System.out.println(result);
	}
}
