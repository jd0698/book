package com.gtu_QA_moksh.service;

import java.util.ArrayList;

import com.gtu_QA_moksh.dao.GetBookFromDB;
import com.gtu_QA_moksh.dao.SaveBookDataDb;
import com.gtu_QA_moksh.vo.BookData;

public class BookService {

	public void saveBookData(BookData data) {
		SaveBookDataDb bookDataDb = new SaveBookDataDb();
		bookDataDb.saveBookData(data);
	}
	
	public ArrayList<BookData> getAllBooksFromDb(){
		GetBookFromDB db = new GetBookFromDB();
		return db.getAllBooks();
	}
	
	public BookData getBookDetails(double bookId) {
		GetBookFromDB db = new GetBookFromDB();
		return db.getBookById(bookId);
	}
}
