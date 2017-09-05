package com.chen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chen.entity.TerUserLinkEntity;
import com.chen.entity.UserTeacherPK;

public interface TerUserLinkRepository extends JpaRepository<TerUserLinkEntity, UserTeacherPK>{

}
