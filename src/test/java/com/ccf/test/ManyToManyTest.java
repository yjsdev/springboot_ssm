package com.ccf.test;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ccf.AppStarter;
import com.ccf.dao.RoleRepository;
import com.ccf.pojo.Menu;
import com.ccf.pojo.Role;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AppStarter.class)
public class ManyToManyTest {

	@Autowired
	private RoleRepository roleRepository;
	
	@Test
	public void testSave() {
		Role role = new Role();
		role.setRolename("后台管理员");
		
		Menu menu = new Menu();
		menu.setMenuname("xxx平台");
		menu.setParentid(0);
		Menu menu2 = new Menu();
		menu2.setMenuname("xxxAPP");
		menu2.setParentid(1);
		
		role.getMenus().add(menu);
		role.getMenus().add(menu2);
		menu.getRoles().add(role);
		menu2.getRoles().add(role);
		
		this.roleRepository.save(role);
	}
	
	@Test
	public void testFind() {
		Role role = this.roleRepository.findById(21).get();
		System.out.println(role.getRolename());
		Set<Menu> menus = role.getMenus();
		
		for (Menu menu : menus) {
			System.out.println(menu);
		}
	}
}
