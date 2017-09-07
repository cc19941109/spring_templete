package com.chen.exception.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.chen.dto.Error;
import com.chen.exception.UserNotFoundException;

@RestControllerAdvice
public class UserExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserExceptionHandler.class);
	
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody Error userNotFOUND(UserNotFoundException exception) {
		long userId = exception.getUserId();
		Error error = new Error(4, "user " + userId + " not found ");
		LOGGER.error(error.getMessage());
		return error;
	}
	
}
