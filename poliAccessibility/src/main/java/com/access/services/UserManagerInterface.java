package com.access.services;

import com.access.domain.Person;

public interface UserManagerInterface {
	
	public void saveUser(Person user);

	public Person getUserByUserName(String userName);
}
