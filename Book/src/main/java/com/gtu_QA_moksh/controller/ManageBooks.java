package com.gtu_QA_moksh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ManageBooks {

	@RequestMapping(value="manageMyBooks")
	public ModelAndView manageBooks() {
		ModelAndView mv = new ModelAndView();
		
		
		return mv;
	}
}
