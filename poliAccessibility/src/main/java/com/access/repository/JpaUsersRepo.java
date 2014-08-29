package com.access.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Repository;

import com.access.domain.User;

/**
 * Implementation of the DAO. The configuration for the entity manager is
 * located in the dataSource-context.xml file.
 * 
 */

@ImportResource("classpath:dataSource-context.xml")
@Repository
public class JpaUsersRepo implements UsersRepository {

	@PersistenceContext
	public EntityManager em;

	@Override
	@Transactional
	public void addUser(User user) {
		em.persist(user);
//		int i;
//		for (i = 0; i < commonFriendsList.size(); i++) {
//			em.merge(commonFriendsList.get(i));
//		}
	}

}