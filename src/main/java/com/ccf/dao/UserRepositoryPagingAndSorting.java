package com.ccf.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ccf.pojo.User;

public interface UserRepositoryPagingAndSorting extends PagingAndSortingRepository<User, Integer> {

	
}
