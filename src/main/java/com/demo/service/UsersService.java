package com.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Users;
import com.demo.repository.UsersRepository;

@Service
public class UsersService {
	
	 @Autowired
	    private UsersRepository usersRepository;
	    
	    public Optional<Users>findUsersByID(Long userId){	    	
	    	return usersRepository.findById(userId);
	    }
	 
	    // read operation
	    public List<Users> findAllUsers() {
	    	List<Users> users = new ArrayList<Users>();
	    	usersRepository.findAll().forEach(users::add);
		    return users;	    
	    }
	 
	    // save operation
	    public Optional<Users> saveUser(Users users) {
	        return Optional.ofNullable(usersRepository.save(users));
	    }
	    
	    // update operation
	    public Optional<Users> updateUser(Users users, Long userId) {
	        Users userDB = usersRepository.findById(userId).get();
	 
	        if (Objects.nonNull(users.getName()) && !"".equalsIgnoreCase(users.getName())) {
	            userDB.setName(users.getName());
	        }	 
	        if (Objects.nonNull(users.getEmail()) && !"".equalsIgnoreCase(users.getEmail())) {
	            userDB.setEmail(users.getEmail());
	        } 
	        return  Optional.ofNullable(usersRepository.save(userDB));
	    }
	 
	    // delete operation
	    public void deleteUserById(Long userId) {
	        usersRepository.deleteById(userId);
	    }
	

}
