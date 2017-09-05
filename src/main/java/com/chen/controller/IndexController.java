package com.chen.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chen.entity.UserEntity;
import com.chen.service.impl.UserServiceImpl;

@Controller
public class IndexController {

	@Autowired
	UserServiceImpl userServiceImpl;
	
	@RequestMapping(value="/test",method = RequestMethod.GET)
	public String index() {
		return "test";
	}
	
	@RequestMapping(value = "/user",method = RequestMethod.GET)
	public List<UserEntity> getUsers(HttpServletRequest request ,HttpServletResponse response) {
		
		
		return null;
	}
	
	
}