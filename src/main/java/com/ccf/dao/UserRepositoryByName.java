package com.ccf.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.ccf.pojo.User;

public interface UserRepositoryByName extends Repository<User, Integer> {

	//findBy方法的名称必须遵循驼峰式命名规则，findBy(关键字)+属性名称(首字母大写)+查询条件(属性名称)
	List<User> findByUsername(String username);
	
	List<User> findByUsernameAndUsertype(String username, String usertype);
	
	List<User> findByUsernameOrUsertype(String username, String usertype);
	
	List<User> findByUsernameLike(String username);
	
}
