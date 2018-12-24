package com.bookExchange.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bookExchange.service.UserService;
import com.bookExchange.model.UserDataVO;

@Controller
public class UserController {
	@RequestMapping(value="registerUser",method=RequestMethod.POST)
	public String registerUser(@ModelAttribute() UserDataVO userDataRegForm) {
		UserService service = new UserService();
		service.registerUser(userDataRegForm);
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("redirect:/goToMainPage");
//		mv.addObject("userDataRegForm",new UserDataVO());
//		return mv;
		return "redirect:/goToMainPage";
	}
	
	@RequestMapping(value="verifyUser",method=RequestMethod.POST)
	public ModelAndView verifyUser(@RequestParam("email") String email , @RequestParam("password") String password) {
		UserService service = new UserService();
		UserDataVO data = new UserDataVO();
		data.setEmail(email);
		data.setPassword(password);
		ModelAndView mv = new ModelAndView();
		UserDataVO userData = service.verifyUser(data);
		
		if(userData != null) {
			mv.setViewName("UserHome");
			mv.addObject("userData",userData);
		}else {
			mv.setViewName("UserLoginRegister");
			mv.addObject("userDataRegForm",new UserDataVO());
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
		mv.addObject("userDataRegForm", new UserDataVO());
		return mv;
	}
	
	@RequestMapping(value="goToMainPage")
	public ModelAndView userLoginRegister() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("UserLoginRegister");
		mv.addObject("userDataRegForm", new UserDataVO());
		return mv;
	}
}
