package com.xyz.example;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class MainClass {

	public static void main(String[] args) {
StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		
		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
		
		SessionFactory factory=meta.getSessionFactoryBuilder().build();
		
		Session session=factory.openSession();
		
		Transaction t=session.beginTransaction();
		
		ArrayList<String>list1=new ArrayList<String>();
		
		list1.add("Java is Programming");
		list1.add("Java is a Platform");
		
		ArrayList<String>list2=new ArrayList<String>();
		
		list2.add("C++ is Programming");
		list2.add("C++ is a Platform");
		
		Employee e1=new Employee();
		e1.setQname("What is java");
		e1.setAnswers(list1);
		
		
		Employee e2=new Employee();
		e2.setQname("What is c++");
		e2.setAnswers(list2);
		
		session.persist(e1);
		
		session.persist(e2);
		
		t.commit();
		
		session.close();
		
		System.out.println("Data Successfully...");

	}

}
