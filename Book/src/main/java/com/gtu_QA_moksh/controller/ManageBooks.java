package com.gtu_QA_moksh.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gtu_QA_moksh.service.BookService;
import com.gtu_QA_moksh.vo.BookData;
import com.gtu_QA_moksh.vo.UserData;

@Controller
public class ManageBooks {

	@RequestMapping(value="manageMyBooks")
	public ModelAndView manageBooks(HttpSession session) {
		ArrayList<BookData> listOfAllBooksByUser = null; 
		UserData userData = (UserData)session.getAttribute("userData");
		BookService bookService = new BookService();
		listOfAllBooksByUser = bookService.getAllBooksFromDb(userData.getId());
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ShowAllBooksOfUser");
		mv.addObject("listOfAllBooksByUser", listOfAllBooksByUser);
		return mv;
	}
	
	@RequestMapping(value="removeBook")
	public ModelAndView removeBook(HttpSession session , HttpServletRequest request) {
		ModelAndView mv = null;
		int bookId = Integer.parseInt(request.getParameter("idOfBook"));
		BookService bookService = new BookService();
		bookService.removeBookFromDbById(bookId);
		mv = manageBooks(session);
		return mv;
	}
	
	@RequestMapping(value="updateBookDataPage")
	public ModelAndView updateBookDataPage(HttpServletRequest request) {
		int bookId = Integer.parseInt(request.getParameter("idOfBook"));
		BookService service = new BookService();
		BookData bookData = service.getBookDetails(bookId);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("UpdateBookData");
		mv.addObject("bookDataUpdateForm",bookData);
		return mv;
	}
	
	@RequestMapping(value="updateBookData")
	public ModelAndView updateBookData(@ModelAttribute BookData bookDataUpdateForm , HttpSession session) {
		BookService service = new BookService();
		service.updateBookDetails(bookDataUpdateForm);
		ModelAndView mv = manageBooks(session);
		return mv;
	}
}
