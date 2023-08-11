package com.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Users;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {
	List<Users>findByNameContaining(String name);
}
