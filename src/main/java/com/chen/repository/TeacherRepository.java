package com.chen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chen.entity.TeacherEntity;

public interface TeacherRepository extends JpaRepository<TeacherEntity, Long>{
	
}
