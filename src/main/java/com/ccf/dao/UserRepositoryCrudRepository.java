package com.ccf.dao;

import org.springframework.data.repository.CrudRepository;

import com.ccf.pojo.User;

public interface UserRepositoryCrudRepository extends CrudRepository<User, Integer> {

}
