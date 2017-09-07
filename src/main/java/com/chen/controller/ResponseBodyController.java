package com.chen.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriComponentsBuilder;

import com.chen.dto.Error;
import com.chen.entity.UserEntity;
import com.chen.exception.UserNotFoundException;
import com.chen.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/rsb")
public class ResponseBodyController {

	@Autowired
	UserServiceImpl userServiceImpl;
	
	
	@RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
	public @ResponseBody UserEntity getOneUser(@PathVariable Long id){
		UserEntity userEntity = userServiceImpl.findById(id);
		HttpStatus status = userEntity !=null?HttpStatus.OK:HttpStatus.NOT_FOUND;
		if(userEntity == null) {
			throw new UserNotFoundException(id);
		}
		
		return userEntity;
	}
	
	@ResponseBody
	@RequestMapping(value = "user/test",method = RequestMethod.GET)
	public UserEntity getOneTest() {
		
		return userServiceImpl.getOne(1l);
		
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody Error userNotFOUND(UserNotFoundException exception) {
		long userId = exception.getUserId();
		Error error = new Error(4, "user "+userId +" not found ");
		return error;
	}
	

	@RequestMapping(value = "/user/save", method = RequestMethod.POST, consumes = "application/json")
	public  ResponseEntity<UserEntity> saveOneUser(@RequestBody UserEntity user,UriComponentsBuilder ucb) {

		 UserEntity userone = userServiceImpl.saveOne(user);
		 
		 HttpHeaders headers = new HttpHeaders();
//		 URI locationUri = URI.create("http://localhost:8080/spring_templete/user/"+user.getId());
		 URI locationUri = ucb.path("/user/").path(String.valueOf(user.getId())).build().toUri();
		 
		 headers.setLocation(locationUri);
		 
		 ResponseEntity<UserEntity> responseEntity = new ResponseEntity<>(userone,headers,HttpStatus.CREATED);
		 
		 return responseEntity;
		 
	}
	
	
	
}
