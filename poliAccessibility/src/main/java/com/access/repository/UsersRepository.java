package com.access.repository;

import com.access.domain.Person;


/**
 * Interface for the DAO
 * 
 */

public interface UsersRepository {

	public void addUser(Person user);

	public Person findUserByUserName(String userName);

}
