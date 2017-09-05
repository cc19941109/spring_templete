package com.chen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chen.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{

}
