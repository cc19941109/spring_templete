package com.chen.formula.engine;

import java.util.HashMap;
import java.util.Map;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.ql.util.express.IExpressContext;

@SuppressWarnings("serial")
public class QLExpressContext extends HashMap<String, Object> implements IExpressContext<String, Object> {

	public QLExpressContext() {
	}

	public QLExpressContext(Map<String, Object> map) {
		putAll(map);
	}

	public Object put(String name, Object object) {
		return super.put(name, object);
	}

}
