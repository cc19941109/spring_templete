package com.chen.qlexpress;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.chen.entity.FactEntity;
import com.chen.qlexpress.func.Func;
import com.chen.service.impl.ExpressionServiceImpl;
import com.chen.test.BasicTest;
import com.ql.util.express.ExpressRunner;

import junit.extensions.TestDecorator;

public class QlexpressTest extends BasicTest {

	@Autowired
	ExpressionServiceImpl expressionServiceImpl;

	
	//test failed .....
	@Test
	public void TestD() throws Exception {
		
		String expression = "d('2017-09-27')";
		ExpressRunner runner = ExpressionCreater.creat();
		Object execute = runner.execute(expression, null, null, true, true);
		Double result = (Double) execute;
		
		System.out.println("---------" +result + "-----------");

	}
	
	
	//test failed .....
	@Test
	public void testSum() {
		String expression = "sum(during('2017-09-27','2017-09-28'))";
		Double sum = expressionServiceImpl.getSum(expression);
		
		System.out.println("---------" +sum + "-----------");
		
		
	}
	
	
	
	@Test
	public void testDuring() {
		String string = "during('2017-09-27','2017-09-28')";

		List<FactEntity> factEntities = expressionServiceImpl.findBy(string);
		System.err.println(factEntities.size() + "  ----------------------------------------");

	}

	@Test
	public void testPcs() {
		String expression = "pcs([1,2])";

		List<FactEntity> factEntities = expressionServiceImpl.findBy(expression);
		System.err.println("---------" + factEntities.size() + "-----------");
		factEntities.stream().forEach(System.err::println);

	}

	@Test
	public void testCategory() {
		String expression = "category([1,2])";

		List<FactEntity> factEntities = expressionServiceImpl.findBy(expression);
		System.err.println("---------" + factEntities.size() + "-----------");
		factEntities.stream().forEach(System.err::println);

	}

	@Test
	public void testDay() {
		String expression = "day('2017-09-27')";

		List<FactEntity> factEntities = expressionServiceImpl.findBy(expression);
		System.err.println("---------" + factEntities.size() + "-----------");
		factEntities.stream().forEach(System.err::println);

	}

	@Test
	public void testWith() {
		// String expression = "during('2017-09-27','2017-09-28') with pcs([1,2]) ";
		String expression = "  pcs([1,2,3,4,5]) with during('2017-09-01','2017-09-28') ";

		List<FactEntity> factEntities = expressionServiceImpl.findBy(expression);
		System.err.println("---------" + factEntities.size() + "-----------");
		factEntities.stream().forEach(System.err::println);

	}

	@Test
	public void testHuo() {
		// String expression = "during('2017-09-27','2017-09-28') with pcs([1,2]) ";
		String expression = "  pcs([1,2]) huo during('2017-09-27','2017-09-28') ";

		List<FactEntity> factEntities = expressionServiceImpl.findBy(expression);
		System.err.println("---------" + factEntities.size() + "-----------");
		factEntities.stream().forEach(System.err::println);

	}

}
