package org.kshrd.template.services;

import java.util.List;

import org.kshrd.template.model.User;

public interface UserService {

	public User findByUser_Hash(String user_hash);
	public List<User> findAll();
	public boolean save(User user);
	public boolean deleteByUserHash(String user_hash);
	public boolean updateByUserHash(User user);
	public boolean saveBatch(List<User> users);
	public long countTotal(String gender);
	
}
