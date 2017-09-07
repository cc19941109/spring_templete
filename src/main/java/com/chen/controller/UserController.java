package com.chen.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chen.entity.UserEntity;
import com.chen.exception.UserNotFoundException;
import com.chen.service.impl.UserServiceImpl;

@Controller
public class UserController {

	@Autowired
	UserServiceImpl userServiceImpl;

	@RequestMapping(value = "/user/page/{page}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<UserEntity> getPageUsers(@PathVariable("page") int page) {

		List<UserEntity> list = new ArrayList<>();
		list= userServiceImpl.getUsers(page, 10);

		return list;
	}

	@RequestMapping(value = "/user/save", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody UserEntity saveOneUser(@RequestBody UserEntity user) {

		return userServiceImpl.saveOne(user);
	}
	

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody UserEntity getOneUser(@PathVariable("id") Long id) {
		
		UserEntity  user = userServiceImpl.getOne(id);
		if(user==null){
			throw new UserNotFoundException(id);
		}
		return user;
	}

}
