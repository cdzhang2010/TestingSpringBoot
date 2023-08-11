package com.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.UserRoles;
import com.demo.model.Users;
import com.demo.service.UserRolesService;
import com.demo.service.UsersService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UsersService usersService;

	@Autowired
	private UserRolesService userRolesService;

	@GetMapping("/v1/users")
	public List<Users> getUsers() {		
		return usersService.findAllUsers();
	}

	@PostMapping("/v1/users")
	public Optional<Users> addUsersAndRole(@RequestBody Users users) {
		return usersService.saveUser(users);
	}

	@GetMapping("/v1/users/{user_id}")
	public Optional<Users> getUserById(@PathVariable() Long id) {
		return usersService.findUsersByID(id);
	}

	@PostMapping("/users")
	public Optional<Users> addUser(@RequestBody Users users) {
		return usersService.saveUser(users);
	}

	@PutMapping("/v1/users/{user_id}")
	public Optional<Users> updateUser(@RequestBody Users users, @PathVariable Long user_id) throws Exception {
		if (users.getId() != user_id) {
			throw new Exception();
		}
		return usersService.updateUser(users, user_id);
	}

	@DeleteMapping("/v1/users/{user_id}")
	public void delete(@PathVariable Long user_id) {
		usersService.deleteUserById(user_id);
	}

	@DeleteMapping("/users/{user_id}/roles/{role_id}")
	public void delete(@PathVariable Long user_id, @PathVariable Long role_id) {
		
		Optional<Users>users= usersService.findUsersByID(user_id);
		if(users.isPresent()) {
			usersService.deleteUserById(user_id);
		}		
		Optional<com.demo.model.UserRoles>userRoles=userRolesService.findRoleByID(role_id);
		if(userRoles.isPresent()) {
			userRolesService.deleteRoleById(role_id);
		}
	}

}
