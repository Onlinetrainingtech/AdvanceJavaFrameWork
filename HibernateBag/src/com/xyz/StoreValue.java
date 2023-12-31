package com.xyz;

import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class StoreValue {

	public static void main(String[] args) 
	{
StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		
		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
		
		SessionFactory factory=meta.getSessionFactoryBuilder().build();
		
		Session session=factory.openSession();
		
		Transaction t=session.beginTransaction();
		
		HashSet<String>list1=new HashSet<String>();
		
		list1.add("Java is Programming");
		list1.add("Java is a plaform");
		
		HashSet<String>list2=new HashSet<String>();
		list2.add("aa");
		list2.add("aa");
		
		Question q1=new Question();
		q1.setQname("What is Java");
	    q1.setAnswers(list1);

	    Question q2=new Question();
	    q2.setQname("What is C++");
	    q2.setAnswers(list2);
	    
	    session.persist(q1);
	    session.persist(q2);
	    
	    t.commit();
	    session.close();
	    System.out.println("Sucesss!!!");
	}

}
