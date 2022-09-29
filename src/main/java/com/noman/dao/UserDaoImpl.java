package com.noman.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.noman.model.Users;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Override
	@Transactional
	public Users findByUserName(String username) {
		
		Session session = getSessionFactory().getCurrentSession();
		List<Users> users = new ArrayList<Users>();
		
		users = session.createQuery("from Users where username=?")
				.setParameter(0, username).list();
		
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}
	
	

}
