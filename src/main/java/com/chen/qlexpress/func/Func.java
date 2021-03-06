package com.chen.qlexpress.func;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.chen.entity.FactEntity;
import com.chen.qlexpress.ExpressionCreater;
import com.chen.service.impl.ExpressionServiceImpl;
import com.ql.util.express.ExpressRunner;

@Service
public class Func {

	@Autowired
	ExpressionServiceImpl expressionServiceImpl;

	public double sum(Specification<FactEntity> specification) {

		return expressionServiceImpl.getSumScore(specification);
	}


}
