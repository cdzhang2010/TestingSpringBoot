package com.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.demo.model.UserRoles;

public interface UserRolesRepository extends CrudRepository<UserRoles, Long> {
	List<UserRoles>findByRoleContaining(String role);
}
