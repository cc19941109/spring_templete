package com.chen.service.impl;

import java.util.List;

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
	
	
	public UserEntity getOne(long id){
		
		 return userRepository.findOne(id) ;
	}
	
	public UserEntity findById(Long id) {
		return userRepository.findOne(id);
	}
	
	public List<UserEntity> getUsers(int pageNumber,int pageSize){
		 PageRequest request = this.buildPageRequest(pageNumber,pageSize);
		 Page<UserEntity> users = userRepository.findAll(request);
		 return users.getContent();
		 
	}
	
    private PageRequest buildPageRequest(int pageNumber, int pagzSize) {
        return new PageRequest(pageNumber - 1, pagzSize, null);
    }

	@Override
	public UserEntity saveOne(UserEntity userEntity) {
		return userRepository.save(userEntity);
	}
	
}
