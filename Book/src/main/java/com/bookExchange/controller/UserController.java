package com.bookExchange.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		return "redirect:/mainPage";
	}
	
	@RequestMapping(value="verifyUser",method=RequestMethod.POST)
	public String verifyUser(HttpSession session,@RequestParam("email") String email , @RequestParam("password") String password , @RequestParam("pageKey") String pageKey , Model model) {
		String page;
		UserService service = new UserService();
		UserDataVO data = new UserDataVO();
		data.setEmail(email);
		data.setPassword(password);
		UserDataVO userData = service.verifyUser(data);	

		session.setAttribute("pageKey", pageKey);
		
		if(userData != null) {
			page = "redirect:/homePage";
			session.setAttribute("userData",userData);
		}else {
			page = "redirect:/mainPage";
			session.setAttribute("userDataRegForm",new UserDataVO());
		}
		return page;
	}
	
	@RequestMapping(value="homePage")			//send User to home page from other jsp
	public String userHomePage() {
		return "UserHome";
	}
	
	@RequestMapping(value="logout")
	public ModelAndView logout(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		session.removeAttribute("userData");			//remove user Data from session when logout
		mv.setViewName("UserLoginRegister");
		mv.addObject("userDataRegForm", new UserDataVO());
		return mv;
	}
	
	@RequestMapping(value="mainPage")
	public ModelAndView mainPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("UserLoginRegister");
		mv.addObject("userDataRegForm", new UserDataVO());
		return mv;
	}
}
