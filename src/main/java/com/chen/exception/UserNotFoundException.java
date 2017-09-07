package com.chen.exception;

public class UserNotFoundException extends RuntimeException {
	
	private long userId;

	public UserNotFoundException(long userId) {
		super();
		this.userId = userId;
	}

	public long getUserId() {
		return userId;
	}

}
