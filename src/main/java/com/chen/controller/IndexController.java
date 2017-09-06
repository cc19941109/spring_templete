package com.chen.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chen.entity.UserEntity;
import com.chen.repository.UserRepository;
import com.chen.service.impl.UserServiceImpl;

@Controller
public class IndexController {

	@Autowired
	UserServiceImpl userServiceImpl;

	@Autowired
	UserRepository userRepository;

	@RequestMapping(value = "/t", method = RequestMethod.GET)
	public String index() {
		return "test";
	}

	@ResponseBody
	@RequestMapping(value = "/user1", method = RequestMethod.GET)
	public UserEntity getUsers(HttpServletRequest request, HttpServletResponse response) {
		UserEntity user1 = userRepository.findOne(1l);

		return user1;
	}

}