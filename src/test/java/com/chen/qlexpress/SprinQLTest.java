package com.chen.qlexpress;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.domain.Specification;

import com.chen.entity.FactEntity;
import com.chen.qlexpress.spring.QlExpressUtil;
import com.chen.service.impl.ExpressionServiceImpl;
import com.chen.test.BasicTest;
import com.ql.util.express.ExpressRunner;

public class SprinQLTest extends BasicTest {

	@Autowired
	ExpressionServiceImpl expressionServiceImpl;

	@Autowired
	private ApplicationContext ctx;
	
	@Test
	public void testNormal() throws Exception {

		Map<String, Object> hMap = new HashMap<>();
		QlExpressUtil qlExpressUtil = new QlExpressUtil(ctx);
		Object result = qlExpressUtil.execute("during('2017-09-27','2017-09-28')", hMap);
		Specification<FactEntity> sp1 = (Specification<FactEntity>) result;

		Double sum = expressionServiceImpl.getSumScore(sp1);
		System.err.println("  ----------------" + sum + "  -----------------------");
	}

	@Test
	public void testSumScore() throws Exception {
		
		String expression = "day('2017-09-27')";
		ExpressRunner runner = ExpressionCreater.creat();
		Object execute = runner.execute(expression, null, null, true, true);
		
		Specification<FactEntity> specification = (Specification<FactEntity>) execute;
		Double sumScore = expressionServiceImpl.getSumScore(specification);
		
		System.out.println("----------"+sumScore+"-------------");
		
	}
	
	
	@Test
	public void testSpring() throws Exception {

		Map<String, Object> hMap = new HashMap<>();
		QlExpressUtil qlExpressUtil = new QlExpressUtil(ctx);
		Object result = qlExpressUtil.execute("sum(during('2017-09-27','2017-09-28'))", hMap);

		Double sum = (Double) result;
		System.err.println("  ----------------" + sum + "  -----------------------");
	}

	@Test
	public void testD() throws Exception {

		String expression = "d('2017-09-28')";
		Map<String, Object> hMap = new HashMap<>();

		QlExpressUtil qlExpressUtil = new QlExpressUtil(ctx);
		Object result = qlExpressUtil.execute(expression, hMap);

		Double sum = (Double) result;
		System.err.println("  ----------------" + sum + "  -----------------------");

	}

}
