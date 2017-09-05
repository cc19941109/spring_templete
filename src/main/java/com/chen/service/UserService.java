package com.chen.service;

import org.springframework.data.domain.Page;

import com.chen.entity.UserEntity;

public interface UserService {
	Page<UserEntity> getUsers(int page,int count);
}
