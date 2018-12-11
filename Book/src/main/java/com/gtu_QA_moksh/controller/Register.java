package com.gtu_QA_moksh.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gtu_QA_moksh.service.RegisterService;
import com.gtu_QA_moksh.vo.UserData;

@Controller
public class Register {
	@RequestMapping(value="registerUser",method=RequestMethod.POST)
	public ModelAndView register(HttpServletRequest request,HttpServletResponse response) {
		UserData userData = new UserData();
		userData.setFirstName(request.getParameter("firstName"));
		userData.setLastName(request.getParameter("lastName"));
		userData.setEmail(request.getParameter("email"));
		userData.setNumber(Long.parseLong(request.getParameter("number")));
		userData.setPassword(request.getParameter("password"));
		
		RegisterService service = new RegisterService();
		service.registerUser(userData);
		
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("UserLoginRegister.jsp");
		
		return mv;
	}
}
