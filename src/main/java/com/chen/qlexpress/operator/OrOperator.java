package com.chen.qlexpress.operator;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import com.ql.util.express.Operator;

public class OrOperator<T> extends Operator {

	private static final long serialVersionUID = 1L;

	public OrOperator(String name) {
		this.name = name;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object executeInner(Object[] list) throws Exception {

		Specification<T> s1 = (Specification<T>) list[0];
		Specification<T> s2 = (Specification<T>) list[1];

		Specifications<T> specifications = Specifications.where(s1).or(s2);

		return specifications;
	}
}
