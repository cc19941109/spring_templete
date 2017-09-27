package com.chen.repository;

import java.time.LocalDate;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.chen.entity.FactEntity;
import com.chen.test.BasicTest;

public class FactRepositoryTest extends BasicTest {

	@Autowired
	private FactRepository factRepository;

	@Test
	public void testFactRepository() {

		FactEntity entity1 = new FactEntity();
		entity1.setPid(1);
		entity1.setCid(1);
		entity1.setDate(new Date());
		entity1.setScore(60.0);;
		
		
		factRepository.save(entity1);
		FactEntity fact1 = factRepository.findOne( 1l);
		
		System.err.println(fact1);
	}

}
