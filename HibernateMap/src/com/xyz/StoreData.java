package com.xyz;

import java.util.HashMap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class StoreData {

	public static void main(String[] args) {
StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		
		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
		
		SessionFactory factory=meta.getSessionFactoryBuilder().build();
		
		Session session=factory.openSession();
		
		Transaction t=session.beginTransaction();
		
		HashMap<String,String>map1=new HashMap<String, String>();
		
		map1.put("Java is good","Mohamed");
		map1.put("Java is a Plaform","azar");
		
		HashMap<String,String>map2=new HashMap<String, String>();
		
		map2.put("Servlet is good","mohamed");
		
		map2.put("Servelet is not good","azar");
		
		Question q1=new Question("What is Java","azar",map1);
		
		Question q2=new Question("What is Web","mohamed",map1);
		
		session.persist(q1);
		
		session.persist(q2);
		
		t.commit();
		
		session.close();
		
		System.out.println("Inserted..");
		
		
		

	}

}
