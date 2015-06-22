package org.benjamin.report.dao;

import org.benjamin.hibernate.Card;
import org.benjamin.hibernate.Person;
import org.benjamin.report.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class PersonCard {
	
	
	public static void main(String[] args) {
		PersonCard sd = new PersonCard();
		HibernateUtils hu = new HibernateUtils();
		
		SessionFactory sf = hu.getSessionFactory();
		Session sesstion = hu.getSession();
		
		Person person = new Person();
		person.setName("PersonName");
		
		Card card = new Card();
		card.setCardNumber(123456789);
		card.setPerson(person);
		person.setCard(card);
		
		sesstion.save(card);
		sesstion.save(person);
		
		sesstion.getTransaction().commit();
		
		sesstion.close();
		hu.closeSesstionFactory();
	}

}
