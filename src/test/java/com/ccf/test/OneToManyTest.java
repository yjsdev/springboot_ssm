package com.ccf.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ccf.AppStarter;
import com.ccf.dao.UserRepository;
import com.ccf.pojo.Role;
import com.ccf.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AppStarter.class)
public class OneToManyTest {
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void testSave() {
		User user = new User();
		user.setUsername("装测试");
		user.setUsertype("测试");
		
		Role role = new Role();
		role.setRolename("管理员");
		
		role.getUsers().add(user);
		user.setRoles(role);
		
		this.userRepository.save(user);
		
	}
	
	@Test
	public void testFind() {
		User user = this.userRepository.findById(7).get();
		System.out.println(user);
	}
	
	
}
