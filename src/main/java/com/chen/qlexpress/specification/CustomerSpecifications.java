package com.chen.qlexpress.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import com.chen.entity.FactEntity;

public class CustomerSpecifications {

	public static void main(String[] args) {
		Specifications.where(test1()).and(test2());
	}
	
	  public static Specification<FactEntity> test2() {
	  
		  Specification<FactEntity> specification = new Specification<FactEntity>() {

			@Override
			public Predicate toPredicate(Root<FactEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return null;
			}
		};
		  return specification;
		  
	  }

	  
	  public static Specification<FactEntity> test1() {
		  
		  Specification<FactEntity> specification = new Specification<FactEntity>() {

			@Override
			public Predicate toPredicate(Root<FactEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return null;
			}
		};
		  return specification;
		  
	  }
	 
	}