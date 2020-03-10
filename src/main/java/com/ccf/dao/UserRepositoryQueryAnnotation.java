package com.ccf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.ccf.pojo.User;

public interface UserRepositoryQueryAnnotation extends Repository<User, Integer> {

	@Query("from User where username = ?1 ")
	List<User> queryByUsernameUseHQL(String username);
	
	@Query(value="SELECT * from T_SYS_USER where username = ?1 ", nativeQuery =true)
	List<User> queryByUsernameUseSQL(String name);
	
	@Query("update User set username =?1 where systemid = ?2 ")
	@Modifying //需要执行一个更新操作
	void updateUsernameByid(String username, Integer systemid);
}
