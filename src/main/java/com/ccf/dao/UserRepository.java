package com.ccf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccf.pojo.User;


/**
 * 参数一T:当前要映射的实体
 * 参数二ID:当前映射实体中的OID的类型
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {

}
