package com.gtu_QA_moksh.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gtu_QA_moksh.service.BookService;
import com.gtu_QA_moksh.vo.BookData;

@Controller
public class UploadBookData {

	@RequestMapping(value="uploadBook" , method=RequestMethod.POST)
	public ModelAndView uploadBook() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/AllJsp/UploadBook");
		mv.addObject("bookData",new BookData());
		return mv;
	}
	
	@RequestMapping(value="saveBookData" , method=RequestMethod.POST)
	public ModelAndView submitBookData(HttpServletRequest request, HttpServletResponse response) {
		BookData bookData = new BookData();
		bookData.setTitle(request.getParameter("title"));
		bookData.setAuthor(request.getParameter("author"));
		bookData.setPubYear(request.getParameter("pubYear"));
		bookData.setAdditionalInfo(request.getParameter("additionalInfo"));
		bookData.setBookCondition(request.getParameter("bookCondition"));
		bookData.setAddress(request.getParameter("address"));
		bookData.setIdOfUser(Integer.parseInt(request.getParameter("idOfUser")));
		
		BookService service = new BookService();
		service.saveBookData(bookData);
		
		return new ModelAndView("WEB-INF/AllJsp/UserHome");
	}
}
