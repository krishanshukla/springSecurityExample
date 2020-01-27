package com.nets.springSecurity.service;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;

import javax.persistence.Query;

import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import com.nets.springSecurity.model.User;

/**
 * 
 * @author 10644085 UserDetailsService means a central interface in Spring
 * 
 *         Security. It is a service to search "User account and such user's
 * 
 *         roles". It is used by the Spring Security everytime when users log in
 * 
 *         the system. Therefore, you need to write a class to implement this
 * 
 *         interface. Herein, I create the UserDetailsServiceImpl class which
 * 
 *         implements the UserDetailsService interface. The
 * 
 *         UserDetailsServiceImpl class is annotated by @Service to tell the
 * 
 *         Spring "let's manage it as a Spring BEAN".
 * 
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@PersistenceContext
	private EntityManager entityManager;

	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

		String hql = "select u from User u where u.name =:name";
		Query query = entityManager.createQuery(hql);
		query.setParameter("name", name);
		List<User> list = query.getResultList();
		User user = list.get(0);
		List<String> roleNames = getRoleName(user.getUserid());
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		if (roleNames != null) {
			for (String role : roleNames) {
				GrantedAuthority authority = new SimpleGrantedAuthority(role);
				grantList.add(authority);

			}
		}

		return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(),
				grantList);
	}

	public List<String> getRoleName(int id) {
		String hql = "select r.rolename from Role r join r.users u where u.userid = :id";
		// String sql = "select r.userRole from role r join audituser u on r.id= u.id
		// where r.id = 101";
		Query query = entityManager.createQuery(hql);
		query.setParameter("id", id);
		return query.getResultList();
	}
}
