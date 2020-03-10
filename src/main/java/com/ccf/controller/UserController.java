package com.ccf.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ccf.pojo.User;
import com.ccf.service.UserService;

@Controller
public class UserController {

	@Resource
	private UserService userService;
	
	@RequestMapping(value="/getuserList")
	public String getuserlist(Model model) {
		List<User> userlist = this.userService.getUserList();
		model.addAttribute("userlist", userlist);
		return "userlist";
	}
	
	@RequestMapping(value="/{page}")
	public String page(@PathVariable String page) {
		return page;
	}
	
	
	@RequestMapping(value="/addUser")
	public String addUser(User user) {
		this.userService.addUser(user);
		return "success";
	}
	
	@RequestMapping(value="/getUserById")
	public String getUserById(Integer systemid, Model model) {
		User user = this.userService.getUserById(systemid);
		model.addAttribute("user", user);
		return "updateUser";
	}
	
	@RequestMapping(value="/updateUser")
	public String updateUser(User user) {
		this.userService.updateUser(user);
		return "success";
	}
}
