package com.access.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.access.domain.User;
import com.access.repository.UsersRepository;

@Service
@Transactional
@ComponentScan("com.access.repository")
public class UserManager implements UserManagerInterface {

	@Autowired
	public UsersRepository repo;
	
	@Override
	public void saveUser(User user) {
		repo.addUser(user);
	}
	
	@Override
	public User getUser(String uid){
		return repo.findUser(uid);
	}
	
}
