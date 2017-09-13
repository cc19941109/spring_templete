package com.chen.compute;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.ValidationResult;
import net.objecthunter.exp4j.function.Function;

public class Exp4jDemo {

	public static void main(String[] args) throws Exception {
		Exp4jDemo eDemo = new Exp4jDemo();
		eDemo.test8();
	}

	public void test8() {
		Expression e = new ExpressionBuilder("x")
		        .variable("x")
		        .build()
		        .setVariable("x", 0.213);

		ValidationResult res = e.validate();
		System.out.println(res.isValid());
	}
	
	public void test7() {
		String exp = "2^0.5";
		double result = new ExpressionBuilder(exp)
				.build().evaluate();
		System.out.println(result);
	}

	public void test6() {
		Function avg = new Function("avg", 4) {

		    @Override
		    public double apply(double... args) {
		        double sum = 0;
		        for (double arg : args) {
		            sum += arg;
		        }
		        return sum / args.length;
		    }
		};
		double result = new ExpressionBuilder("avg(1,2,3,4)")
		        .function(avg)
		        .build()
		        .evaluate();

		double expected = 2.5d;
		System.out.println(result);
	}

	public void test5() {
		Function logb = new Function("logb", 2) {
			@Override
			public double apply(double... args) {
				return Math.log(args[0]) / Math.log(args[1]);
			}
		};
		double result = new ExpressionBuilder("logb(8, 2)").function(logb).build().evaluate();
		System.out.println(result);
	}

	public void test4() {
		// String expr = "7.2973525698e-3";
		String expr = "2^4";

		Expression e = new ExpressionBuilder(expr).build();
		System.out.println(e.evaluate());
	}

	public void test3() {
		// String expr = "pi+π+e+φ";
		String expr = "φ";

		double expected = 2 * Math.PI + Math.E + 1.61803398874d;
		Expression e = new ExpressionBuilder(expr).build();
		System.out.println(e.evaluate());
	}

	public void test2() throws InterruptedException, ExecutionException {
		// For evaluating expressions asynchronously the user only has to
		// supply a java.util.concurrent.ExecutorService.

		ExecutorService exec = Executors.newFixedThreadPool(1);
		Expression e = new ExpressionBuilder("3log(y)/(x+1)").variables("x", "y").build().setVariable("x", 2.3)
				.setVariable("y", 3.14);
		Future<Double> future = e.evaluateAsync(exec);
		double result = future.get();
		System.out.println(result);
	}

	public void test1() {
		Expression e = new ExpressionBuilder("3 * sin(y) - 2 / (x - 2)").variables("x", "y").build()
				.setVariable("x", 2.3).setVariable("y", 3.14);
		double result = e.evaluate();
		System.out.println(result);
	}
}
