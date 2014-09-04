package com.access.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.access.domain.Person;
import com.access.repository.UsersRepository;

@Service
@Transactional
@ComponentScan("com.access.repository")
public class UserManager implements UserManagerInterface {

	@Autowired
	public UsersRepository repo;
	
	@Override
	public void saveUser(Person user) {
		repo.addUser(user);
	}
	
	@Override
	public Person getUser(String name){
		return repo.findUser(name);
	}
	
}
