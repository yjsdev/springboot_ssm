package com.ccf.mapper;

import java.util.List;

import com.ccf.pojo.User;

public interface UserMapper {

	List<User> getUserList();
	
	void addUser(User user);

	User getUserById(Integer systemid);

	void updateUser(User user);
}
