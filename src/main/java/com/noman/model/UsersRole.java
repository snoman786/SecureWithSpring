package com.noman.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="user_roles_sec")
public class UsersRole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_role_id",unique = true, nullable = false)
	private Integer userRoleId;
	
	@Column(name = "role", nullable = false, length = 45)
	private String role;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="username")
	private Users user;

	public Integer getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
	
}
