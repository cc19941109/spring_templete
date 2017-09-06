package com.chen.service;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import com.chen.entity.UserEntity;
import com.chen.repository.UserRepository;
import com.chen.service.impl.UserServiceImpl;
import com.chen.test.BasicTest;

public class UserServiceTest extends BasicTest {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@Test
	public void testUserService() {
		System.out.println("test begin....");
		List<UserEntity> uList = userServiceImpl.getUsers(1, 10);

		Iterator<UserEntity> iterator = uList.iterator();
		while (iterator.hasNext()) {
			System.err.println(iterator.next());
		}
	}

	@Test
	public void testGetOne() {
		UserEntity userEntity = userServiceImpl.getOne();
		System.out.println(userEntity);

	}

	@Test
	public void testUserServiceImpl() {
		UserEntity userEntity = userServiceImpl.getOne();
		System.out.println(userEntity);
	}

}
