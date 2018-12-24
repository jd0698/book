package com.bookExchange.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.bookExchange.model.BookDataVO;

public class BookDAO {
	
	public ArrayList<BookDataVO> getAllBooks() {		
		ArrayList<BookDataVO> listOfAllBook = new ArrayList<BookDataVO>();
		
		Configuration con = new Configuration().configure().addAnnotatedClass(BookDataVO.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery("From BookDataVO");
		listOfAllBook = (ArrayList<BookDataVO>)query.list();
		tran.commit();
		session.close();
		
		return listOfAllBook;
	}
	
	public BookDataVO getBookById(double bookId) {      // when more Info is clicked
		BookDataVO bookData = null;
		
		Configuration con = new Configuration().configure().addAnnotatedClass(BookDataVO.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery("From BookDataVO WHERE id="+bookId);
		List<BookDataVO> list = (List<BookDataVO>)query.list();
		if(!list.isEmpty()) {
			bookData = list.get(0);
		}
		tran.commit();
		session.close();
		
		return bookData;
	}
	
	public ArrayList<BookDataVO> getAllBooksOfUser(int userId){
		ArrayList<BookDataVO> allBooksOfUser = new ArrayList<BookDataVO>();
		
		Configuration con = new Configuration().configure().addAnnotatedClass(BookDataVO.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery("From BookDataVO WHERE idOfUser="+userId);
		allBooksOfUser = (ArrayList<BookDataVO>)query.list();
		tran.commit();
		session.close();
		
		return allBooksOfUser;
	}
	
	public void removeBookById(int bookId){
		Configuration con = new Configuration().configure().addAnnotatedClass(BookDataVO.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery("DELETE FROM BookDataVO WHERE id="+bookId);
		query.executeUpdate();
		tran.commit();
		session.close();
	}
	
	public void updateBookDetails(BookDataVO bookDataUpdateForm) {
		Configuration con = new Configuration().configure().addAnnotatedClass(BookDataVO.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
		session.saveOrUpdate(bookDataUpdateForm);
		tran.commit();
		session.close();
	}
	
	public void saveBookData(BookDataVO data) {
		Configuration con = new Configuration().configure().addAnnotatedClass(BookDataVO.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(data);
		transaction.commit();
	}
}
