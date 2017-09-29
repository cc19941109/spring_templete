package com.chen.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.chen.entity.FactEntity;
import com.chen.qlexpress.data.FactRepository;
import com.chen.service.FactService;

@Service
public class FactServiceImpl implements FactService {

	@Autowired
	FactRepository factRepository;

	public List<FactEntity> findSearch(Predicate predicate) {

		List<FactEntity> factEntities = factRepository.findAll(new Specification<FactEntity>() {

			@Override
			public Predicate toPredicate(Root<FactEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
//				List<Predicate> predicates = new ArrayList<>();

				return predicate;
			}
		});

		return factEntities;

	}

	public List<FactEntity> findSearch(Date minDate, Date maxDate) {

		List<FactEntity> factEntities = factRepository.findAll(new Specification<FactEntity>() {

			@Override
			public Predicate toPredicate(Root<FactEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<>();
				if (null != minDate) {
					predicates.add(cb.greaterThanOrEqualTo(root.get("date"), minDate));
				}
				if (null != maxDate) {
					predicates.add(cb.lessThanOrEqualTo(root.get("date"), maxDate));
				}

				return cb.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		});

		return factEntities;
	}

	public List<FactEntity> findBySpecification(Specification<FactEntity> specification) {
		return factRepository.findAll(specification);
	}

}
