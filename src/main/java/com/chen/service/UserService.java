package com.chen.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.chen.entity.UserEntity;

public interface UserService {
	List<UserEntity> getUsers(int page,int count);
	UserEntity saveOne(UserEntity userEntity);
}
