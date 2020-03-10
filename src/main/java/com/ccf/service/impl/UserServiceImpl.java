package com.ccf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccf.mapper.UserMapper;
import com.ccf.pojo.User;
import com.ccf.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> getUserList() {
		return this.userMapper.getUserList();
	}

	@Override
	public void addUser(User user) {
		this.userMapper.addUser(user);
	}
	
	@Override
	public User getUserById(Integer systemid) {
		return this.userMapper.getUserById(systemid);
	}
	
	@Override
	public void updateUser(User user) {
		this.userMapper.updateUser(user);
	}
}
