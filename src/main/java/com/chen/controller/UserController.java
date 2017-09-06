package com.chen.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chen.entity.UserEntity;
import com.chen.service.impl.UserServiceImpl;

@Controller
public class UserController {

	@Autowired
	UserServiceImpl userServiceImpl;

	@ResponseBody
	@RequestMapping(value = "/user/{page}", method = RequestMethod.GET)
	public List<UserEntity> getPageUsers(@PathVariable("page") int page) {

		List<UserEntity> list = new ArrayList<>();
		Page<UserEntity> pages = userServiceImpl.getUsers(page, 10);
		list = pages.getContent();

		return list;
	}
	
	
	

}
