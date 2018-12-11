package com.gtu_QA_moksh.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gtu_QA_moksh.service.BookService;
import com.gtu_QA_moksh.vo.BookData;

@Controller
public class ShowBooks {

	@RequestMapping("showAllBooks")
	public ModelAndView showBooks() {
		ArrayList<BookData> listOfAllBooks = null;
		BookService bookService = new BookService();
		listOfAllBooks = bookService.getAllBooksFromDb();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/AllJsp/ShowAllBooks");
		mv.addObject("listOfAllBooks", listOfAllBooks);
		
		return mv;
	}
	
	@RequestMapping("ShowBookInfo")
	public ModelAndView showBookInfo(HttpServletRequest request, HttpServletResponse response) {
		double bookId = Double.parseDouble(request.getParameter("idOfBook"));
		BookService bookService = new BookService();
		BookData bookDetails = bookService.getBookDetails(bookId);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/AllJsp/ShowBookInfo");
		mv.addObject("bookDetails", bookDetails);
		
		return mv;
	}
}
