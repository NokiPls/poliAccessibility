package com.access.services;

import com.access.domain.User;

public interface UserManagerInterface {
	
	public void saveUser(User user);

	public User getUser(String uid);
}
