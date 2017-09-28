package com.chen.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.chen.entity.FactEntity;
import com.chen.service.impl.FactServiceImpl;
import com.chen.test.BasicTest;

public class FactRepositoryTest extends BasicTest {

	@Autowired
	private FactRepository factRepository;

	@Autowired
	private FactServiceImpl factServiceImpl;

	
	@Test
	public void Test() {
		
		FactEntity entity = factRepository.findOne(1l);
		System.out.println(entity);
	}
	
	@Test
	public void testFactPredicateSearch() {

		LocalDateTime now = LocalDateTime.now();
		LocalDateTime old = now.minus(1, ChronoUnit.DAYS);
		LocalDateTime after = now.plus(1, ChronoUnit.DAYS);

		Date date1 = Date.from(old.atZone(ZoneId.systemDefault()).toInstant());
		Date date2 = Date.from(after.atZone(ZoneId.systemDefault()).toInstant());

		List<FactEntity> factEntities = factServiceImpl.findSearch(date1, date2);
		System.err.println("--------------------------------------------------------");

		System.err.println("size: " + factEntities.size());
		factEntities.stream().forEach(System.err::println);

		System.err.println("--------------------------------------------------------");

	}

	@Test
	public void testFactRepository() {

		FactEntity entity1 = new FactEntity();

		for (long i = 0; i < 100; i++) {
			entity1.setId(i + 108);
			entity1.setPid(getRan(10));
			entity1.setCid(getRan(10));
			
			Date date = new Date();
			date.setYear(116);
			date.setMonth(8);
			date.setDate(getRan(30));
			entity1.setDate(date);
			entity1.setScore(10 * getRan(10).doubleValue());

			factRepository.save(entity1);
			System.err.println(entity1);
		}

	}

	public static Integer getRan(int x) {

		return new Double(Math.random() * x).intValue();
	}

}
