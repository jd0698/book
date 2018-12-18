package com.gtu_QA_moksh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		mv.setViewName("UploadBook");
		mv.addObject("bookDataForm",new BookData());
		return mv;
	}
	
	@RequestMapping(value="saveBookData" , method=RequestMethod.POST)
	public ModelAndView submitBookData(@ModelAttribute() BookData bookDataForm) {
		BookService service = new BookService();
		service.saveBookData(bookDataForm);
		return new ModelAndView("UserHome");
	}
}
