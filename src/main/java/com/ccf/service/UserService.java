package com.ccf.service;

import java.util.List;

import com.ccf.pojo.User;

public interface UserService {

	List<User> getUserList();

	void addUser(User user);

	User getUserById(Integer systemid);

	void updateUser(User user);
}
