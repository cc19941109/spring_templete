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

public class TimeFunc {

	public  Specification<FactEntity> during(String day1, String day2) {
		
		Specification<FactEntity> s1 = new Specification<FactEntity>() {

			@Override
			public Predicate toPredicate(Root<FactEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<>();
				if (null != day1&&""!=day1) {
					LocalDate afterDay = LocalDate.parse(day1);
					Date date = TimeUtil.convertToDate(afterDay);
					predicateList.add(cb.greaterThanOrEqualTo(root.get("date"), date));
				}
				if (null != day2&&""!=day2) {
					LocalDate beforeDay = LocalDate.parse(day2);
					Date date = TimeUtil.convertToDate(beforeDay);
					predicateList.add(cb.lessThanOrEqualTo(root.get("date"), date));
				}
		
				return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));
			}
			
		};

		return s1;
	}

public  Specification<FactEntity> day(String day1) {
		
		Specification<FactEntity> s1 = new Specification<FactEntity>() {

			@Override
			public Predicate toPredicate(Root<FactEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<>();
				if (null != day1&&""!=day1) {
					LocalDate afterDay = LocalDate.parse(day1);
					Date date = TimeUtil.convertToDate(afterDay);
					predicateList.add(cb.equal(root.get("date"), date));
				}
				
				return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));
			}
			
		};
		return s1;
	}

	
	
	
}
