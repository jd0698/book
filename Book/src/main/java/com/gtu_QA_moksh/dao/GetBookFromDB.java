package com.gtu_QA_moksh.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.gtu_QA_moksh.vo.BookData;

public class GetBookFromDB {
	
	public ArrayList<BookData> getAllBooks() {		
		ArrayList<BookData> listOfAllBook = new ArrayList<BookData>();
		
		Configuration con = new Configuration().configure().addAnnotatedClass(BookData.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery("From BookData");
		listOfAllBook = (ArrayList<BookData>)query.list();
		tran.commit();
		session.close();
		
		return listOfAllBook;
	}
	
	public BookData getBookById(double bookId) {      // when more Info is clicked
		BookData bookData = null;
		
		Configuration con = new Configuration().configure().addAnnotatedClass(BookData.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery("From BookData WHERE id="+bookId);
		List<BookData> list = (List<BookData>)query.list();
		if(!list.isEmpty()) {
			bookData = list.get(0);
		}
		tran.commit();
		session.close();
		
		return bookData;
	}
	
	public ArrayList<BookData> getAllBooksOfUser(int userId){
		ArrayList<BookData> allBooksOfUser = new ArrayList<BookData>();
		
		Configuration con = new Configuration().configure().addAnnotatedClass(BookData.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery("From BookData WHERE idOfUser="+userId);
		allBooksOfUser = (ArrayList<BookData>)query.list();
		tran.commit();
		session.close();
		
		return allBooksOfUser;
	}
	
	public void removeBookById(int bookId){
		Configuration con = new Configuration().configure().addAnnotatedClass(BookData.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery("DELETE FROM BookData WHERE id="+bookId);
		query.executeUpdate();
		tran.commit();
		session.close();
	}
	
	public void updateBookDetails(BookData bookDataUpdateForm) {
		Configuration con = new Configuration().configure().addAnnotatedClass(BookData.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
		session.saveOrUpdate(bookDataUpdateForm);
		tran.commit();
		session.close();
	}
}
