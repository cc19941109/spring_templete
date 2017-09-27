package com.chen.qlexpress.func;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.chen.entity.FactEntity;
import com.chen.utils.TimeUtil;

public class Func {

	public Predicate during(String date1, String date2) {

		LocalDate localDate1 = LocalDate.parse(date1);
		LocalDate localDate2 = LocalDate.parse(date2);

		Date after = TimeUtil.convertToDate(localDate1);
		Date before = TimeUtil.convertToDate(localDate2);

		List<Predicate> predicates = new ArrayList<>();
		Specification<FactEntity> s =  new Specification<FactEntity>() {

			@Override
			public Predicate toPredicate(Root<FactEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		
		return null;
	}

}
