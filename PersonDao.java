package com.one_to_one_uni.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.one_to_one_uni.dto.PanCard;
import com.one_to_one_uni.dto.Person;

public class PersonDao {
	public EntityManager geEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
	}
	
	public void savePerson(Person person) {
		EntityManager entityManager = geEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(person);
		entityTransaction.commit();
	}
	
	public void updatePerson(Person person) {
		EntityManager entityManager = geEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Person person1 = entityManager.find(Person.class, person.getId());
		person1.setName(person.getName());
		entityTransaction.begin();
		entityManager.merge(person1);
		entityTransaction.commit();
				
	}
	
	public void deletePerson(Person person) {
		EntityManager entityManager = geEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Person person1 = entityManager.find(Person.class, person.getId());
		entityTransaction.begin();
		entityManager.remove(person1);
		entityTransaction.commit();
	}
	
	public void getById(Person person) {
		EntityManager entityManager = geEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Person person1 = entityManager.find(Person.class, person.getId());
		System.out.println(person1);
	}
}
