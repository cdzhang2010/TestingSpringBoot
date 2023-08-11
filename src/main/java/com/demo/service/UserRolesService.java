package com.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.UserRoles;
import com.demo.repository.UserRolesRepository;

@Service
public class UserRolesService {
	 @Autowired
	    private UserRolesRepository userRolesRepository;
	    
	    public Optional<UserRoles>findRoleByID(Long userId){	    	
	    	return userRolesRepository.findById(userId);
	    }
	 
	    // read operation
	    public List<UserRoles> findAllRole() {
	    	List<UserRoles> UserRoles = new ArrayList<UserRoles>();
	    	userRolesRepository.findAll().forEach(UserRoles::add);
		    return UserRoles;	    
	    }
	 
	    // save operation
	    public Optional<UserRoles> saveUser(UserRoles userRoles) {
	        return Optional.ofNullable(userRolesRepository.save(userRoles));
	    }
	    
	    // delete operation
	    public void deleteRoleById(Long roleId) {
	        userRolesRepository.deleteById(roleId);
	    }

}
