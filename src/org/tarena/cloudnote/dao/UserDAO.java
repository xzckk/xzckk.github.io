package org.tarena.cloudnote.dao;

import java.util.List;

import org.tarena.cloudnote.entity.User;

public interface UserDAO {

	public int authorize(User user);
	
	public List<User> findAll();
	
	public User findByName(String name);
	
	public int save(User user);
}