package com.ccf.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ccf.AppStarter;
import com.ccf.dao.UserRepository;
import com.ccf.dao.UserRepositoryByName;
import com.ccf.dao.UserRepositoryCrudRepository;
import com.ccf.dao.UserRepositoryPagingAndSorting;
import com.ccf.dao.UserRepositoryQueryAnnotation;
import com.ccf.dao.UserRepositorySpecification;
import com.ccf.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AppStarter.class)
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserRepositoryByName userRepositoryByName;
	@Autowired
	private UserRepositoryQueryAnnotation userRepositoryQueryAnnotation;
	@Autowired
	private UserRepositoryCrudRepository userRepositoryCrudRepository;
	@Autowired
	private UserRepositoryPagingAndSorting userRepositoryPagingAndSorting;
	
	@Autowired
	private UserRepositorySpecification userRepositorySpecification;
	
	@Test
	public void saveUser() {
		User user = new User();
		user.setSystemid(3);//id存在就update，没有就insert
		user.setUsername("liucs");
		user.setUsertype("d7");
		this.userRepository.save(user);
		
	}
	
	@Test
	public void testFindByName() {
//		List<User> list = this.userRepositoryByName.findByUsername("liucs");
//		List<User> list = this.userRepositoryByName.findByUsernameAndUsertype("liucs", "d7");
//		List<User> list = this.userRepositoryByName.findByUsernameOrUsertype("liucs", "d");
		List<User> list = this.userRepositoryByName.findByUsernameLike("%liu%");
		
//		List<User> list = this.userRepositoryQueryAnnotation.queryByUsernameUseHQL("liucs");
//		List<User> list = this.userRepositoryQueryAnnotation.queryByUsernameUseSQL("liucs");
		for (User user : list) {
			System.out.println(user);
		}
		
	}
	
	@Test
	@Transactional //与@test 一起使用时事务是自动回滚的
	@Rollback(false)//取消自动回滚
	public void testUpdateUsername() {
		this.userRepositoryQueryAnnotation.updateUsernameByid("liucsscs",2);
		
	}
	@Test
	public void testCrudRepositorySave() {
		User user = new User();
		user.setSystemid(3);//id存在就update，没有就insert
		user.setUsername("出书liucs");
		user.setUsertype("d7");
		this.userRepositoryCrudRepository.save(user);
	}
	
	@Test
	public void testCrudRepositoryFindOne() {
		User user = this.userRepositoryCrudRepository.findById(2).get();
		System.out.println(user);
	}
	
	@Test
	public void testCrudRepositoryFindAll() {
		this.userRepositoryCrudRepository.deleteById(2);
		
		List<User> list = (List<User>)this.userRepositoryCrudRepository.findAll();
		for (User user : list) {
			System.out.println(user);
		}
	}
	
	@Test
	public void testPagingAndSortingSorting() {
		//order定义排序规则
		Order order1 = new Order(Direction.DESC, "systemid");
		//sort对象封装排序规则
		Sort sort = new Sort(order1);
		List<User> list = (List<User>)this.userRepositoryPagingAndSorting.findAll(sort);
		for (User user : list) {
			System.out.println(user);
		}
	}
	
	@Test
	public void testPagingAndSortingPaging() {
		//pageable封装了分页的参数：当前页，每页显示的条数，注意当前页是从0开始的
		Pageable pageable = new PageRequest(0, 2);
		Page<User> page = this.userRepositoryPagingAndSorting.findAll(pageable);
		System.out.println("总条数："+page.getTotalElements());
		System.out.println("总页数："+page.getTotalPages());
		List<User> list = page.getContent();
		for (User user : list) {
			System.out.println(user);
		}
	}
	
	@Test
	public void testPagingAndSorting() {
		//sort对象封装排序规则
		Pageable pageable = new PageRequest(0, 3, Direction.DESC, "systemid");
		Page<User> page = this.userRepositoryPagingAndSorting.findAll(pageable);
		System.out.println("总条数："+page.getTotalElements());
		System.out.println("总页数："+page.getTotalPages());
		List<User> list = page.getContent();
		for (User user : list) {
			System.out.println(user);
		}
	}
	
	@Test
	public void testSpecificationExecutor() {
		/**
		 * Specification<User> 用于封装查询条件
		 */
		Specification<User> spec = new Specification<User>() {
			//Predicate:封装单个查询条件
			/*
			 * Root<User> root：查询对象属性的封装
			 * CriteriaQuery<?> query:封装要执行的查询中的各部分信息 select from 	order by
			 * CriteriaBuilder cb: 查询条件的构造器，定义不同的查询条件
			 */
			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
//				return cb.equal(root.get("username"), "lis");
				List<Predicate> list = new ArrayList<Predicate>();
				list.add( cb.equal(root.get("username"), "liucs"));
				list.add( cb.equal(root.get("usertype"), "d7"));
				
				return cb.and(list.toArray(new Predicate[list.size()]));
			}
		};
		
		List<User> list = 
				this.userRepositorySpecification.findAll(spec);
		for (User user : list) {
			System.out.println(user);
		}
		
	}
	
	@Test
	public void testSpecificationExecutor2() {
		Specification<User> spec = new Specification<User>() {
			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
//				return cb.and(cb.equal(root.get("username"), "liucs"),cb.equal(root.get("usertype"), "d7"));
//				return cb.or(cb.equal(root.get("username"), "liucs"),cb.equal(root.get("usertype"), "d"));
				return cb.or(cb.and(cb.equal(root.get("username"), "liucs"),cb.equal(root.get("usertype"), "d")),
						cb.equal(root.get("systemid"), "4"));
			}
		};
		
		List<User> list = 
				this.userRepositorySpecification.findAll(spec); //(spec, pageable)
		for (User user : list) {
			System.out.println(user);
		}
		
	}
	
}
