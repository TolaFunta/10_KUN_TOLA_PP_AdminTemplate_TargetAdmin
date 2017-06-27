package org.kshrd.template.services.impl;

import java.util.List;
import java.util.UUID;

import org.kshrd.template.model.User;
import org.kshrd.template.repositories.UserRepository;
import org.kshrd.template.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User findByUser_Hash(String user_hash) {
		return userRepository.findByUser_Hash(user_hash);
	}
	
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public boolean save(User user) {
		// TODO: save user to database
		String user_hash = UUID.randomUUID().toString();
		user.setUser_hash(user_hash);
		boolean status = userRepository.save(user);
		return status;
	}

	@Override
	public boolean deleteByUserHash(String userHash) {
		// TODO: delete user from database by userHash
		boolean status = userRepository.delete(userHash);
		return status;
	}

	@Override
	public boolean updateByUserHash(User user) {
		// TODO: update user from database by userHash
		boolean status = userRepository.update(user);
		return status;
	}

	@Override
	public boolean saveBatch(List<User> users) {
		return userRepository.saveBatch(users);
	}

	@Override
	public long countTotal(String gender) {
		// TODO Auto-generated method stub
		return userRepository.countTotal(gender);
	}

}
