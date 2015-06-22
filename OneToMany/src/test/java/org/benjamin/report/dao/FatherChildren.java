package org.benjamin.report.dao;

import java.util.ArrayList;
import java.util.List;

import org.benjamin.hibernate.Child;
import org.benjamin.hibernate.Father;
import org.benjamin.report.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class FatherChildren {
	
	
	public static void main(String[] args) {
		FatherChildren sd = new FatherChildren();
		HibernateUtils hu = new HibernateUtils();
		
		SessionFactory sf = hu.getSessionFactory();
		Session sesstion = hu.getSession();
		
		Father father = new Father();
		father.setName("Father");
		sesstion.save(father);
		List<Child> children = new ArrayList<Child>();
		for(int i=0;i<3;i++){
			Child child = new Child();
			child.setCardNumber(123456789 + i);
			child.setFather(father);
			children.add(child);
			sesstion.save(child);
		}

		father.setChildren(children);
		
		sesstion.getTransaction().commit();
		
		sesstion.close();
		hu.closeSesstionFactory();
	}

}
