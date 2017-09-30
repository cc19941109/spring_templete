package com.chen.qlexpress.spring;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.chen.entity.FactEntity;
import com.chen.qlexpress.func.CategoryFunc;
import com.chen.qlexpress.func.PcsFunc;
import com.chen.qlexpress.func.TimeFunc;
import com.chen.qlexpress.operator.WithOperator;
import com.chen.service.impl.ExpressionServiceImpl;
import com.ql.util.express.ExpressRunner;
import com.ql.util.express.IExpressContext;
//import com.taobao.upp.sc.common.expression.QLExpressContext;

@Component
public class QlExpressUtil implements ApplicationContextAware,InitializingBean {

	private static ExpressRunner runner;
	static {
		runner = new ExpressRunner();
	}
	private static boolean isInitialRunner = false;

	private  ApplicationContext applicationContext;// spring上下文

	public QlExpressUtil() {
	}
	
	public QlExpressUtil(ApplicationContext applicationContext) {
		super();
		this.applicationContext = applicationContext;
	}

	/**
	 *
	 * @param statement
	 *            执行语句
	 * @param context
	 *            上下文
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Object execute(String statement, Map<String, Object> context) throws Exception {
		
		if(applicationContext==null) {
			System.err.println("expressionServiceImpl get bean applicationContext is null");
		}else {
			try {
				Object bean = applicationContext.getBean("expressionServiceImpl");
				System.err.println("expressionServiceImpl get bean success....");
			} catch (Exception e) {
				System.err.println("expressionServiceImpl get bean failed ......................................");
			}
			
		}
		initRunner(runner);
		IExpressContext expressContext = new QLExpressContext(context, applicationContext);
		statement = initStatement(statement);
		return runner.execute(statement, expressContext, null, true, false);
	}
	
	
	
	public Object coreExecute(QLExpressContext expressContext ,String statement){
		
		if(applicationContext==null) {
			System.err.println(" applicationContext is null");
		}else{
			System.err.println(" applicationContext initialzed...");

			
		}
		
		initRunner(runner);
		statement = initStatement(statement);
		
//		expressContext.setApplicationContext(applicationContext);
		
		try {
			Object value = this.runner.execute(statement, expressContext, null, true, true);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("expression exception ....");
		}
		return null;
		
		
	}
	
	

	public Map<String, Object> pag(Map<String, Object> map) {
		Object bean = null;
		if (applicationContext == null) {
			System.err.println("applicationContext 为 null..........");

		}
		// int num = applicationContext.getBeanDefinitionCount();
		// System.out.println("bean definited num = "+num+" .......................");
		try {
			bean = applicationContext.getBean("expressionServiceImpl");
			System.err.println("expressionServiceImpl get success ......................................");
		} catch (Exception e) {
			System.err.println("expressionServiceImpl get failed ......................................");
		}
		map.put("expressionServiceImpl", bean);
		return map;
	}

	/**
	 * 在此处把一些中文符号替换成英文符号
	 * 
	 * @param statement
	 * @return
	 */
	private String initStatement(String statement) {
		return statement.replace("（", "(").replace("）", ")").replace("；", ";").replace("，", ",").replace("“", "\"")
				.replace("”", "\"");
	}

	private void initRunner(ExpressRunner runner) {
		if (isInitialRunner == true) {
			return;
		}
		synchronized (runner) {
			if (isInitialRunner == true) {
				return;
			}
			try {
				// 在此加入预定义函数
				runner.addFunctionOfClassMethod("pcs", PcsFunc.class.getName(), "filterPCS",
						new Class[] { Integer[].class }, null);
				runner.addFunctionOfClassMethod("during", TimeFunc.class.getName(), "during",
						new Class[] { String.class, String.class }, null);
				runner.addFunctionOfClassMethod("day", TimeFunc.class.getName(), "day", new Class[] { String.class },
						null);
				runner.addFunctionOfClassMethod("category", CategoryFunc.class.getName(), "filterCategory",
						new Class[] { Integer[].class }, null);
				runner.addFunctionOfClassMethod("sum", ExpressionServiceImpl.class.getName(), "getSumScore",
						new Class[] { Specification.class }, null);
				runner.addFunctionOfClassMethod("d", ExpressionServiceImpl.class.getName(), "d",
						new Class[] { String.class }, null);

				runner.addOperator("with", new WithOperator<FactEntity>("with"));
				runner.addOperator("huo", new com.chen.qlexpress.operator.OrOperator<>("or"));

			} catch (Exception e) {
				throw new RuntimeException("初始化失败表达式", e);
			}
		}
		isInitialRunner = true;
	}

	public void setApplicationContext(ApplicationContext aContext) throws BeansException {
		applicationContext = aContext;
	}

	public void afterPropertiesSet() throws Exception {
		
	}

}
