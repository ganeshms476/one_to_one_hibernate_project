package com.one_to_one_uni.controller;

import java.util.Scanner;

import org.hibernate.usertype.UserCollectionType;

import com.one_to_one_uni.dao.PanCardDao;
import com.one_to_one_uni.dao.PersonDao;
import com.one_to_one_uni.dto.PanCard;
import com.one_to_one_uni.dto.Person;

public class PersonMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean b = true;
		do {
			System.out.println("Enter the choice \n:1insert \n2:Update \n3:delete \n4:getById \n:5getAll");

			Person person = new Person();
			PanCard card = new PanCard();
			PersonDao dao = new PersonDao();
			PanCardDao cardDao = new PanCardDao();
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Enter person id");
				int id = scanner.nextInt();
				System.out.println("Enter personName");
				String name = scanner.next();
				System.out.println("Enter pesron phone");
				long phone = scanner.nextLong();
				System.out.println("Enter person address");
				String address = scanner.next();

				person.setId(id);
				person.setName(name);
				person.setPhone(phone);
				person.setAddress(address);
				person.setCard(card);

				System.out.println("Enter pan id");
				int aid = scanner.nextInt();
				System.out.println("Enter pan name");
				String name1 = scanner.next();
				System.out.println("Enter pan address");
				String address1 = scanner.next();

				card.setAid(aid);
				card.setName(name1);
				card.setAddress(address1);
				
				cardDao.savePanCard(card);
				dao.savePerson(person);
				

			}
				break;
			case 2:{
				System.out.println("Enter id ");
				int id = scanner.nextInt();
				System.out.println("enter name");
				String name =scanner.next();
				person.setId(id);
				person.setName(name);
				
				
				System.out.println("Enter id ");
				int id1 = scanner.nextInt();
				System.out.println("enter name");
				String name1 =scanner.next();
				card.setAid(id1);
				card.setName(name1);
				dao.updatePerson(person);
				cardDao.updatePanCard(card);
			}break;
			case 3:{
				System.out.println("Enter id ");
				int id = scanner.nextInt();
				person.setId(id);
				
				System.out.println("Enter id ");
				int id1 = scanner.nextInt();
				card.setAid(id1);
				dao.deletePerson(person);
				cardDao.deletePerson(card);
			}break;
			case 4:{
				System.out.println("Enter id ");
				int id = scanner.nextInt();
				person.setId(id);
				System.out.println("Enter id ");
				int id1 = scanner.nextInt();
				card.setAid(id1);
				dao.getById(person);
				cardDao.getById(card);
				
			}break;
			}
		} while (b);
	}
}
