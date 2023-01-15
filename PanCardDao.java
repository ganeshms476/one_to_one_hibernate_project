package com.one_to_one_uni.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.one_to_one_uni.dto.PanCard;
import com.one_to_one_uni.dto.Person;

public class PanCardDao {
	public EntityManager geEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
	}
	public void savePanCard(PanCard card) {
		EntityManager entityManager = geEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(card);
		entityTransaction.commit();
	}
	
	public void updatePanCard(PanCard card) {
		EntityManager entityManager = geEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		PanCard card1 = entityManager.find(PanCard.class,card.getAid());
		card1.setName(card.getName());
		entityTransaction.begin();
		entityManager.merge(card1);
		entityTransaction.commit();
				
	}
	
	public void deletePerson(PanCard card) {
		EntityManager entityManager = geEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		PanCard card1 = entityManager.find(PanCard.class, card.getAid());
		entityTransaction.begin();
		entityManager.remove(card1);
		entityTransaction.commit();
	}
	
	public void getById(PanCard card) {
		EntityManager entityManager = geEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		PanCard card1 = entityManager.find(PanCard.class,card.getAid());
		System.out.println(card1);
	}
}
