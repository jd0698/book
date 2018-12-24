package com.bookExchange.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.bookExchange.model.UserDataVO;

public class UserDAO {
	public void registerUser(UserDataVO data) {
		Configuration con = new Configuration().configure().addAnnotatedClass(UserDataVO.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(data);
		transaction.commit();
	}
	
	public UserDataVO verifyUser(UserDataVO userData) {
		UserDataVO user = null;
		
		Configuration con = new Configuration().configure().addAnnotatedClass(UserDataVO.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery("FROM UserDataVO WHERE email='"+userData.getEmail()+"' and password='"+userData.getPassword()+"'");
		ArrayList<UserDataVO> list = (ArrayList<UserDataVO>)query.list();
		if(!list.isEmpty()) {
			user = list.get(0);
		}
		tran.commit();
		session.close();
		
		return user;
	}	
}
