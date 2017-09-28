package com.chen.qlexpress.func;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.chen.entity.FactEntity;
import com.chen.service.impl.FactServiceImpl;

public class Fact {


	public List<FactEntity> fact(Specification<FactEntity> specification) {

//		List<FactEntity> list = factServiceImpl.findBySpecification(specification);

		return null;
	}

}
