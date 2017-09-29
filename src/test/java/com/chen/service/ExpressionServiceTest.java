package com.chen.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import com.chen.entity.FactEntity;
import com.chen.qlexpress.func.TimeFunc;
import com.chen.service.impl.ExpressionServiceImpl;
import com.chen.test.BasicTest;

public class ExpressionServiceTest extends BasicTest{
	
	@Autowired
	ExpressionServiceImpl expressionServiceImpl;
	
	@Test
	public void test() {
		
		TimeFunc timeFunc = new TimeFunc();
		Specification<FactEntity> during = timeFunc.during("2017-09-20", "2017-09-28");
		Double sumScore = expressionServiceImpl.getSumScore(during);
		System.err.println("-------------- "+sumScore+" ------------");
		
		
	}
	
}
