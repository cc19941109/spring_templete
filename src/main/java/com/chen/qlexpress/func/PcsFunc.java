package com.chen.qlexpress.func;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import com.chen.entity.FactEntity;

public class PcsFunc {

	public Specification<FactEntity> filterPCS(Integer... ids) {

		Specification<FactEntity> s1 = new Specification<FactEntity>() {

			@Override
			public Predicate toPredicate(Root<FactEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				if (ids == null) {
					return null;
				}
				List<Predicate> predicateList = new ArrayList<>();

				for (Integer integer : ids) {
					predicateList.add(cb.equal(root.get("pid"), integer));
				}
				
				return cb.or(predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};
		return s1;

	}

}
