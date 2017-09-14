package com.chen.compute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.chen.entity.UserEntity;

public class SpringELTest {
	public static void main(String[] args) {
		SpringELTest springELTest = new SpringELTest();

		springELTest.testObJ2();
	}

	
	public void testObJ2(){
		Car car = new Car();
		car.setName("bmw");
		List<String> names = new ArrayList<>();
		names.add("cc");
		names.add("xw");
		names.add("zf");
		car.setNames(names);
		car.setSize(120);
		Map<String, Integer> owners = new HashMap<>();
		owners.put("cc1", 1);
		owners.put("xw1",1);
		owners.put("zf1", 1);
		car.setOwners(owners);
		
		UserEntity user = new UserEntity();
		user.setId(1l);
		user.setInfo("你好");
		user.setName("cc");
		car.setUserEntity(user);
		
		
		ExpressionParser parser = new SpelExpressionParser();
		EvaluationContext context = new StandardEvaluationContext(car);

		String username = (String) parser.parseExpression("userEntity.name").getValue(context);
		System.out.println(username);
		
		
	}
	
	
	public void testObj() {

		UserEntity user = new UserEntity();
		user.setId(1l);
		user.setInfo("你好");
		user.setName("cc");
		ExpressionParser parser = new SpelExpressionParser();
		EvaluationContext context = new StandardEvaluationContext(user);

		String username = (String) parser.parseExpression("name").getValue(context);
		System.out.println(username);
		long id = (long) parser.parseExpression("id").getValue(context);
		System.out.println(id);
		
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
