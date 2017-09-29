package com.chen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.chen.entity.FactEntity;
import com.chen.qlexpress.ExpressionCreater;
import com.chen.repository.FactRepository;
import com.chen.service.ExpressionService;
import com.ql.util.express.ExpressRunner;

@Service
public class ExpressionServiceImpl implements ExpressionService {

	@Autowired
	FactRepository factRepository;

	public List<FactEntity> findBy(String expression) {
		Object result = null;
		ExpressRunner runner = ExpressionCreater.creat();
		try {
			result = runner.execute(expression, null, null, true, true);

		} catch (Exception e) {
			e.printStackTrace();
		}
		Specification<FactEntity> facts = (Specification<FactEntity>) result;

		List<FactEntity> factEntities = factRepository.findAll(facts);

		return factEntities;
	}

	public Double get(String expression) {

		Object result = null;
		ExpressRunner runner = ExpressionCreater.creat();
		try {
			result = runner.execute(expression, null, null, true, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (double) result;

	}

	public Double getSumScore(Specification<FactEntity> specification) {

		List<FactEntity> list = factRepository.findAll(specification);

		return list.stream().map(FactEntity::getScore).reduce(0.0, Double::sum);

	}

}
