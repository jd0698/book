package com.gtu_QA_moksh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gtu_QA_moksh.service.RegisterService;
import com.gtu_QA_moksh.vo.UserData;

@Controller
public class Register {
	@RequestMapping(value="registerUser",method=RequestMethod.POST)
	public ModelAndView register(@ModelAttribute() UserData userDataRegForm) {
		RegisterService service = new RegisterService();
		service.registerUser(userDataRegForm);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("UserLoginRegister");
		mv.addObject("userDataRegForm",new UserData());
		return mv;
	}
}
