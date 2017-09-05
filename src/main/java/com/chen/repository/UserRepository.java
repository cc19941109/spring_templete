package com.chen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chen.entity.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
