package com.demo.model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class Users {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
    private String name;
    
    private  String email;
    

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
   @JoinTable(name="User_Role",  joinColumns = @JoinColumn(name = "user_id", referencedColumnName="id") ,inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName="id" ))   
    private Set<UserRoles> userRoles;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
	  public Set<UserRoles> getRoles() {
	        return userRoles;
	    }

	    public void setRoles(Set<UserRoles> userRoles) {
	        this.userRoles = userRoles;
	    }

	    public Users(String email, String password, Set<UserRoles> userRoles) {
	        super();
	        this.email = email;
	        this.userRoles = userRoles;
	    }

		public Users() {
		}

		@Override
		public int hashCode() {
			return Objects.hash(email, id, name, userRoles);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Users other = (Users) obj;
			return Objects.equals(email, other.email) && id == other.id && Objects.equals(name, other.name)
					&& Objects.equals(userRoles, other.userRoles);
		}

		@Override
		public String toString() {
			return "Users [id=" + id + ", name=" + name + ", email=" + email + ", roles=" + userRoles + "]";
		}
    
		
}
