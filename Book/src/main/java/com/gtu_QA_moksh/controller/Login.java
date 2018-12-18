package com.gtu_QA_moksh.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gtu_QA_moksh.service.LoginService;
import com.gtu_QA_moksh.vo.AdminData;
import com.gtu_QA_moksh.vo.UserData;

@Controller
public class Login {
	
	@RequestMapping(value="verifyAdmin",method=RequestMethod.POST)
	public ModelAndView loginReq(@RequestParam("userName") String userName , @RequestParam("password") String password) {
		LoginService service = new LoginService();
		
		AdminData adminData = new AdminData();
		adminData.setUserName(userName);
		adminData.setPassword(password);
		
		ModelAndView mv = new ModelAndView();
		
		if(service.verify(adminData)) {
			mv.setViewName("AdminHomePage");
		}else {
			mv.setViewName("AdminLogin");
		}
		return mv;
	}
	
	@RequestMapping(value="verifyUser",method=RequestMethod.POST)
	public ModelAndView loginUser(@RequestParam("email") String email , @RequestParam("password") String password) {
		LoginService service = new LoginService();
		
		UserData data = new UserData();
		data.setEmail(email);
		data.setPassword(password);
		
		ModelAndView mv = new ModelAndView();
		
		UserData userData = service.verify(data);
		
		if(userData != null) {
			mv.setViewName("UserHome");
			mv.addObject("userData",userData);
		}else {
			mv.setViewName("UserLoginRegister");
			//mv.setViewName("redirect:/homePage");
		}
		
		return mv;
	}

	@RequestMapping(value="homePage")				//send User to home page from other jsp
	public ModelAndView userHomePage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("UserHome");
		return mv;
	}
	
	@RequestMapping(value="logout")
	public ModelAndView logout(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		session.removeAttribute("userData");			//remove user Data from session when logout
		mv.setViewName("UserLoginRegister");
		mv.addObject("userDataRegForm", new UserData());
		return mv;
	}
	
	@RequestMapping(value="goToMainPage")
	public ModelAndView userLoginRegister() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("UserLoginRegister");
		mv.addObject("userDataRegForm", new UserData());
		return mv;
	}
}
