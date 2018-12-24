package com.bookExchange.service;

import java.util.ArrayList;

import com.bookExchange.dao.BookDAO;
import com.bookExchange.model.BookDataVO;

public class BookService {
	public void saveBookData(BookDataVO data) {
		BookDAO bookDAO = new BookDAO();
		bookDAO.saveBookData(data);
	}
	
	public ArrayList<BookDataVO> getAllBooksFromDb(){
		BookDAO bookDAO = new BookDAO();
		return bookDAO.getAllBooks();
	}
	
	public ArrayList<BookDataVO> getAllBooksFromDb(int userId){
		BookDAO bookDAO = new BookDAO();
		return bookDAO.getAllBooksOfUser(userId);
	}
	
	public BookDataVO getBookDetails(double bookId) {
		BookDAO bookDAO = new BookDAO();
		return bookDAO.getBookById(bookId);
	}
	
	public void removeBookFromDbById(int bookId) {
		BookDAO bookDAO = new BookDAO();
		bookDAO.removeBookById(bookId);
	}
	
	public void updateBookDetails(BookDataVO bookDataUpdateForm) {
		BookDAO bookDAO = new BookDAO();
		bookDAO.updateBookDetails(bookDataUpdateForm);
	}
}
