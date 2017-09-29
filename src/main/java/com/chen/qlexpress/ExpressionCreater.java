package com.chen.qlexpress;

import org.springframework.data.jpa.domain.Specification;

import com.chen.entity.FactEntity;
import com.chen.qlexpress.func.CategoryFunc;
import com.chen.qlexpress.func.Func;
import com.chen.qlexpress.func.PcsFunc;
import com.chen.qlexpress.func.TimeFunc;
import com.chen.qlexpress.operator.WithOperator;
import com.ql.util.express.ExpressRunner;

public class ExpressionCreater {

	private static ExpressRunner runner = new ExpressRunner();

	public static ExpressRunner creat() {

		try {
			runner.addFunctionOfClassMethod("pcs", PcsFunc.class.getName(), "filterPCS",
					new Class[] { Integer[].class }, null);
			runner.addFunctionOfClassMethod("during", TimeFunc.class.getName(), "during",
					new Class[] { String.class, String.class }, null);
			runner.addFunctionOfClassMethod("day", TimeFunc.class.getName(), "day", new Class[] { String.class }, null);
			runner.addFunctionOfClassMethod("category", CategoryFunc.class.getName(), "filterCategory",
					new Class[] { Integer[].class }, null);
			runner.addFunctionOfClassMethod("sum", Func.class.getName(), "sum", new Class[] { Specification.class },
					null);

			runner.addOperator("with", new WithOperator<FactEntity>("with"));
			runner.addOperator("huo", new com.chen.qlexpress.operator.OrOperator<>("or"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return runner;
	}

}
