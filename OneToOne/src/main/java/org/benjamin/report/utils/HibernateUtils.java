package org.benjamin.report.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory sessionFactory;
	private Session session;
	
	public SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		sessionFactory = configuration
				.buildSessionFactory(builder.build());
		return sessionFactory;
	}

	public void closeSesstionFactory(){
		if(sessionFactory != null) {
			sessionFactory.close();
		}
	}
	
	public Session getSession(){
	    session=sessionFactory.openSession(); // 生成一个session
	    session.beginTransaction(); // 开启事务
	    return session;
	}
	
	public void closeSession(){
	    session.getTransaction().commit(); // 提交事务
		if(session != null) {
			session.close();
		}
	}
}
