package com.chen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chen.entity.UserEntity;
import com.chen.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/rest")
public class UserRestController {

	@Autowired
	UserServiceImpl userServiceImpl;

	@RequestMapping(value = "/user/{page}", method = RequestMethod.GET)
	public List<UserEntity> getPageUsers(@PathVariable Integer page) {

		return userServiceImpl.getUsers(1, 10);
	}

	@RequestMapping(value = "/user/save", method = RequestMethod.POST, consumes = "application/json")
	public  UserEntity saveOneUser(@RequestBody UserEntity user) {

		return userServiceImpl.saveOne(user);
	}
	
}
