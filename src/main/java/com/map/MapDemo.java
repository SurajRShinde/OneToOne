package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
public static void main(String[] args) {
	System.out.println("step 1");
	Configuration cfg = new Configuration();
	cfg=cfg.configure("hibernate.cfg.xml");
	System.out.println("step 2");
	SessionFactory factory =cfg.buildSessionFactory();
	Session s = factory.openSession();
	Question q1=new Question();
	q1.setQuestionId(1212);
	q1.setQuestion("what is java");
	
	Answer answer=new Answer();
	answer.setAnswerId(343);
	answer.setAnswer("java is programming language");
	answer.setQuesion(q1);
	
	q1.setAnswer(answer);
	

	Transaction tx = s.beginTransaction();
	s.save(answer);
	s.save(q1);
	
	tx.commit();
	s.close();
	factory.close();

	
}
}
