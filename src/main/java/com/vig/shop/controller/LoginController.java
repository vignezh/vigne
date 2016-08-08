package com.vig.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vig.shop.model.UserDetails;
import com.vig.shop.service.LoginService;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String loginshow() {

		return "login";
	}

	@Autowired(required = true)
	LoginService ls;

	@ModelAttribute("userform")
	public UserDetails getob() {
		return new UserDetails();
	}

	@RequestMapping(value = "/loginpage", method = RequestMethod.POST)
	public ModelAndView loginuser(@ModelAttribute UserDetails u) {
		boolean isvaliduser = false;
		/*
		 * u.setUser_name(name); u.setUser_password(pwd);
		 */
		isvaliduser = ls.checkUser(u);
		ModelAndView mv = null;
		if (isvaliduser == true) {
			mv = new ModelAndView("success");
			mv.addObject("msg", "Welcome");
			mv.addObject("name", u.getUser_firstname());
		}
		return mv;
	}

}
