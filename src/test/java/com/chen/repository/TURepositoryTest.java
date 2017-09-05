package com.chen.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.chen.entity.UserEntity;
import com.chen.test.BasicTest;

public class TURepositoryTest extends BasicTest {

	@Autowired
	TeacherRepository teacherRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TerUserLinkRepository tUserLinkRepository;

	@Test
	public void addUser() {
		for (int i = 0; i < 20; i++) {
			UserEntity userEntity = new UserEntity();
			
			userEntity.setInfo("info "+i);
			userEntity.setName("name "+i);
			System.err.println(i);
			userRepository.save(userEntity);
			
		}
	}
	
	@Test
	public void testTU() {
		
		
		
	}
	
	

}
