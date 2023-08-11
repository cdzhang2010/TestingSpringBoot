package com.demo.model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table(name = "Roles")
public class UserRoles {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
    private String role;
    
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name="User_Role", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private Set<Users> users;
    
    
    public Set<Users> getUsers() {
        return users;
    }

    public void setRoles(Set<Users> users) {
        this.users = users;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public UserRoles(long id, String role, Set<Users> users) {
		super();
		this.id = id;
		this.role = role;
		this.users = users;
	}

	public UserRoles() {
		super();
	}

}
