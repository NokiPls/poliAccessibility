package com.access.repository;

import com.access.domain.User;

/**
 * Interface for the DAO
 * 
 */

public interface UsersRepository {

	public void addUser(User user);

	public User findUser(String uid);

}
