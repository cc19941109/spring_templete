package com.chen.qlexpress;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.chen.entity.FactEntity;
import com.chen.qlexpress.func.Func;
import com.chen.service.impl.ExpressionServiceImpl;
import com.chen.test.BasicTest;

public class SumTest extends BasicTest {

	@Autowired
	ExpressionServiceImpl expressionServiceImpl;


	
	@Test
	public void testSum() {

		String expression = "sum( during('2017-09-01','2017-09-28')  )";
		Double num = expressionServiceImpl.get(expression);
		System.err.println("--------- "+num+" ------------");

	}

}
