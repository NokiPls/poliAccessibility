package com.access.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.access.domain.User;
import com.access.repository.UsersRepository;

public class UserManager implements UserManagerInterface {

	@Autowired
	UsersRepository repo;
	
	@Override
	public void saveUser(User user) {
		repo.addUser(user);
	}
	
}
