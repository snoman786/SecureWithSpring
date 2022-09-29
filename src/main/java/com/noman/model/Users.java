package com.noman.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users_sec")
public class Users {

	@Id
	@Column(name="username",nullable=false,unique=true)
	private String username;
	
	@Column(name = "password",nullable = false, length = 60)
	private String password;
	
	@Column(name = "enabled", nullable = false)
	private boolean enabled;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="username")
	private List<UsersRole> userRole = new ArrayList();

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<UsersRole> getUserRole() {
		return userRole;
	}

	public void setUserRole(List<UsersRole> userRole) {
		this.userRole = userRole;
	}
	
	
}
