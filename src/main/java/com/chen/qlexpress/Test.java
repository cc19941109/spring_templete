package com.chen.qlexpress;

import java.time.LocalDate;
import java.util.HashMap;

import com.chen.qlexpress.spring.QLExpressContext;
import com.ql.util.express.ExpressRunner;

public class Test {

	public static void main(String[] args) throws Exception  {
		
		ExpressRunner runner = new ExpressRunner();
		QLExpressContext hashMap =new QLExpressContext();
		
		hashMap.put("num1", 2);
		
		Object result = runner.execute("num1*3", hashMap, null, true, true);
		System.out.println(result);
		
		
	}

}
