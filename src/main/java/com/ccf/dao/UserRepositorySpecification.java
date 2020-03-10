package com.ccf.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ccf.pojo.User;


public interface UserRepositorySpecification extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

	
}
