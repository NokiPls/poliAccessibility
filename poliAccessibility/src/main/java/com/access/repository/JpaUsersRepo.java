package com.access.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Repository;

import com.access.domain.Person;


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
	public void addUser(Person user) {
		em.persist(user);
		// int i;
		// for (i = 0; i < commonFriendsList.size(); i++) {
		// em.merge(commonFriendsList.get(i));
		// }
	}

	public Person findUser(String userName) {
		Query query = em.createQuery("from com.access.domain.Person where userName = :userName ");
		query.setParameter("userName", userName);
		List<Person> list = query.getResultList();
		Person p = list.get(0);
		return p;
	}

}