package com.chen.formula.engine;


import java.util.Map;

import com.ql.util.express.ExpressRunner;
import com.ql.util.express.IExpressContext;

public class QlExpressUtil {

	private static ExpressRunner runner;

	static {
		runner = new ExpressRunner();
	}
	
	private static boolean isInitialRunner = false;
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
		initRunner(runner);
		IExpressContext<String, Object> expressContext = new QLExpressContext(context);
		statement = initStatement(statement);
		return runner.execute(statement, expressContext, null, true, false);
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

			} catch (Exception e) {
				throw new RuntimeException("初始化失败表达式", e);
			}
		}
		isInitialRunner = true;
	}

}
