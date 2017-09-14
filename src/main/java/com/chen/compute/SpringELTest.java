package com.chen.compute;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class SpringELTest {
	public static void main(String[] args) {
		SpringELTest springELTest = new SpringELTest();

		springELTest.testBaisc();
	}

	public void testBaisc() {
		ExpressionParser parser = new SpelExpressionParser();
		String hello = (String) parser.parseExpression("'hello'").getValue();
		System.out.println(hello);
		double doublenum = (double) parser.parseExpression("1231E+21").getValue();
		System.out.println(doublenum);
		Integer maxValue = (Integer) parser.parseExpression("0x7FFFFFFF").getValue();
		System.out.println(maxValue);
		
		boolean value = (boolean) parser.parseExpression("1>2").getValue();
		Object nullValue = parser.parseExpression("null").getValue();
		System.out.println(value);
		System.out.println(nullValue);
	
		
	
	}

}
