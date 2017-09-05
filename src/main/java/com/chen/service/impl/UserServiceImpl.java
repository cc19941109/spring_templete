package com.chen.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.chen.entity.UserEntity;
import com.chen.repository.UserRepository;
import com.chen.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired 
	private UserRepository userRepository;
	
	
	public Page<UserEntity> getUsers(int pageNumber,int pageSize){
		 PageRequest request = this.buildPageRequest(pageNumber,pageSize);
		 Page<UserEntity> users = userRepository.findAll(request);
		 return users;
		 
	}
	
    private PageRequest buildPageRequest(int pageNumber, int pagzSize) {
        return new PageRequest(pageNumber - 1, pagzSize, null);
    }
	
}
