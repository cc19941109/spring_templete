package com.chen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.chen.entity.FactEntity;

@Repository
public interface FactRepository extends JpaRepository<FactEntity, Long>,JpaSpecificationExecutor<FactEntity>{

}
