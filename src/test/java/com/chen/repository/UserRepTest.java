package com.chen.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
