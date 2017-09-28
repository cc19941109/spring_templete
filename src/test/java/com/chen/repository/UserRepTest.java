package com.chen.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import com.chen.entity.UserEntity;
import com.chen.test.BasicTest;

public class UserRepTest extends BasicTest {
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	public void testUserRep() {
		UserEntity userEntity = userRepository.findOne(1l);
		System.out.println(userEntity);
		
	}
	
	
}
