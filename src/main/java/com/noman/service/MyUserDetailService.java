package com.noman.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.noman.dao.UserDao;
import com.noman.model.Users;
import com.noman.model.UsersRole;
@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		Users user = userDao.findByUserName(username);
		List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());
		
		return buildUserForAuthentication(user,authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(List<UsersRole> userRoles) {

		List<GrantedAuthority> setAuths = new ArrayList<GrantedAuthority>();
		// Build user's authorities
		for (UsersRole userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}
	
	// converts "com.oracle.model.Users" into "org.springframework.security.core.userdetails.User" 
	private User buildUserForAuthentication(Users user,List<GrantedAuthority> authorities) {
			return new User(user.getUsername(),user.getPassword(), user.isEnabled(),true, true, true, authorities);
		}
	
}
